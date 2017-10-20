package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * Classe que representa os eventos
 * @author Gusttavo Nunes
 * @since
 */
public class Evento {
    
    /**
     * Atributo que identifica a evento
     */
    private Integer id;
    
    /**
     * Atributo que armazena o nome do evento
     */
    private String nome;
    
    /**
     * Atributo que armazena a descrição do evento
     */
    private String descricao;
    
    /**
     * Função que retorna a data de inicio de um evento
     * @return data
     */
    private Date inicio;
    
    /**
     * Função que retorna a data de final de um evento
     * @return data
     */
    private Date fim;
    
    /**
     * Função que retorna se possui certificado
     * @return data
     */
    private Boolean certificado;
    
    
    /**
     * Função que retorna o identificador de um evento
     * @return identificador
     */
    public Integer getId(){
        return id;
    }
    
    /**
     * Função que modifica o identificador de um evento
     * @param id novo identificador
     */
    public void setId(Integer id){
        this.id = id;
    }
    
    /**
     * Função que retorna o nome de um evento
     * @return nome da cidade
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Função que modifica o nome de um evento
     * @param nome novo nome um evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Função que retorna a descricao de um evento
     * @return identificador
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * Função que modifica o identificador de um evento
     * @param descricao
     */
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    /**
     * Função que retorna a data de inicio do evento
     * @return data
     */
    public Date getInicio(){
        return inicio;
    }

    /**
     * Função que modifica a data de um evento
     * @param inicio
     */
    public void setInicio(Date inicio){
        this.inicio = inicio;
    }
    
    /**
     * Função que retorna a data de fim do evento
     * @return data
     */
    public Date getFim(){
        return fim;
    }

    /**
     * Função que modifica a data de fim um evento
     * @param fim
     */
    public void setFim(Date fim){
        this.fim = fim;
    }
    
    /**
     * Função que retorna a data de fim do evento
     * @return data
     */
    public Boolean getCertificado(){
        return certificado;
    }

    /**
     * Função que modifica a existencia de certificado do evento
     * @param certificado
     */
    public void setCertificado(Boolean certificado){
        this.certificado = certificado;
    }
    
    
}
