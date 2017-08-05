package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Album;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Daniel
 */
public class AlbumDAO extends DAOBase{
    Connection con;
    
    private void conectar()throws Exception{
        
        String url = "jdbc:mysql://localhost:3306/redesocial";
        con = DriverManager.getConnection(url, "admin", "redesocial");
    }
    
    public Album selecionar(int id)throws Exception{
        conectar();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("select * from albuns where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        if(rs.next()){
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setData(rs.getDate("data"));
            //a.setUsuario();
            
            return a;
        }else{
            return null;
        }
        
    }
}
