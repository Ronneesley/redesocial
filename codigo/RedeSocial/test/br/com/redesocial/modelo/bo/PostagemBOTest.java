package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Postagem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulo Henrique
 */
public class PostagemBOTest {
    
   
    @Test
    public void testMetodoInserir() {
        PostagemBO bo = new PostagemBO();

        Postagem postagem1 = new Postagem();
        postagem1.setDescricao("Comentário");
        postagem1.setCurtidas(0);
        postagem1.setData("2017/08/16");

        try {
            bo.inserir(postagem1);
        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());
        }

        Postagem postagem2 = new Postagem();
        postagem2.setDescricao("Novo Comentário");
        postagem2.setCurtidas(0);
        postagem1.setData("2017/08/16");

        try {
            bo.inserir(postagem2);
        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());
        }
        
    }
    
    
}
