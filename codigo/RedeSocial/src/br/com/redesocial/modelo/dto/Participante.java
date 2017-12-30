package br.com.redesocial.modelo.dto;

/**
 * DTO para representação da entidade participante
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */
public class Participante {
    
    private Grupo grupo;
    private Usuario usuario;
    private Integer cargo;
    
    /**
     * Construtor vazio para a classe
     */
    public Participante(){
        
    }
    
    /**
     * Construtor da classe Participante com três parâmetros
     * @param grupo identificador do grupo
     * @param usuario identificador do usuário
     * @param cargo cargo do participante
     */
    public Participante(Grupo grupo, Usuario usuario, Integer cargo) {
        this.grupo = grupo;
        this.usuario = usuario;
        this.cargo = cargo;
    }   
    
    /**
     * Função que retorna o identificador do grupo
     * @return identificador
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Função que modifica o identificador do grupo
     * @param grupo
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    /**
     * Função que retorna o identificador do usuário
     * @return identificador
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Função que modifica o identificador do usuário
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Função que retorna o cargo do participante
     * @return cargo
     */
    public Integer getCargo() {
        return cargo;
    }

    /**
     * Função que modifica o cargo do participante
     * @param cargo
     */
    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }    
}