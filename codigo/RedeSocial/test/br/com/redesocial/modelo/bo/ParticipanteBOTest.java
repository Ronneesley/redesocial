package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Estado;
import br.com.redesocial.modelo.dto.Pais;
import br.com.redesocial.modelo.dto.Cidade;
import br.com.redesocial.modelo.dto.Grupo;
import br.com.redesocial.modelo.dto.Participante;
import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o PaisBO
 * @author Ronneesley Moura Teles
 * @since 09/08/2017
 */
public class ParticipanteBOTest {
    
    @Test
    public void testMetodoInserir() {
        ParticipanteBO participanteBO = new ParticipanteBO();
        
        try {
            
            Grupo grupo = new Grupo();        
            grupo.setNome("Watchmen");
            grupo.setDataCriacao(new Date());
            grupo.setDescricao("O mundo desgovernado não é moldado por forças metafísicas. Não é Deus que mata as crianças, não é o acaso que as trucida, nem é o destino que as dá de comer aos cães. Somos nós. Só nós. -Rorschach");
            grupo.setPrivacidade(2);
            grupo.setTipo("Fechado");
            
            Pais pais = new Pais();
            pais.setNome("Brasil");

            Estado estado = new Estado();
            estado.setNome("Goiás");
            estado.setPais(pais);

            Cidade cidade = new Cidade();
            cidade.setNome("Ceres");
            cidade.setEstado(estado);

            Usuario usuario = new Usuario();
            usuario.setNome("Usuario de Teste");
            usuario.setDataCadastro(new Date());
            usuario.setEmail("usuario@teste.com");
            Calendar calendario = Calendar.getInstance();
            calendario.set(1999, 5, 16, 0, 0, 0);            
            usuario.setDataNascimento(calendario.getTime());
            usuario.setSenha("456");
            usuario.setSexo(Sexo.FEMININO);
            usuario.setStatus(true);
            usuario.setTelefone("(62) 91234-4567");
            usuario.setCidade(cidade);      
        
            Participante participante = new Participante(); 
        
        
            
            GrupoBO grupoBO = new GrupoBO();
            grupoBO.inserir(grupo);
            
            PaisBO paisBO = new PaisBO();
            paisBO.inserir(pais);
            
            EstadoBO estadoBO = new EstadoBO();
            estadoBO.inserir(estado);
            
            CidadeBO cidadeBO = new CidadeBO();
            cidadeBO.inserir(cidade);
            
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.inserir(usuario);                      
            
            participante.setGrupo(grupo);
            participante.setUsuario(usuario);
            participante.setCargo(1);
            
            participanteBO.inserir(participante);
            
        } catch (Exception ex) {
            fail("Falha ao inserir participante: " + ex.getMessage());
        }        
    }

    /*@Test
    public void testMetodoAlterar() {
        PaisBO bo = new PaisBO();

        Pais pais = new Pais();
        pais.setNome("Argentinaaaaa");

        try {
            bo.inserir(pais);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }

        //Mudança dos dados
        pais.setNome("Argentina");

        try {
            bo.alterar(pais);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoSelecionar() {
        PaisBO bo = new PaisBO();

        Pais pais = new Pais();
        pais.setNome("Canadá");

        try {
            bo.inserir(pais);

            int id = pais.getId();

            Pais paisSelecionado = bo.selecionar(id);

            assertNotNull("Pais não encontrado", paisSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }*/

    /*@Test
    public void testMetodoListar() {
        ParticipanteBO bo = new ParticipanteBO();

        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 10;
            for (int i = 0; i < 10; i++){
                Participante participante = new Participante();
                
                participante.setCargo(1);

                try {
                    bo.inserir(participante);
                } catch (Exception ex) {
                    fail("Falha ao inserir um país: " + ex.getMessage());
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

    /*@Test
    public void testMetodoExcluir() {
        PaisBO bo = new PaisBO();

        Pais pais = new Pais();
        pais.setNome("Japão");

        try {
            bo.inserir(pais);

            int id = pais.getId();
            Pais paisSelecionado = bo.selecionar(id);
            assertNotNull("Pais não encontrado", paisSelecionado);

            bo.excluir(id);
            Pais paisSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Pais encontrado, mesmo após excluí-lo", paisSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }
    }*/
}