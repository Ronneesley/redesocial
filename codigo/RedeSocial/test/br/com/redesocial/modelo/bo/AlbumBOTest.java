package br.com.redesocial.modelo.bo;

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

/**
 * Unidade de testes para o AlbumBO
 * @author Ronneesley Moura Teles, Ianka Talita Bastos de Assis
 * @since 16/08/2017
 */
public class AlbumBOTest {
    
    /**
     * Método de teste responsável pela inserção de um album no banco de dados
     * @author Gusttavo Nunes Gomes
     */    
    @Test
    public void testMetodoInserir() {
        //Para inserir um album é necessário inserir um usuário, país, estado e cidade no banco de dados
          
        Pais pais = new Pais();
        pais.setNome("EUA");        
        
	try {
            PaisBO paisBO = new PaisBO();
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
            usuario.setNome("Paul");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("paul@gmail.com");
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
            
            //Usuário, país, estado e cidade foram inseridos no banco de dados        
            
            AlbumBO bo = new AlbumBO();             		
            Album album = new Album();
            album.setNome("Hollywood");
            calendario.set(2016, 8, 29, 0, 0, 0);
            album.setData(calendario.getTime()); 
            album.setUsuario(usuario);
            //Os dados do album foram definidos para inserir no banco de dados  
            bo.inserir(album);
        } catch (Exception ex) {
            //Mensagem de erro caso não insira o album no banco de dados
            fail("Falha ao inserir um album: " + ex.getMessage());
        }		
    } 
    
    /**
     * Método de teste responsável pela listagem dos albuns existentes no banco de dados
     * @author Jônatas de Souza Rezende
     */
    @Test
    public void testMetodoListar() {
        
        /* Para realizar a listagem é necessário que existam dados a serem lidos
        por isso precisa inserir inserir usuário, país, estado e cidade no banco de dados */  
        AlbumBO bo = new AlbumBO();

        try {
            
            
            //Verifica a quantidade de albuns existentes no banco de dados 
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            //Define a quantidade a ser listada
            final int qtde = 10;
            
            for (int i = 0; i < 10; i++){
                Pais pais = new Pais();
                pais.setNome("EUA");
                
                PaisBO paisBO = new PaisBO();
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
                usuario.setNome("Paul");
                usuario.setDataCadastro(new Date());
                usuario.setEmail("paul@gmail.com");

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
                
                /* Após inserir usuário, país, estado e cidade no banco de dados
                é necessário inserir um album no banco de dados */  
                Album album = new Album();
                album.setNome("Hollywood");
                album.setData(new Date()); 
                album.setUsuario(usuario);

                //Os dados do album foram definidos para inserir no banco de dados
                try {
                    bo.inserir(album);
                
                } catch (Exception ex) {
                    /* Caso não seja possível inserir o album no banco de dados
                    apresenta a mensagem de erro */ 
                    fail("Falha ao inserir um álbum: " + ex.getMessage());
                }
            }
            
            //Verifica a quantidade de albuns após inserir
            List existentesFinal = bo.listar(); 
            int qtdeExistentesFinal = existentesFinal.size();
            
            //Verifica a quantidade de albuns realmente inseridos
            int diferenca = qtdeExistentesFinal - qtdeExistentes;
            
            /* Compara a quantidade definida para listagem e a quantidade de
            albuns inseridos, finaliza se estiver tudo certo */ 
            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            
            //Mensagem de erro caso a comparação não seja exata
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    /**
     * Método de teste responsável por selecionar um album no banco de dados
     * @author Igor Justino Rodrigues
     */
    @Test
    public void testMetodoSelecionar() {
        /*
         * Criação e inserção de Pais, Estado, Cidade, Usuario e Album no banco de dados
         */
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        try {
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
            usuario.setNome("Igor");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("igor@gmail.com");
            //usuario.setFoto();
                           
            Calendar calendario = Calendar.getInstance();
            calendario.set(1988, 2, 7, 0, 0, 0);            
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("123");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 99654-0873");
            usuario.setCidade(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);
            
            Album album = new Album();
            album.setNome("Album1");
            calendario.set(1998, 0, 8, 0, 0, 0);            
            album.setData(calendario.getTime());
            album.setUsuario(usuario);
            
            AlbumBO albumbo = new AlbumBO();
            albumbo.inserir(album);
            
            int idalbum = album.getId();
            
            /*
             *Seleção no banco de dados 
             */
            albumbo.selecionar(idalbum);
            
        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());            
        }

    }

    /**
     * Método de teste responsável por excluir um album no banco de dados
     * @author Ianka Talita Bastos de Assis
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Test
    public void testMetodoExcluir () throws Exception {
	AlbumBO albumBO = new AlbumBO();
	
        /* Criação e inserção de dados de: país, estado, cidade, usuário e álbum.
           Tenta inserir e em seguida exclui.*/
        try{ 
            //País
            PaisBO paisBO = new PaisBO();
            Pais pais = new Pais();
            pais.setNome("Brasil");
            paisBO.inserir(pais);
	
            //Estado
            EstadoBO estadoBO = new EstadoBO();
            Estado estado = new Estado();
            estado.setNome("Goiás");
            estado.setPais(pais);
            estadoBO.inserir(estado);
	
            //Cidade
            CidadeBO cidadeBO =  new CidadeBO();
            Cidade cidade = new Cidade();
            cidade.setNome("Bragolândia");
            cidade.setEstado(estado);
            cidadeBO.inserir(cidade);
	
            //Usuário
            UsuarioBO usuarioBO = new UsuarioBO();
        
            Usuario usuario = new Usuario();
            usuario.setNome("Ianka");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("iankatalitaa@gmail.com");
            //usuario.setFoto();
	
            Calendar calendario = Calendar.getInstance();
            calendario.set(1997, 1, 15, 0, 0, 0);
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("gaivotinha");
            usuario.setSexo(Sexo.FEMININO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 98483-0937");
            usuario.setCidade(cidade);
	
            usuarioBO.inserir(usuario);
	
            calendario.set(2016, 8, 28, 0, 0, 0);
        
            //Álbum
            Album album = new Album ();
            album.setNome("Desisto, Ronne!");
            album.setData(calendario.getTime());
            album.setUsuario(usuario);
            albumBO.inserir(album);
	
            //Verifica se o álbum está cadastrado no banco de dados;            
            int id = album.getId();
            
            // Seleciona um álbum inserido atráves do id;
            Album albumSelecionado = albumBO.selecionar(id);
            
            // Se o álbum não exitir, exibirá uma mensagem de erro.
            assertNotNull("Album não encontrado", albumSelecionado);
	
            //Exclui o álbum selecionado através do id. 
            albumBO.excluir(id);
            
            // Seleciona o álbum excluido para confirmação de exclusão. 
            Album albumSelecionadoPosExclusao = albumBO.selecionar(id);
	
            /*Caso o álbum possa ser encontrado no banco de dados mesmo após a exclusão,
            será exibida uma mensagem de erro ao excluir.*/
            assertNull("Album não encontrado", albumSelecionadoPosExclusao);
	} catch (Exception ex){
	
        //Caso haja algum erro ao inserir um álbum no banco de dados    
        fail("Falha ao inserir um album: " + ex.getMessage());
        }
    }
}