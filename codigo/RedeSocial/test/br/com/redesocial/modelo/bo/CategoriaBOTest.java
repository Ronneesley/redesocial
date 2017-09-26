package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Categoria;
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
        
    }

    @Test
    public void testMetodoExcluir() {
        
    }
}