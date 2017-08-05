/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Multimidia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lara
 */
public class MultimidiaDAO {
    
    public Multimidia selecionar(int id) throws Exception{
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("select * from multimidia where id = ?");
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
    
}
