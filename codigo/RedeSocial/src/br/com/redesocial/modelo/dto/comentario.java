package br.com.redesocial.modelo.dto;

import java.sql.Date;

/**
 * Remover o comentário após ler: o nome do arquivo deve começar com letra maiúscula
 * @author Ronneesley, Ianka, coloquem os demais membros
 * @since 29/07/2017
 */
public class Comentario {
    
    private Integer id;
    
    private String descricao;
    
    private Integer curtidas;
    
    private Date data;
    
    private Postagem postagem;
    
    private Comentario resposta;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(String curtidas) { //Não é Integer
        this.curtidas = curtidas;
    }

    public String getData() { //Reveja os tipos de dados dos demais métodos getters e setters
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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return getNome();
    }
}

}





    