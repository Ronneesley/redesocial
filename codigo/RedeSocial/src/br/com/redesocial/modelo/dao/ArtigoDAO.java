package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Artigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gusttavo Nunes, Gleyson Israel
 */
public class ArtigoDAO extends DAOCRUDBase<Artigo>  {
    @Override
    public void inserir(Artigo a) throws Exception {
        
    }
    
    /**
     * Método que seleciona um Artigo já cadastrado no banco de dados
     * @author Gleyson Israel Alves
     * @param id identificador do artigo
     * @return Artigo selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public Artigo selecionar(int id) throws Exception{
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from artigos where id = ?");
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        if (rs.next()){
            
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
            
            return a;
        } else {
            return null;
        }
    }
    
    /**
     * Método responsável pela exclusão de um Artigo no banco de dados
     * @author Fernando Maciel da Silva     
     * @param id identificador do país a ser excluído    
     * @throws Exception possíveis exceções que podem acontecer
     */    
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("delete from artigos where id = ?");        
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();        
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
            a.setAreaConhecimento(rs.getString("area_Conhecimento"));
            a.setTitulo(rs.getString("titulo"));
            a.setResumo(rs.getString("resumo"));
            a.setURL(rs.getString("url"));
            a.setArtigo(rs.getBytes("artigo"));    
            lista.add(a);
        }        
        return lista;        
    }
    
    @Override
    public void alterar(Artigo a) throws Exception {
        
    }

}
