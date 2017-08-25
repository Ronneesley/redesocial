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
        /**
         * Para inserir um album é necessário inserir um usuário, país, estado e cidade no banco de dados
         */  
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
            
            /**
             * Usuário, país, estado e cidade foram inseridos no banco de dados
             */  
            
            AlbumBO bo = new AlbumBO();             		
            Album album = new Album();
            album.setNome("Hollywood");
            calendario.set(2016, 8, 29, 0, 0, 0);
            album.setData(calendario.getTime()); 
            album.setUsuario(usuario);
            /**
             * Os dados do album foram definidos para inserir no banco de dados
             */  
           bo.inserir(album);
        } catch (Exception ex) {
            /**
             * Mensagem de erro caso não insira o album no banco de dados
             */ 
           fail("Falha ao inserir um album: " + ex.getMessage());
        }		
    } 
    
   @Test
    public void testMetodoListar() {
        AlbumBO bo = new AlbumBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 2;
            
            for (int i = 0; i < 2; i++){
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

                Album album = new Album();
                album.setNome("Hollywood");
                album.setData(new Date()); 
                album.setUsuario(usuario);

                try {
                    bo.inserir(album);
                } catch (Exception ex) {
                    fail("Falha ao inserir um álbum: " + ex.getMessage());
                }
            }
            List existentesFinal = bo.listar(); //insere os dados perfeitamente quando chega aqui dá erro e n consigo arrumar
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
   
    @Test
    public void testMetodoSelecionar() {
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
            
            albumbo.selecionar(idalbum);
            
        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());            
        }

    }

    @Test
    public void testMetodoExcluir () throws Exception {
	AlbumBO albumBO = new AlbumBO();
	
    try{
        
	Album album = new Album ();
	album.setNome("Desisto, Ronne!");
	albumBO.inserir(album);
	
	PaisBO paisBO = new PaisBO();
	Pais pais = new Pais();
	pais.setNome("Brasil");
	paisBO.inserir(pais);
	
	EstadoBO estadoBO = new EstadoBO();
	Estado estado = new Estado();
	estado.setNome("Goiás");
	estadoBO.inserir(estado);
	
	CidadeBO cidadeBO =  new CidadeBO();
	Cidade cidade = new Cidade();
	cidade.setNome("Bragolândia");
	cidadeBO.inserir(cidade);
	
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
	album.setData(calendario.getTime());
	album.setUsuario(usuario);
	albumBO.inserir(album);
	
	int id = album.getId();
	Album albumSelecionado = albumBO.selecionar(id);
	assertNotNull("Album não encontrado", albumSelecionado);
	
	albumBO.excluir(id);
	Album albumSelecionadoPosExclusao = albumBO.selecionar(id);
	
	assertNotNull("Album não encontrado", albumSelecionadoPosExclusao);
	} catch (Exception ex){
	fail("Falha ao inserir um album: " + ex.getMessage());
	}
  }
}