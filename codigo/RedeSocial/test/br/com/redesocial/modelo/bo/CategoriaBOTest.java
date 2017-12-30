package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Categoria;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o CategoriaBO
 * @author Fernando Maciel da Silva
 * @since 26/09/2017
 */
public class CategoriaBOTest {
    @Test
    public void testMetodoInserir() {
        CategoriaBO categoriaBO = new CategoriaBO();

        Categoria categoria = new Categoria();
        categoria.setDescricao("Comentário");

        try {
            categoriaBO.inserir(categoria);
        } catch (Exception ex) {
            fail("Falha ao inserir comentário: " + ex.getMessage());
        }        
    }

    @Test
    public void testMetodoAlterar() {
              
    }

    @Test
    public void testMetodoSelecionar() {
        
    }

    @Test
    public void testMetodoListar() {
        CategoriaBO bo = new CategoriaBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Categoria categoria = new Categoria();
                categoria.setDescricao("Listar");

                try {
                    bo.inserir(categoria);
                } catch (Exception ex) {
                    fail("Falha ao inserir uma categoria: " + ex.getMessage());
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