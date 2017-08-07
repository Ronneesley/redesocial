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
    
    
    
    public void alterar(PaisDAO p) throws Exception {
        conectar();
        
        if (p.getNome().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("update paises set  nome = ? where id = ?");
        
   
        pstmt.setString(1, p.getNome());
        pstmt.setInt(2, p.getId());
        
        pstmt.executeUpdate();
    }
    
    private String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    



    public void excluir(int id) throws Exception {
        conectar();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("delete from paises where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }




    
   
    
    
    
    
}
