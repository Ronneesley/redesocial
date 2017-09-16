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
    
   @Test
    public void testMetodoInserir(){
        
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

            estado.setNome("Paraná");
            estado.setPais(pais);

            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            Cidade cidade = new Cidade();

            cidade.setNome("Ceres");
            cidade.setEstado(estado);

            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            Usuario usuario = new Usuario();

            usuario.setNome("Jeferson Rossini");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("contatinho@contato.com");     
            usuario.setDataNascimento(calendarioNascimento.getTime());
            usuario.setSenha("202030");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 8432-98632");
            usuario.setCidade(cidade);

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            Postagem postagem = new Postagem();

            postagem.setCurtidas(6);
            postagem.setDescricao("Texto do Post");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);
            //inserir visualização em todos !!!!!!!
            
            //insere post
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            
            //instancia comentario e insere
            Comentario comentario = new Comentario();

            comentario.setDescricao("Comentário escrito aqui!!!");
            comentario.setCurtidas(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);

            try{
                /**
                 * Inserindo comentário no banco de dados
                 */
                bo.inserir(comentario);
            } catch(Exception ex){
                /**
                 * Mensagem de erro caso falhe
                 */
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }
        } catch(Exception ex){
                /**
                 * Mensagem de erro caso falhe
                 */
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }
    }
    
    @Test
    
    public void testMetodoAlterar(){
    ComentarioBO bo = new ComentarioBO();
        
        
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

            estado.setNome("Goias");
            estado.setPais(pais);

            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            Cidade cidade = new Cidade();

            cidade.setNome("Carmo do Rio Verde");
            cidade.setEstado(estado);

            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            Usuario usuario = new Usuario();

            usuario.setNome("Jose");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("junior@contato.com");     
            usuario.setDataNascimento(calendarioNascimento.getTime());
            usuario.setSenha("9982");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 9904-8964");
            usuario.setCidade(cidade);

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            Postagem postagem = new Postagem();

            postagem.setCurtidas(6);
            postagem.setDescricao("postagem");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);

            //insere post
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);
            

            
            //instancia comentario e insere
            Comentario comentario = new Comentario();

            comentario.setDescricao("Comentario escrito");
            comentario.setCurtidas(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);

            try{
                                
                bo.inserir(comentario);
            } catch(Exception ex){
                //Mensagem de erro caso falhe
                 
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }
            //alterando o comentario que foi inserido no banco de dados
            comentario.setDescricao("Ola");
            comentario.setCurtidas(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);

        try {
           
            bo.alterar(comentario);
        } catch (Exception ex) {
            //Mensagem de erro caso falhe
            fail("Falha ao inserir o comentario: " + ex.getMessage());
        }
        }
    }
    }
    
    @Test
    public void testMetodoSelecionar(){
        
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

            estado.setNome("Paraná");
            estado.setPais(pais);

            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            Cidade cidade = new Cidade();

            cidade.setNome("Ceres");
            cidade.setEstado(estado);

            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            Usuario usuario = new Usuario();

            usuario.setNome("Jeferson Rossini");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("contatinho@contato.com");     
            usuario.setDataNascimento(calendarioNascimento.getTime());
            usuario.setSenha("202030");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 8432-98632");
            usuario.setCidade(cidade);

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            Postagem postagem = new Postagem();

            postagem.setCurtidas(6);
            postagem.setDescricao("Texto do Post");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);

            //insere post
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            
            //instancia comentario e insere
            Comentario comentario = new Comentario();

            comentario.setDescricao("Comentário escrito aqui!!!");
            comentario.setCurtidas(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);

            try{
                /**
                 * Inserindo comentário no banco de dados
                 */
                bo.inserir(comentario);
            }catch(Exception ex){
                /**
                 * Mensagem de erro caso falhe
                 */
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }

        }catch (Exception ex){
            /**
             * Erro caso a listagem falhe
             */
            fail("Erro ao listar: " + ex.getMessage());
        }
        

    }
    
    /**
     * Método de teste responsável pela listagem dos commentários existentes no banco de dados
     * @author Lara Caroline
     */
    //@Test
    public void testMetodoListar() {
        /*
        Para listar comentários é necessário a existência dos mesmos.
        Para inserir comentários, deve-se inserir postagem, usuário, cidade
        estado e país.
        */
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
            
            //Definindo a quantidade de comentários a serem inseridos
            
            final int qtde = 3;
            for (int i = 0; i < 3; i++){
                
                Comentario comentario = new Comentario();
                
                comentario.setDescricao("Que legal!");
                comentario.setCurtidas(2);
                comentario.setData(calendario.getTime());
                comentario.setPostagem(postagem);
                
                try{
                    //Inserindo comentário no banco de dados
                    bo.inserir(comentario);
                }catch(Exception ex){
                    //Mensagem de erro caso falhe
                    fail("Falha ao inserir um comentário: " + ex.getMessage());
                }
            }
            //Verifica a quantidade de comentários após inserção
            List existentesFinal = bo.listar();
            int qtdeExistentesFinal = existentesFinal.size();
            //Verifica quantos comentários foram inseridos
            int diferenca = qtdeExistentesFinal - qtdeExistentes;
            assertEquals(qtde, diferenca);
            
        }catch (Exception ex){
            //Erro caso a listagem falhe
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    
    /**
     * Método responsável pelo teste da exclusão de um comentário no banco de dados
     * @author Luciano de Carvalho Borba
     */
    //@Test
    public void testMetodoExcluir(){
       Pais pais = new Pais();
       pais.setNome("Brasil");
       
        
       //Criação e inserção de dados de: país, estado, cidade, usuário, postagem e comentário.
        
       try{
           
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            Estado estado = new Estado();
            estado.setNome("Acre");
            estado.setPais(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            Cidade cidade = new Cidade();
            cidade.setNome("Los Angel");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            usuario.setNome("Raul");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("raul@gmail.com");
            Calendar calendario = Calendar.getInstance();
            calendario.set(1986, 2, 8, 0, 0, 0);            
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("123789");
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
            
            ComentarioBO bo = new ComentarioBO();
            
            Comentario comentario = new Comentario();
            comentario.setDescricao("bommm");
            comentario.setCurtidas(0);
            
            calendario.set(1986, 4, 8, 0, 0, 0);            
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);
            
            bo.inserir(comentario);
            
            //Verifica se o comentário está cadastrada no banco de dados
              
            int id = comentario.getId();
            
            //Seleciona um cometário inserido atráves do id 
             
            Comentario comentarioSelecionado = bo.selecionar(id);
            
            //Se não houver comentério exibirá uma mensagem de erro
            
            assertNotNull("Comentario não encontrado", comentarioSelecionado);
            
            //Exclui comentário selecionado pelo id
            
            bo.excluir(id);
           
            //Seleciona coméntario excluido para saber se ele foi realmente deletado
            
           Comentario comentarioSelecionadoPosExclusao = bo.selecionar(id);
           
           //Caso o coméntario possa ser encontrado no banco de dados mesmo após a exclusão, será exibida uma mensagem de erro ao excluir
           
           assertNull("comentario encontrado, mesmo apos exclui-la", comentarioSelecionadoPosExclusao);
        }catch (Exception ex){
            
            //Caso houver algum erro ao inserir um comentário no banco de dados

           fail ("Falha ao inserir um comentario" + ex.getMessage());
        }   
    }
}
