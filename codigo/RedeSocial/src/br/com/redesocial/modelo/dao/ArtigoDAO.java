package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Artigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import java.sql.Statement;

/**
 *
 * @author Gusttavo Nunes
 */
public class ArtigoDAO {
    @Override
    public void inserir(){
        
    }
    @Override
    public void selecionar(){
        
    }
    @Override
    public void excluir(){
        
    }
    /**
     * Método que lista todos os artigos em ordem descrecem por data do banco de dados
     * @author Gusttavo Nunes Gomes
     * @return lista os artigos em ordem descrescente por data
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from artigos order by data desc");
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        while (rs.next()){
            
            Artigo a = new Artigo();
            a.setId(rs.getInt("id"));
            a.setIdioma(rs.getString("idioma"));
            a.setRevista(rs.getString("revista"));
            a.setISSN(rs.getString("issn"));
            a.setAutor(rs.getString("autor"));
            a.setData(rs.getDate("data"));
            a.setAreaConhecimento(rs.getString("areaConhecimento"));
            a.setTitulo(rs.getString("titulo"));
            a.setResumo(rs.getString("resumo"));
            a.setURL(rs.getString("URL"));
            a.setArtigo(rs.getBytes("artigo"));    
            lista.add(a);
        }
        
        return lista;
        
    }
    @Override
    public void alterar(){
        
    }
}
