package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * Classe que representa as multimídias
 * @author Ronneesley, COLOCAR O NOME DE QUEM FEZ
 */
public class Multimidia {
    private Integer id;

    private byte[] midia;

    private String tipoConteudo;

    private Date data;

    public Multimidia() {
    }

    public Multimidia(byte[] midia, String tipoConteudo) {
        this.midia = midia;
        this.tipoConteudo = tipoConteudo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getMidia() {
        return midia;
    }

    public void setMidia(byte[] midia) {
        this.midia = midia;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String tipoConteudo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public byte getmidia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}