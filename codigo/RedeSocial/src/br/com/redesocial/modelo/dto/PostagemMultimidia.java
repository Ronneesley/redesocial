package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Postagens com Multimídias
 * @author Daniel e Macilon
 */
public class PostagemMultimidia {
    //Classe privadas de Postagem e Multimídia
    private Postagem postagem;
    private Multimidia multimidia;

    /**
     * Construtor vazio para a classe
    */
    public PostagemMultimidia() {
    
    }

    /**
     * Construtor da classe PostagemMultimidia com dois parâmetros
     * @param postagem identificador da postagem
     * @param multimidia nome desejado para a multimidia
     */
    public PostagemMultimidia(Postagem postagem, Multimidia multimidia) {
        this.postagem = postagem;
        this.multimidia = multimidia;
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
     * Função que retorna o identificador de uma multimidia
     * @return identificador
     */
    public Multimidia getMultimidia() {
        return multimidia;
    }

    /**
     * Função que modifica o nome da multimidia
     * @param multimidia novo nome da multimidia
     */
    public void setMultimidia(Multimidia multimidia) {
        this.multimidia = multimidia;
    }
    
    
    
}
