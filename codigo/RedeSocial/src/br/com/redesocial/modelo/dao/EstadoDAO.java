package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Wesley M. Felix
 * @since 27/07/2017
 */
<<<<<<< HEAD
public class EstadoDAO extends DAOBase {

   
    
=======
public class EstadoDAO extends DAOCRUDBase<Estado> {
    @Override
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
    public void alterar(Estado p) throws SQLException, Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
<<<<<<< HEAD
        pstmt = conexao.prepareStatement("update estados set nome = ? pais = ? where id = ?");
        
=======
        pstmt = conexao.prepareStatement("update estados set id = ?, pais = ? where nome = ? order by ASC");

>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
        pstmt.setInt(1, p.getId());
        pstmt.setString(2, p.getPais());
        pstmt.setString(3, p.getNome());
<<<<<<< HEAD
        
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
=======

        pstmt.execute();
    }

    @Override
    public void inserir(Estado dto) throws Exception {
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a

            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            //e.setPais(paisDAO.selecionar(rs.getInt("pais")));  
            
            lista.add(e);
        }

<<<<<<< HEAD
        return lista;
=======
    @Override
    public Estado selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
    }
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

<<<<<<< HEAD
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from estados where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
=======
    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {

>>>>>>> 8af9da3eced508f5097c74136a1d05ef8557150a
    }
}
