/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Aporte;
import br.com.redesocial.modelo.dto.Categoria;
import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Unidade de testes para o AporteBO
 * @author Lara Caroline
 * @since 30/10/2017
 */
public class AporteBOTest {
    /**
     * Método de teste responsável por inserir os aportes no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoInserir(){
        AporteBO aporteBO = new AporteBO();
        
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
    
        Cidade cidade = new Cidade();
        cidade.setNome("Ceres");
        cidade.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario de Teste");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("usuario@teste.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1999, 5, 16, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("456");
        usuario.setSexo(Sexo.FEMININO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 91234-4567");
        usuario.setCidade(cidade);
        
        Postagem postagem = new Postagem();
        postagem.setDescricao("Comentário");
        postagem.setUps(0);
        postagem.setDowns(0);
        postagem.setUsuario(usuario);
        postagem.setVisualizacoes(0);
        calendario.set(2017, 7, 16, 21, 58, 0);
        postagem.setData(calendario.getTime());
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("categoria 1");
        
        Aporte aporte = new Aporte();
        aporte.setTitulo("Novo");
        aporte.setCategoria(categoria);
        aporte.setPostagem(postagem);
        
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);

            aporteBO.inserir(aporte);
            
        } catch (Exception ex){
            fail("Falha ao inserir um aporte: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por alterar os aportes no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoAlterar() {
        AporteBO aporteBO = new AporteBO();
        
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
    
        Cidade cidade = new Cidade();
        cidade.setNome("Ceres");
        cidade.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario de Teste");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("usuario@teste.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1999, 5, 16, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("456");
        usuario.setSexo(Sexo.FEMININO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 91234-4567");
        usuario.setCidade(cidade);
        
        Postagem postagem = new Postagem();
        postagem.setDescricao("Comentário");
        postagem.setUps(0);
        postagem.setDowns(0);
        postagem.setUsuario(usuario);
        postagem.setVisualizacoes(0);
        calendario.set(2017, 7, 16, 21, 58, 0);
        postagem.setData(calendario.getTime());
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("categoria 1");
        
        Aporte aporte = new Aporte();
        aporte.setTitulo("Novo");
        aporte.setCategoria(categoria);
        aporte.setPostagem(postagem);
        
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);

            aporteBO.inserir(aporte);
            
        } catch (Exception ex){
            fail("Falha ao inserir um aporte: " + ex.getMessage());
        }
        
        aporte.setTitulo("Titulo 2");
        aporte.setCategoria(categoria);
        aporte.setPostagem(postagem);
        
        try{
            aporteBO.alterar(aporte);
        }catch(Exception ex){
            fail("Falha ao alterar um aporte:" + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar o aporte no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoSelecionar() {
        AporteBO aporteBO = new AporteBO();
        
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
    
        Cidade cidade = new Cidade();
        cidade.setNome("Ceres");
        cidade.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario de Teste");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("usuario@teste.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1999, 5, 16, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("456");
        usuario.setSexo(Sexo.FEMININO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 91234-4567");
        usuario.setCidade(cidade);
        
        Postagem postagem = new Postagem();
        postagem.setDescricao("Comentário");
        postagem.setUps(0);
        postagem.setDowns(0);
        postagem.setUsuario(usuario);
        postagem.setVisualizacoes(0);
        calendario.set(2017, 7, 16, 21, 58, 0);
        postagem.setData(calendario.getTime());
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("categoria 1");
        
        Aporte aporte = new Aporte();
        aporte.setTitulo("Novo");
        aporte.setCategoria(categoria);
        aporte.setPostagem(postagem);
        
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);

            aporteBO.inserir(aporte);
            
            int id = aporte.getId();
            
            Aporte aporteSelecionado = aporteBO.selecionar(id);
            
            assertNotNull("Aporte não encontrado", aporteSelecionado);
        } catch (Exception ex){
            fail("Falha ao inserir um aporte: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por listar os aportes inseridos no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoListar() {
        AporteBO aporteBO = new AporteBO();
        
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
    
        Cidade cidade = new Cidade();
        cidade.setNome("Ceres");
        cidade.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario de Teste");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("usuario@teste.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1999, 5, 16, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("456");
        usuario.setSexo(Sexo.FEMININO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 91234-4567");
        usuario.setCidade(cidade);
        
        Postagem postagem = new Postagem();
        postagem.setDescricao("Comentário");
        postagem.setUps(0);
        postagem.setDowns(0);
        postagem.setUsuario(usuario);
        postagem.setVisualizacoes(0);
        calendario.set(2017, 7, 16, 21, 58, 0);
        postagem.setData(calendario.getTime());
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("categoria 1");
        
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);
            
            List existentes = aporteBO.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 3;
            for (int i = 0; i < 3; i++){
                Aporte aporte = new Aporte();
                aporte.setTitulo("Novo");
                aporte.setCategoria(categoria);
                aporte.setPostagem(postagem);
                
                try{
                   aporteBO.inserir(aporte); 
                }catch(Exception ex){
                    fail("Falha ao inserir um aporte: " + ex.getMessage());
                }
            }
            
            List existentesFinal = aporteBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            fail("Falha ao listar um aporte: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por excluir os aportes no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() {
        AporteBO aporteBO = new AporteBO();
        
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
    
        Cidade cidade = new Cidade();
        cidade.setNome("Ceres");
        cidade.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario de Teste");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("usuario@teste.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1999, 5, 16, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("456");
        usuario.setSexo(Sexo.FEMININO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 91234-4567");
        usuario.setCidade(cidade);
        
        Postagem postagem = new Postagem();
        postagem.setDescricao("Comentário");
        postagem.setUps(0);
        postagem.setDowns(0);
        postagem.setUsuario(usuario);
        postagem.setVisualizacoes(0);
        calendario.set(2017, 7, 16, 21, 58, 0);
        postagem.setData(calendario.getTime());
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("categoria 1");
        
        Aporte aporte = new Aporte();
        aporte.setTitulo("Novo 10");
        aporte.setCategoria(categoria);
        aporte.setPostagem(postagem);
        
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem);

            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);

            aporteBO.inserir(aporte);
            
            int id = aporte.getId();
            
            Aporte aporteSelecionado = aporteBO.selecionar(id);
            assertNotNull("Aporte não encontrado", aporteSelecionado);
            
            aporteBO.excluir(id);
            
            Aporte aporteSelecionadoPosExclusao = aporteBO.selecionar(id);
            assertNull("Aporte encontrado, mesmo após excluí-lo", aporteSelecionadoPosExclusao);
            
        } catch (Exception ex){
            fail("Falha ao inserir um aporte: " + ex.getMessage());
        }
    }
}
