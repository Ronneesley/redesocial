package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dto.Artigo;
import br.com.redesocial.modelo.utilitarios.Utilitarios;
import java.io.File;
import java.util.List;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;

/**
 * Unidade de testes para o ArtigoBO
 * @author Andrey Silva Ribeiro
 * @since 15/09/2017
*/
public class ArtigoBOTest {
    @Test     
    public void testMetodoInserir() throws Exception {
        ArtigoBO bo = new ArtigoBO();

        Artigo artigo1 = new Artigo();
        artigo1.setIdioma("Portugues");       
        artigo1.setRevista("SBIS");
        artigo1.setISSN("33333333");
        artigo1.setAutor("Ciencias da terra"); 
        Calendar calendario = Calendar.getInstance();
        calendario.set(1988, 2, 7, 0, 0, 0);            
        artigo1.setData(calendario.getTime());
        artigo1.setAreaConhecimento("Ciencias da terra");
        artigo1.setTitulo("Título teste 1");
        artigo1.setResumo("Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo1.setURL("www.artigo.com.br");
        artigo1.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        
        try {
            bo.inserir(artigo1);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }

    }
     
    //@Test
    public void testMetodoAlterar() throws Exception {
        ArtigoBO bo = new ArtigoBO();
        
        Artigo artigo = new Artigo();
        
        artigo.setIdioma("Ingles");       
        artigo.setRevista("RC");
        artigo.setISSN("1234");
        artigo.setAutor("João"); 
        Calendar calendario = Calendar.getInstance();
        calendario.set(1988, 2, 7, 0, 0, 0);            
        artigo.setData(calendario.getTime());
        artigo.setAreaConhecimento("Ciencias da Terra");
        artigo.setTitulo("Qualquer Coisa");
        artigo.setResumo("Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo.setURL("www.artigo.com.br");
        artigo.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        
        try {
            bo.inserir(artigo);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }

        //Mudança dos dados
        artigo.setIdioma("Portugues");       
        artigo.setRevista("RC");
        artigo.setISSN("1234");
        artigo.setAutor("João");           
        artigo.setData(calendario.getTime());
        artigo.setAreaConhecimento("Ciencias da Terra");
        artigo.setTitulo("Qualquer Coisa");
        artigo.setResumo("Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo.setURL("www.artigo.com.br");
        artigo.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
        
        try {
            bo.alterar(artigo);
        } catch (Exception ex) {
            fail("Falha ao inserir um artigo: " + ex.getMessage());
        }
    }
    
    @Test
    public void testMetodoSelecionar() throws Exception{
        
        ArtigoBO bo = new ArtigoBO();

        try{
            List existentes = bo.listar();
            int qtdeExistentes = existentes.size();
            
            Artigo artigo2 = new Artigo();
        artigo2.setIdioma("Ingles");       
        artigo2.setRevista("SBIS");
        artigo2.setISSN("33333333");
        artigo2.setAutor("Ciencias da terra"); 
        Calendar calendario = Calendar.getInstance();
        calendario.set(1988, 2, 7, 0, 0, 0);            
        artigo2.setData(calendario.getTime());
        artigo2.setAreaConhecimento("Ciencias da terra");
        artigo2.setTitulo("Título teste 1");
        artigo2.setResumo("Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de texto em publicações (jornais, revistas, e websites), com a finalidade de verificar o lay-out, tipografia e formatação antes de utilizar conteúdo real. Muitas vezes este texto também é utilizado em catálogos de tipografia para demonstrar textos e títulos escritos com as fontes.");
        artigo2.setURL("www.artigo.com.br");
        artigo2.setArtigo(Utilitarios.lerArquivo(new File("../../arquivos_teste/nome_arquivo.txt")));
      
        
        try{
                /**
                 * Inserindo comentário no banco de dados
                 */
                bo.inserir(artigo2);
            }catch(Exception ex){
                /**
                 * Mensagem de erro caso falhe
                 */
                fail("Falha ao inserir um artigo: " + ex.getMessage());
            }

        }catch (Exception ex){
            /**
             * Erro caso a listagem falhe
             */
            fail("Erro ao listar: " + ex.getMessage());
        }
        

    }
}
