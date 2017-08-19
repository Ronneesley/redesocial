package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Multimidia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultimidiaBOTeste {
    
    /**
     * @autor Macilon
    */ 
    @Test
    public void testMetodoListar() throws Exception {
        MultimidiaBO bo = new MultimidiaBO();

        try{
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Multimidia multimidia = new Multimidia();
                multimidia.setTipoConteudo("foto");

                try {
                    bo.inserir(multimidia);
                } catch (Exception ex) {
                    fail("Falha ao inserir uma multimidia: " + ex.getMessage());
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
    public void testeMetodoExcluir() throws Exception{
        MultimidiaBO bo = new MultimidiaBO ();
        
        Multimidia multimidia = new Multimidia();
        multimidia.setMidia();
        multimidia.setTipoConteudo("fkk");
        multimidia.setData(2017, 2, 1, 0, 0, 0);
        multimidia.setAlbum();
        
        try{
            bo.inserir(multimidia);
            
            int id = multimidia.getId();
            Multimidia multimidiaSelecionado = bo.selecionar(id);
            assertNotNull("Foto não encontrada!", multimidiaSelecionado);
            
            bo.excluir(id);
            Multimidia multimidiaSelecionadoPosExclusao = bo.selecionar(id);
            
            assertNull("Foto não encontrada, mesmo após excluí-lá", multimidiaSelecionadoPosExclusao);
        }catch (Exception ex){
            fail("Falha ao adicionar uma foto" +ex.getMessage());
        }
        
    }
}

