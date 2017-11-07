package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * Classe que representa as multimídias
 * @author Ronneesley, COLOCAR O NOME DE QUEM FEZ
 */

/**
* COMENTARIOS DAS FUNÇÕES DOS ATRIBUTOS QUE COMPOEM A MULTIMIDIA.
* @author Brener.
* @since 25/08/2017
*/
public class Multimidia {
    /**
    * Atributo de idenficação da Multimidia
    */
    private Integer id;
    /**
    * Atributo que armazena no Album na qual a multimidia pertence
    */
    private Album album;
    /**
    * Atributo do tipo byte apropriado para armazenar a midia
    */
    private byte[] midia;
    /**
    * Atributo para armazenar o tipo do conteudo da midia
    */
    private String tipoConteudo;
    /**
    * Atributo do tipo Date para armazenar a data da midia
    */
    private Date data;
    /**
    * Construtor para a classe
    */
    public Multimidia() {
    }
    /**
    * Construtor da classe multimidia com 2 parâmetros
     * @param midia caminho para uma nova midia
     * @param tipoConteudo para um novo tipo de conteudo
    */
    public Multimidia(byte[] midia, String tipoConteudo) {
        this.midia = midia;
        this.tipoConteudo = tipoConteudo;
    }
    /**
    * Função que retorna um identificador da multimidia
    * @return identificador da multimidia
    */
    public Integer getId() {
        return id;
    }
    /**
    * Função de modificia o identificador da multimidia
    * @param id novo identificador de multimidia
    */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * Função que retorna um atributo do tipo byte que armazena uma midia
    * @return a nova midia da multimidia
    */
    public byte[] getMidia() {
        return midia;
    }
    /**
    * Função que modificia o tipo da midia da multimidia
     * @param midia identificador de mídia
    */
    public void setMidia(byte[] midia) {
        this.midia = midia;
    }
    /**
    * Função que retorna o nome do tipo de conteudo da multimidia
    * @return o novo tipo de conteudo
    */
    public String getTipoConteudo() {
        return tipoConteudo;
    }
    /**
    * Função que modifica o tipo de conteudo da multimidia
    */
    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }
    /**
    * Função que retonar uma data em que foi inserida ou alterada a multimidia
    * @return a data da multimidia
    */
    public Date getData() {
        return data;
    }
    /**
    * Função que modifica a data da multimidia 
    */
    public void setData(Date data) {
        this.data = data;
    }
    /**
    * Função que retorna um Album ao qual a multimidia pertence
    * @return um Album para a midia
    */
    public Album getAlbum(){
        return album;
    }
    /**
    * Função que modifica o Album ao qual a midia pertence
    */
    public void setAlbum(Album album){
        this.album = album;
    }
}
