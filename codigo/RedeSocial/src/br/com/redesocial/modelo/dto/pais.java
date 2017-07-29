package br.com.redesocial.modelo.dto;
  /**

  * @author Lucas, Luciano, Adalberto
  * @since 29/07/2017
  */

public class Pais {
    private int id;
	private String nome;
	

    public Pais(int id, String nome) {
       this.id = id;
       this.nome = nome;
	  
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
	
    
}