
package br.com.redesocial.modelo.dto;


public class TipoAtividade {
    private Integer id;
    private String nome;
    private Boolean rescricao;

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

    public Boolean getRescricao() {
        return rescricao;
    }

    public void setRescricao(Boolean certificado) {
        this.rescricao = certificado;
    }

    public Object getRestricao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


