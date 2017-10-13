package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.EventoDAO;
import br.com.redesocial.modelo.dto.Evento;

/**
 * Define as regras de negócio para os usuários
 * @author Willian Wallace de Matteus Silva
 * @since 13/10/2017
 */
public class EventoBO extends BOCRUDBase<Evento, EventoDAO> {
  
    @Override
    protected EventoDAO instanciarDAO() {
        return new EventoDAO();
    }
    
    /**
    * Validação da chave primária de um objeto da tabela eventos
    * @param dto objeto em questão
    * @throws Exception validação se a chave não foi preenchida
    */
    @Override
    protected void validarChavePrimaria(Evento dto) throws Exception {
         if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
    
    /**
    * Validação dos atributos dos eventos
    * @param dto objeto em questão que será validado
    * @throws Exception validações encontradas
    */
    @Override
    protected void validar(Evento dto) throws Exception {
        
        if (dto.getNome() == null || dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do evento");
        
        if (dto.getDescricao().trim().equals("")) throw new Exception("Preencha a descricao do evento");     
    }
}
