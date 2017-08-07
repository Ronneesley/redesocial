package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe base para conexão com o banco de dados
 * @author Wesley M. Felix
 * @since 27/07/2017
 */
public class EstadoDAO {
    Connection con;
    private String getString;
    
    private void conectar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/redesocial";
        con = DriverManager.getConnection(url, "admin", "redesocial");
    }
    
    public void altera(EstadoDAO p) throws SQLException, Exception {
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("update estados set nome = ?, pais = ? where id = ?");
        conectar();

        pstmt.setString(1, p.getNome());
        pstmt.setString(2, p.getPais());        
        pstmt.setInt(3, p.getId());

        pstmt.execute();
        

    }

    private String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getPais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
