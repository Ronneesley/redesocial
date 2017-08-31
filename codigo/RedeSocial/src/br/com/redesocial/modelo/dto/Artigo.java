package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * Classe para representação de um artigo
 * @author Daniel Moreira Cardoso
 * @since 30/08/2017
 */
public class Artigo {
    //Atributo que identifica o artigo
    private Integer id;
    //Atributo que identifica o idioma do artigo
    private String idioma;
    //Atributo que identifica a revista em que o artigo foi publicado
    private String revista;
    //Atributo que identifica o ISSN
    private String ISSN;
    //Atributo que identifica o autor do artigo
    private String autor;
    //Atributo que identifica a data em que o artigo foi postado
    private Date data;
    //Atributo que identifica a area de conhecimentod do artigo
    private String areaConhecimento;
    //Atributo que identifica o título do artigo
    private String titulo;
    //Artgigo que identifica o resumo do artigo
    private String resumo;
    //Atributo que identifica o URL para o artigo
    private String URL;
    //Atributo que identifica o arquivo do artigo
    private byte[] artigo;
    
    //Construtor vazio para a classe
    public Artigo() {
    
    }
    
    //Construtor para a classe com parâmetros
    public Artigo(Integer id, String idioma, String revista, String ISSN, String autor, Date data, String areaConhecimento, String titulo, String resumo, String URL, byte[] artigo) {
        this.id = id;
        this.idioma = idioma;
        this.revista = revista;
        this.ISSN = ISSN;
        this.autor = autor;
        this.data = data;
        this.areaConhecimento = areaConhecimento;
        this.titulo = titulo;
        this.resumo = resumo;
        this.URL = URL;
        this.artigo = artigo;
    }
    
    //Função que retorna um identificador de um artigo
    public Integer getId() {
        return id;
    }

    //Função que modifica o identficador de um artigo
    public void setId(Integer id) {
        this.id = id;
    }
    
    //Função que retorna um idioma
    public String getIdioma() {
        return idioma;
    }
    
    //Função que modifica um idioma
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    //Função que retorna uma revista
    public String getRevista() {
        return revista;
    }

    //Função que modifica uma revista
    public void setRevista(String revista) {
        this.revista = revista;
    }

    //Função que retorna um ISSN
    public String getISSN() {
        return ISSN;
    }

    //Função que modifica um ISSN
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }
    
    //Função que retorna um autor
    public String getAutor() {
        return autor;
    }

    //Função que modifica um autor
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Função que retorna uma data
    public Date getData() {
        return data;
    }

    //Função que modifica uma data
    public void setData(Date data) {
        this.data = data;
    }

    //Função que retorna uma area de conhecimento
    public String getAreaConhecimento() {
        return areaConhecimento;
    }

    //Função que modifica uma area de conhecimento
    public void setAreaConhecimento(String areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    //Função que retorna um titulo
    public String getTitulo() {
        return titulo;
    }

    //Função que modifica o título
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Função que retorna o resumo
    public String getResumo() {
        return resumo;
    }

    //Função que modifica o resumo
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    //Função que retorna uma url
    public String getURL() {
        return URL;
    }

    //Função que modifica uma url
    public void setURL(String URL) {
        this.URL = URL;
    }

    //Função que retorna o arquivo de um artigo
    public byte[] getArtigo() {
        return artigo;
    }

    //Função que modifica o arquivo de um artigo
    public void setArtigo(byte[] artigo) {
        this.artigo = artigo;
    }
}
