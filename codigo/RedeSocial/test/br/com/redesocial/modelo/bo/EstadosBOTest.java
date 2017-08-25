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
    
    @Test
    public void testMetodoSelecionar(){
        EstadoBO estadoBO = new EstadoBO();
        PaisBO paisBO = new PaisBO();

        try{
            Estado estado = new Estado();
        
            Pais pais = new Pais();
            pais.setNome("Brasil");
            paisBO.inserir(pais);
            
            estado.setNome("Goiás");
            estado.setPais(pais);
            estadoBO.inserir(estado);

            int id = estado.getId();

            Estado estadoSelecionado = estadoBO.selecionar(id);

            assertNotNull("Estado não encontrado", estadoSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }
    }
    


 @Test
 public void testMetodoListar() {
        EstadoBO bo = new EstadoBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Estado estado = new Estado();
                estado.setNome("Goiás");

                try {
                    bo.inserir(estado);
                } catch (Exception ex) {
                    fail("Falha ao inserir um estado: " + ex.getMessage());
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
 }