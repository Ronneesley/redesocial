package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Cidades
 * @author Daniel, Jônatas e Paulo
 */
public class Cidade {
    private Integer id;
    private Estado estado;
    private String nome;

    public Cidade() {}
    
    public Cidade(Integer id, Estado estado, String nome) {
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
