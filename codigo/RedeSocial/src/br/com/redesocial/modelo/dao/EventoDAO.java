package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos dados dos eventos
 * @author Willian Wallace e Jonathan Silvestre
 * @since 13/10/2017
 */
public class EventoDAO extends DAOCRUDBase<Evento> {
    /**
    * Metodo que lista os eventos
    * @author Jonathan Silvestre e Willian Wallace 
    * @param dto 
    * @throws java.lang.Exception 
    * @since 13/10/2017
    */
    @Override
    public void inserir(Evento dto) throws Exception {
        Connection conexao = getConexao();

        if(dto.getNome().trim().equals("")){
            throw new Exception("O campo nome não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into eventos (descricao, nome, certificado, inicio, fim) values(?,?,?,,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, dto.getDescricao());
        pstmt.setString(2, dto.getNome());
        pstmt.setBoolean(3, dto.getCertificado());
        pstmt.setDate(4, new java.sql.Date(dto.getInicio().getTime()));
        pstmt.setDate(5, new java.sql.Date(dto.getFim().getTime()));
        pstmt.executeUpdate();

        dto.setId(getId(pstmt));
    }
    
    /**
    * Metodo que altera o os valores do campo de evento
    * @author Jonathan Silvestre e Salmi Nunes
    * @param dto 
    * @throws java.lang.Exception 
    * @since 20/10/2017
    */
    @Override
    public void alterar(Evento dto) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt = conexao.prepareStatement("update eventos set nome = ?, descricao  = ?, certificado = ?, inicio = ?, fim = ? where id = ?"); 
        
        pstmt.setString(1, dto.getNome()); 
        pstmt.setString(2, dto.getDescricao());
        pstmt.setBoolean(3, dto.getCertificado());
        pstmt.setDate(4, new java.sql.Date(dto.getInicio().getTime()));
        pstmt.setDate(5, new java.sql.Date(dto.getFim().getTime()));
        pstmt.setInt(6, dto.getId());

        pstmt.executeUpdate();
    }

   /**
    * Metodo que lista os eventos
    * @author Jonathan Silvestre e Salmi Nunes
    * @param id
    * @return 
    * @throws java.lang.Exception 
    * @since 20/10/2017
    */
    @Override
    public Evento selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from eventos where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Evento dto = new Evento();
            
            dto.setDescricao(rs.getString("descricao"));
            dto.setNome(rs.getString("nome"));
            dto.setId(rs.getInt("id"));
            dto.setCertificado(rs.getBoolean("certificado"));
            dto.setInicio(rs.getDate("inicio"));
            dto.setFim(rs.getDate("fim"));
            
            return dto;
        } else {
            return null;
        }
    }
    
    /**
    * Metodo que lista os eventos
    * @author Jonathan Silvestre e Willian Wallace 
    * @return  
    * @throws java.lang.Exception 
    * @since 20/10/2017
    */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from eventos order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           Evento p = new Evento();
           p.setNome(rs.getString("descricao"));
           p.setNome(rs.getString("nome"));
           p.setId(rs.getInt("id"));

           lista.add(p);
       }

       return lista;
    }
    
    /**
    * Metodo que exclui um evento apartir do id   
    * @author Willian Wallace
    * @param id
    * @throws java.lang.Exception
    * @since 13/10/2017
    */
    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();  
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from eventos where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}