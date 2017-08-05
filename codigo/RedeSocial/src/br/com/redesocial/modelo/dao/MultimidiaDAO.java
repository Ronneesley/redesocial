/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Multimidia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Lara
 */
public class MultimidiaDAO extends DAOBase {
    
    
    /* METÓDO PARA CONECTAR AO BANCO DE DADOS*/
   
    public void inserir( Multimidia dto ) throws Exception {
        Connection conexao = getConexao();
        
        if (dto.getDescricao().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into posts(descricao, autor) values(?, ?)");
        
        pstmt.setString(1, dto.getDescricao());
        pstmt.setString(2, dto.getAutor());
        
        pstmt.executeUpdate();
    }
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from multimidia where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

}
