package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.CidadeDAO;
import br.com.redesocial.modelo.dto.Cidade;

/**
 *
 * @author Lucas Azevedo
 * since 11/08/2017
 */
public class CidadeBO extends BOCRUDBase<Cidade, CidadeDAO>{

    @Override
    protected CidadeDAO instanciarDAO() {
        return new CidadeDAO();
    }
    
    @Override
    protected void validarChavePrimaria(Cidade dto) throws Exception {
        if (dto.getId() == null) 
            throw new Exception("Preencha o campo id.");
    }

    @Override
    protected void validar(Cidade dto) throws Exception {
       if (dto.getNome().trim().equals(""))
            throw new Exception("Insira o nome dacidade.");
       if (dto.getEstado() == null)
            throw new Exception("Insira o estado.");
    }
}

