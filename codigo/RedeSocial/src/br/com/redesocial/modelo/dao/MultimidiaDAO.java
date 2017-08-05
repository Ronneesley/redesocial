/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Lara
 */
public class MultimidiaDAO {
    
    /* METÓDO PARA CONECTAR AO BANCO DE DADOS*/
    private Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from multimidia where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

}
