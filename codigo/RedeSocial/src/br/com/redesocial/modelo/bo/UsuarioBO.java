package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.UsuarioDAO;
import br.com.redesocial.modelo.dto.Usuario;

/**
 * Define as regras de negócio para os usuários
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class UsuarioBO {
    /**
     * Inseri um usuário no banco de dados verificando as regras necessárias de inserção
     * @param usuario DTO com dados preenchidos
     * @throws Exception 
     */
    public void inserir(Usuario usuario) throws Exception {
        //Validações
        if (usuario.getNome().trim().equals("")) throw new Exception("Preencha o nome do usuário");
        
        if (usuario.getEmail().trim().equals("")) throw new Exception("Preencha o e-mail do usuário");
        
        if (usuario.getSenha().trim().equals("")) throw new Exception("Preencha a senha do usuário");
        
        //Inserção
        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(usuario);
    }
}
