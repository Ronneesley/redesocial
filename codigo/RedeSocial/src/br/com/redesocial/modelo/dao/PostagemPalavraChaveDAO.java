/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Postagem;
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

   /**
     * Método responsável por alterar uma postagem a partir de suas palavras chaves
     * @author José Gilvan
     * @param palavraChave da postagem a ser alterada
     * @return a postagem alterada a partir da palavra chave
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void alterar(PostagemPalavraChave dto) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection conexao = getConexao();


         PreparedStatement  pstmt;
         pstmt = conexao.prepareStatement("update postagens set postagem = ?, palavra_chave = ? where id = ? ");
       
       
        pstmt.setInt(1, dto.getPostagem());
        pstmt.setInt(2, dto.getPalavraChave());
        
       
        pstmt.executeUpdate();
    }
        

    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("Select * from postagens order by data desc");
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
    
    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
