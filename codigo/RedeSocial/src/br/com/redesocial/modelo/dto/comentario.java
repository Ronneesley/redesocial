package br.com.redesocial.modelo.dto;
import java.sql.Date;
/**
 * DTO para representação do Comentário
 * @author Ronneesley, Ianka, Anny e Macilon
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

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Comentario getResposta() {
        return resposta;
    }

    public void setResposta(Comentario resposta) {
        this.resposta = resposta;
    }    
}