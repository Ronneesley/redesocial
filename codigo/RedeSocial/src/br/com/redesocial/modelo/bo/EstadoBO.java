package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.EstadoDAO;
import br.com.redesocial.modelo.dto.Estado;

/**
 *
 * @author Daniel Moreira Cardoso
 */
public class EstadoBO extends BOCRUDBase<Estado, EstadoDAO>{
    /**
     * Instancia um objeto de Estado
     * @author Daniel Moreira Cardoso
     * @return instância de acesso aos dados do estado
     */
    @Override
    protected EstadoDAO instanciarDAO() {
        return new EstadoDAO();
    }
    
    /**
     * Validação da chave primária de um objeto Estado
     * @author Daniel Moreira Cardoso
     * @param dto identificador de Estado
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    protected void validarChavePrimaria(Estado dto) throws Exception {
        if (dto.getId() == null)
            throw new Exception("Preencha o campo id.");
    }
    
    /**
     * Validação de atributos de um Estado
     * @author Daniel Moreira Cardoso
     * @param dto identificador de Estado
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    protected void validar(Estado dto) throws Exception {
       if (dto.getNome().trim().equals(""))
            throw new Exception("Insira o nome do estado.");
       if (dto.getPais() == null)
            throw new Exception("Insira o país.");
    }
}
