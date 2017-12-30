package br.com.redesocial.modelo.dto;

/**
 * Classe que representa um país
 * @author Lucas, Luciano, Adalberto
 * @since 29/07/2017
 */
public class Pais {
    /**
     * Atributo que identifica o usuário
     */
    private Integer id;

    /**
     * Atributo que armazena o nome do usuário
     */
    private String nome;
    
    /**
     * Construtor vazio para a classe
     */
    public Pais(){        
    }

    /**
     * Construtor da classe Pais com dois parâmetros
     * @param id identificador do país
     * @param nome nome desejado para o país
     */
    public Pais(Integer id, String nome) {
       this.id = id;
       this.nome = nome;
    }  

    /**
     * Função que retorna o identificador de um país
     * @return identificador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Função que modifica o identificador de um país
     * @param id novo identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Função que retorna o nome do país
     * @return nome do país
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função que modifica o nome do país
     * @param nome novo nome do país
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}