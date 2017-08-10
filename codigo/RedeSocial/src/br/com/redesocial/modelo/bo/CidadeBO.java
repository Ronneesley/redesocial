package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.CidadeDAO;
import br.com.redesocial.modelo.dto.Cidade;


public class CidadeBO extends BOCRUDBase<Cidade, CidadeDAO> {
    @Override
    protected CidadeDAO instanciarDAO() {
        return new CidadeDAO();
    }
  
    @Override
    protected void validar(Cidade dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o nome da cidade");
        
    }
    
    @Override
    protected void validarChavePrimaria(Cidade dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
    
    protected void validarEstado(Cidade dto) throws Exception{
        if (dto.getEstado().getNome().trim().equals(""))
            throw new Exception("Insira o nome do estado.");

    }
}

