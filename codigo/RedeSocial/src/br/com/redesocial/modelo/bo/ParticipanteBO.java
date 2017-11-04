/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.ParticipanteDAO;
import br.com.redesocial.modelo.dto.Participante;

public class ParticipanteBO {
    /**
     * Instancia um objeto de país DAO
     * @return instância de acesso aos dados do país
     */
    protected ParticipanteDAO instanciarDAO() {
        return new ParticipanteDAO();
    }

    /**
     * Validação dos atributos de país
     * @param p objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    protected void validar(Participante p) throws Exception {
        //Validações
        if (p.getCargo() == null) throw new Exception("Preencha o Cargo");
    }

    /**
     * Validação da chave primária de um objeto país
     * @param p objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    protected void validarChavePrimaria(Participante p) throws Exception {
        if(p.getGrupo() == null ) throw new Exception("Prencha a Grupo"); 
        if (p.getUsuario() == null) throw new Exception("Prencha a Usuario");
    }
}

