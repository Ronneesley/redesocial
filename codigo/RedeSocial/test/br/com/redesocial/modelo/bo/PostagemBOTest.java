package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulo Henrique
 */
public class PostagemBOTest {
    
   
    @Test
    public void testMetodoInserir() {
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

            PostagemBO bo = new PostagemBO();

            Postagem postagem1 = new Postagem();
            postagem1.setDescricao("Comentário");
            postagem1.setCurtidas(0);
            postagem1.setUsuario(usuario);

            calendario.set(2017, 7, 16, 21, 58, 0);
            postagem1.setData(calendario.getTime());
        
            bo.inserir(postagem1);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Falha ao inserir um comentário: " + ex.getMessage());            
        }

        /*Postagem postagem2 = new Postagem();
        postagem2.setDescricao("Novo Comentário");
        postagem2.setCurtidas(0);
        postagem1.setData(calendario.getTime());

        try {
            bo.inserir(postagem2);
        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());
        }*/
        
    }
    
    @Test
    public void testMetodoExcluir() {
        Pais pais = new Pais();
        pais.setNome("Canadá");
        
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            Estado estado = new Estado();
            estado.setNome("Rondônia");
            estado.setPais(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            Cidade cidade = new Cidade();
            cidade.setNome("Rubiataba");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            usuario.setNome("Thalia");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("thalia@gmail.com");
            //usuario.setFoto();
           
            Calendar calendario = Calendar.getInstance();
            calendario.set(1998, 2, 15, 0, 0, 0);            
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("123456");
            usuario.setSexo(Sexo.FEMININO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 91222-4444");
            usuario.setCidade(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);

            PostagemBO bo = new PostagemBO();

            Postagem postagem1 = new Postagem();
            postagem1.setDescricao("Comentário");
            postagem1.setCurtidas(0);
            postagem1.setUsuario(usuario);

            calendario.set(2017, 7, 16, 21, 58, 0);
            postagem1.setData(calendario.getTime());
        
            bo.inserir(postagem1);

            int id = postagem1.getId();
            Postagem postagem1Selecionada = bo.selecionar(id);
            assertNotNull("Postagem não encontrada", postagem1Selecionada);

            bo.excluir(id);
            Postagem postagem1SelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Postagem encontrada, mesmo após excluí-la", postagem1SelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir uma postagem: " + ex.getMessage());
        }
    }
}
