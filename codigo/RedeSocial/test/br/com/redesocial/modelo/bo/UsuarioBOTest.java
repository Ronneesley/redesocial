package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
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
 * Unidade de testes para o UsuarioBO
 * @author Igor Justino Rodrigues, Gusttavo Nunes, Willian Wallace e Lara Caroline
 * @since 19/08/2017
 */
public class UsuarioBOTest {

    @Test
    public void testMetodoInserir() {        
        UsuarioBO usuariobo = new UsuarioBO();
        
        Pais pais = new Pais();
        pais.setNome("Brasil");
        try{
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
            
            usuariobo.inserir(usuario);
        }catch (Exception ex) {
            ex.printStackTrace();
            fail("Falha ao inserir um usuario: " + ex.getMessage());            
        }
    }
    
    /**
     * Método de teste responsável por listar os usuarios no banco de dados
     * @author Igor Justino Rodrigues
     */
    @Test
    public void testMetodoListar() {

        //Criação e Inserção de Usuario no banco de dados
        UsuarioBO usuariobo = new UsuarioBO();

        try {
            List existentes = usuariobo.listar();
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
                usuario.setNome("Igor");
                usuario.setDataCadastro(new Date());
                usuario.setEmail("Igor@gmail.com");

                Calendar calendario = Calendar.getInstance();
                calendario.set(1998, 0, 8, 0, 0, 0);            
                usuario.setDataNascimento(calendario.getTime());
                usuario.setSenha("123");
                usuario.setSexo(Sexo.MASCULINO);
                usuario.setStatus(true);
                usuario.setTelefone("(62) 99654-0873");
                usuario.setCidade(cidade);

                
                try {
                    usuariobo.inserir(usuario);
                } catch (Exception ex) {
                    fail("Falha ao inserir um álbum: " + ex.getMessage());
                }
            }
            //Lista os usuarios
            
            List existentesFinal = usuariobo.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        } catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    
    }
   
    @Test
    public void testMetodoSelecionar() {
    
    }    
    /**
     * Método de teste responsável pela alteração de dados de um usuário no banco de dados
     * @author Gusttavo Nunes Gomes
     */    
    @Test
    public void testMetodoAlterar() {
    //Para inserir um usuário, é necessário inserir um país, um estado e cidade no banco de dados              
        
        Pais pais = new Pais();
        pais.setNome("USA");
            
        Estado estado = new Estado();
        estado.setNome("California");
        estado.setPais(pais);
        
        Cidade cidade = new Cidade();
        cidade.setNome("Los Angeles");
        cidade.setEstado(estado);
        
        //O nome do país,estado e cidade a ser inseridos no banco de dados, foram definidos
                
        UsuarioBO bo = new UsuarioBO();  
        
        Usuario usuario = new Usuario();
        usuario.setNome("GusTavo");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("gus22ng@gmail.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1996, 8, 29, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("123");
        usuario.setSexo(Sexo.MASCULINO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 98765-4321");
        usuario.setCidade(cidade);
        
        //O dados do usuário foram definidos para inserir no banco de dados
                 
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            //O pais foi inserido no banco de dados 
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            // O pais foi inserido no banco de dados
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            // O pais foi inserido no banco de dados
            
            bo.inserir(usuario);
            } catch (Exception ex) {
                // Mensagem de erro caso não insira o usuario no banco de dados                 
                fail("Falha ao inserir um usuario: " + ex.getMessage());
            }           
            
            usuario.setNome("Gusttavo"); 
            // Uma alteração no usuario é feita e deve ser feita essa mudança no banco de dados            
            try {
                bo.alterar(usuario);
            } catch (Exception ex) {
                //Mensagem de erro caso não altere o usuario no banco de dados                  
                fail("Falha ao alterar usuario: " + ex.getMessage());
            }
    }
    /**
     * Método responsável pelo teste da exclusão de um Usuário no banco de dados
     * @author Lara Caroline
     */
    @Test
    public void testMetodoExcluir() throws Exception{
        /*
        Para excluir um usuário o mesmo deve estar inserido.
        Ao inserir um usuário, é necessário inserir cidade, estado e país.
         */
        Pais pais = new Pais();
        pais.setNome("Brasil");
            
        Estado estado = new Estado();
        estado.setNome("Goiás");
        estado.setPais(pais);
        
        Cidade cidade = new Cidade();
        cidade.setNome("Anapolis");
        cidade.setEstado(estado);
        
        Usuario usuario = new Usuario();
        usuario.setNome("Lorraine");
        usuario.setDataCadastro(new Date());
        usuario.setEmail("lorraine21@gmail.com");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1998, 10, 12, 0, 0, 0);            
        usuario.setDataNascimento(calendario.getTime());
        usuario.setSenha("pato90");
        usuario.setSexo(Sexo.MASCULINO);
        usuario.setStatus(true);
        usuario.setTelefone("(62) 99999-8765");
        usuario.setCidade(cidade);
        
        UsuarioBO bo = new UsuarioBO(); 
        
        try {
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);
        
            bo.inserir(usuario);

            int id = usuario.getId();
            //Seleciona o usuário inserido através do id.
            Usuario usuarioSelecionado = bo.selecionar(id);
            //Se não houver usuário exibe a mensagem de falha.
            assertNotNull("Usuário não encontrado!", usuarioSelecionado);
            
            //Exclui o usuário selecionado através do id.
            bo.excluir(id);
            //Seleciona o usuario excluído para saber se o mesmo foi excluído.
            Usuario usurarioSelecionadoPosExclusao = bo.selecionar(id);
            //Se não foi excluído, exibe a mensagem seguinte:
            assertNull("Usuário encontrado, mesmo após exclusão.", usurarioSelecionadoPosExclusao);
        } catch (Exception ex) {
            //Mensagem exibida quando o usuário não é inserido.
            fail("Falha ao inserir um usuário: " + ex.getMessage());
        }
    }
}