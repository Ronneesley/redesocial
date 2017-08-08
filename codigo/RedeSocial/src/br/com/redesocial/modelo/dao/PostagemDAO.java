package br.com.redesocial.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author IgorRodrigues
 */
public class PostagemDAO extends DAOBase {
    
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from postagens where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
