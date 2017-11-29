package br.com.redesocial.modelo.bo;
import br.com.redesocial.modelo.dto.TiposAtividades;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brener, Jose Gilvan e Marcos Arriel
 * @since 27/11/2017
 */
public class TiposAtividadesBOTest {
    
    @Test
    public void testMetodoInserir() {
        TiposAtividadesBO bo = new TiposAtividadesBO();

        TiposAtividades tiposAtividades01 = new TiposAtividades();
        tiposAtividades01.setNome("Designer");
        tiposAtividades01.setRestricao(true);

        try {
            bo.inserir(tiposAtividades01);
        } catch (Exception ex) {
            fail("Falha ao inserir uma atividade: " + ex.getMessage());
        }
    } 
   
    @Test
    public void testMetodoAlterar() {
        TiposAtividadesBO bo = new TiposAtividadesBO();

        TiposAtividades tiposAtividades02 = new TiposAtividades();
        tiposAtividades02.setNome("Programacao");
        tiposAtividades02.setRestricao(true);

        try {
            bo.inserir(tiposAtividades02);
        } catch (Exception ex) {
            fail("Falha ao inserir uma atividade: " + ex.getMessage());
        }

        //Mudança dos dados
        tiposAtividades02.setNome("Banco de Dados");

        try {
            bo.alterar(tiposAtividades02);
        } catch (Exception ex) {
            fail("Falha ao inserir uma atividade: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoSelecionar() {
        TiposAtividadesBO bo = new TiposAtividadesBO();

        TiposAtividades tiposAtividades03 = new TiposAtividades();
        tiposAtividades03.setNome("Engenharia");
        tiposAtividades03.setRestricao(true);
        
        try {
            bo.inserir(tiposAtividades03);

            int id = tiposAtividades03.getId();

            TiposAtividades tiposAtividadesSelecionado = bo.selecionar(id);

            assertNotNull("Atividade não encontrada", tiposAtividadesSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir uma atividade: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoExcluir() {
        TiposAtividadesBO bo = new TiposAtividadesBO();

        TiposAtividades tiposAtividades04 = new TiposAtividades();
        tiposAtividades04.setNome("Teoria da Computacao");
        tiposAtividades04.setRestricao(true);

        try {
            bo.inserir(tiposAtividades04);

            int id = tiposAtividades04.getId();
            TiposAtividades tiposAtividadesSelecionado = bo.selecionar(id);
            assertNotNull("Atividade não encontrada", tiposAtividadesSelecionado);

            bo.excluir(id);
            TiposAtividades tiposAtividadesSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Atividade encontrada, mesmo após excluí-lo", tiposAtividadesSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir uma atividade: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoListar() {
        TiposAtividadesBO bo = new TiposAtividadesBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                TiposAtividades tiposAtividades05 = new TiposAtividades();
                tiposAtividades05.setNome("Web");
                tiposAtividades05.setRestricao(true);

                try {
                    bo.inserir(tiposAtividades05);
                } catch (Exception ex) {
                    fail("Falha ao inserir uma atividade: " + ex.getMessage());
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
