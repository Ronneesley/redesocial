package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    Connection con;
    
    private void conectar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/redesocial";
        con = DriverManager.getConnection(url, "root", "");
    }
    
    public void inserir(Post p) throws Exception {
        conectar();
        
        if (p.getDescricao().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("insert into posts(descricao, autor) values(?, ?)");
        
        pstmt.setString(1, p.getDescricao());
        pstmt.setString(2, p.getAutor());
        
        pstmt.executeUpdate();
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
            Post p = new Post();
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setAutor(rs.getString("autor"));
            
            lista.add(p);
        }
        
        return lista;
    }
    
    public Post selecionar(int id) throws Exception {
        conectar();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("select * from posts where id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        if (rs.next()){
            Post p = new Post();
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setAutor(rs.getString("autor"));
            
            return p;
        } else {
            return null;
        }
    }
    
    public void atualizar(Post p) throws Exception {
        conectar();
        
        if (p.getDescricao().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("update posts set descricao = ?, autor = ? where id = ?");
        
        pstmt.setString(1, p.getDescricao());
        pstmt.setString(2, p.getAutor());
        pstmt.setInt(3, p.getId());
        
        pstmt.executeUpdate();
    }
    
    public void excluir(int id) throws Exception {
        conectar();
        
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("delete from posts where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
    
    public static void main(String[] args) throws Exception {
        PostDAO dao = new PostDAO();
        Post p = dao.selecionar(4);
        
        System.out.println(p.getDescricao());
    }
    
    public static void mainAtualizar(String[] args) throws Exception {
        Post p = new Post();
        p.setId(5);
        p.setDescricao("Dia chato esse!");
        p.setAutor("Bob");
        
        PostDAO dao = new PostDAO();
        dao.atualizar(p);
    }
    
    public static void mainExcluir(String[] args) throws Exception {
        PostDAO dao = new PostDAO();
        dao.excluir(2);
    }
    
    public static void mainInserir(String[] args) {
        Post p = new Post();
        p.setDescricao("Que dia lindo!");
        p.setAutor("Bob");
        
        try {
            PostDAO dao = new PostDAO();
            dao.inserir(p);
        } catch (Exception ex){
            System.err.println("Erro: " + ex.getMessage());
        }
    }
}
