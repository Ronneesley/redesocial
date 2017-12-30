package br.com.redesocial.modelo.dto;

/**
 * TERMINAR O CÓDIGO
 * @author Ronneesley Moura Teles
 * @since 06/09/2017
 */
public class Categoria {
    
    private Integer id;    
    private String descricao;

    
    /**
     * Função que retorna o identificador do usuário
     * @return identificador
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Função que modifica o identificador do usuário
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Função que modifica a descrição
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Função que retorna a descrição
     * @param id
     */
    public String getDescricao(){
        return descricao;
    }

}
