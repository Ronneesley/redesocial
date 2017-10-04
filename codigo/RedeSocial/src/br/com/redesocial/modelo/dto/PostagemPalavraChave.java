/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dto;

/**
 *
 * @author Jonathan Silvestre
 */
public class PostagemPalavraChave {
    
    private Postagem postagem;
    private PalavraChave palavraChave;

    public PostagemPalavraChave() {
    }
    
     /**
     * Construtor da classe PostagemPalavraChave com dois parâmetros
     * @param postagem identificador da postagem
     * @param palavraChave nome desejado para a PalavraChave
     */
    public PostagemPalavraChave(Postagem postagem, PalavraChave palavraChave) {
        this.postagem = postagem;
        this.palavraChave = palavraChave;
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
     * Função que retorna o identificador de uma palavraChave
     * @return identificador
     */
    public PalavraChave getPalavraChave() {
        return palavraChave;
    }
    /**
     * Função que modifica o nome da palavraChave
     * @param palavraChave novo nome da palavraChave
     */
    public void setPalavraChave(PalavraChave palavraChave) {
        this.palavraChave = palavraChave;
    }
    
    
}
