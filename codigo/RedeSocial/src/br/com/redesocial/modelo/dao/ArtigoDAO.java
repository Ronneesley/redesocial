package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Artigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gusttavo Nunes, Gleyson Israel
 */
public class ArtigoDAO extends DAOCRUDBase<Artigo>  {
    /**
     * Método para inserir um artigo no banco de dados
     * @param dto identificador de artigo
     * @author Davi de Faria
     * @throws Exception Possíveis exceções que podem acontecer
     */
    @Override
    public void inserir(Artigo dto) throws Exception {
        Connection conexao = getConexao();
        
        if (dto.getArtigo().equals("")){
            throw new Exception("O arquivo do artigo não pode estar vazio!");
        }
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into artigos (idioma, revista, issn, autor, data, area_conhecimento, titulo, resumo, url, artigo) values (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getIdioma());
        pstmt.setString(2, dto.getRevista());
        pstmt.setString(3, dto.getISSN());
        pstmt.setString(4, dto.getAutor());
        pstmt.setDate(5, new java.sql.Date(dto.getData().getTime()));
        pstmt.setString(6, dto.getAreaConhecimento());
        pstmt.setString(7, dto.getTitulo());
        pstmt.setString(8, dto.getResumo());
        pstmt.setString(9, dto.getURL());
        pstmt.setBytes(10, dto.getArtigo());
        
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
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
            a.setAreaConhecimento(rs.getString("area_conhecimento"));
            a.setTitulo(rs.getString("titulo"));
            a.setResumo(rs.getString("resumo"));
            a.setURL(rs.getString("url"));
            a.setArtigo(rs.getBytes("artigo"));    
            lista.add(a);
        }        
        return lista;        
    }
     
    /**
     * Método que Altera um Artigo já cadastrado no banco de dados
     * @author Eduardo Oliveira Silva
     * @param a attigo a ser alterado
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public void alterar(Artigo a) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update artigos set  idioma = ?, revista = ?, issn = ?, autor = ?, data = ?, area_conhecimento = ?, titulo = ?, resumo = ?, url = ?, artigo = ? where id = ?");
        
        pstmt.setString(1, a.getIdioma());
        pstmt.setString(2, a.getRevista());
        pstmt.setString(3, a.getISSN());
        pstmt.setString(4, a.getAutor());
        pstmt.setDate(5, new java.sql.Date(a.getData().getTime()));
        pstmt.setString(6, a.getAreaConhecimento());
        pstmt.setString(7, a.getTitulo());
        pstmt.setString(8, a.getResumo());
        pstmt.setString(9, a.getURL());
        pstmt.setBytes(10, a.getArtigo());
        pstmt.setInt(11, a.getId());
        
        //executa uma atualização/alteração
        pstmt.executeUpdate();
        
    }

}
