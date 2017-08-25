package br.com.redesocial.modelo.dto;

/**
 * Classe que representa uma cidade
 * @author Daniel, Jônatas e Paulo
 * @sice 29/07/2017
 */
public class Cidade {
    
    /**
     * Atributo que identifica a cidade
     */
    private Integer id;
    
    /**
     * Atributo que armazena o estado em que a cidade existe
     */
    private Estado estado;
    
    /**
     * Atributo que armazena o nome da cidade
     */
    private String nome;
    
    /**
     * Construtor vazio para a classe
     */
    public Cidade() {}
    
    /**
     * Construtor da classe Cidade com três parâmetros
     * @param id identificador do estado
     * @param estado estado em que a cidade existe
     * @param nome nome desejado para a cidade
     */
    public Cidade(Integer id, Estado estado, String nome) {
        this.id = id;
        this.estado = estado;
        this.nome = nome;
    }

    /**
     * Função que retorna o identificador de uma cidade
     * @return identificador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Função que modifica o identificador de uma cidade
     * @param id novo identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Função que retorna o identificador do estado
     * @return identificador do estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Função que modifica o identificador do estado
     * @param estado novo identificador do estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Função que retorna o nome da cidade
     * @return nome da cidade
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função que modifica o nome da cidade
     * @param nome novo nome da cidade
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
