package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.CategoriaDAO;
import br.com.redesocial.modelo.dto.Categoria;

/**
 * Define as regras de negócio para os usuários
 * @author Lara
 * @since 22/09/2017
 */
public class CategoriaBO extends BOCRUDBase<Categoria, CategoriaDAO> {
    /**
     * Instancia um objeto de CategoriaDAO
     * @return instância de acesso aos dados da Categoria
     */
    @Override
    protected CategoriaDAO instanciarDAO() {
       return new CategoriaDAO();
    }

    @Override
    protected void validarChavePrimaria(Categoria dto) throws Exception {
        //Validação da chave primária
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
    /**
     * Validação de atributos da categoria
     * @author Lara Caroline
     * @param dto identificador da categoria
     * @throws Exception possíveis excessões que podem acontecer
     */
    @Override
    protected void validar(Categoria dto) throws Exception {
       //Validação do campo descrição
       if (dto.getDescricao() == null || dto.getDescricao().trim().equals("")) throw new Exception("Preencha a descrição da categoria!");
    }
}