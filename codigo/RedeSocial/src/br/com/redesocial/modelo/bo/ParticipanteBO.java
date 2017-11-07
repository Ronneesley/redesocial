package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.ParticipanteDAO;
import br.com.redesocial.modelo.dto.Participante;

/**
 * Define as regras de negócio para os usuários
 * @author Igor Justino Rodrigues
 * @since 27/07/2017
 */


public class ParticipanteBO extends BOCRUDBase<Participante, ParticipanteDAO> {
    /**
     * Instancia um objeto de país DAO
     * @return instância de acesso aos dados do país
     */
    @Override
    protected ParticipanteDAO instanciarDAO() {
        return new ParticipanteDAO();
    }
    
    /**
     * Validação da chave primária de um objeto país
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    @Override
    protected void validarChavePrimaria(Participante dto) throws Exception {
        if (dto.getGrupo() == null) throw new Exception("Preencha o campo Grupo");
         if (dto.getUsuario() == null) throw new Exception("Preencha o campo Usuario");
   }

    /**
     * Validação dos atributos de país
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    @Override
    protected void validar(Participante dto) throws Exception {
       // Validações
        if (dto.getCargo() == null) throw new Exception("Preencha o Cargo");
        
    } 
}