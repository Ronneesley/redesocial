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
 @Test
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
    }
}
 
 
