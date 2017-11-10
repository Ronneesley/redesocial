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
 * Unidade de testes para o ParticipanteBO
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */
public class ParticipanteBOTest {
    
    @Test
    public void testMetodoInserir() {
        ParticipanteBO participanteBO = new ParticipanteBO();
        //inserção de dados
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
        
        GrupoBO grupoBO = new GrupoBO();
        PaisBO paisBO = new PaisBO();
        EstadoBO estadoBO = new EstadoBO();
        CidadeBO cidadeBO = new CidadeBO();
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Participante participante = new Participante();
        participante.setGrupo(grupo);
        participante.setUsuario(usuario);
        participante.setCargo(1);
        
        //validação de inserção
        try {
            
            grupoBO.inserir(grupo);
            
            paisBO.inserir(pais);
            
            estadoBO.inserir(estado);
            
            cidadeBO.inserir(cidade);
            
            usuarioBO.inserir(usuario);          

            participanteBO.inserir(participante);

        } catch (Exception ex) {
            fail("Falha ao inserir participante: " + ex.getMessage());
        }        
    }

    @Test
    public void testMetodoAlterar() {
        ParticipanteBO participanteBO = new ParticipanteBO();
        //inserção de dados
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
        
        GrupoBO grupoBO = new GrupoBO();
        PaisBO paisBO = new PaisBO();
        EstadoBO estadoBO = new EstadoBO();
        CidadeBO cidadeBO = new CidadeBO();
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Participante participante = new Participante();
        participante.setGrupo(grupo);
        participante.setUsuario(usuario);
        participante.setCargo(1);
        
        //validação de inserção
        try {
            
            grupoBO.inserir(grupo);
            
            paisBO.inserir(pais);
            
            estadoBO.inserir(estado);
            
            cidadeBO.inserir(cidade);
            
            usuarioBO.inserir(usuario);          

            participanteBO.inserir(participante);

        } catch (Exception ex) {
            fail("Falha ao inserir participante: " + ex.getMessage());
        }
        
        //Mudança dos dados
        grupo.setNome("Watchmen");
        grupo.setDataCriacao(new Date());
        grupo.setDescricao("Quanto a mim, de nada me arrependo. Vivi a vida sem concessões... e agora avanço rumo as sombras sem me queixar. -Rorschach");
        grupo.setPrivacidade(2);
        grupo.setTipo("Fechado");
        try {
            grupoBO.alterar(grupo);
        } catch (Exception ex) {
            fail("Falha ao alterar grupo: " + ex.getMessage());
        }        
        
        pais.setNome("Argentina");
        try {
            paisBO.alterar(pais);
        } catch (Exception ex) {
            fail("Falha ao inserir um país: " + ex.getMessage());
        }        
        
        estado.setNome("Tocantins");
        try {            
            estadoBO.alterar(estado);
        } catch (Exception ex) {            
            fail("Falha ao alterar estado: " + ex.getMessage());
        }       
        
        cidade.setNome("Rialma");
        try {            
            cidadeBO.alterar(cidade);
        } catch (Exception ex) {
            fail("Falha ao inserir a cidade: " + ex.getMessage());
        }
        
        usuario.setNome("Comentario(Referências)"); 
        
        try {
            usuarioBO.alterar(usuario);
        } catch (Exception ex) {                              
            fail("Falha ao alterar usuario: " + ex.getMessage());
        }
        
        participante.setGrupo(grupo);
        participante.setUsuario(usuario);
        participante.setCargo(2);
        
        //validação de mudança
        try{
            participanteBO.alterar(participante);
        }catch(Exception ex){
            fail("Falha ao alterar participante:" + ex.getMessage());
        }
    }

    @Test
    public void testMetodoSelecionar() {
        ParticipanteBO participanteBO = new ParticipanteBO();
        //inserção de dados
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
        
        GrupoBO grupoBO = new GrupoBO();
        PaisBO paisBO = new PaisBO();
        EstadoBO estadoBO = new EstadoBO();
        CidadeBO cidadeBO = new CidadeBO();
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Participante participante = new Participante();
        participante.setGrupo(grupo);
        participante.setUsuario(usuario);
        participante.setCargo(1);
        
        //validação de seleção
        try {
            
            grupoBO.inserir(grupo);
            
            paisBO.inserir(pais);
            
            estadoBO.inserir(estado);
            
            cidadeBO.inserir(cidade);
            
            usuarioBO.inserir(usuario);          

            participanteBO.inserir(participante);

            int cargo = participante.getCargo();

            Participante participanteSelecionado = participanteBO.selecionar(cargo);

            assertNotNull("Participante não encontrado", participanteSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir um participante: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoListar() {
        ParticipanteBO participanteBO = new ParticipanteBO();
        
        //inserção de dados
        try {
            List existentes = participanteBO.listar();
            int qtdeExistentes = existentes.size();

            final int qtde = 2;
            for (int i = 0; i < 2; i++){
                //inserção de dados
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
        
                GrupoBO grupoBO = new GrupoBO();
                PaisBO paisBO = new PaisBO();
                EstadoBO estadoBO = new EstadoBO();
                CidadeBO cidadeBO = new CidadeBO();
                UsuarioBO usuarioBO = new UsuarioBO();
        
                Participante participante = new Participante();
                participante.setGrupo(grupo);
                participante.setUsuario(usuario);
                participante.setCargo(1);
        
                try {
            
                    grupoBO.inserir(grupo);
            
                    paisBO.inserir(pais);
            
                    estadoBO.inserir(estado);
            
                    cidadeBO.inserir(cidade);
            
                    usuarioBO.inserir(usuario);          

                    participanteBO.inserir(participante);

                } catch (Exception ex) {
                    fail("Falha ao inserir participante: " + ex.getMessage());
                }
            }
            
            //validação de listagem
            List existentesFinal = participanteBO.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
            
        //erro ao listar    
        } catch (Exception ex){
            fail("Erro ao listar participantes: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoExcluir() {
        ParticipanteBO participanteBO = new ParticipanteBO();
        
        //inserção de dados
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
        
        GrupoBO grupoBO = new GrupoBO();
        PaisBO paisBO = new PaisBO();
        EstadoBO estadoBO = new EstadoBO();
        CidadeBO cidadeBO = new CidadeBO();
        UsuarioBO usuarioBO = new UsuarioBO();
        
        Participante participante = new Participante();
        participante.setGrupo(grupo);
        participante.setUsuario(usuario);
        participante.setCargo(1);
        
        //validação de exclusão
        try {
            
            grupoBO.inserir(grupo);
            
            paisBO.inserir(pais);
            
            estadoBO.inserir(estado);
            
            cidadeBO.inserir(cidade);
            
            usuarioBO.inserir(usuario);          

            participanteBO.inserir(participante);

            int cargo = participante.getCargo();

            Participante participanteSelecionado = participanteBO.selecionar(cargo);

            assertNotNull("Participante não encontrado", participanteSelecionado);

            participanteBO.excluir(cargo);
            Participante participanteSelecionadoPosExclusao = participanteBO.selecionar(cargo);

            assertNull("Participante encontrado, mesmo após excluí-lo", participanteSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir um participante: " + ex.getMessage());
        }
    }
}