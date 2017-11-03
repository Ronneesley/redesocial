package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza as operações de acesso ao banco de dados da entidade país
 * @author Ronneesley Moura Teles, Thalia Santos de Santana, beltrano
 * @since 24/09/2017
 */
public class ParticipanteDAO extends DAOBase {

    /**
     * Método responsável pela inserção de um país no banco de dados
     * @author Ciclano
     * @param p país a ser inserido
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void inserir(Participante p) throws Exception {
        Connection conexao = getConexao();

        if(p.getGrupo() == null){
            throw new Exception("O campo Grupo não pode estar vazio!");
        }
        if(p.getUsuario() == null){
            throw new Exception("O campo Usuario não pode estar vazio!");
        }
        if(p.getCargo() == null){
            throw new Exception("O campo Cargo não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into participantes (grupo, usuario, cargo) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, p.getGrupo().getId());
        pstmt.setInt(2, p.getUsuario().getId());
        pstmt.setInt(3, p.getCargo());
        
        pstmt.executeUpdate();        
    }

    /**
     * Método responsável pela alteração de um país no banco de dados
     * @author Macilon Arruda
     * @param p novos dados do país, com o ID do país a ser alterado preenchido
     * @param pNovo
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void alterar(Participante p, Participante pNovo) throws Exception {
        Connection conexao = getConexao();

        if (p.getGrupo() == null){
            throw new Exception("O Grupo não pode estar vazio!");
        }
        
        if (p.getUsuario() == null){
            throw new Exception("O Usuario não pode estar vazio!");
        }
        
        if (p.getCargo() == null){
            throw new Exception("O Cargo não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update participantes set grupo = ?, usuario = ?, cargo = ? where grupo = ? and usuario = ? and cargo = ?");

        pstmt.setInt(1, pNovo.getGrupo().getId());
        pstmt.setInt(2, pNovo.getUsuario().getId());
        pstmt.setInt(3, pNovo.getCargo());
        
        pstmt.setInt(4, p.getGrupo().getId());
        pstmt.setInt(5, p.getUsuario().getId());
        pstmt.setInt(6, p.getCargo());

        pstmt.executeUpdate();
    }

    /**
     * Método responsável pela exclusão de um país no banco de dados
     * @author Ciclano
     * @param grupo
     * @param usuario
     * @param cargo
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void excluir(int grupo, int usuario, int cargo) throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("delete from participantes where grupo = ? and usuario = ? and cargo = ?");

        pstmt.setInt(1, grupo);
        pstmt.setInt(2, usuario);
        pstmt.setInt(3, cargo);
        
        pstmt.executeUpdate();
    }

    /**
     * Método que seleciona um país já cadastrado no banco de dados
     * @author Ciclano
     * @param grupo
     * @param usuario
     * @param cargo
     * @return país selecionado no banco de dados
     * @throws Exception possíveis exceções que podem acontecer
     */
    public Participante selecionar(int grupo, int usuario, int cargo) throws Exception {
        Connection conexao = getConexao();
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from participantes where grupo = ? and usuario = ? and cargo = ?");
        
        pstmt.setInt(1, grupo);
        pstmt.setInt(2, usuario);
        pstmt.setInt(3, cargo);

        ResultSet rs;
        rs = pstmt.executeQuery();        
        
        if(rs.next()){
            
            Participante p = new Participante();            
            GrupoDAO grupoDAO = new GrupoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            p.setGrupo(grupoDAO.selecionar(rs.getInt("grupo")));
            p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            p.setCargo(rs.getInt("cargo"));
            
            return p;
        } else {
            return null;
        } 
    }

    /**
     * Método que lista todos os países em ordem alfabética do banco de dados
     * @author Thalia Santos de Santana
     * @return lista de países ordenados alfabeticamente
     * @throws Exception possíveis exceções que podem acontecer
     */
    public List listar() throws Exception {
        Connection conexao = getConexao();

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from participantes order by data desc");

        ResultSet rs;
        rs = pstmt.executeQuery();
        
        GrupoDAO grupoDAO = new GrupoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List lista;
        lista = new ArrayList();       

        while (rs.next()){
           
           Participante p = new Participante();
           
                    
           p.setGrupo(grupoDAO.selecionar(rs.getInt("grupo")));
           p.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
           p.setCargo(rs.getInt("cargo"));
           
           lista.add(p);
        }

        return lista;
    }
}
