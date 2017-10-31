package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Atividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jonathan Silvestre
 */
public class AtividadesDAO extends DAOCRUDBase<Atividades> {
    
    @Override
    public void alterar(Atividades dto) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into atividades (descricao, tipo, vagas, evento, inicio, fim) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, dto.getDescricao());
        pstmt.setInt(2, dto.getTipo());
        pstmt.setInt(3, dto.getVagas());
        pstmt.setInt(4, dto.getEvento());
        pstmt.setDate(5, new java.sql.Date(dto.getInicio().getTime()));
        pstmt.setDate(6, new java.sql.Date(dto.getFim().getTime()));

        pstmt.executeUpdate();
    }

    @Override
    public Atividades selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from atividades where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Atividades dto = new Atividades();
            
           dto.setDescricao(rs.getString("descricao"));
           dto.setTipo(rs.getInt("Tipo"));
           dto.setVagas(rs.getInt("Vagas"));
           dto.setEvento(rs.getInt("Evento"));
           dto.setInicio(rs.getDate("Inicio"));
           dto.setFim(rs.getDate("Fim"));
           dto.setId(rs.getInt("id"));
            
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from atividades order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           Atividades p = new Atividades();
           p.setDescricao(rs.getString("descricao"));
           p.setTipo(rs.getInt("Tipo"));
           p.setVagas(rs.getInt("Vagas"));
           p.setEvento(rs.getInt("Evento"));
           p.setInicio(rs.getDate("Inicio"));
           p.setFim(rs.getDate("Fim"));
           p.setId(rs.getInt("id"));

           lista.add(p);
       }

       return lista;
    }

    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();  
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from atividades where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public void inserir(Atividades dto) throws Exception {
        Connection conexao = getConexao();

        if(dto.getDescricao().equals("")){
            throw new Exception("O campo Descrição não pode estar vazio!");
        } 
        if(dto.getInicio().equals("")){
            throw new Exception("O campo Inicio não pode estar vazio!");
        } 
        if(dto.getFim().equals("")){
            throw new Exception("O campo Fim não pode estar vazio!");
        } 

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into Atividades (descricao, tipo, vagas, evento, inicio, fim) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, dto.getDescricao());
        pstmt.setInt(2, dto.getTipo());
        pstmt.setInt(3, dto.getVagas());
        pstmt.setInt(4, dto.getEvento());
        pstmt.setDate(5, new java.sql.Date(dto.getInicio().getTime()));
        pstmt.setDate(6, new java.sql.Date(dto.getFim().getTime()));
        pstmt.executeUpdate();

        dto.setId(getId(pstmt));
    }
}
