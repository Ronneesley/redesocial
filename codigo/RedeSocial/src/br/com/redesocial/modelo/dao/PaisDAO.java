package br.com.redesocial.modelo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaisDAO {
    Connection con;
    
    private void conectar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/redesocial";
        con = DriverManager.getConnection(url, "root", "");
    }
    
    
    
    
    
    
    
    public void excluir(int id) throws Exception {
        conectar();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("delete from paises where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
    
   
    
    
    
    
}
