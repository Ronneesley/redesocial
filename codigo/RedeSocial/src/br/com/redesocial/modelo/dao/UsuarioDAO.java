package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dao.interfaces.DAOCRUD;
import br.com.redesocial.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Objeto de acesso aos dados dos usuários
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class UsuarioDAO extends DAOBase implements DAOCRUD<Usuario> {
    /**
     * Inseri um objeto no banco de dados na tabela usuários
     * @param dto objeto com os dados de usuário já preenchido
     * @throws Exception 
     */
    @Override
    public void inserir(Usuario dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into usuarios(nome, email, senha) values(?, ?, ?)");
        
        pstmt.setString(1, dto.getNome());
        pstmt.setString(2, dto.getEmail());
        pstmt.setString(3, dto.getSenha());
        
        pstmt.executeUpdate();
    }
}
