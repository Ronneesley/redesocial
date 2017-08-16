package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o CidadeBO
 * @author Ronneesley Moura Teles
 * @since 09/08/2017
 */
 
 public class CidadeBOTest {
    @Test
    public void testMetodoSelecionar() {
        CidadeBO bo = new CidadeBO();

        Cidade cidade = new Cidade();
        cidade.setNome("Ceres");

        try{
            bo.inserir(cidade);
            int id = cidade.getId();

            Cidade cidadeSelecionado = bo.selecionar(id);

            assertNotNull("Cidade nao encontrada", cidadeSelecionado);
        } catch (Exception ex){
            fail("Falha ao inserir uma cidade: " + ex.getMessage());
        }
    }
 }