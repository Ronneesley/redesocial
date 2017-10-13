package br.com.redesocial.modelo.dto;

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
}
