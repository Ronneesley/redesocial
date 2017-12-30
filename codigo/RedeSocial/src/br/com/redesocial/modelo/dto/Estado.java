package br.com.redesocial.modelo.dto;

 /**
  * REMOVER DEPOIS DE LER: O nome do arquivo deve ser igual, ou seja, com letra maiúscula.
  * Isso também se aplica a classe Pais.
  * @author Lucas, Luciano, Adalberto
  * @since 29/07/2017
  */
 
  /**
  * COMENTARIOS DAS FUNÇÕES DOS ATRIBUTOS DE ESTADO
  * @author Brener.
  * @since 25/08/2017
  */
public class Estado {
    /**
    * Atributo de identificação do Estado
    */
    private Integer id;
    /**
    * Atributo que guarda o nome do Estado
    */
    private String nome;
    /**
    * Atributo que armazena o Pais ao qual o Estado pertence
    */
    private Pais pais;
    /**
    * Construtor para a classe vazia
    */
    public Estado(){
        
    }
    /**
    * Construtor da classe Estado com 3 parâmetros
    * @param id idenficador para pais
    * @param nome nome desejado para o Estado
    * @param Pais pais em que estado pertence
    */
    public Estado(int id, String nome, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }
    /**
    * Função que retorna o identificador de um Estado
    * @return identificador
    */
    public Integer getId() {
        return id;
    }
    /**
    * Função vazia que modifica um identificador do Estado
    * @param id novo identificador
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * Função que retorna o nome do Estado
    */
    public String getNome() {
        return nome;
    }
    /**
    * Função vazia que modifica um nome do Estado
    * @param nome novo nome de Estado
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
    * Função que retorna um identificador de Pais
    * @return identificador do Pais
    */
    public Pais getPais() {
        return pais;
    }
    /**
    * Função que modifica o identificador do Pais
    * @param pais novo identificador do pais
    */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
