/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dto;

/**
 *
 * @author Paulo Henrique
 */

public class PalavraChave {
    //id é o atributo que identifica o usuário
    private Integer id;
    
    //descicao é o atributo que armazena as palavras chaves 
    private String descricao;

    /**
     * método que retorna o identificador da palavra chave
     * @return identificador (id)
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * método que modifica o identificador da palavra chave
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * método que retorna as palavras chaves
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * método que modifica as palavras chaves
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
