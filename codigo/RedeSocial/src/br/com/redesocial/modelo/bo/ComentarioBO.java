package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.ComentarioDAO;
import br.com.redesocial.modelo.dto.Comentario;

/**
 *
 * @author Adallberto Lucena
 */
public class ComentarioBO extends BOCRUDBase<Comentario, ComentarioDAO>{
    /**
     * Instancia um objeto de Comentario
     * @author Adallberto Lucena Moura
     * @return instância de acesso aos dados do comentario
     */
    @Override
    protected ComentarioDAO instanciarDAO() {
        return new ComentarioDAO();
    }
    
    /**
     * Validação da chave primária de um objeto Comentario
     * @author Adallberto Lucena Moura
     * @param dto identificador do objeto Comentario
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    protected void validarChavePrimaria(Comentario dto) throws Exception {
        if (dto.getId() == null)
            throw new Exception("Preencha o campo id.");
    }
    
    /**
     * Validação de atributos de um Comentario
     * @author Adallberto Lucena Moura
     * @param dto identificador do objeto Comentario
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    protected void validar(Comentario dto) throws Exception {
         if (dto.getDescricao().trim().equals("")) throw new Exception("Insira o comentário.");
         if (dto.getUps()== null) throw new Exception("Insira as comentários");
         if (dto.getDowns()== null) throw new Exception("Insira as comentários");
         if (dto.getData() == null) throw new Exception("Preencha o data da comentários");
         if (dto.getPostagem() == null) throw new Exception("Preencha a postagem do comentário");
         if (dto.getResposta() == null) throw new Exception("Preencha a postagem do comentário");
    }
}
