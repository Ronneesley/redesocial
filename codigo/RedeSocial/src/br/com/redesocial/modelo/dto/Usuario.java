package br.com.redesocial.modelo.dto;

import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.util.Date;

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

    private Sexo sexo;

    private Date dataCadastro;

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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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
