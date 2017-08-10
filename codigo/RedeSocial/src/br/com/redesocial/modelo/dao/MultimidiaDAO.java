package br.com.redesocial.modelo.dao;

import java.sql.ResultSet;
import br.com.redesocial.modelo.dto.Multimidia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lara, Jeferson, Luciano, Jonathan
 */
<<<<<<< HEAD
public class MultimidiaDAO extends DAOBase {
    
=======
public class MultimidiaDAO extends DAOCRUDBase<Multimidia> {
    @Override
    public void inserir(Multimidia m) throws Exception {
        Connection conexao = getConexao();
        
        //Arrumar as validações
        if (m.getMidia().equals("")){
            throw new Exception("A mídia não pode estar vazia!");
        }
                
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into multimidias(id, midia, tipoConteudo, data, album) values(?, ?, ?, ?, ?)");

        pstmt.setInt (1, m.getId());
        pstmt.setBytes (2, m.getMidia());
        pstmt.setString (3, m.getTipoConteudo());
        pstmt.setDate(4, new java.sql.Date(m.getData().getTime()));
        pstmt.setInt (5, m.getAlbum().getId());
        
        pstmt.executeUpdate();
        
        m.setId(getId(pstmt));
    }
   
    @Override
>>>>>>> e612b7dfa0f2d85726c668889781de9616ee8d34
    public Multimidia selecionar(int id) throws Exception{
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from multimidia where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if (rs.next()){
            Multimidia m = new Multimidia();
            m.setId(rs.getInt("id"));
            m.setMidia(rs.getBytes("midia"));
            m.setTipoConteudo(rs.getString("tipoConteudo"));
            m.setData(rs.getDate("data"));

            return m;
        } else {
            return null;
        }
    }

<<<<<<< HEAD
    public void inserir (Multimidia m) throws Exception {
        Connection conexao = getConexao();

        //Arrumar as validações
        if (conexao.getMidia().trim().equals("")){
            throw new Exception("A mídia não pode estar vazia!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into multimidia(id, midia, tipoConteudo, data) values(?, ?, ?, ?)");
        
        pstmt.setInt(1, conexao.getId());
        

        pstmt.setString(1, conexao.getId()); //ID é automático, portanto não deve estar no SQL, nem arqui informado
        //Mídia
        //Conteúdo
        pstmt.setDate(4, new java.sql.Date(m.getData().getTime()));

        pstmt.executeUpdate();
    }

=======
    @Override
>>>>>>> e612b7dfa0f2d85726c668889781de9616ee8d34
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from multimidia where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
    
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from multimidia order by id desc");
        
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        while (rs.next()){
            Multimidia m = new Multimidia();
            m.setId(rs.getInt("id"));
            m.setMidia(rs.getBytes("midia"));
            m.setTipoConteudo(rs.getString("TipoConteudo"));
            m.setData(rs.getDate("data"));
            lista.add(m);
        }
        
        return lista;
    }
<<<<<<< HEAD
}
=======

    @Override
    public void alterar(Multimidia dto) throws Exception {
        
    }
}
>>>>>>> e612b7dfa0f2d85726c668889781de9616ee8d34
