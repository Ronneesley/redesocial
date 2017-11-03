/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Love
 */
public class GrupoDAO extends DAOCRUDBase<Grupo>{

        /**
     * Método responsável pela inserção de um país no banco de dados
     * @author Ciclano
     * @param g país a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Grupo g) throws Exception {
        Connection conexao = getConexao();

        if(g.getNome().trim().equals("")){
            throw new Exception("O campo Nome não pode estar vazio!");
        }
        
        if(g.getDataCriacao() == null){
            throw new Exception("O campo Data da Criação não pode estar vazio!");
        }
        
        if(g.getDescricao().trim().equals("")){
            throw new Exception("O campo Descrição não pode estar vazio!");
        }
        
        if(g.getPrivacidade() == null){
            throw new Exception("O campo Privacidade não pode estar vazio!");
        }
        
        if(g.getTipo().trim().equals("")){
            throw new Exception("O campo Tipo não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into grupos (nome, data_criacao, descricao, privacidade, tipo) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, g.getNome());
        pstmt.setDate(2, new java.sql.Date(g.getDataCriacao().getTime()));
        pstmt.setString(3,g.getDescricao());
        pstmt.setInt(4, g.getPrivacidade());
        pstmt.setString(5, g.getTipo());        
        
        pstmt.executeUpdate();

        g.setId(getId(pstmt));
    }

    /**
     * Método responsável pela alteração de um país no banco de dados
     * @author Macilon Arruda
     * @param g novos dados do país, com o ID do país a ser alterado preenchido
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void alterar(Grupo g) throws Exception {
        Connection conexao = getConexao();

        if(g.getNome().trim().equals("")){
            throw new Exception("O campo Nome não pode estar vazio!");
        }
        
        if(g.getDataCriacao() == null){
            throw new Exception("O campo Data da Criação não pode estar vazio!");
        }
        
        if(g.getDescricao().trim().equals("")){
            throw new Exception("O campo Descrição não pode estar vazio!");
        }
        
        if(g.getPrivacidade() == null){
            throw new Exception("O campo Privacidade não pode estar vazio!");
        }
        
        if(g.getTipo().trim().equals("")){
            throw new Exception("O campo Tipo não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update grupos set nome = ?, data_criacao = ?, descricao = ?, privacidade = ?, tipo = ? where id = ?");

        pstmt.setString(1, g.getNome());
        pstmt.setDate(2, new java.sql.Date(g.getDataCriacao().getTime()));
        pstmt.setString(3,g.getDescricao());
        pstmt.setInt(4, g.getPrivacidade());
        pstmt.setString(5, g.getTipo());        
        
        pstmt.setInt(6,g.getId());

        pstmt.executeUpdate();
    }

    /**
     * Método responsável pela exclusão de um país no banco de dados
     * @author Ciclano
     * @param id identificador do país a ser excluído
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from grupos where id = ?");

        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }

    /**
     * Método que seleciona um país já cadastrado no banco de dados
     * @author Ciclano
     * @param id identificador do país
     * @return país selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public Grupo selecionar(int id) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("select * from grupos where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            Grupo g = new Grupo();
            g.setId(id);
            g.setNome(rs.getString("nome"));

            return g;
        }else{
            return null;
        }
    }

    /**
     * Método que lista todos os países em ordem alfabética do banco de dados
     * @author Thalia Santos de Santana
     * @return lista de países ordenados alfabeticamente
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
        
       Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from grupos order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           Grupo g = new Grupo();
           g.setId(rs.getInt("id"));
           g.setNome(rs.getString("nome"));

           lista.add(g);
       }

       return lista;
    }

    
}
