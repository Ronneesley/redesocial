package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Postagem;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

      /**
        Postagem postagem2 = new Postagem();
        postagem2.setDescricao("Novo Comentário");
        postagem2.setCurtidas(0);
        postagem1.setData(calendario.getTime());

        try {
            bo.inserir(postagem2);
        } catch (Exception ex) {
            fail("Falha ao inserir um comentário: " + ex.getMessage());
        }
    */
     }
/**
 *@author Warley Rodrigues
 *Criação e inserção de Pais, Estado, Cidade, Usuario e Postagem no banco de dados
 */        
  @Test
    public void testMetodoSelecionar() {
        Pais pais = new Pais();
        pais.setNome("Brasil");
        
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);

            Estado estado = new Estado();
            estado.setNome("Acre");
            estado.setPais(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            Cidade cidade = new Cidade();
            cidade.setNome("Rio Branco");
            cidade.setEstado(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            Usuario usuario = new Usuario();
            usuario.setNome("Warley");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("Acreano@gmail.com");
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
           
            // Usuário, país, estado e cidade foram inseridos no banco de dados
              
            Postagem postagem = new Postagem();
            postagem.setDescricao("Comentário");
            postagem.setCurtidas(0);
            postagem.setUsuario(usuario);
            
            calendario.set(1998, 0, 8, 0, 0, 0);            
            postagem.setData(calendario.getTime());
            
            
            // Os dados do album foram definidos para inserir no banco de dados
             
            
            PostagemBO postagembo = new PostagemBO();
            postagembo.inserir(postagem);
            
            int idpostagem = postagem.getId();
            
            //Seleção no banco de dados
            
            Postagem postagemSelecionada = postagembo.selecionar(idpostagem);
            
            //Mensagem de erro caso não encontre a postagem no banco de dados
             
            assertNotNull("Postagem não encontrada", postagemSelecionada);
        } catch (Exception ex) {
            fail("Postagem não selecionada: " + ex.getMessage());            
        }

    }
    
   @Test
    public void testMetodoListar() {
       PostagemBO bo = new PostagemBO();

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

            
            Postagem postagem1 = new Postagem();
            postagem1.setDescricao("Comentário");
            postagem1.setCurtidas(0);
            postagem1.setUsuario(usuario);

            calendario.set(2017, 7, 16, 21, 58, 0);
            postagem1.setData(calendario.getTime());
        
            bo.inserir(postagem1);
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
     * Método responsável pelo teste da exclusão de uma postagem no banco de dados
     * @author Thalia Santos de Santana
     */
    @Test
    public void testMetodoExcluir() { 
        Pais pais = new Pais();
        pais.setNome("Canadá");
		
        //Criação e inserção de Pais, Estado, Cidade, Usuario e Postagem no banco de dados     
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

			//Verifica se a postagem está cadastrada no banco de dados
            int id = postagem1.getId();
            Postagem postagem1Selecionada = bo.selecionar(id);
            assertNotNull("Postagem não encontrada", postagem1Selecionada);

			//Realiza a exclusão da postagem selecionada
            bo.excluir(id);
            Postagem postagem1SelecionadoPosExclusao = bo.selecionar(id);
			
			//Caso após a exclusão, a postagem ainda possa ser encontrada no banco de dados, apresenta a mensagem de erro
            assertNull("Postagem encontrada, mesmo após excluí-la", postagem1SelecionadoPosExclusao);
        } catch (Exception ex) {
            //Caso não seja possível inserir a postagem no banco de dados apresenta a mensagem de erro
            fail("Falha ao inserir uma postagem: " + ex.getMessage());
        }
    }
 }

