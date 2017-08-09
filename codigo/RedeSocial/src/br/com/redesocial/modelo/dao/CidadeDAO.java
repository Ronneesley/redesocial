package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Ronneesley Moura Teles
 * @since 08/08/2017
 */
public class CidadeDAO extends DAOCRUDBase<Cidade> {

    @Override
    public void inserir(Cidade dto) throws Exception {
        
    }

    @Override
    public void alterar(Cidade dto) throws Exception {
        
    }

    @Override
    public Cidade selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from cidade where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Cidade p = new Cidade();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            p.setId(rs.getInt("id"));
            p.setEstado(EstadoDAO.selecionar(rs.getString("estado")));
            p.setNome(rs.getString("nome"));
            
            return p;
        } else {
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //Apague a linha e escreva o código
    }

    @Override
    public void excluir(int id) throws Exception {
        
    }

}
