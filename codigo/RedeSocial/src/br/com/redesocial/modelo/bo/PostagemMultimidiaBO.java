package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.PostagemMultimidiaDAO;
import br.com.redesocial.modelo.dto.PostagemMultimidia;

/**
 *
 * @author Paulo Henrique
 */
public class PostagemMultimidiaBO {


    protected PostagemMultimidiaDAO instanciarDAO() {
        return new PostagemMultimidiaDAO();
    }


    protected void validarChavePrimaria(PostagemMultimidia dto) throws Exception {
        if(dto.getMultimidia() == null ) throw new Exception("Prencha a mídia"); 
        if (dto.getPostagem() == null) throw new Exception("Prencha a postagem");
    }


    
    
    
}
