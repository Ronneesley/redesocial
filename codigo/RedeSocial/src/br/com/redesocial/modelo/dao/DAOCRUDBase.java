package br.com.redesocial.modelo.dao;

import java.util.List;

/**
 * Acesso aos dados para entidades com CRUD
 * @author Ronneesley Moura Teles
 * @param <DTO> tipo de dado do DTO
 * @since 08/08/2017
 */
public abstract class DAOCRUDBase<DTO> extends DAOBase {
    public abstract void inserir(DTO dto) throws Exception;
    public abstract void alterar(DTO dto) throws Exception;
    public abstract DTO selecionar(int id) throws Exception;
    public abstract List listar() throws Exception;
    public abstract void excluir(int id) throws Exception;
}
