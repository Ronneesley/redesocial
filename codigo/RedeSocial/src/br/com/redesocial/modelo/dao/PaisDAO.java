package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO extends DAOCRUDBase<Pais> {
    
    @Override
    public void inserir(Pais p) throws Exception{
        Connection conexao = getConexao();
        
        if(p.getNome().trim().equals("")){
            throw new Exception("O campo país não pode estar vazio!");  
        }
        
        preparedStatement pstmt;
        pstmt = conexao.prepareStatement("inserir into paises (nome) values(?)");
        
        pstmt.setString(1, p.getNome());
        pstmt.executeUpdate();
        
    }
    
    @Override
    public void alterar(Pais p) throws Exception {
        Connection conexao = getConexao();

        if (p.getNome().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update paises set nome = ? where id = ?");

        pstmt.setString(1, p.getNome());
        pstmt.setInt(2, p.getId());

        pstmt.executeUpdate();
    }

    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from paises where id = ?");

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public Pais selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from paises where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            Pais p = new Pais();
            p.setId(id);
            p.setNome(rs.getString("nome"));

            return p;
        }else{
            return null;
        }
    }

    @Override
    public List listar() throws Exception {
       Connection conexao = getConexao();
        
       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from paises order by nome asc");
        
       ResultSet rs;
       rs = pstmt.executeQuery();
        
       List lista;
       lista = new ArrayList();
        
       while (rs.next()){
           Pais p = new Pais();
           p.setId(rs.getInt("id"));
           p.setNome(rs.getString("nome"));
            
           lista.add(p);
       }
        
       return lista;
    } 
   
 }
