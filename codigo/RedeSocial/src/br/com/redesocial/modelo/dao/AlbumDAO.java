package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Album;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(rs.next()){
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setData(rs.getDate("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            return a;
        }else{
            return null;
        }
    }

    public List listar() throws Exception {
        conectar();

        PreparedStatement pstmt;
        pstmt = con.prepareStatement("select * from albuns order by id desc"); 

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        while (rs.next()){
            Album a = new Album();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setData(rs.getDate("data"));
            a.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));

            lista.add(a);
        }

        return lista;
    }
}
