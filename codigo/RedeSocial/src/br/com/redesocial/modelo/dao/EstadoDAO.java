package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Wesley M. Felix
 * @since 27/07/2017
 */
public class EstadoDAO extends DAOBase {
    
    public Estado selecionar(int id) throws Exception{
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from estado where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if (rs.next()){
            Estado e = new Estado();
            //Pais p = new Pais(); 
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            //p.setNome(rs.getString("nome")); 
            //Existe essa possibilidade, porém os estados e países não estarão ligados, podendo retornar valores errados
            //DÚVIDAAAAAAAAAAAA!!!!!!!!!!!
            return e;
        } else {
            return null;
        }
    }
    
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from estados order by nome"); 

        ResultSet rs;
        rs = pstmt.executeQuery();

        List lista;
        lista = new ArrayList();
        
        //PaisDAO paisDAO = new PaisDAO();
        while (rs.next()){
            Estado e = new Estado();

            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            //e.setPais(paisDAO.selecionar(rs.getInt("pais")));  
            
            lista.add(e);
        }

        return lista;
    }
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from estados where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
