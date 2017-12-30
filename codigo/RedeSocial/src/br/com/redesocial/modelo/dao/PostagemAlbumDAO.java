package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.PostagemAlbum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wesley Morais, Paulo Henrique Araujo e Gusttavo Nunes Gomes
 */
public class PostagemAlbumDAO extends DAOBase {
    
    public void excluir(int postagem, int album) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from postagens_albuns where postagem = ? and album = ?");
        
        pstmt.setInt(1, postagem);
        pstmt.setInt(2, album);
        
        pstmt.executeUpdate();
    }

    /**
    * Método para inserir uma postagem com album
    * @author Lara Caroline
    * @throws Exception possíveis exceções que podem acontecer
    * @param dto identificador de PostagemAlbum
    */
    public void inserir(PostagemAlbum dto) throws Exception {
        Connection conexao = getConexao();
       
        if(dto.getPostagem() == null || dto.getAlbum() == null){
            throw new Exception("A Postagem ou Album está vazia.");
        }
       
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into postagens_albuns (postagem, album) values (?,?)", Statement.RETURN_GENERATED_KEYS);
       
        pstmt.setInt(1, dto.getPostagem().getId());
        pstmt.setInt(2, dto.getAlbum().getId());
       
        pstmt.executeQuery();
    }

    /**
     * Método responsável pela alteração de relacionar uma postagem a um album no banco de dados.
     * @author Paulo Henrique Araujo e Gusttavo Nunes Gomes.
     * @param dto dados antigos da postagemAlbum, com ID da postagem do album.
     * @param dtoNovo novos dados da postagemAlbum, com o ID da postagem e do album.
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void alterar(PostagemAlbum dto, PostagemAlbum dtoNovo) throws Exception{
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update postagens_albuns set postagem = ?, album = ? where postagem = ? and album = ?");
        
        pstmt.setInt(1, dtoNovo.getPostagem().getId());
        pstmt.setInt(2, dtoNovo.getAlbum().getId());
        pstmt.setInt(3, dto.getPostagem().getId());
        pstmt.setInt(4, dto.getAlbum().getId());
        
        pstmt.executeUpdate();
        
    }

    public PostagemAlbum selecionar(int postagem, int album) throws Exception{
       Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_albuns where postagem = ? and album = ?");
        
        pstmt.setInt(1, postagem);
        pstmt.setInt(2, album);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            PostagemAlbum pa = new PostagemAlbum();
            PostagemDAO postagemDAO = new PostagemDAO();
            AlbumDAO albumDAO = new AlbumDAO();
            
            pa.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            pa.setAlbum(albumDAO.selecionar(rs.getInt("album")));
            
            return pa;
        } else {
            return null;
        } 
    }
    
    /**
     * Método responsável por listar as postagens e albuns do banco de dados
     * @author Paulo Henrique Araujo
     * @return lista com todos os itens cadastrados no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    public List listar() throws Exception{
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens order by data desc");
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        PostagemDAO postagemDAO = new PostagemDAO();
        AlbumDAO albumDAO = new AlbumDAO();
        List lista;
        lista = new ArrayList();
        
        while(rs.next()){
            PostagemAlbum pa = new PostagemAlbum();
            pa.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            pa.setAlbum(albumDAO.selecionar(rs.getInt("album")));    
        }
        
        return lista;

    } 
}
