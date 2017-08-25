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
            
            AlbumBO bo = new AlbumBO();             		
            Album album = new Album();
            album.setNome("Hollywood");
            calendario.set(2016, 8, 29, 0, 0, 0);
            album.setData(calendario.getTime()); 
            album.setUsuario(usuario);
            bo.inserir(album);
        } catch (Exception ex) {
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
    public void testMetodoExcluir() throws Exception{
        AlbumBO bo = new AlbumBO();  
        
        Album album = new Album();
        album.setNome("Hollywood");    
       
       try {
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
                        		
            calendario.set(2016, 8, 29, 0, 0, 0);
            album.setData(calendario.getTime()); 
            album.setUsuario(usuario);
            bo.inserir(album);
           
            int id = album.getId();
            Album albumSelecionado = bo.selecionar(id);
            assertNotNull("Album não encontrada", albumSelecionado);
           
            bo.excluir(id);
            Album albumSelecionadoPosExclusao = bo.selecionar(id);
           
            assertNotNull("Album não encontrado", albumSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um Album: " + ex.getMessage());
        }
    }
   
}