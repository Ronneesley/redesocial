package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Atividade;
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
public class AtividadeDAO extends DAOCRUDBase<Atividade> {
    
    @Override
    public void alterar(Atividade dto) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update atividades set descricao = ?, tipo = ?, vagas = ?, evento = ?, inicio = ?, fim = ?, where id = ?");

        pstmt.setString(1, dto.getDescricao());
        pstmt.setInt(2, dto.getTipo());
        pstmt.setInt(3, dto.getVagas());
        pstmt.setInt(4, dto.getEvento());
        pstmt.setDate(5, new java.sql.Date(dto.getInicio().getTime()));
        pstmt.setDate(6, new java.sql.Date(dto.getFim().getTime()));

        pstmt.executeUpdate();
    }

    @Override
    public Atividade selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from atividades where id = ?");
        
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            Atividade dto = new Atividade();
            
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
           Atividade p = new Atividade();
           p.setDescricao(rs.getString("descricao"));
           p.setTipo(rs.getInt("tipo"));
           p.setVagas(rs.getInt("vagas"));
           p.setEvento(rs.getInt("evento"));
           p.setInicio(rs.getDate("inicio"));
           p.setFim(rs.getDate("fim"));
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
    public void inserir(Atividade dto) throws Exception {
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
