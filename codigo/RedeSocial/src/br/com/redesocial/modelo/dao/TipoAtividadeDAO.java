/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;



import br.com.redesocial.modelo.dto.TipoAtividade;
import br.com.redesocial.modelo.dto.TiposAtividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Inimigo
 */
public class TipoAtividadeDAO extends DAOCRUDBase <TipoAtividade> {
    @Override
    public void inserir(TipoAtividade t) throws Exception {
        Connection conexao = getConexao();        

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into tipos_atividades (nome, restricao) values(?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, t.getNome());
        pstmt.setBoolean(2, t.getRescricao());        
        
        pstmt.executeUpdate();

        t.setId(getId(pstmt));
    }
    public void alterar(TiposAtividades t) throws Exception {
        Connection conexao = getConexao();        

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update tipos_atividades set nome = ?, restricao = ?, where id = ?");
        
        pstmt.setString(1, t.getNome());
        pstmt.setBoolean(2, t.getRescricao());        
        
        pstmt.setInt(3,t.getId());

        pstmt.executeUpdate();
    }
    @Override

    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from tipos_atividades where id = ?");

        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }
    @Override
    public TipoAtividade selecionar(int id) throws Exception {        
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        
        pstmt = conexao.prepareStatement("select * from tipos_atividades where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            TipoAtividade t = new TipoAtividade();
            t.setId(id);
            t.setNome(rs.getString("nome"));

            return t;
        }else{
            return null;
        }
    }
    @Override
    public List listar() throws Exception {        
       Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from tipos_atividades order by nome asc");

       ResultSet rs;
       rs = pstmt.executeQuery();

       List lista;
       lista = new ArrayList();

       while (rs.next()){
           TiposAtividades t = new TiposAtividades();
           t.setId(rs.getInt("id"));
           t.setNome(rs.getString("nome"));

           lista.add(t);
       }
       return lista;
    }    

    @Override
    public void alterar(TipoAtividade dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
