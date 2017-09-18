/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.PostagemPalavraChave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lara
 */
public class PostagemPalavraChaveDAO extends DAOCRUDBase<PostagemPalavraChave>{
    
    /**
     * Método responsável por selecionar uma postagem a partir de suas palavras chaves
     * @author Lara Caroline
     * @param palavraChave da postagem a ser selecionada
     * @return a postagem selecionada a partir da palavra chave
     * @throws Exception possíveis exceções que podem acontecer
     */
    public PostagemPalavraChave selecionar(int palavraChave) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from postagens_palavras_chave where palavra_chave = ?");
        pstmt.setInt(1, palavraChave);

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

    @Override
    public void inserir(PostagemPalavraChave dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(PostagemPalavraChave dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstm;
        pstmt = conexao.preparedStatement("Select * from postagens_palavras_chave where palavra_chave = ?");
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        List lista;
        lista = new ArrayList();
        
        while(rs.next()){
            Postagem_Palavra_Chave ppc = new Postagem_Palavra_Chave();
            ppc.setPostagem(PostagemDAO.selecionar(rs.getPostagem("postagem")));
            ppc.setPalavraChave(rs.getPalavraChave("palavra_chave")));
        
        }
        return lista;
    }
*/
    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
