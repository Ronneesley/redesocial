package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Unidade de testes para o CidadeBO
 * @author Eduardo Oliveira
 * @since 16/08/2017
 */
 public class CidadeBOTest {
     @Test
    public void testMetodoInserir() {
        
        
    }
    
    @Test
    public void testMetodoAlterar() {
        CidadeBO bo = new CidadeBO();

        Cidade cidade = new Cidade();
        cidade.setNome("Ceressssssss");
        
        try {
            bo.inserir(cidade);
        } catch (Exception ex) {
            fail("Falha ao inserir a cidade: " + ex.getMessage());
        }

        cidade.setNome("Ceres");

        try {
            bo.alterar(cidade);
        } catch (Exception ex) {
            fail("Falha ao inserir a cidade: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoSelecionar() {
        CidadeBO bo = new CidadeBO();

        Cidade cidade = new Cidade();
        cidade.setId(1);

        try{
            bo.inserir(cidade);
            int id = cidade.getId();

            Cidade cidadeSelecionado = bo.selecionar(id);

            assertNotNull("Cidade nao encontrada", cidadeSelecionado);
        } catch (Exception ex){
            fail("Falha ao inserir uma cidade: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoListar() {
        CidadeBO bo = new CidadeBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Cidade cidade = new Cidade();
                cidade.setNome("Goiania");

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
    
    @Test
    public void testMetodoExcluir() {
        
    }
 }
