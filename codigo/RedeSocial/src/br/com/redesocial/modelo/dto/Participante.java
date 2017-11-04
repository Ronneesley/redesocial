package br.com.redesocial.modelo.dto;

/**
 * DTO para representação das Postagens com Multimídias
 * @author Andrey
 */
public class Participante {
    //classe privadas de postagem e album
    private Grupo grupo;
    private Usuario usuario;
    private Integer cargo;
    
    /**
     * Construtor vazio para a classe
     */
    public Participante(){
        
    }
    
    /**
     * Construtor vazio para a classe
     * @param grupo
     * @param usuario
     * @param cargo
     */
    public Participante(Grupo grupo, Usuario usuario, Integer cargo) {
        this.grupo = grupo;
        this.usuario = usuario;
        this.cargo = cargo;
    }   

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }    
}