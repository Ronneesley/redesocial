package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 *
 * @author Lara
 */
public class Postagem {
    private Integer id;

    private Integer curtidas;

    private String descricao;

    private Date data;

    private Usuario usuario;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getCurtidas(){
        return curtidas;
    }

    public void setCurtidas(Integer curtidas){
        this.curtidas = curtidas;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public Date getData(){
        return data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}