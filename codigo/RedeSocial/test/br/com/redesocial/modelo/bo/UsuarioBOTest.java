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
 * @author Igor Justino Rodrigues, Gusttavo Nunes, Willian Wallace
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
    
    @Test
    public void testMetodoListar() {
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
            List existentesFinal = usuariobo.listar(); //insere os dados perfeitamente quando chega aqui dá erro e n consigo arrumar
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

    @Test
    public void testMetodoAlterar() {
             
        
        Pais pais = new Pais();
        pais.setNome("USA");
            
        Estado estado = new Estado();
        estado.setNome("California");
        estado.setPais(pais);
        
        Cidade cidade = new Cidade();
        cidade.setNome("Los Angeles");
        cidade.setEstado(estado);
        
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
        
        try{
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);

            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);

            bo.inserir(usuario);
            } catch (Exception ex) {
                fail("Falha ao inserir um usuario: " + ex.getMessage());
            }           
            
            usuario.setNome("Gusttavo");            
            
            try {
                bo.alterar(usuario);//Falhou: ao alterar usuario: null
            } catch (Exception ex) {
                fail("Falha ao alterar usuario: " + ex.getMessage());
            }
    }
    
    @Test
    public void testMetodoExcluir() throws Exception{
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
            Usuario usuarioSelecionado = bo.selecionar(id);
            assertNotNull("Usuário não encontrado!", usuarioSelecionado);

            bo.excluir(id);
            Usuario usurarioSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Usuário encontrado, mesmo após exclusão.", usurarioSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um usuário: " + ex.getMessage());
        }
    }
}