/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Comentario;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.util.Calendar;
import java.util.Date;
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
    
    @Test
    public void testMetodoListar() {
        ComentarioBO bo = new ComentarioBO();
        
        try{
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();
            
            Calendar calendario = Calendar.getInstance();
            calendario.set(2017, 7, 18, 10, 55, 13);
            
            Calendar calendarioPost = Calendar.getInstance();
            calendarioPost.set(2017, 7, 18, 9, 30, 45);
            
            Calendar calendarioNascimento = Calendar.getInstance();
            calendarioNascimento.set(2017, 7, 18, 9, 30, 45);
            
            Pais pais = new Pais();
            
            pais.setNome("Brasil");
            
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            Estado estado = new Estado();
            
            estado.setNome("Goiás");
            estado.setPais(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            Cidade cidade = new Cidade();
            
            cidade.setNome("Goiânia");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            
            usuario.setNome("Joana");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("joaninha@contato.com");
            //usuario.setFoto();           
            usuario.setDataNascimento(calendarioNascimento.getTime());
            usuario.setSenha("192837");
            usuario.setSexo(Sexo.FEMININO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 91234-4567");
            usuario.setCidade(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);
            
            Postagem postagem = new Postagem();
            
            postagem.setCurtidas(6);
            postagem.setDescricao("Post de texto");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);
            
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);
            
            final int qtde = 3;
            for (int i = 0; i < 3; i++){
                
                Comentario comentario = new Comentario();
                
                comentario.setDescricao("Que legal!");
                comentario.setCurtidas(2);
                comentario.setData(calendario.getTime());
                comentario.setPostagem(postagem);
                
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
