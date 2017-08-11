package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dao.interfaces.DAOCRUD;
import br.com.redesocial.modelo.dto.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Objeto de acesso aos dados dos Comentarios
 * @author Fernando Maciel da Silva
 * @since 11/08/2017
 */

public class ComentarioDAO extends DAOBase implements DAOCRUD<Comentario> {

    /**
     * Inseri um objeto no banco de dados na tabela comentario.
     * @param dto objeto responsavel pela transferencia dos dados do comentario.
     * @throws java.lang.Exception
     */
    
    @Override // envia uma mensagem de erro caso mude o nome do metodo pai.

    public void inserir(Comentario dto) throws Exception {
        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into comentario(descricao) values(?)");
        
        pstmt.setString(1, dto.getDescricao());
                
        pstmt.executeUpdate();
    }    
}
