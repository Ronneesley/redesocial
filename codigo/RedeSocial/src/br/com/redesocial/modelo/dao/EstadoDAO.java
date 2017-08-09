package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

   
    
    public void alterar(Estado p) throws SQLException, Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update estados set nome = ? pais = ? where id = ?");
        
        pstmt.setInt(1, p.getId());
        pstmt.setString(2, p.getPais());  
        pstmt.setString(3, p.getNome());
        
        pstmt.executeUpdate();
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
