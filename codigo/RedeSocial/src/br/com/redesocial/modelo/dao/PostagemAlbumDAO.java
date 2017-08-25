/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.PostagemAlbum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Wesley Morais
 */
public class PostagemAlbumDAO extends DAOBase {
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from postagens_albuns where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    public void inserir(Object dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável pela alteração de relacionar uma postagem a um album no banco de dados.
     * @author Paulo Henrique Araujo.
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
        
        pstmt.executeQuery();
        
    }

    public Postagem selecionar(int id) throws Exception{
       Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_albuns where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Postagem p = new Postagem();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            p.setId(rs.getInt("id"));
            p.setCurtidas(rs.getInt("curtidas"));
            p.setDescricao(rs.getString("descricao"));
            p.setData(rs.getDate("data"));
            
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            
            return p;
        } else {
            return null;
        } 
    }



}
