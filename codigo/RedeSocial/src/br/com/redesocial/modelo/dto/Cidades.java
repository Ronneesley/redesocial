/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dto;

/**
 *
 * @author Daniel, Jônatas e Paulo
 */
public class Cidades {
    private int id;
    private Estados estado;
    private String nome;

    public Cidades(int id, int estado, String nome) {
        this.id = id;
        this.estado = estado;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
