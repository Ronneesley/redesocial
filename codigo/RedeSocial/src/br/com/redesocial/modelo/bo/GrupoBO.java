package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.GrupoDAO;
import br.com.redesocial.modelo.dto.Grupo;

/**
 * Define as regras de negócio para os usuários
 * @author Igor Justino Rodrigues
 * @since 27/07/2017
 */
public class GrupoBO extends BOCRUDBase <Grupo, GrupoDAO> {
    /**
     * Instancia um objeto de país DAO
     * @return instância de acesso aos dados do país
     */
    @Override
    protected GrupoDAO instanciarDAO() {
        return new GrupoDAO();
    }
    
    /**
     * Validação da chave primária de um objeto país
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    @Override
    protected void validarChavePrimaria(Grupo dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo Id");
    }

    /**
     * Validação dos atributos de país
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    @Override
    protected void validar(Grupo dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o Nome do grupo");
        if (dto.getDataCriacao() == null) throw new Exception("Preencha a Data de Criação do grupo");
        if (dto.getDescricao() == null || dto.getDescricao().trim().equals("")) throw new Exception("Preencha o campo Descricao");
        if (dto.getPrivacidade() == null) throw new Exception("Preencha o campo Privacidade");
        if (dto.getTipo().trim().equals("")) throw new Exception("Preencha o Tipo");
    }    
}
