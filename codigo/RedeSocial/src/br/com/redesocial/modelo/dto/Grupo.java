/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 *
 * @author Love
 */
public class Grupo {
    
    private Integer id;
    
    private String nome;
    
    private Date dataCriacao;
    
    private String descricao;
    
    private Integer privacidade;
    
    private String tipo;
    

    public Grupo(){
        
    }
    
    /**
     * Construtor da classe Pais com dois parâmetros
     * @param id identificador do país     
     * @param nome     
     * @param dataCriacao         
     * @param descricao         
     * @param privacidade         
     * @param tipo         
     */
    public Grupo(Integer id, String nome, Date dataCriacao, String descricao, Integer privacidade, String tipo) {
       this.id = id;
       this.nome = nome;
       this.dataCriacao = dataCriacao;
       this.descricao = descricao;
       this.privacidade = privacidade;
       this.tipo = tipo;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(Integer privacidade) {
        this.privacidade = privacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
