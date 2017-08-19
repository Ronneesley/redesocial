package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Inimigo, Andrey
 */
public class EstadosBoTest {
   
    @Test
    public void testMetodoInserir() {
        EstadoBO bo = new EstadoBO();

        Estado estado1 = new Estado();
        estado1.setNome("Goias");

        try {
            bo.inserir(estado1);
        } catch (Exception ex) {
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }

        Estado estado2 = new Estado();
        estado2.setNome("Paraiba");

        try {
            bo.inserir(estado2);
        } catch (Exception ex) {
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }
    }
    
     @Test
    public void testMetodoAlterar() {
        EstadoBO bo = new EstadoBO();

        Estado estado = new Estado();
        estado.setNome("Cearaaaaa");

        try {
            bo.inserir(estado);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }

        //Mudança dos dados
        estado.setNome("Argentina");

        try {
            bo.alterar(estado);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }
    
    
    @Test
    public void testMetodoExcluir() {
        PaisBO paisbo = new PaisBO();
        
        Pais pais = new Pais();
        pais.setNome("igor");
        
        try {
            paisbo.inserir(pais);
             
            int idpais = pais.getId();
            Pais paisSelecionado = paisbo.selecionar(idpais);
             
            EstadoBO bo = new EstadoBO();

            Estado estado = new Estado();
            estado.setNome("igor");
            estado.setPais(paisSelecionado);

        
            bo.inserir(estado);
                        
            int id = estado.getId();
            Estado estadoSelecionado = bo.selecionar(id);
            assertNotNull("Estado não encontrado", estadoSelecionado);

            bo.excluir(id);
            Estado estadoSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Estado encontrado, mesmo após excluí-lo", estadoSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um estado: " + ex.getMessage());
        }
    }
    
}
