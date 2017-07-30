package br.com.redesocial.modelo.dtoa;

import java.sql.Date;

/**
 * DTO para representação da entidade usuário
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class Usuario {
    private Integer id;

    private String nome;

    private String email;

    private String telefone;

    private String senha;

    private Date nascimento;

    private String sexo;

    private Date data_cadastro;

    private Boolean status;

    private Multimidia foto;

    private Cidade cidade;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Multimidia getFoto() {
        return foto;
    }

    public void setFoto(Multimidia foto) {
        this.foto = foto;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }



    @Override
    public String toString() {
        return getNome();
    }
}
