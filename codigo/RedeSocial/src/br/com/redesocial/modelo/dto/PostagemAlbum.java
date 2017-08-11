package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Postagens com Multimídias
 * @author Daniel e Macilon
 */
public class PostagemAlbum {
    private Postagem postagem;
    private Album album;

    public PostagemAlbum() {
    
    }
    
    public PostagemAlbum(Postagem postagem, Album album) {
        this.postagem = postagem;
        this.album = album;
    }
    
    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
}