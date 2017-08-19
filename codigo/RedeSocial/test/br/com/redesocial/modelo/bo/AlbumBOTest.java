package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Album;
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

/**
 * Unidade de testes para o AlbumBO
 * @author Ronneesley Moura Teles
 * @since 16/08/2017
 */
public class AlbumBOTest {
/*    @Test
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
            usuario.setNascimento(calendario.getTime());
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
    }*/
    
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
/*    @Test
    public void testMetodoSelecionar() {
        AlbumBO bo = new AlbumBO();

        Album album = new Album();
        album.setId(1);

        try {
            bo.inserir(album);

            int id = album.getId();

            Album albumSelecionado = bo.selecionar(id);

            assertNotNull("Album não encontrado", albumSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir um Album: " + ex.getMessage());
        }
    }*/
}