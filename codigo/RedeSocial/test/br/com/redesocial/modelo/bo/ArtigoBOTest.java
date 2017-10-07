package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Artigo;
import br.com.redesocial.modelo.dto.Categoria;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import br.com.redesocial.modelo.utilitarios.Utilitarios;
import java.io.File;
import java.util.List;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o ArtigoBO
 * @author Andrey Silva Ribeiro, Lucas Azevedo, Macilon Arruda
 * @since 15/09/2017
*/
public class ArtigoBOTest {
    @Test     
    public void testMetodoInserir() throws Exception {
        ArtigoBO bo = new ArtigoBO();

        Artigo artigo1 = new Artigo();
        artigo1.setIdioma("Portugues");       
        artigo1.setRevista("SBIS");
        artigo1.setISSN("33333333");
        //artigo1.setAutor("Ciencias da terra"); 
        Calendar calendario = Calendar.getInstance();
        calendario.set(1988, 2, 7, 0, 0, 0);            
        artigo1.setData(calendario.getTime());
        artigo1.setAreaConhecimento("Ciencias da terra");
        artigo1.setTitulo("Título teste 1");
        artigo1.setResumo("Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo1.setURL("www.artigo.com.br");
        artigo1.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        
        try {
            bo.inserir(artigo1);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }

    }
    
    /**
     * Método de teste responsável pela listagem dos artigos existentes no banco de dados
     * @author Macilon Arruda
     */
    @Test
    public void testMetodoListar() {
        
        /* Para realizar a listagem é necessário que existam dados a serem lidos
        por isso precisa inserir usuário, país, estado e cidade no banco de dados */  
        ArtigoBO bo = new ArtigoBO();

        try {            
            
            //Verifica a quantidade de artigos existentes no banco de dados 
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            //Define a quantidade a ser listada
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
            cidade.setNome("Uruana");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            usuario.setNome("Cilon");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("macilonarruda@outlook.com");
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

            Postagem postagem1 = new Postagem();
            postagem1.setUps(0);
            postagem1.setDowns(0);
            postagem1.setDescricao("Comentário");
            postagem1.setData(calendario.getTime());
            postagem1.setVisualizacoes(3);
            postagem1.setUsuario(usuario);
            
            PostagemBO postagemBO = new PostagemBO();
            postagemBO.inserir(postagem1);

            Categoria categoria = new Categoria();
            categoria.setDescricao("Qualquer coisa.");
            
            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoria);
            
            Artigo artigo = new Artigo();
            artigo.setIdioma("Português");
            artigo.setRevista("Veja");
            artigo.setISSN("12345678");
            artigo.setData(new Date());
            artigo.setAreaConhecimento("Matemática");
            artigo.setTitulo("A matemática no seu cotidiano");
            artigo.setResumo("As exatas te persegue eu qualquer área que você estiver.");
            artigo.setURL("http://www.matematicapravidatoda.com.br");
            artigo.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
            artigo.setCategoria(categoria);
            
            ArtigoBO artigoBO = new ArtigoBO();
            
            try {
                    artigoBO.inserir(artigo);
                    
                } catch (Exception ex) {
                    fail("Falha ao inserir um artigo: " + ex.getMessage());
                }
            }
            
            //Verifica a quantidade de artigos após inserir
            List existentesFinal = bo.listar(); 
            int qtdeExistentesFinal = existentesFinal.size();
            
            //Verifica a quantidade de albuns realmente inseridos
            int diferenca = qtdeExistentesFinal - qtdeExistentes;
            
            /* Compara a quantidade definida para listagem e a quantidade de
            artigos inseridos, finaliza se estiver tudo certo */ 
            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            
            //Mensagem de erro caso a comparação não seja exata
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoAlterar() throws Exception {
        ArtigoBO bo = new ArtigoBO();
        
        Artigo artigo = new Artigo();
        
        artigo.setIdioma("Ingles");       
        artigo.setRevista("RC");
        artigo.setISSN("1234");
        //artigo.setAutor("João"); 
        Calendar calendario = Calendar.getInstance();
        calendario.set(1988, 2, 7, 0, 0, 0);            
        artigo.setData(calendario.getTime());
        artigo.setAreaConhecimento("Ciencias da Terra");
        artigo.setTitulo("Qualquer Coisa");
        artigo.setResumo("Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo.setURL("www.artigo.com.br");
        artigo.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        
        try {
            bo.inserir(artigo);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }

        //Mudança dos dados
        artigo.setIdioma("Portugues");       
        artigo.setRevista("RC");
        artigo.setISSN("1234");
        //artigo.setAutor("João");           
        artigo.setData(calendario.getTime());
        artigo.setAreaConhecimento("Ciencias da Terra");
        artigo.setTitulo("Qualquer Coisa");
        artigo.setResumo("Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo.setURL("www.artigo.com.br");
        artigo.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        
        try {
            bo.alterar(artigo);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoSelecionar() throws Exception{
        
        ArtigoBO bo = new ArtigoBO();

        try{
            
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            Artigo artigo2 = new Artigo();

            artigo2.setIdioma("Ingles");       
            artigo2.setRevista("SBIS");
            artigo2.setISSN("33333333");
            //artigo2.setAutor("Ciencias da terra"); 
            Calendar calendario = Calendar.getInstance();
            calendario.set(1988, 2, 7, 0, 0, 0);            
            artigo2.setData(calendario.getTime());
            artigo2.setAreaConhecimento("Ciencias da terra");
            artigo2.setTitulo("Título teste 1");
            artigo2.setResumo("Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
            artigo2.setURL("www.artigo.com.br");
            artigo2.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));

        
        try{
            bo.inserir(artigo2);
                }catch(Exception ex){
           
            fail("Falha ao inserir um artigo: " + ex.getMessage());
                }
            }catch (Exception ex){
                fail("Erro ao listar: " + ex.getMessage());
        }
    }
    
     @Test
    public void testMetodoExcluir() throws Exception{
        
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
            cidade.setNome("Uruana");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            usuario.setNome("Cilon");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("macilonarruda@outlook.com");
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

            
            Postagem postagem1 = new Postagem();
            postagem1.setDescricao("Comentário");
            postagem1.setUps(0);
            postagem1.setDowns(0);
            postagem1.setUsuario(usuario);

            ArtigoBO bo = new ArtigoBO();
            Artigo artigo = new Artigo();
            artigo.setIdioma("Português");
            artigo.setRevista("Veja");
            artigo.setISSN("12345678");
            //artigo.setAutor("Jorge Fernando");
            artigo.setData(new Date());
            artigo.setAreaConhecimento("Matemática");
            artigo.setTitulo("A matemática no seu cotidiano");
            artigo.setResumo("As exatas te persegue eu qualquer área que você estiver.");
            artigo.setURL("http://www.matematicapravidatoda.com.br");
        
        try {
            bo.inserir(artigo);
            
        int id = artigo.getId();
        
        Artigo artigoSelecionado = bo.selecionar(id);
        
        assertNotNull("Artigo não encontrado", artigoSelecionado);
        
        bo.excluir(id);
        
        Artigo artigoSelecionadoPosExclusao = bo.selecionar(id);
        
        assertNull("comentario encontrado, mesmo apos exclui-lo", artigoSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }
        
        
    }
}
