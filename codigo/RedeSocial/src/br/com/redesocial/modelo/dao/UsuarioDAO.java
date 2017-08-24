package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Usuario;
import br.com.redesocial.modelo.dto.enumeracoes.Sexo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de acesso aos dados dos usuários
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class UsuarioDAO extends DAOCRUDBase<Usuario> {
    /**
     * Inseri um objeto no banco de dados na tabela usuários
     * @param dto objeto com os dados de usuário já preenchido
     * @throws Exception 
     */
    @Override
    public void inserir(Usuario dto) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt = conexao.prepareStatement("insert into usuarios(nome, email, telefone, senha, data_nascimento, sexo, data_cadastro, status, foto, cidade) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, dto.getNome());
        pstmt.setString(2, dto.getEmail());
        pstmt.setString(3, dto.getTelefone());
        pstmt.setString(4, dto.getSenha());
        pstmt.setDate(5, new java.sql.Date(dto.getDataNascimento().getTime()));
        pstmt.setString(6, String.valueOf(dto.getSexo().getId()));
        pstmt.setDate(7, new java.sql.Date(dto.getDataCadastro().getTime()));
        pstmt.setBoolean(8, dto.getStatus());
        
        if (dto.getFoto() != null){
            pstmt.setInt(9, dto.getFoto().getId());
        } else {
            pstmt.setNull(9, Types.BLOB);
        }
        
        
        pstmt.setInt(10, dto.getCidade().getId()); 
       
        
        pstmt.executeUpdate();
        
        dto.setId(getId(pstmt));
    }
    
    @Override
    public Usuario selecionar(int id) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from usuarios where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        MultimidiaDAO multimidiaDAO = new MultimidiaDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();
        if (rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setTelefone(rs.getString("telefone"));
            u.setSenha(rs.getString("senha"));
            u.setDataNascimento(rs.getDate("data_nascimento"));            
            u.setSexo(Sexo.getSexo(rs.getString("sexo").charAt(0)));
            u.setDataCadastro(rs.getDate("data_cadastro"));
            u.setStatus(rs.getBoolean("status"));
            u.setFoto(multimidiaDAO.selecionar(rs.getInt("foto")));
            u.setCidade(cidadeDAO.selecionar(rs.getInt("cidade")));

            return u;
        }else{
            return null;
        }
    }    

    @Override
    public void alterar (Usuario  u) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement  pstmt; 
        
        pstmt = conexao.prepareStatement("update usuarios set nome = ?, email=?, telefone=?, senha =?, data_nascimento =?, sexo = ?, data_cadastro =?, status =?, foto=?, cidade=?, where id =? ");
       
        pstmt.setString(1, u.getNome());
        pstmt.setString(2, u.getEmail());
        pstmt.setString(3, u.getTelefone());
        pstmt.setString(4, u.getSenha());  
        pstmt.setDate(5, new java.sql.Date(u.getDataNascimento().getTime()));
        pstmt.setString(6, String.valueOf(u.getSexo().getId()));
        pstmt.setDate(7, new java.sql.Date(u.getDataCadastro().getTime()));
        pstmt.setBoolean(8, u.getStatus());
        
        if (u.getFoto() != null){
            pstmt.setInt(9, u.getFoto().getId());
        } else {
            pstmt.setNull(9, Types.BLOB);
        }
        
        pstmt.setInt(10, u.getCidade().getId()); 
        pstmt.setInt(11, u.getId());          
       
        pstmt.executeUpdate();
    }
    public void alterarSenha (Usuario  u) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("update usuario set senha = ? where id = ?");
       
        pstmt.setString(1, u.getSenha()); 
        pstmt.setInt(2, u.getId());
       
        pstmt.executeUpdate();
    }
    @Override
     public List listar() throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement  pstmt; 
        pstmt = conexao.prepareStatement("select * from usuarios order by nome asc");
                
        ResultSet rs;
        rs = pstmt.executeQuery();
        
	MultimidiaDAO multimidiaDAO = new MultimidiaDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();
        List lista;
        lista = new ArrayList();
        
        while (rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setTelefone(rs.getString("telefone"));
            u.setSenha(rs.getString("senha"));
            u.setDataNascimento(rs.getDate("data_nascimento"));            
            u.setSexo(Sexo.getSexo(rs.getString("sexo").charAt(0)));
            u.setDataCadastro(rs.getDate("data_cadastro"));
            u.setStatus(rs.getBoolean("status"));
            u.setFoto(multimidiaDAO.selecionar(rs.getInt("foto")));
            u.setCidade(cidadeDAO.selecionar(rs.getInt("cidade")));
            
            lista.add(u);
        }
        
        return lista;
    }

    @Override
    public void excluir(int id) throws Exception {
        Connection conexao = getConexao();  
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from usuarios where id = ?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

    }
}