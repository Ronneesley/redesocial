package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Album;
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
    @Test
    public void testMetodoInserir() {
        AlbumBO bo = new AlbumBO();              		

        Album album = new Album();
		
		album.setNome("Album Viagem");
		
		try {
			bo.inserir(album1);
		} catch (Exception ex) {
			fail("Falha ao inserir um album: " + ex.getMessage());
		}
		
		album.setData("2017-01-01");
		
		try {
			bo.inserir(album1);
		} catch (Exception ex) {
			fail("Falha ao inserir a data no album: " + ex.getMessage());
		}
		
		album.setUsuario("Tom");
		
		try {
			bo.inserir(album1);
		} catch (Exception ex) {
			fail("Falha ao inserir o usuário: " + ex.getMessage());
		}
    }
    @Test
    public void testMetodoListar() {
        AlbumBO bo = new AlbumBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Album album = new Album();
                album.setNome("FERIAS");
                album.setData(new Date());
                album.setUsuario("2");

                try {
                    bo.inserir(album);
                } catch (Exception ex) {
                    fail("Falha ao inserir um álbum: " + ex.getMessage());
                }
            }

            List existentesFinal = bo.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }
    @Test
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
    }
}