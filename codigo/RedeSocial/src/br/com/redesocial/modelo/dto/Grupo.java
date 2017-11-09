package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * DTO para representação da entidade grupo
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */
public class Grupo {
    
    private Integer id;
    
    private String nome;
    
    private Date dataCriacao;
    
    private String descricao;
    
    private Integer privacidade;
    
    private String tipo;
    

    public Grupo(){
        
    }
    
    /**
     * Construtor da classe Grupo com seis parâmetros
     * @param id identificador do grupo     
     * @param nome nome do grupo   
     * @param dataCriacao data de criação do grupo        
     * @param descricao descrição do grupo      
     * @param privacidade perfil de privacidade do grupo       
     * @param tipo definição da modalidade do grupo        
     */
    public Grupo(Integer id, String nome, Date dataCriacao, String descricao, Integer privacidade, String tipo) {
       this.id = id;
       this.nome = nome;
       this.dataCriacao = dataCriacao;
       this.descricao = descricao;
       this.privacidade = privacidade;
       this.tipo = tipo;
    }
    
    /**
     * Função que retorna o identificador do grupo
     * @return identificador
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Função que modifica o identificador do grupo
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Função que retorna o nome do grupo
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Função que modifica o nome do grupo
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Função que retorna a data de criação do grupo
     * @return data de criação
     */
    public Date getDataCriacao() {
        return dataCriacao;
    }
    
    /**
     * Função que modifica a data de criação do grupo
     * @param dataCriacao
     */
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    /**
     * Função que retorna a descrição do grupo
     * @return descrição
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Função que modifica a descrição do grupo
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Função que retorna a privacidade do grupo
     * @return privacidade
     */
    public Integer getPrivacidade() {
        return privacidade;
    }

    /**
     * Função que modifica a privacidade do grupo
     * @param privacidade
     */
    public void setPrivacidade(Integer privacidade) {
        this.privacidade = privacidade;
    }
    
    /**
     * Função que retorna o tipo do grupo
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Função que modifica o tipo do grupo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
