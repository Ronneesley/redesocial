package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.DAOCRUDBase;

/**
 * Regras de negócio fundamentais para os CRUDs
 * @author Ronneesley Moura Teles
 * @param <DTO> tipo de dado da classe DTO
 * @param <DAO> tipo de dado da classe DAO
 * @since 08/08/2017
 */
public abstract class BOBase<DTO, DAO extends DAOCRUDBase> {
    protected abstract DAO instanciarDAO();
    
    protected abstract void validar(DTO dto) throws Exception;
    
    public void inserir(DTO dto) throws Exception {
        validar(dto);
        
        //Inserção
        DAO dao = instanciarDAO();
        dao.inserir(dao);
    }    
}
