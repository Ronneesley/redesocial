package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe base para conexão com o banco de dados
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public abstract class DAOBase {
    private static Connection conexao = null;
    
    /**
     * Retorna uma conexão ativa com o banco de dados MySQL
     * @return conexão ativa com o banco de dados
     * @throws SQLException 
     * @throws java.lang.ClassNotFoundException caso não encontre o driver do banco de dados
     */
    protected Connection getConexao() throws SQLException, ClassNotFoundException {
        if (conexao == null){
            Class.forName("com.mysql.jdbc.Driver");
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/redesocial", "admin", "redesocial");
        }
        
        return conexao;
    }
    
    /**
     * Retorna o ID que foi gerado no banco de dados
     * @param stmt comando enviado
     * @return ID gerado pelo banco de dados
     * @throws SQLException 
     */
    protected Integer getId(Statement stmt) throws SQLException {
        ResultSet chavesGeradas = stmt.getGeneratedKeys();
        
        if (chavesGeradas.next()){
            return chavesGeradas.getInt(1);
        } else {
            return null;
        }
    }
}
