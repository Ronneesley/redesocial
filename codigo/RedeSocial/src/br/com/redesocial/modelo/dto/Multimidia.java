/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dto;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Multimidia {
    private Integer id;

    private Byte midia;

    private String tipo_conteudo;

    private Date data;

    public Multimidia() {
    }

    public Multimidia(Byte midia, String tipo_conteudo) {
        this.midia = midia;
        this.tipo_conteudo = tipo_conteudo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getMidia() {
        return midia;
    }

    public void setMidia(Byte midia) {
        this.midia = midia;
    }

    public String getTipo_Conteudo() {
        return tipo_conteudo;
    }

    public void setTipo_Conteudo(String tipo_conteudo) {
        this.tipo_conteudo = tipo_conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public Byte toByte() {
        return getMidia();
    }
}
