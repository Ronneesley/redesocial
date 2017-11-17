package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.AtividadeDAO;
import br.com.redesocial.modelo.dto.Atividade;

/**
 * Define as regras de negócio para os usuários
 * @author 
 * @since 11/08/2017
 */
public class AtividadeBO extends BOCRUDBase<Atividade, AtividadeDAO>{
    /**
     * Instancia um objeto de cidade DAO
     * @return instância de acesso aos dados do cidade
     */
    @Override
    protected AtividadeDAO instanciarDAO() {
        return new AtividadeDAO();
    }
     /**
     * Validação da chave primária de um objeto cidade
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    @Override
    protected void validarChavePrimaria(Atividade dto) throws Exception {
        if (dto.getId() == null)
            throw new Exception("Preencha o campo id.");
    }
     /**
     * Validação dos atributos de cidade
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    @Override
    protected void validar(Atividade dto) throws Exception {
       if (dto.getDescricao().trim().equals(""))
            throw new Exception("Insira a descrição da Atividade.");
       if (dto.getInicio() == null)
            throw new Exception("Insira o inicio da Atividade.");
       if (dto.getFim() == null)
            throw new Exception("Insira o fim da Atividade.");
       if (dto.getTipo() == null)
            throw new Exception("Insira o Tipo da Atividade.");
       if (dto.getEvento() == null)
            throw new Exception("Insira o Evento.");
    }
}