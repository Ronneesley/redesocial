package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Multimidia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultimidiaBOTeste {
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
}

