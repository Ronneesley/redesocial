package br.com.redesocial.modelo.dto;

import java.util.Date;
/**
 * DTO para representação das Atividades
 * @author Jonathan Silvestre
 * @since 25/10/2017
 */

public class Atividade {
    
     /**
     * Atributo que identifica Atividades
     */
    private Integer id;

    /**
     * Atributo que identifica a descrição das Atividades
     */
    private String descricao;
    
    /**
     * Atributo que identifica a data de inicio das Atividades
     */
    private Date inicio;
    
    /**
     * Atributo que identifica o fim das Atividades
     */
    private Date fim;;
    
    /**
     * Atributo que identifica as vagas das Atividades
     */
    private Integer vagas;
    
    /**
     * Atributo que identifica o tipo das Atividades
     */
    private Integer tipo;
    
    /**
     * Atributo que identifica o Evento das Atividades
     */
    
     private Integer evento;
    
    /**
     * Atributo que identifica a postagem do comentário
     * @return 
     */
      
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
     
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    public Date getInicio() {
        return inicio;
    }
    
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    
    
    
    public Date getFim() {
        return fim;
    }
    
    public void setFim(Date fim) {
        this.fim = fim;
    }
    
    
    
    public Integer getVagas() {
        return vagas;
    }
   
    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
    
    
    
    public Integer getTipo() {
        return tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    
    public Integer getEvento() {
        return evento;
    }
    
    public void setEvento(Integer evento) {
        this.evento = evento;
    }
}
