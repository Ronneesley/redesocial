package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dao.interfaces.DAOCRUD;
import br.com.redesocial.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
        public Usuario selecionar (int id) throws Exception{
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
        pstmt.setInt(1, id);
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        if (rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setTelefone(rs.getString("telefone"));
            u.setSenha(rs.getString("senha"));
            u.setNascimento(rs.getDate("data"));
            //u.setSexo(rs.getSexo("sexo"));//olhar esse aqui
            //u.setDataCadastro(rs.getData("dataCadastro"));
            u.setStatus(rs.getBoolean("status"));
            //u.setFoto(rs.getMultimida("foto"));
            //u.setCidade(rs.setCidade("cidade"));
            
            return u;
            
        }else{
            return null;
        }
    }
}
