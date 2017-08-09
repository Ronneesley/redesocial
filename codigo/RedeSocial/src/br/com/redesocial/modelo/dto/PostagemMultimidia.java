package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Postagens com Multimídias
 * @author Daniel e Macilon
 */
public class PostagemMultimidia {
    private Postagem postagem;
    private Multimidia multimidia;

    public PostagemMultimidia() {
    
    }
    
    public PostagemMultimidia(Postagem postagem, Multimidia multimidia) {
        this.postagem = postagem;
        this.multimidia = multimidia;
    }
    
    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Multimidia getMultimidia() {
        return multimidia;
    }

    public void setMultimidia(Multimidia multimidia) {
        this.multimidia = multimidia;
    }
    
    
    
}
