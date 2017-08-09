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

    static Estado selecionar(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void alterar(Estado p) throws SQLException, Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update estados set nome = ?, pais = ? where id = ?");

        pstmt.setString(1, p.getNome());
        pstmt.setInt(2, p.getPais().getId());
        pstmt.setInt(3, p.getId());

        pstmt.executeUpdate();
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