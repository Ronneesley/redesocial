package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 *
 * @author Lara, Gusttavo Nunes, Jonathan Silvestre
 */
public class Postagem {
    private Integer id;

    private Integer ups;

    private Integer downs;
    
    private String descricao;

    private Date data;

    private Usuario usuario;
    
    private Integer visualizacoes;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    /**
     * Função que retorna os Ups de um comentário
     * @return Ups do comentário
     */
    public Integer getUps() {
        return ups;
    }
    
    /**
     * Função que modifica as curtidas de um comentário
     * @param ups novo curtidas do comentário
     */
    public void setUps(Integer ups) {
        this.ups = ups;
    }
    
    /**
     * Função que retorna os Downs de um comentário
     * @return Downs do comentário
     */
    public Integer getDowns() {
        return downs;
    }
    
    /**
     * Função que modifica as curtidas de um comentário
     * @param downs novo curtidas do comentário
     */
    
    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    /**
     * Função que retorna a descricao de uma postagem
     * @return identificador
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * Função que modifica o identificador de uma postagem
     * @param id novo identificador
     */
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

    public Integer getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(Integer visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
}
