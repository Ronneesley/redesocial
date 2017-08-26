package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
/**
 *
 * @author Inimigo, Andrey, Daniel,Anny
 */
public class EstadosBOTest {
    
    @Test
    public void testMetodoInserir() {
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            Estado estado = new Estado();
            estado.setNome("Goiás");
            estado.setPais(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
           
        }catch (Exception ex) {
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }
    }
        
    
    
    /**
    * Método Alterar, insere dados e depois altera
    * @author Andrey Silva Ribeiro
    */
    @Test
    public void testMetodoAlterar() {
        /**
        * responsável pela inserção de um país no banco de dados
        * @param pais país a ser inserido
        */
        Pais pais = new Pais();
        pais.setNome("Finalemnte");
        
        /**
        * responsável pela inserção de um estado no banco de dados
        * @param estado estado a ser inserido
        */
        EstadoBO bo = new EstadoBO();

        Estado estado = new Estado();
        estado.setNome("Cearaaaaa");

        try {
            /**
            * realiza a tentativa de inserção do pais e do estado
            */
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            estado.setPais(pais);
            
            bo.inserir(estado);
        } catch (Exception ex) {
            /**
            * mensagem caso tenha erro ao inserir
            */
            fail("Falha ao inserir um país: " + ex.getMessage());
        }

        //indicação de alteração do estado que foi inserido no banco de dados
        estado.setNome("testando");

        try {
            // tentativa de alteração do estado
            bo.alterar(estado);
        } catch (Exception ex) {
            //mensagem de erro caso a alteração nao seja feita
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }
    
    /**
     * Método selecionar, seleciona dados 
     * @author Daniel Moreira Cardoso
     */
    @Test
    public void testMetodoSelecionar(){
        /**
         * responsável pela inserção de um estado no banco de dados
         * @param estadoBO identificador de um EstadoBO
         */
        EstadoBO estadoBO = new EstadoBO();
        
        /**
         * responsável pela inserção de um país no banco de dados
         * @param paisBO identificador de um paisBO
         */
        PaisBO paisBO = new PaisBO();
        
        
        /**
         * realiza a tentativa de inserção no banco de dados
         */
        try{
            /**
             * responsável pela inserção de um estado no banco de dados
             * @param estado indetificador do estado a ser inserido
             */
            Estado estado = new Estado();
            
            /**
             * responsável pela inserção de um país no banco de dados
             * @param pais identificador de um pais a ser inserido
             */
            Pais pais = new Pais();
            
            /**
             * atribuição das características do país a ser inserido
             */
            pais.setNome("Brasil");
            paisBO.inserir(pais);
            
            /**
             * atribuição das características do estado a ser inserido
             */
            estado.setNome("Goiás");
            estado.setPais(pais);
            estadoBO.inserir(estado);
            
            /**
             * atribuição do identificador do estado à uma variável
             * @param id identificador do id do estado a ser selecionado
             */
            int id = estado.getId();
            
            /**
             * seleciona o estado desejado
             */
            Estado estadoSelecionado = estadoBO.selecionar(id);
            
            /**
             * mensagem de erro caso não encontre o estado
             */
            assertNotNull("Estado não encontrado", estadoSelecionado);
        } catch (Exception ex) {
            /**
             * mensagem de erro caso não consiga inserir o estado
             */
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }
    }
    


 @Test
 public void testMetodoListar() throws Exception {
    
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        PaisBO paisBO = new PaisBO();
        paisBO.inserir(pais);
        
        EstadoBO estadoBO = new EstadoBO();

        try {
            List existentes = estadoBO.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 3;
            for (int i = 0; i < 3; i++){
                Estado estado = new Estado();
                estado.setNome("Goiás");

                try {
                    estadoBO.inserir(estado);
                } catch (Exception ex) {
                    fail("Falha ao inserir um estado: " + ex.getMessage());
                }
            }

            List existentesFinal = estadoBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
 }