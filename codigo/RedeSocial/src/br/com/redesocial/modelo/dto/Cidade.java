package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Cidades
 * @author Daniel, Jônatas e Paulo
 */
public class Cidade {
    private Integer id;
    private Estado estado;
    private String nome;

<<<<<<< HEAD
    public Cidade() {
     
    }
    
    
      public Cidade(int id, Estado estado, String nome) {
=======
    public Cidade(Integer id, Estado estado, String nome) {
>>>>>>> 7deae1fce5ed1e3251681ebf86a83ade4f147643
        this.id = id;
        this.estado = estado;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
