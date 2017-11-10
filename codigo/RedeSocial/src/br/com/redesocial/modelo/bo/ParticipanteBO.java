package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.ParticipanteDAO;
import br.com.redesocial.modelo.dto.Participante;

/**
 * Define as regras de negócio para os participantes
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */


public class ParticipanteBO extends BOCRUDBase <Participante, ParticipanteDAO>{
    /**
     * Instancia um objeto de participante DAO
     * @return instância de acesso aos dados do participante
     */
    
    @Override
    protected ParticipanteDAO instanciarDAO() {
        return new ParticipanteDAO();
    }
    
    /**
     * Validação da chave primária de um objeto participante
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    
    @Override
    protected void validarChavePrimaria(Participante dto) throws Exception {
        // Validações    
        if (dto.getGrupo() == null) throw new Exception("Você precisa ter criado um Grupo!");
        if (dto.getUsuario() == null) throw new Exception("Você precisa ter criado um Usuario!");
   }

    /**
     * Validação dos atributos de participante
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    
    @Override
    protected void validar(Participante dto) throws Exception {
        // Validações         
        if(dto.getCargo() == null) throw new Exception("O campo Cargo não pode estar vazio!");              
    } 
}