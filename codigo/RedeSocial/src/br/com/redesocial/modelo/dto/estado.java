package br.com.redesocial.modelo.dto;
 /**
  * REMOVER DEPOIS DE LER: O nome do arquivo deve ser igual, ou seja, com letra maiúscula.
  * Isso também se aplica a classe Pais.
  * @author Lucas, Luciano, Adalberto
  * @since 29/07/2017
  */

public class Estado {
    private int id;
	private String nome;
	private Pais pais;

    public Estado(int id, String nome,int pais) {
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
	
	public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }
    
}