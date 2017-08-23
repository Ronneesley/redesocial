/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Album;
import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import br.com.redesocial.modelo.utilitarios.Utilitarios;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import br.com.redesocial.modelo.dto.Comentario;
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
       ComentarioBO bo = new ComentarioBO();
        
       Comentario comentario = new Comentario();
       comentario.setId(1);
       
       try{
           
            PaisBO paisBO = new PaisBO();
            Pais pais = null;
            paisBO.inserir(pais);

            Estado estado = new Estado();
            estado.setNome("California");
            estado.setPais(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            Cidade cidade = new Cidade();
            cidade.setNome("Los Angeles");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            usuario.setNome("Raul");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("raul@gmail.com");
            //usuario.setFoto();
           
            Calendar calendario = Calendar.getInstance();
            calendario.set(1986, 2, 8, 0, 0, 0);            
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("1239");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 91432-9867");
            usuario.setCidade(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);
           

            Postagem postagem = new Postagem();
            postagem.setDescricao("Comentário");
            postagem.setCurtidas(0);
            postagem.setUsuario(usuario);

            calendario.set(2017, 7, 16, 21, 58, 0);
            postagem.setData(calendario.getTime());
            
            PostagemBO postagemBO  = new PostagemBO();
            postagemBO.inserir(postagem);
            
 
           
            comentario.setDescricao("bommm");
            comentario.setCurtidas(0);
            
            calendario.set(1986, 4, 8, 0, 0, 0);            
            comentario.setData(calendario.getTime());
            comentario.setPostagem(1);
            
            bo.inserir(comentario);
           
            int id = comentario.getId();
            Comentario comentarioSelecionado = bo.selecionar(id);
            assertNotNull("Album não encontrada", comentarioSelecionado);
          
            bo.excluir(id);
           
           Comentario comentarioSelecionadoPosExclusao = bo.selecionar(id);
           
           assertNull("comentario não encontrado", comentarioSelecionadoPosExclusao);
        }catch (Exception ex){
                fail ("Falha ao inserir um comentario" + ex.getMessage());
                
         }
    }
}
