package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.DAOCRUDBase;
import java.util.List;

/**
 * Regras de negócio fundamentais para os CRUDs
 * @author Ronneesley Moura Teles
 * @param <DTO> tipo de dado da classe DTO
 * @param <DAO> tipo de dado da classe DAO
 * @since 08/08/2017
 */
public abstract class BOCRUDBase<DTO, DAO extends DAOCRUDBase<DTO>> {
    protected abstract DAO instanciarDAO();

    protected abstract void validarChavePrimaria(DTO dto) throws Exception;
    protected abstract void validar(DTO dto) throws Exception;

    public void inserir(DTO dto) throws Exception {
        validar(dto);

        //Inserção
        DAO dao = instanciarDAO();
        dao.inserir(dto);
    }

    public void alterar(DTO dto) throws Exception {
        validarChavePrimaria(dto);
        validar(dto);

        //Inserção
        DAO dao = instanciarDAO();
        dao.alterar(dto);
    }
    
    public void excluir(int id) throws Exception {
        DAO dao = instanciarDAO();
        dao.excluir(id);
    } 
    
    public DTO selecionar(int id) throws Exception {
        DAO dao = instanciarDAO();
        return dao.selecionar(id);
    }
    
    public List listar() throws Exception {
        DAO dao = instanciarDAO();
        return dao.listar();
    }
}
