package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.UsuarioDAO;
import br.com.redesocial.modelo.dto.Usuario;

/**
 * Define as regras de negócio para os usuários
 * @author Ronneesley Moura Teles e Daniel Moreira Cardoso
 * @since 27/07/2017
 */
public class UsuarioBO extends BOCRUDBase<Usuario, UsuarioDAO> {
    @Override
    protected UsuarioDAO instanciarDAO() {
        return new UsuarioDAO();
    }
    
    /**
     * Validação de atributos de um usuário
     * @author Daniel Moreira Cardoso
     * @param dto idetificador de usuário
     * @throws Exception possíveis excessões que podem acontecer
     */
    @Override
    protected void validar(Usuario dto) throws Exception {
        //Validações
        if (dto.getNome() == null || dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do usuário");

        if (dto.getEmail().trim().equals("")) throw new Exception("Preencha o e-mail do usuário");

        if (dto.getSenha().trim().equals("")) throw new Exception("Preencha a senha do usuário");

        if (dto.getTelefone().trim().equals("")) throw new Exception("Preencha o telefone do usuário");

        if (dto.getDataNascimento() == null) throw new Exception("Preencha a data de nascimento do usuário");

        if (dto.getSexo() == null) throw new Exception("Preencha o sexo do usuário");

        if (dto.getDataCadastro() == null) throw new Exception("Preencha a data de cadastro do usuário");

        if (dto.getStatus() == null) throw new Exception("Preencha o status do usuário");

        //Validação de chave estrangeira
        if (dto.getCidade() == null) throw new Exception("Preencha a cidade do usuário");
    }

    @Override
    protected void validarChavePrimaria(Usuario dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }

    public Usuario logar(String email, String senha) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.logar(email, senha);
    }
}
