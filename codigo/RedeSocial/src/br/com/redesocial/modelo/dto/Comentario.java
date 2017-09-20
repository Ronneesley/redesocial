package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * DTO para representação do Comentário
 * @author Ronneesley, Ianka, Anny e Macilon Arruda
 * @since 29/07/2017
 */
public class Comentario {
    /**
     * Atributo que identifica o comentário
     */
    private Integer id;

    /**
     * Atributo que identifica a descrição do comentário
     */
    private String descricao;
    
    /**
     * Atributo que identifica as curtidas do comentário
     */
    private Integer curtidas;
    
    /**
     * Atributo que identifica a data do comentário
     */
    private Date data;
    
    /**
     * Atributo que identifica a postagem do comentário
     */
    private Postagem postagem;
    
    /**
     * Atributo que identifica a resposta do comentário
     */
    private Comentario resposta;

    /**
     * Atributo que identifica o usuário que comentou
     */
    private Usuario usuario;
    
    /**
     * Função que retorna o identificador de um comentário
     * @return identificador
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Finção que modifica o identificador de um comentário
     * @param id novo identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Função que retorna a descrição de um comentário
     * @return descrição do comentário
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Função que modifica a descrição de um comentário
     * @param descricao novo descrição do comentário 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Função que retorna as curtidas de um comentário
     * @return curtidas do comentário
     */
    public Integer getCurtidas() {
        return curtidas;
    }
    
    /**
     * Função que modifica as curtidas de um comentário
     * @param curtidas novo curtidas do comentário
     */
    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }
    
    /**
     * Função que retorna a data de um comentário
     * @return data do comentário
     */
    public Date getData() {
        return data;
    }
    
    /**
     * Função que modifica a data de um comentário
     * @param data novo data do comentário
     */
    public void setData(Date data) {
        this.data = data;
    }
    
    /**
     * Função que retorna a postagem de um comentário
     * @return postagem do comentário
     */
    public Postagem getPostagem() {
        return postagem;
    }
    
    /**
     * Função que modifica a postagem de um comentário
     * @param postagem novo postagem do comentário
     */
    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
    
    /**
     * Função que retorna a resposta de um comentário
     * @return resposta do comentário
     */
    public Comentario getResposta() {
        return resposta;
    }
    
    /**
     * Função que modifica a resposta de um comentário
     * @param resposta novo reposta do comentário
     */
    public void setResposta(Comentario resposta) {
        this.resposta = resposta;
    }
    
    /**
     * Função que retorna o usuario que comentou
     * @return usuario do comentário
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Função que modifica o usuário de um comentário
     * @param usuario novo usuario comentando
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}