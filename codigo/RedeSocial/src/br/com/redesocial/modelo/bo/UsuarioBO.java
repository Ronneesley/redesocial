package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.UsuarioDAO;
import br.com.redesocial.modelo.dto.Usuario;

/**
 * Define as regras de negócio para os usuários
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class UsuarioBO extends BOBase<Usuario, UsuarioDAO> {
    @Override
    protected UsuarioDAO instanciarDAO() {
        return new UsuarioDAO();
    }

    @Override
    protected void validar(Usuario dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do usuário");
        
        if (dto.getEmail().trim().equals("")) throw new Exception("Preencha o e-mail do usuário");
        
        if (dto.getSenha().trim().equals("")) throw new Exception("Preencha a senha do usuário");
    }
}
