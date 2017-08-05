/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;


import br.com.redesocial.modelo.dao.interfaces.DAOCRUD;
import br.com.redesocial.modelo.dto.Multimidia;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Lara, Jeferson
 */
public class MultimidiaDAO extends DAOBase{
    /* METÓDO PARA CONECTAR AO BANCO DE DADOS*/
    
    public Multimidia selecionar(int id) throws Exception{
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from multimidia where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        if (rs.next()){
            Multimidia m = new Multimidia();
            m.setId(rs.getInt("id"));
            m.setMidia(rs.getBytes("midia"));
            m.setTipoConteudo(rs.getString("tipoConteudo"));
            m.setData(rs.getDate("data"));
            
            return m;
        } else {
            return null;
        }
    }
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from multimidia where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
