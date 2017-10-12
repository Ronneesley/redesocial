package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Unidade de testes para o CidadeBO
 * @author Eduardo Oliveira
 * @since 16/08/2017
 */
 public class CidadeBOTest {
/**
     * @throws java.lang.Exception *  @Test
    public void testMetodoInserir() {
        PaisBO paisbo = new PaisBO();
        
        Pais pais = new Pais();
        try {
            pais.setNome("Brasil");
            paisbo.inserir(pais);

            int idpais = pais.getId();

            Pais paisSelecionado = paisbo.selecionar(idpais);

            EstadoBO estadobo = new EstadoBO();

            Estado estado = new Estado();
            estado.setNome("Goiás");
            estado.setPais(paisSelecionado);
            estadobo.inserir(estado);
            
            int idestado = estado.getId();
            
            Estado estadoSelecionado = estadobo.selecionar(idestado);
            
           
            CidadeBO cidadebo = new CidadeBO();

            Cidade cidade = new Cidade();
            cidade.setNome("Goianesia");
            cidade.setEstado(estadoSelecionado);
                   
       
            cidadebo.inserir(cidade);
            
        } catch (Exception ex) {
            fail("Falha ao inserir a cidade: " + ex.getMessage());
        }

    }*/
    /**
 
    * Unidade de testes para o CidadeBO
    * @author Eduardo Oliveira
    * @since 16/08/2017
    */
     /**  @Test
    public void testMetodoAlterar() throws Exception {
        //Para testar é necessário inserir uma Cidade, mas para inserir a cidade é preciso inserir um Pais e um Estado 
        Pais pais = new Pais();
        pais.setNome("Brazil");
        
        PaisBO paisBO = new PaisBO();
        paisBO.inserir(pais);
        
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
        
        EstadoBO estadoBO = new EstadoBO();
        estadoBO.inserir(estado);
        
        Cidade cidade = new Cidade();
        cidade.setNome("Ceressssssss");
        cidade.setEstado(estado);
        
        //realiza a tentativa de inserção da Cidade.
        try {
            CidadeBO bo = new CidadeBO();
            bo.inserir(cidade);
        } catch (Exception ex) {
            fail("Falha ao inserir a cidade: " + ex.getMessage());
        //Mensagem caso a inserção falhe.
        }
        
        //alterando o nome da Cidade que foi inserida no banco de dados
        cidade.setNome("Ceres");

        try {
            CidadeBO bo = new CidadeBO();
            bo.alterar(cidade);
        } catch (Exception ex) {
            fail("Falha ao inserir a cidade: " + ex.getMessage());
        }
    }
    
  @Test
    public void testMetodoSelecionar() {
         PaisBO paisBO = new PaisBO();
         EstadoBO estadoBO = new EstadoBO();
         CidadeBO cidadeBO = new CidadeBO();
        
        try{
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            Pais pais = new Pais();
            
            pais.setNome("Brasil");
            paisBO.inserir(pais);
         
            estado.setNome("Goiás");
            estado.setPais(pais);
            estadoBO.inserir(estado);
            
            cidade.setNome("Ceres");
            cidade.setEstado(estado);
            cidadeBO.inserir(cidade);
           
            int id = cidade.getId();
            /**
             * seleciona o estado desejado
             */
 /**           Cidade cidadeSelecionado = cidadeBO.selecionar(id);
            
            assertNotNull("Cidade não encontrada", cidadeSelecionado);
        } catch (Exception ex) {
           
            fail("Falha ao inserir uma cidade: " + ex.getMessage());
        }
    }
} **/

    @Test
    public void testMetodoListar() throws Exception {
        Pais pais = new Pais();
        pais.setNome("China");
        
        PaisBO paisBO = new PaisBO();
        paisBO.inserir(pais);
        
        Estado estado = new Estado();
        estado.setNome("Para");
        estado.setPais(pais);
        
        EstadoBO estadoBO = new EstadoBO();
        estadoBO.inserir(estado);
        CidadeBO bo = new CidadeBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Cidade cidade = new Cidade();
                cidade.setNome("Goianiaa goi");
                cidade.setEstado(estado);

                try {
                    bo.inserir(cidade);
                } catch (Exception ex) {
                    fail("Falha ao inserir cidade: " + ex.getMessage());
                }
            }

            List existentesFinal = bo.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    
    /**
     * Teste responsável pela exclusão de uma cidade no banco de dados
     * @author Fernando Maciel da Silva
     */
   /** @Test
    public void testMetodoExcluir() {
        
        PaisBO paisBO = new PaisBO();       
        Pais pais = new Pais();
        
        pais.setNome("Brasil");
        
        try {
            paisBO.inserir(pais);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
        
        EstadoBO estadoBO = new EstadoBO();
        Estado estado = new Estado();
        
        estado.setNome("Goiás");
        estado.setPais(pais);
        
        try {
            estadoBO.inserir(estado);
        } catch (Exception ex) {
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }
        
        CidadeBO cidadeBO = new CidadeBO();
        Cidade cidade = new Cidade();
        
        cidade.setNome("Ceres");        
        cidade.setEstado(estado);        
        
        try {
            cidadeBO.inserir(cidade);

            int id = cidade.getId();
            Cidade cidadeSelecionada = cidadeBO.selecionar(id);
            assertNotNull("Cidade não encontrada", cidadeSelecionada);

            cidadeBO.excluir(id);
            Cidade cidadeSelecionadaPosExclusao = cidadeBO.selecionar(id);

            assertNull("Cidade encontrada, mesmo após excluí-la", cidadeSelecionadaPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir uma cidade: " + ex.getMessage());
        }        
    }**/
}
 
 
