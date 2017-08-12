package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Pais;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o PaisBO
 * @author Ronneesley Moura Teles
 * @since 09/08/2017
 */
public class PaisBOTest {
    @Test
    public void testMetodoInserir() {
        PaisBO bo = new PaisBO();

        Pais pais1 = new Pais();
        pais1.setNome("Brasil");

        try {
            bo.inserir(pais1);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }

        Pais pais2 = new Pais();
        pais2.setNome("Estados Unidos");

        try {
            bo.inserir(pais2);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoAlterar() {
        PaisBO bo = new PaisBO();

        Pais pais = new Pais();
        pais.setNome("Argentinaaaaa");

        try {
            bo.inserir(pais);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }

        //Mudança dos dados
        pais.setNome("Argentina");

        try {
            bo.alterar(pais);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoSelecionar() {
        PaisBO bo = new PaisBO();

        Pais pais = new Pais();
        pais.setNome("Canadá");

        try {
            bo.inserir(pais);

            int id = pais.getId();

            Pais paisSelecionado = bo.selecionar(id);

            assertNotNull("Pais não encontrado", paisSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoListar() {
        PaisBO bo = new PaisBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Pais pais = new Pais();
                pais.setNome("França");

                try {
                    bo.inserir(pais);
                } catch (Exception ex) {
                    fail("Falha ao inserir um país: " + ex.getMessage());
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

    @Test
    public void testMetodoExcluir() {
        PaisBO bo = new PaisBO();

        Pais pais = new Pais();
        pais.setNome("Japão");

        try {
            bo.inserir(pais);

            int id = pais.getId();
            Pais paisSelecionado = bo.selecionar(id);
            assertNotNull("Pais não encontrado", paisSelecionado);

            bo.excluir(id);
            Pais paisSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Pais encontrado, mesmo após excluí-lo", paisSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }
}