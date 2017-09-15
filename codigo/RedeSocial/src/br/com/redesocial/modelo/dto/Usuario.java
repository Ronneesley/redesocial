package br.com.redesocial.modelo.dto;

import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.util.Date;

/**
 * DTO para representação da entidade usuário
 * @author Ronneesley Moura Teles, Igor Justino Rodrigues, Wesley M Felix
 * @since 27/07/2017
 */
public class Usuario {

    private Integer id;
    
    private String nome;

    private String email;

    private String telefone;

    private String senha;

    private Date dataNascimento;

    private Sexo sexo;

    private Date dataCadastro;

    private Boolean status;

    private Multimidia foto;

    private Cidade cidade;
    
    /**
     * Construtor vazio para a classe
     */
    public Usuario() {
    }
    
    /**
     * Construtor da classe Usuario com dois parâmetros
     * @param email identificador do usuário
     * @param senha senha do usuário
     */
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
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
     * Função que retorna o nome do usuário
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Função que modifica o nome do usuário
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Função que retorna o email do usuário
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Função que modifica o email do usuário
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Função que retorna o telefone do usuário
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Função que modifica o telefone do usuário
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Função que retorna a senha do usuário
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Função que modifica a senha do usuário
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Função que retorna a data de nascimento do usuário
     * @return dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Função que modifica a data de nascimento do usuário
     * @param dataNascimento
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Função que retorna o sexo do usuário
     * @return sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Função que modifica o sexo do usuário
     * @param sexo
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * Função que retorna a data de cadastro do usuário
     * @return DataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * Função que modifica a data de cadastro do usuário
     * @param dataCadastro
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * Função que retorna o status do usuário
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Função que modifica o status do usuário
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Função que retorna a foto do usuário
     * @return foto
     */
    public Multimidia getFoto() {
        return foto;
    }

    /**
     * Função que modifica a foto do usuário
     * @param foto
     */
    public void setFoto(Multimidia foto) {
        this.foto = foto;
    }

    /**
     * Função que retorna a cidade do usuário
     * @return cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * Função que modifica a cidade do usuário
     * @param cidade
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * Função que retorna um nome
     */
    @Override
    public String toString() {
        return getNome();
    }
}