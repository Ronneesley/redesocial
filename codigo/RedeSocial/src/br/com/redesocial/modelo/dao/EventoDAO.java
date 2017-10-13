package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Objeto de acesso aos dados dos eventos
 * @author Willian Wallace
 * @since 13/10/2017
 */
public class EventoDAO extends DAOCRUDBase<Evento> {
     
    @Override
    public void inserir(Evento dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Evento dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evento selecionar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();  
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from eventos where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
