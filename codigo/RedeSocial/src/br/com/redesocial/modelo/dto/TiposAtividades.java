package br.com.redesocial.modelo.dto;
/**
 *
 * @author Brener, José Gilva e Marcos
 */
public class TiposAtividades {
    //Atributo que armazena o id do tipo da atividade
    private Integer id;
    //Atributo que armazena o nome do tipo da atividade   
    private String nome;
    //Atributo que armazena o status do tipo da atividade
    private Boolean restricao;
    
    public TiposAtividades() {    
    }
    /**
     * Construtor da classe TiposAtividades com dois parâmetros
     * @param id identificador do tipo da atividade
     * @param nome descricao tipo da atividade
     * @param restricao restricao da atividade
     */
   public TiposAtividades(Integer id, String nome, Boolean restricao) {
       this.id = id;
       this.nome = nome;
       this.restricao = restricao;
    } 
   /**
     * Função que retorna o identificador de um tipo de atividade
     * @return identificador
     */
   public Integer getId(){
       return id;
   }
   /**
     * Função que modifica o identificador de um tipo de atividade
     * @param id novo identificador
     */
   public void setId(Integer id){
       this.id = id;
   }
   /**
     * Função que retorna o nome do tipo de atividade
     * @return nome do tipo de atividade
     */
   public String getNome(){
       return nome;
   }
   /**
     * Função que modifica o nome do tipo de atividade
     * @param nome novo nome do tipo de atividade
     */
   public void setNome(String nome){
       this.nome = nome;
   }
   /**
     * Função que retorna a restricao do tipo da atividade
     * @return restricao
     */
   public Boolean getRestricao(){
       return restricao;
   }
   /**
     * Função que modifica a restricao do tipo da atividade
     * @param restricao
     */
   public void setRestricao(Boolean restricao){
       this.restricao = restricao;
   }
}

