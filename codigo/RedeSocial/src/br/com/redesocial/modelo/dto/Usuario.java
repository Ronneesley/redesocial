package br.com.redesocial.modelo.dto;

/**
 * DTO para representação da entidade usuário
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class Usuario {
    private Integer codigo;
    
    private String nome;
    
    private String email;
    
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
