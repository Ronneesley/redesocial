package br.com.redesocial.modelo.dto;

import java.sql.Date;

/**
 * DTO para representação do Abuns
 * @author Willian, Thalia e Salmi
 * @since 28/07/2017
 */
public class Album {
    private Integer id;

    private String nome;

    private Date data;

    private Usuario usuario;

    public Album(){
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

       public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
