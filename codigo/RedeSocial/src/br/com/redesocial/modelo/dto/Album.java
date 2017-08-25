package br.com.redesocial.modelo.dto;

import java.util.Date;

/**
 * Classe para representação de um Álbum
 * @author Willian, Thalia e Salmi
 * @since 28/07/2017
 */
 
public class Album {
	/**
     * Atributo que identifica o álbum
     */
    private Integer id;
	/**
     * Atributo que armazena o nome do álbum
     */
    private String nome;
	/**
     * Atributo que armazena a data de criação do álbum
     */
    private Date data;
	/**
     * Atributo que armazena o usuário responsável pela criação do álbum
     */
    private Usuario usuario;

	/**
     * Construtor vazio para a classe
     */
    public Album(){
    }

	/**
     * Função que retorna o identificador de um álbum
     * @return identificador
     */
    public Integer getId() {
        return id;
    }

	/**
     * Função que modifica o identificador de um álbum
     * @param id novo identificador
     */
    public void setId(Integer id) {
        this.id = id;
    }

	/**
     * Função que retorna o nome do álbum
     * @return nome do álbum
     */
     public String getNome() {
        return nome;
    }
	
	/**
     * Função que modifica o nome do álbum
     * @param nome novo nome do álbum
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

	/**
     * Função que retorna a data de criação do álbum
     * @return data do álbum
     */
    public Date getData() {
        return data;
    }

	/**
     * Função que modifica a data de criação do álbum
     * @param data nova data do álbum
     */
    public void setData(Date data) {
        this.data = data;
    }

	/**
     * Função que retorna usuário responsável pela criação do álbum
     * @return usuário do álbum
     */
    public Usuario getUsuario() {
        return usuario;
    }

	/**
     * Função que modifica o usuário responsável pela criação do álbum
     * @param usuario novo usuário do álbum
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
