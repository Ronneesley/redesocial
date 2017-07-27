package br.com.redesocial.modelo.dao.interfaces;

/**
 * Define os métodos obrigatórios de uma DAO para CRUD
 * @author Ronneesley Moura Teles
 * @param <T> classe da entidade do CRUD
 * @since 27/07/2017
 */
public interface DAOCRUD<T> {
    public void inserir(T dto) throws Exception;
}
