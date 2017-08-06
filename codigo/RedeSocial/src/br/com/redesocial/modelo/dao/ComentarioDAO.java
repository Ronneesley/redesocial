package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Comentario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public void atualizar() throws Exception {
        conectar();
        
        PreparedStatement pstmt = con.prepareStatement("update comentarios set descricao = ? where id = ?");
        pstmt.setString(1, p.getDescricao);
        pstmt.setInt(2, p.getId);
        
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
    
 public List listar() throws Exception {
        conectar();

        PreparedStatement pstmt;
        pstmt = con.prepareStatement("select * from posts order by id desc"); 

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();
        
        while (rs.next()){
            Comentario c = new Comentario();
            c.setId(rs.getInt("id"));
            c.setDescricao(rs.getString("descricao"));
            c.setCurtidas(rs.getInt("curtidas"));
            c.setData(rs.getDate("data"));
            //c.setPostagem(rs.getInt(""));
            c.setComentario(c.selecionar(rs.getInt("resposta")));
            lista.add(c);
        }

        return lista;
    }
}
