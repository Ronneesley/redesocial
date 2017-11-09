/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
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
    public void testMetodoInserir() throws Exception{
        ComentarioBO bo = new ComentarioBO();
        
        try{
            
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
            
            postagem.setUps(0);
            postagem.setDowns(0);
            postagem.setDescricao("Post de texto");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);
            postagem.setVisualizacoes(0);
            
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);
           
            
            //instancia comentario e insere
            Comentario comentario = new Comentario();

            comentario.setDescricao("Teste Inserir comentario! ");
            comentario.setUps(5);
            comentario.setDowns(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);
            comentario.setResposta(comentario);
            comentario.setUsuario(usuario);
            comentario.setId(2);
            

            try{
                //Inserindo comentário no banco de dados
                bo.inserir(comentario);
            }catch(Exception ex){
                //Mensagem de erro caso falhe
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }

            } catch(Exception ex){
                //Mensagem de erro caso falhe
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }
    }


   @Test
    public void testMetodoAlterar(){
       ComentarioBO bo = new ComentarioBO();
        
        try{
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
            postagem.setDescricao("Comentário");
            postagem.setUps(0);
            postagem.setDowns(0);
            postagem.setUsuario(usuario);
            postagem.setVisualizacoes(0);
            
            calendario.set(1998, 0, 8, 0, 0, 0);            
            postagem.setData(calendario.getTime());
            
            PostagemBO postagembo = new PostagemBO();
            postagembo.inserir(postagem);
            
            
            
            Comentario comentario = new Comentario();            
            comentario.setDescricao("comentario! ");
            comentario.setUps(5);
            comentario.setDowns(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);
            comentario.setResposta(comentario);
            comentario.setUsuario(usuario);
            comentario.setId(2);
            
            ComentarioBO comentarioBO = new ComentarioBO();
             
            try{                               
                comentarioBO.inserir(comentario);
            } catch(Exception ex){
              fail("Falha ao inserir um comentário: " + ex.getMessage());
            }
            
            comentario.setDescricao("comentario! ");
            comentario.setUps(5);
            comentario.setDowns(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);
            comentario.setResposta(comentario);
            comentario.setUsuario(usuario);
            comentario.setId(2);

        try {
            comentarioBO.alterar(comentario);
        } catch (Exception ex) {
            //Mensagem de erro caso falhe
            fail("Falha ao alterar o comentario: " + ex.getMessage());
        }
    }
          catch(Exception ex){
            //Mensagem de erro caso falhe
            fail("Falha ao inserir um comentário: " + ex.getMessage());
        
       }
    }
    
    
    /**
     * Método de teste responsável por selecionar commentários existentes no banco de dados
     * @author Jeferson Rossini
     */
    @Test
    public void testMetodoSelecionar(){
        
      /*
        Para selecionar comentários é necessário a existência dos mesmos.
        Para inserir comentários, deve-se inserir postagem, usuário, cidade
        estado e país.
        */
        ComentarioBO comentarioBo = new ComentarioBO();
        
        try{
            
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
            
            postagem.setUps(0);
            postagem.setDowns(0);
            postagem.setDescricao("Post de texto");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);
            postagem.setVisualizacoes(50);
            
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);
            
            //Definindo o comentario a ser inserido  
            Comentario comentario = new Comentario();

            comentario.setDescricao("comentario! ");
            comentario.setUps(5);
            comentario.setDowns(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);
            comentario.setResposta(null);
            comentario.setUsuario(usuario);
            
            try{
                //Inserindo comentário no banco de dados
                comentarioBo.inserir(comentario);
                Comentario comentarioSelecionado = comentarioBo.selecionar(comentario.getId());
                assertNotNull("Comentario não encontrado", comentarioSelecionado);
                
            } catch (Exception ex) {
                fail("Falha ao inserir um comentário: " + ex.getMessage());
            }
            
        }catch (Exception ex){
            //Erro caso a listagem falhe
            fail("Erro ao selecionar: " + ex.getMessage());
        }
    }
    
    /**
     * Método de teste responsável pela listagem dos commentários existentes no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        
       ComentarioBO bo = new ComentarioBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 2;
            
            for (int i = 0; i < 2; i++){
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
                cidade.setNome("Ceres");
                cidade.setEstado(estado);

                CidadeBO cidadeBO = new CidadeBO();
                cidadeBO.inserir(cidade);

                Usuario usuario = new Usuario();
                usuario.setNome("Roni");
                usuario.setDataCadastro(new Date());
                usuario.setEmail("ronneesley@gmail.com");
                //usuario.setFoto();

                Calendar calendario = Calendar.getInstance();
                calendario.set(1988, 2, 7, 0, 0, 0);            
                usuario.setDataNascimento(calendario.getTime());
                usuario.setSenha("123");
                usuario.setSexo(Sexo.MASCULINO);
                usuario.setStatus(true);
                usuario.setTelefone("(62) 91234-4567");
                usuario.setCidade(cidade);

                UsuarioBO usuarioBO = new UsuarioBO();
                usuarioBO.inserir(usuario);


                PostagemBO postagemBO = new PostagemBO();
                Postagem postagem = new Postagem();
                postagem.setDescricao("Comentário");
                postagem.setUps(1);
                postagem.setDowns(2);
                postagem.setUsuario(usuario);
                postagem.setVisualizacoes(98);

                calendario.set(2017, 7, 16, 21, 58, 0);
                postagem.setData(calendario.getTime());

                postagemBO.inserir(postagem);
                
                
                 //instancia comentario
                Comentario comentario = new Comentario();

                comentario.setDescricao("Teste Inserir comentario! ");
                comentario.setUps(5);
                comentario.setDowns(2);
                comentario.setData(calendario.getTime());
                comentario.setPostagem(postagem);
                comentario.setResposta(null);
                comentario.setUsuario(usuario);

                //insere o comentario no db
                bo.inserir(comentario);
                
            }
            
            List existentesFinal = bo.listar(); //insere os dados perfeitamente quando chega aqui dá erro e n consigo arrumar
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);

        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());            
        }
    }

    
    /**
     * Método responsável pelo teste da exclusão de um comentário no banco de dados
     * @author Luciano de Carvalho Borba
     */
    @Test
    public void testMetodoExcluir(){
        ComentarioBO bo = new ComentarioBO();
        
        try{
            
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
            
            postagem.setUps(0);
            postagem.setDowns(0);
            postagem.setDescricao("Post de texto");
            postagem.setData(calendarioPost.getTime());
            postagem.setUsuario(usuario);
            postagem.setVisualizacoes(0);
            
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);
           
           //instancia comentario
            Comentario comentario = new Comentario();

            comentario.setDescricao("Teste Inserir comentario! ");
            comentario.setUps(5);
            comentario.setDowns(2);
            comentario.setData(calendario.getTime());
            comentario.setPostagem(postagem);
            comentario.setResposta(null);
            comentario.setUsuario(usuario);
            
            
            //insere o comentario no db
            bo.inserir(comentario);
            
            //recupera o id do comentario              
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
           fail ("Falha ao apagar um comentario" + ex.getMessage());
        }   
    }
}
