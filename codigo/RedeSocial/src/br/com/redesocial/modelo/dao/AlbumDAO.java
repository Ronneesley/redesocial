package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Daniel
 */
public class AlbumDAO {
    Connection con;
    
    private void conectar()throws Exception{
        
        String url = "jdbc:mysql://localhost:3306/redesocial";
        con = DriverManager.getConnection(url, "admin", "redesocial");
    }
    
    public void
}
