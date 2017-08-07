package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Estado;
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
    /**
     * Retorna uma conexão ativa com o banco de dados MySQL
     * @return conexão ativa com o banco de dados
     * @throws SQLException 
     * @throws java.lang.ClassNotFoundException caso não encontre o driver do banco de dados
     */
    
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from estados order by nome asc"); 

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

}
