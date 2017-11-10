package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Grupo;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o GrupoBO
 * @author Fernando Maciel da Silva, Warley Rodrigues de Andrade, Wesley Morais Félix
 * @since 09/11/2017
 */
public class GrupoBOTest {
    @Test
    public void testMetodoInserir() {
        GrupoBO bo = new GrupoBO();
        //inserção de dados
        Grupo grupo01 = new Grupo();
        
        grupo01.setNome("Watchmen");
        grupo01.setDataCriacao(new Date());
        grupo01.setDescricao("Carcaça de cachorro atropelado encontrada no beco hoje de manhã. Esta cidade tem medo de mim porque conheço sua verdadeira face. As ruas são extensões das sarjetas cheias de sangue. Quando os canos dos esgotos se encherem de sangue todos os vermes morrerão afogados. A sujeira acumulada de sexo e crime envolverá prostitutas e políticos, que voltarão os olhos para cima, implorando... 'salve-nos!'... e eu do alto sussurrarei 'não!'. Tiveram uma escolha. Todos eles. Poderiam ter seguido os passos de homens bons como o meu pai, ou o presidente Truman. Homens decentes que acreditavam em trabalho honesto. Ao invés disso, eles seguiram os libertinos e comunistas, e só perceberam que a trilha levava a um precipício quando já era tarde demais. E não me diga que não tiveram escolha. Agora o mundo inteiro está à beira do precipício, olhando pra baixo no inferno sangrento. Todos aqueles intelectuais e gente de fala mansa... De repente mais ninguém tem nada a dizer. -Rorschach");
        grupo01.setPrivacidade(1);
        grupo01.setTipo("Público");
        
        //validação de inserção
        try {
            bo.inserir(grupo01);
        } catch (Exception ex) {
            fail("Falha ao inserir grupo: " + ex.getMessage());
        }      
    }

    @Test
    public void testMetodoAlterar() {
        GrupoBO bo = new GrupoBO();
        //inserção de dados
        Grupo grupo = new Grupo();
        
        grupo.setNome("DC");
        grupo.setDataCriacao(new Date());
        grupo.setDescricao("Carcaça de cachorro atropelado encontrada no beco hoje de manhã. Esta cidade tem medo de mim porque conheço sua verdadeira face. As ruas são extensões das sarjetas cheias de sangue. Quando os canos dos esgotos se encherem de sangue todos os vermes morrerão afogados. A sujeira acumulada de sexo e crime envolverá prostitutas e políticos, que voltarão os olhos para cima, implorando... 'salve-nos!'... e eu do alto sussurrarei 'não!'. Tiveram uma escolha. Todos eles. Poderiam ter seguido os passos de homens bons como o meu pai, ou o presidente Truman. Homens decentes que acreditavam em trabalho honesto. Ao invés disso, eles seguiram os libertinos e comunistas, e só perceberam que a trilha levava a um precipício quando já era tarde demais. E não me diga que não tiveram escolha. Agora o mundo inteiro está à beira do precipício, olhando pra baixo no inferno sangrento. Todos aqueles intelectuais e gente de fala mansa... De repente mais ninguém tem nada a dizer. -Rorschach");
        grupo.setPrivacidade(1);
        grupo.setTipo("Público");
        //validação de inserção
        try {
            bo.inserir(grupo);
        } catch (Exception ex) {
            fail("Falha ao inserir grupo: " + ex.getMessage());
        }

        //Mudança dos dados
        grupo.setNome("Watchmen");
        grupo.setDataCriacao(new Date());
        grupo.setDescricao("Quanto a mim, de nada me arrependo. Vivi a vida sem concessões... e agora avanço rumo as sombras sem me queixar. -Rorschach");
        grupo.setPrivacidade(2);
        grupo.setTipo("Fechado");
        
        //validação de mudança
        try {
            bo.alterar(grupo);
        } catch (Exception ex) {
            fail("Falha ao alterar grupo: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoSelecionar() {
        GrupoBO bo = new GrupoBO();
        //inserção de dados
        Grupo grupo = new Grupo();
        
        grupo.setNome("Watchmen");
        grupo.setDataCriacao(new Date());
        grupo.setDescricao("Carcaça de cachorro atropelado encontrada no beco hoje de manhã. Esta cidade tem medo de mim porque conheço sua verdadeira face. As ruas são extensões das sarjetas cheias de sangue. Quando os canos dos esgotos se encherem de sangue todos os vermes morrerão afogados. A sujeira acumulada de sexo e crime envolverá prostitutas e políticos, que voltarão os olhos para cima, implorando... 'salve-nos!'... e eu do alto sussurrarei 'não!'. Tiveram uma escolha. Todos eles. Poderiam ter seguido os passos de homens bons como o meu pai, ou o presidente Truman. Homens decentes que acreditavam em trabalho honesto. Ao invés disso, eles seguiram os libertinos e comunistas, e só perceberam que a trilha levava a um precipício quando já era tarde demais. E não me diga que não tiveram escolha. Agora o mundo inteiro está à beira do precipício, olhando pra baixo no inferno sangrento. Todos aqueles intelectuais e gente de fala mansa... De repente mais ninguém tem nada a dizer. -Rorschach");
        grupo.setPrivacidade(1);
        grupo.setTipo("Público");
        //validação de seleção
        try {
            bo.inserir(grupo);

            int id = grupo.getId();

            Grupo grupoSelecionado = bo.selecionar(id);

            assertNotNull("Grupo não encontrado", grupoSelecionado);
        } catch (Exception ex) {
            fail("Falha ao inserir grupo: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoListar() {
        GrupoBO bo = new GrupoBO();
        
        try {
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();
            
            final int qtde = 10;
            for (int i = 0; i < 10; i++){ 
                
                //inserção de dados
                Grupo grupo = new Grupo();                
                grupo.setNome("Watchmen");
                grupo.setDataCriacao(new Date());
                grupo.setDescricao("-A coisa mais poderosa no universo... ainda apenas um fantoche. Espectral II  /n -Todos nós somos fantoches, Laurie. Eu apenas sou um fantoche que consegue ver os fios. Doutor Manhattan");
                grupo.setPrivacidade(2);
                grupo.setTipo("Fechado");

                try {
                    bo.inserir(grupo);
                } catch (Exception ex) {
                    fail("Falha ao inserir grupo: " + ex.getMessage());
                }
            }
            
            //validação de listagem
            List existentesFinal = bo.listar();
            int qtdeExistentesFinal = existentesFinal.size();

            int diferenca = qtdeExistentesFinal - qtdeExistentes;

            assertEquals(qtde, diferenca);
        //erro ao listar
        } catch (Exception ex){
            fail("Erro ao listar: " + ex.getMessage());
        }
    }

    @Test
    public void testMetodoExcluir() {
        
        GrupoBO bo = new GrupoBO();
        Grupo grupo = new Grupo();
        
        grupo.setNome("Watchmen");
        grupo.setDataCriacao(new Date());
        grupo.setDescricao("Estou olhando as estrelas. Elas estão tão longe, e a sua luz demora tanto tempo a chegar até nós. Tudo o que vemos das estrelas são suas velhas fotografias. -Doutor Manhattan");
        grupo.setPrivacidade(2);
        grupo.setTipo("Fechado");
        //validação de exclusão
        try {
            bo.inserir(grupo);

            int id = grupo.getId();
            Grupo grupoSelecionado = bo.selecionar(id);
            assertNotNull("Grupo não encontrado", grupoSelecionado);

            bo.excluir(id);
            Grupo grupoSelecionadoPosExclusao = bo.selecionar(id);

            assertNull("Grupo encontrado, mesmo após excluí-lo", grupoSelecionadoPosExclusao);
        } catch (Exception ex) {
            fail("Falha ao inserir grupo: " + ex.getMessage());
        }
    }
}