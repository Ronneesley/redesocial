package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.EstadoDAO;
import br.com.redesocial.modelo.dto.Estado;

/**
 *
 * @author Daniel Moreira Cardoso
 */
public class EstadoBO extends BOCRUDBase<Estado, EstadoDAO>{
    @Override
    protected EstadoDAO instanciarDAO() {
        return new EstadoDAO();
    }

    @Override
    protected void validarChavePrimaria(Estado dto) throws Exception {
        if (dto.getId() == null)
            throw new Exception("Preencha o campo id.");
    }

    @Override
    protected void validar(Estado dto) throws Exception {
       if (dto.getNome().trim().equals(""))
            throw new Exception("Insira o nome do estado.");
       if (dto.getPais() == null)
            throw new Exception("Insira o país.");
    }
}
