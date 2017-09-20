package br.com.redesocial.modelo.dto;

/**
 * Classe para representação de Aporte
 * @author Lucas
 * @since 15/09/2017
 */
public class Aporte {
    /**
     * Atributo que identifica aporte
     */
    private Integer id;
    
    /**
     * Atributo que armazena o titulo do aporte
     */
    private String titulo;
    
    /**
     * Atributo que armazena o categoria do aporte
     */
    private Categoria categoria;
    
    /**
     * Atributo que armazena a postagem do aporte
     */
     private Postagem postagem;
     
     /**
     * Construtor vazio para a classe
     */
    public Aporte(){
    } 
    
    /**
     * Função que retorna o identificador de aporte
     * @return identificador
     */
    
    public Integer getId(){
        return id;
    }
    
    /**
     * Função que modifica o identificador de aporte
     * @param id novo identificador
     */
    public void setId(Integer id){
        this.id = id;
        
     /**
     * Função que retorna o titulo do aporte
     * @return titulo do aporte
     */   
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
        
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    /**
     * Função que retorna categoria responsável pela criação do aporte
     * @return categoria do aporte
     */
    public Categoria getCategoria(){
        return categoria;
        
    }
    /**
     * Função que modifica a categoria do aporte
     * @param categoria novo categoria do aporte
     */
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;   
    }
    
    /**
     * Função que retorna a postagem do aporte
     * @return postagem do aporte
     */
    public Postagem getPostagem(){
        return postagem;
    }
    
    /**
     * Função que modifica a postagem  do aporte
     * @param  postagem  nova postagem  do aporte
     */
    public void setPostagem(Postagem postagem){
        this.postagem= postagem;
        
     }
}