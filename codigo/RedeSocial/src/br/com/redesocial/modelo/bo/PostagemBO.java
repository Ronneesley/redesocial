package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.PostagemDAO;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Usuario;
import java.util.Date;

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
        if (dto.getUps() == null) throw new Exception("Preencha o campo ups");
        if (dto.getDowns() == null) throw new Exception("Preencha o campo downs");
        if (dto.getDescricao() == null || dto.getDescricao().trim().equals("")) throw new Exception("Preencha o campo Descricao");
        if (dto.getData() == null) throw new Exception("Preencha a Data");
        if (dto.getUsuario()== null) throw new Exception("Preencha o campo usuário");
    }

     @Override
    protected void validarChavePrimaria(Postagem dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }

    public void publicar(Usuario usuario, String mensagem) throws Exception {        
        Postagem postagem = new Postagem();
        postagem.setUps(0);
        postagem.setDowns(0);
        postagem.setData(new Date());
        postagem.setDescricao(mensagem);
        postagem.setUsuario(usuario);
        postagem.setVisualizacoes(0);
                
        PostagemDAO dao = new PostagemDAO();
        dao.inserir(postagem);
    }
}

