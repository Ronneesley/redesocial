package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.PalavraChave;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.PostagemPalavraChave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lara
 */
public class PostagemPalavraChaveDAO extends DAOBase {
    
    /**
     * Método responsável por selecionar uma postagem a partir de suas palavras chaves
     * @author Lara Caroline
     * @param palavraChave e postagem, da postagem a ser selecionada
     * @return a postagem selecionada a partir da palavra chave
     * @throws Exception possíveis exceções que podem acontecer
     */
    public PostagemPalavraChave selecionar(int palavraChave, int postagem) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_palavras_chave where palavra_chave = ? and postagem = ?");
        pstmt.setInt(1, palavraChave);
        pstmt.setInt(2, postagem);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            PostagemPalavraChave ppc = new PostagemPalavraChave();
            PostagemDAO postagemDAO = new PostagemDAO();
            PalavraChaveDAO palavraChaveDAO = new PalavraChaveDAO();

            ppc.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            ppc.setPalavraChave(palavraChaveDAO.selecionar(rs.getInt("palavra_chave")));
    
            return ppc;
        }else{
            return null;
        }
    }
    
    
   /**
     * Método responsável por criar um registro de palavras chaves na tabela
     * postagens_palavras_chave
     * @author Jeferson Rossini
     * @param palavra da palavraChave
     * @param post da postagem
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void inserir(PalavraChave palavra, Postagem post) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into postagens_palavras_chave (palavra_chave, postagem) values(?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, palavra.getId());
        pstmt.setInt(2, post.getId());
        pstmt.executeQuery();
    }
    

   /**
     * Método responsável por relacionar uma postagem a uma palavra chave
     * @author Paulo Henrique Araujo
     * @param dto, valores antigos
     * @param dtoNovo, valores novos
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void alterar(PostagemPalavraChave dto, PostagemPalavraChave dtoNovo) throws Exception {
        
        Connection conexao = getConexao();


        PreparedStatement  pstmt;
        pstmt = conexao.prepareStatement("update postagens_palavras_chaves set postagem = ?, palavra_chave = ? where postagem = ? and palavra_chave = ? ");
       
       
        pstmt.setInt(1, dtoNovo.getPostagem().getId());
        pstmt.setInt(2, dtoNovo.getPalavraChave().getId());
        pstmt.setInt(3, dto.getPostagem().getId());
        pstmt.setInt(4, dto.getPalavraChave().getId());
        
       
        pstmt.executeQuery();
    }
        

    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_palavras_chave order by data desc");
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        PostagemDAO postagemDAO = new PostagemDAO();
        PalavraChaveDAO palavrachaveDAO = new PalavraChaveDAO();
        List lista;
        lista = new ArrayList();
        
        while(rs.next()){
            PostagemPalavraChave ppc = new PostagemPalavraChave();
            ppc.setPostagem(postagemDAO.selecionar(rs.getInt("postagem")));
            ppc.setPalavraChave(palavrachaveDAO.selecionar(rs.getInt("palavra_chave")));
        }
        return lista;
    }
    
       /**
     * Método responsável por excluir registro da tabela postagens_palavras_chave
     * @author Jeferson Rossini
     * @param postagem da palavraChave
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void excluir(int postagem) throws Exception {

        
       Connection conexao = getConexao();
       
       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement ("delete from postagens_palavras_chave where postagem = ?");
       
       pstmt.setInt(1, postagem);
       pstmt.executeUpdate();

    }

}
