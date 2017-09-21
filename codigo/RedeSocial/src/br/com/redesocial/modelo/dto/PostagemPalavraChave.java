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
    private PalavraChave palavra_chave;
    
     /**
     * Construtor da classe PostagemPalavraChave com dois parâmetros
     * @param postagem identificador da postagem
     * @param palavra_chave nome desejado para a PalavraChave
     */
    public PostagemPalavraChave(Postagem postagem, PalavraChave palavra_chave) {
        this.postagem = postagem;
        this.palavra_chave = palavra_chave;
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
     * Função que retorna o identificador de uma palavra_chave
     * @return identificador
     */
    public PalavraChave getPalavraChave() {
        return palavra_chave;
    }
    /**
     * Função que modifica o nome da palavra_chave
     * @param palavra_chave novo nome da palavra_chave
     */
    public void setPalavraChave(PalavraChave palavra_chave) {
        this.palavra_chave = palavra_chave;
    }
    
    
}
