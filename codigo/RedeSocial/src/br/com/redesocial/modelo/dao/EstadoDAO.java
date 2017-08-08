package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 * @author Wesley M. Felix
 * @since 27/07/2017
 */
public class EstadoDAO extends DAOCRUDBase<Estado> {
    @Override
    public void alterar(Estado p) throws SQLException, Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update estados set id = ?, pais = ? where nome = ? order by ASC");

        pstmt.setInt(1, p.getId());
        pstmt.setString(2, p.getPais());
        pstmt.setString(3, p.getNome());

        pstmt.execute();
    }

    @Override
    public void inserir(Estado dto) throws Exception {

    }

    @Override
    public Estado selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {

    }
}
