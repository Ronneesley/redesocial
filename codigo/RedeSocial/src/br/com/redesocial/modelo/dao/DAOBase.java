package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe base para conexão com o banco de dados
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class DAOBase {
    /**
     * Retorna uma conexão ativa com o banco de dados MySQL
     * @return conexão ativa com o banco de dados
     * @throws SQLException 
     */
    protected Connection getConexao() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/redesocial", "admin", "123456789");
    }
}
