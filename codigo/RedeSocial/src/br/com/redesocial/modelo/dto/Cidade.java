package br.com.redesocial.modelo.dto;

/**
 * Descreva a classe aqui: ex.: Class que representa as cidades
 * @author Daniel, Jônatas e Paulo
 */
public class Cidade {
    private int id;
    private Estado estado;
    private String nome;

    public Cidade(int id, int estado, String nome) {
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
