package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe base para conexão com o banco de dados
 * @author Ronneesley Moura Teles, Igor, Ianka, Heitor e Gusttavo.
 * @since 27/07/2017
 */
public class ComentarioDAO {
    /**
     * Retorna uma conexão ativa com o banco de dados MySQL
     * @return conexão ativa com o banco de dados
     * @throws SQLException 
     * @throws java.lang.ClassNotFoundException caso não encontre o driver do banco de dados
     */
    
    Connection con;
    protected Connection getConexao() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/redesocial", "admin", "redesocial");
    }
    
    private void conectar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/redesocial";
        con = DriverManager.getConnection(url, "root", "");
    }
    
    public void excluir(int id) throws Exception {
        conectar();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("delete from comentarios where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
    
    public Post selecionar(int id) throws Exception {
        conectar ();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("Select * from posts where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        if (rs.next()){
            Post p = new Post();
            p.setId(id);
            p.setCurtidas(rs.getString("curtidas"));
            p.setData(rs.getDate("data"));
            p.setPostagem(rs.getString("postagem"));
            p.setResposta(rs.getString("resposta"));
           
            return p;
        } else {
            return null;
        }
    }
}
