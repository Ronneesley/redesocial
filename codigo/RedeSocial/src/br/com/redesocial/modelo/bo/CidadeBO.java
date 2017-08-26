package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.CidadeDAO;
import br.com.redesocial.modelo.dto.Cidade;

/**
 * Define as regras de negócio para os usuários
 * @author Lucas Azevedo
 * @since 11/08/2017
 */
public class CidadeBO extends BOCRUDBase<Cidade, CidadeDAO>{
    /**
     * Instancia um objeto de cidade DAO
     * @return instância de acesso aos dados do cidade
     */
    @Override
    protected CidadeDAO instanciarDAO() {
        return new CidadeDAO();
    }
     /**
     * Validação da chave primária de um objeto cidade
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    @Override
    protected void validarChavePrimaria(Cidade dto) throws Exception {
        if (dto.getId() == null)
            throw new Exception("Preencha o campo id.");
    }
     /**
     * Validação dos atributos de cidade
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    @Override
    protected void validar(Cidade dto) throws Exception {
       if (dto.getNome().trim().equals(""))
            throw new Exception("Insira o nome da cidade.");
       if (dto.getEstado() == null)
            throw new Exception("Insira o estado.");
    }
}

