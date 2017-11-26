package br.com.redesocial.modelo.bo;
import br.com.redesocial.modelo.dto.TipoAtividade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Brener
 */
public class TipoAtividadeBOTest {
    @Test
    public void testMetodoInserir() {
        TipoAtividadeBO bo = new TipoAtividadeBO();

        TipoAtividade tipoAtividade01 = new TipoAtividade();
        tipoAtividade01.setNome("Programacao");
        tipoAtividade01.setRescricao(Boolean.TRUE);
        try {
            bo.inserir(tipoAtividade01);
        } catch (Exception ex) {
            fail("Falha ao inserir um tipo de atividade: " + ex.getMessage());
        }
    }   
    @Test
    public void testMetodoAlterar() {
        TipoAtividadeBO bo = new TipoAtividadeBO();

        TipoAtividade tipoAtividade01 = new TipoAtividade();
        tipoAtividade01.setNome("Design");
        tipoAtividade01.setRescricao(Boolean.TRUE);

        try {
            bo.inserir(tipoAtividade01);
        } catch (Exception ex) {
            fail("Falha ao inserir um tipo de atividade: " + ex.getMessage());
        }

        //Mudança dos dados
        tipoAtividade01.setNome("Programacao");

        try {
            bo.alterar(tipoAtividade01);
        } catch (Exception ex) {
            fail("Falha ao inserir um tipo de atividade: " + ex.getMessage());
        }
    }
    @Test
    public void testMetodoSelecionar() {
        TipoAtividadeBO bo = new TipoAtividadeBO();

        TipoAtividade tipoAtividade01 = new TipoAtividade();
        tipoAtividade01.setNome("Banco de Dados");
        tipoAtividade01.setRescricao(Boolean.TRUE);

        try {
            bo.inserir(tipoAtividade01);

            int id = tipoAtividade01.getId();

            TipoAtividade tipoAtividadeSelecionado = bo.selecionar(id);

            assertNotNull("Atividade não encontrada", tipoAtividadeSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }
    @Test
    public void testMetodoExcluir() {
        TipoAtividadeBO bo = new TipoAtividadeBO();

        TipoAtividade tipoAtividade01 = new TipoAtividade();
        tipoAtividade01.setNome("Orientacao a objetos");
        tipoAtividade01.setRescricao(Boolean.TRUE);

        try {
            bo.inserir(tipoAtividade01);

            int id = tipoAtividade01.getId();
            TipoAtividade tipoAtividadeSelecionado = bo.selecionar(id);
            assertNotNull("Atividade não encontrada", tipoAtividadeSelecionado);

            bo.excluir(id);
            TipoAtividade tipoAtividadeSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Atividade encontrada, mesmo após excluí-la", tipoAtividadeSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um tipo de atividade: " + ex.getMessage());
        }
    }
    @Test
    public void testMetodoListar() {
        TipoAtividadeBO bo = new TipoAtividadeBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                TipoAtividade tipoAtividade01 = new TipoAtividade();
                tipoAtividade01.setNome("Engenharia de Software");
                tipoAtividade01.setRescricao(Boolean.TRUE);

                try {
                    bo.inserir(tipoAtividade01);
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
