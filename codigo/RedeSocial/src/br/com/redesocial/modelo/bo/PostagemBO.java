package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.PostagemDAO;
import br.com.redesocial.modelo.dto.Postagem;

/**
 *
 * @author aluno
 */
public class PostagemBO extends BOCRUDBase<Postagem, PostagemDAO> {
     @Override
     protected PostagemDAO instanciarDAO() {
        return new PostagemDAO();
    }
     @Override
    protected void validar(Postagem dto) throws Exception {
        //Validações
        if (dto.getCurtidas() == null) throw new Exception("Preencha o campo Curtidas");
        if (dto.getDescricao() == null || dto.getDescricao().trim().equals("")) throw new Exception("Preencha o campo Descricao");
        if (dto.getData() == null) throw new Exception("Preencha a Data");
        if (dto.getUsuario()== null) throw new Exception("Preencha o campo usuário");
    }

     @Override
    protected void validarChavePrimaria(Postagem dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
}

