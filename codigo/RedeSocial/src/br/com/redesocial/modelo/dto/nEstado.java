package br.com.redesocial.modelo.dto;

 /**
  * REMOVER DEPOIS DE LER: O nome do arquivo deve ser igual, ou seja, com letra maiúscula.
  * Isso também se aplica a classe Pais.
  * @author Lucas, Luciano, Adalberto
  * @since 29/07/2017
  */
public class nEstado {
    private int id;

    private String nome;

    private nPais pais;

    public nEstado(int id, String nome, nPais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public nPais getPais() {
        return pais;
    }

    public void setPais(nPais pais) {
        this.pais = pais;
    }
}