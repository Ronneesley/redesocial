package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Album;
import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Multimidia;
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
 * Unidade de testes para o MultímidiaBO
 *
 * @author Lucas Azevedo, Macilon Arruda
 * @since 16/08/2017
 */
public class MultimidiaBOTeste {

    /**
     * Método de teste responsável pela inserção de multímidia no banco de dados
     *
     * @author Lucas Azevedo
     */
    @Test
    public void testMetodoInserir() {
        /**
         * Para inserir um multímidia é necessário inserir um usuário, país,
         * estado e cidade, usuário e album no banco de dados
         */
        Pais pais = new Pais();
        pais.setNome("EUA");

        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            br.com.redesocial.modelo.dto.Estado estado = new br.com.redesocial.modelo.dto.Estado();
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
            album.setNome("California");
            calendario.set(2016, 8, 29, 0, 0, 0);
            album.setData(calendario.getTime());
            album.setUsuario(usuario);
            bo.inserir(album);

            AlbumBO albumBO = new AlbumBO();
            albumBO.inserir(album);

            MultimidiaBO mult = new MultimidiaBO();
            Multimidia multimidia = new Multimidia();
            multimidia.setAlbum(album);
            multimidia.setMidia(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
            multimidia.setTipoConteudo("foto");
            calendario.set(2017, 8, 20, 8, 0, 0);
            multimidia.setData(calendario.getTime());
            mult.inserir(multimidia);
        } catch (Exception ex) {

            /**
             * Mensagem de erro caso não insira uma multímida no banco de dados
             */
            fail("Falha ao inserir uma multimidia: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoListar() throws Exception {
        Pais pais = new Pais();
        pais.setNome("Dinamarca");

        MultimidiaBO bo = new MultimidiaBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            Estado estado = new Estado();
            estado.setNome("Para");
            estado.setPais(pais);

            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            Cidade cidade = new Cidade();
            cidade.setNome("Crixas");
            cidade.setEstado(estado);

            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            Usuario usuario = new Usuario();
            usuario.setNome("Zezim");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("Ze@gmail.com");
            Calendar calendario = Calendar.getInstance();
            calendario.set(1988, 2, 7, 0, 0, 0);
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("7070");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 6060-7070");
            usuario.setCidade(cidade);

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            Album album = new Album();
            album.setNome("Album1");
            album.setData(calendario.getTime());
            album.setUsuario(usuario);

            AlbumBO albumbo = new AlbumBO();
            albumbo.inserir(album);

            final int qtde = 10;
            for (int i = 0; i < 10; i++) {
                Multimidia multimidia = new Multimidia();
                multimidia.setMidia(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
                multimidia.setData(calendario.getTime());
                multimidia.setTipoConteudo("foto");
                multimidia.setAlbum(album);

                try {
                    bo.inserir(multimidia);
                } catch (Exception ex) {
                    fail("Falha ao listar uma multimidia: " + ex.getMessage());
                }
            }

            List existentesFinal = bo.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex) {
            fail("Falha ao listar uma multimidia: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoSelecionar() {
        Pais pais = new Pais();
        pais.setNome("Irlanda");

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
            usuario.setNome("Andrey");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("andrey@gmail.com");
            Calendar calendario = Calendar.getInstance();
            calendario.set(1988, 2, 7, 0, 0, 0);
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("123");
            usuario.setSexo(Sexo.MASCULINO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 8888-8888");
            usuario.setCidade(cidade);

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            Album album = new Album();
            album.setNome("Album1");
            album.setData(calendario.getTime());
            album.setUsuario(usuario);

            AlbumBO albumbo = new AlbumBO();
            albumbo.inserir(album);

            MultimidiaBO mult = new MultimidiaBO();
            Multimidia multimidia = new Multimidia();

            multimidia.setMidia(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
            multimidia.setTipoConteudo("foto");
            calendario.set(2017, 8, 20, 8, 0, 0);
            multimidia.setData(calendario.getTime());
            multimidia.setAlbum(album);

            mult.inserir(multimidia);

            int id = multimidia.getId();

            Multimidia multimidiaSelecionada = mult.selecionar(id);

            assertNotNull("Multimídia não encontrada", multimidiaSelecionada);

        } catch (Exception ex) {
            fail("Falha ao selecionar uma Multimídia: " + ex.getMessage());
        }
    }

    @Test
    public void testeExcluir() throws Exception {
        Calendar calendario = Calendar.getInstance();
        calendario.set(2017, 2, 7, 0, 0, 0);

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
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("123");
        usuario.setSexo(Sexo.MASCULINO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 91234-4567");
        usuario.setCidade(cidade);

        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.inserir(usuario);

        Album album = new Album();
        album.setNome("Lara");
        album.setData(calendario.getTime());
        album.setUsuario(usuario);

        AlbumBO albumBO = new AlbumBO();
        albumBO.inserir(album);

        MultimidiaBO bo = new MultimidiaBO();

        Multimidia multimidia = new Multimidia();
        multimidia.setMidia(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        multimidia.setTipoConteudo("foto");
        multimidia.setData(calendario.getTime());
        multimidia.setAlbum(album);

        try {
            bo.inserir(multimidia);

            int id = multimidia.getId();
            Multimidia multimidiaSelecionado = bo.selecionar(id);
            assertNotNull("Foto não encontrada!", multimidiaSelecionado);

            bo.excluir(id);
            Multimidia multimidiaSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Foto não encontrada, mesmo após excluí-lá", multimidiaSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao adicionar uma foto " + ex.getMessage());
        }

    }

    @Test
    public void testMetodoAlterar() throws Exception {

        /*MultimidiaBO bo = new MultimidiaBO();

        MultimidiaBO multimidiaBO = new MultimidiaBO();

        Pais pais = new Pais();
        pais.setNome("Brasil");

        PaisBO paisBO = new PaisBO();
        paisBO.inserir(pais);

        br.com.redesocial.modelo.dto.Estado estado = new br.com.redesocial.modelo.dto.Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);

        EstadoBO estadoBO = new EstadoBO();
        estadoBO.inserir(estado);

        Cidade cidade = new Cidade();
        cidade.setNome("Itapaci");
        cidade.setEstado(estado);

        CidadeBO cidadeBO = new CidadeBO();
        cidadeBO.inserir(cidade);

        Usuario usuario = new Usuario();
        usuario.setNome("Maciele");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("maciele@gmail.com");
        //usuario.setFoto();

        Calendar calendario = Calendar.getInstance();
        calendario.set(1988, 2, 7, 0, 0, 0);
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("111");
        usuario.setSexo(Sexo.FEMININO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 94321-9874");
        usuario.setCidade(cidade);

        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.inserir(usuario);

        AlbumBO albumbo = new AlbumBO();
        Album album = new Album();
        album.setNome("California");
        calendario.set(2016, 8, 29, 0, 0, 0);
        album.setData(calendario.getTime());
        album.setUsuario(usuario);
        albumbo.inserir(album);

        AlbumBO albumBO = new AlbumBO();
        albumBO.inserir(album);

        MultimidiaBO mult = new MultimidiaBO();
        Multimidia multimidia = new Multimidia();
        multimidia.setAlbum(album);
        multimidia.setMidia(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        multimidia.setTipoConteudo("foto");
        calendario.set(2017, 8, 20, 8, 0, 0);
        multimidia.setData(calendario.getTime());
        mult.inserir(multimidia);

        try {
            bo.inserir(multimidia);
        } catch (Exception ex) {
            fail("Falha ao inserir uma multimidia: " + ex.getMessage());
        }

        //Mudança dos dados
        multimidia.setAlbum(album);
        multimidia.setMidia(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        multimidia.setTipoConteudo("foto");
        calendario.set(2017, 8, 20, 8, 0, 0);
        multimidia.setData(calendario.getTime());
        mult.inserir(multimidia);

        try {
            bo.alterar(multimidia);
        } catch (Exception ex) {
            fail("Falha ao alterar uma multimidia: " + ex.getMessage());
        }*/
    }
}
