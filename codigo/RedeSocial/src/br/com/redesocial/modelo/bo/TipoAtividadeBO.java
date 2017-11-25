/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.TipoAtividadeDAO;
import br.com.redesocial.modelo.dto.TipoAtividade;

/**
 *
 * @author Inimigo
 */
public class TipoAtividadeBO extends BOCRUDBase <TipoAtividade, TipoAtividadeDAO> {
   
    @Override
    protected TipoAtividadeDAO instanciarDAO() {
        return new TipoAtividadeDAO();
}
    @Override
    protected void validarChavePrimaria(TipoAtividade dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo Id");
    }
/**
     * Validação dos atributos de grupo
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    @Override
    protected void validar(TipoAtividade dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o Nome do Tipo de atividade");
        if (dto.getRestricao() == null) throw new Exception("Preencha se existe restricao");
    }    
}