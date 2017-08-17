/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Comentario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Lara
 */
public class ComentarioBOTest {
    
    public void testMetodoInserir(){
        //INSIRA O testMetodoInserir AQUI
    }
    
    public void testMetodoAlterar(){
        //INSIRA O testMetodoAlterar AQUI
    }
    
    public void testMetodoSelecionar(){

        //instancia regras de negocio
        ComentarioBO bo = new ComentarioBO();

        //Instancia Comentario
        Comentario comentario = new Comentario();
        //seta um id para o comentario
        comentario.setId(1);
        
        //tenta inserir e apos seleciona
         try{
            bo.inserir(comentario);
            int id = comentario.getId();

            Comentario comentarioSelecionado = bo.selecionar(id);

            assertNotNull("Comentario nao encontrado", comentarioSelecionado);
        } catch (Exception ex){
            fail("Falha ao inserir o comentario: " + ex.getMessage());
        }

    }
    
    
    public void testMetodoListar() {
        ComentarioBO bo = new ComentarioBO();
        
        try{
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Comentario comentario = new Comentario();
                comentario.setDescricao("Comentario");
                
                try{
                    bo.inserir(comentario);
                }catch(Exception ex){
                    fail("Falha ao inserir um comentário: " + ex.getMessage());
                }
                
                List existentesFinal = bo.listar();
                int qtdeExistentesFinal = existentesFinal.size();
                 
                int diferenca = qtdeExistentesFinal - qtdeExistentes;

                assertEquals(qtde, diferenca);
            }
            
        }catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    
    public void testMetodoExcluir(){
        //INSIRA O testMetodoExcluir AQUI
    }
}
