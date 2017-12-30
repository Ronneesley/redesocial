/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.PalavraChave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salmi Nunes
 */
public class PalavraChaveDAO extends DAOCRUDBase<PalavraChave> {
    
    @Override
    public void inserir(PalavraChave p) throws Exception {
        
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into palavras_chave (descricao) values(?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, p.getDescricao());
        pstmt.executeUpdate();

        p.setId(getId(pstmt));
    }

    @Override
    
    public void alterar(PalavraChave p) throws Exception {
        Connection conexao = getConexao();
        
        if (p.getDescricao().trim().equals("")){
            throw new Exception("A descrição não pode estar vazia!");
        }
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update palavras_chave set descricao = ? where id = ?");

        pstmt.setString(1, p.getDescricao());
        pstmt.setInt(2, p.getId());
        
        pstmt.executeUpdate();
    }

    /**
     * Método para selecionar uma palavra chave
     * @param id identificador de palavra chave
     * @return palavra chave ou null
     * @throws Exception possíves erros que podem acontecer
     */
    @Override
    public PalavraChave selecionar(int id) throws Exception {
        //conecta ao banco
        Connection conexao = getConexao();
        //prepara um comando sql
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from palavras_chave where id = ?");
        
        pstmt.setInt(1, id);
        //executa o comando sql
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            //objeto para uma palavra chave
            PalavraChave dto = new PalavraChave();
            
            dto.setId(rs.getInt("id"));
            dto.setDescricao(rs.getString("descricao"));
            //retorna o objeto desejado
            return dto;
        }else{       
            return null;
        }
    }
    
    /**
     * Método para listar as palavras chaves existentes
     * @author Jônatas de Souza Rezende.
     * @return lista.
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from palavras_chave order by descricao");
        ResultSet rs;
        rs = pstmt.executeQuery();
        
        List lista;
        lista = new ArrayList();
        
        while(rs.next()){
            PalavraChave pc = new PalavraChave();
            pc.setId(rs.getInt("id"));
            pc.setDescricao(rs.getString("descricao"));
            lista.add(pc);
        }
        
        return lista;
    }

    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from palavras_chave where id = ?");
        
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
       }
    
    
    
}
    
    

