package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Classe base para conexão com o banco de dados
 *
 * @author Wesley M. Felix, Lara Caroline
 * @since 27/07/2017
 */
public class EstadoDAO extends DAOCRUDBase<Estado> {

    @Override
    public Estado selecionar(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from estados where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if (rs.next()) {
            Estado e = new Estado();
            PaisDAO paisDAO = new PaisDAO();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            e.setPais(paisDAO.selecionar(rs.getInt("pais")));
            return e;
        } else {
            return null;
        }
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
        Connection conexao = getConexao();

        PreparedStatement pstmt = conexao.prepareStatement("insert into estados(nome, pais) values(?, ?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, dto.getNome());
        pstmt.setInt(2, dto.getPais().getId());

        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from estados where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
