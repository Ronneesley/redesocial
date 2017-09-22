package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.PostagemMultimidiaDAO;
import br.com.redesocial.modelo.dto.PostagemMultimidia;

/**
 *
 * @author Paulo Henrique
 */
public class PostagemMultimidiaBO {

     /**
     * Instancia um objeto de Postagem Multimidia DAO
     * @return instância de acesso aos dados da multimidia
     */
    protected PostagemMultimidiaDAO instanciarDAO() {
        return new PostagemMultimidiaDAO();
    }
    /*
     * Validação da chave primária de um objeto PostagemMultimidia
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    protected void validarChavePrimaria(PostagemMultimidia dto) throws Exception {
        if(dto.getMultimidia() == null ) throw new Exception("Prencha a mídia"); 
        if (dto.getPostagem() == null) throw new Exception("Prencha a postagem");
    }
    
}
