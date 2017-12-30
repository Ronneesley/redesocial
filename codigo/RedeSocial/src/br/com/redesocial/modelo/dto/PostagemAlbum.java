package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Postagens com Multimídias
 * @author Andrey
 */
public class PostagemAlbum {
    //classe privadas de postagem e album
    private Postagem postagem;
    private Album album;

    
    /**
     * Construtor vazio para a classe
     */
    public PostagemAlbum() {
    
    }
    
    /**
     * Construtor da classe Pais com dois parâmetros
     * @param postagem identificador da postagem
     * @param album nome desejado para o album
     */
    public PostagemAlbum(Postagem postagem, Album album) {
        this.postagem = postagem;
        this.album = album;
    }
    
    /**
     * Função que retorna o identificador de uma postagem
     * @return identificador
     */
    public Postagem getPostagem() {
        return postagem;
    }

    
    /**
     * Função que modifica o nome da postagem
     * @param postagem novo nome da postagem
     */
    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    /**
     * Função que retorna o identificador de umalbum
     * @return identificador
     */
    public Album getAlbum() {
        return album;
    }

    
    /**
     * Função que modifica o nome do album
     * @param album novo nome do album
     */
    public void setAlbum(Album album) {
        this.album = album;
    }
    
}