
package br.com.redesocial.modelo.dao;

import br.com.redesocial.modelo.dto.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Love
 */
public class ParticipanteDAO extends DAOBase {

        /**
     * Método responsável pela inserção de um país no banco de dados
     * @author Ciclano
     * @param dto
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void inserir(Participante dto) throws Exception {
        Connection conexao = getConexao();

        if(dto.getGrupo() == null){
            throw new Exception("O campo Grupo não pode estar vazio!");
        }
        
        if(dto.getUsuario() == null){
            throw new Exception("O campo Usuario não pode estar vazio!");
        }
        
        if(dto.getCargo() == null){
            throw new Exception("O campo Cargo não pode estar vazio!");        
        }
        
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into participantes (grupo, usuario, cargo) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, dto.getGrupo().getId());
        pstmt.setInt(2, dto.getUsuario().getId());
        pstmt.setInt(3, dto.getCargo());
        
        pstmt.executeUpdate();        
    }

    /**
     * Método responsável pela alteração de um país no banco de dados
     * @author Macilon Arruda
     * @param dto
     * @param dtoNovo
     * @throws Exception possíveis exceções que podem acontecer
     */
    public void alterar(Participante dto, Participante dtoNovo) throws Exception {
        Connection conexao = getConexao();

        if(dto.getGrupo() == null){
            throw new Exception("O campo Grupo não pode estar vazio!");
        }
        
        if(dto.getUsuario() == null){
            throw new Exception("O campo Usuario não pode estar vazio!");
        }
        
        if(dto.getCargo() == null){
            throw new Exception("O campo Cargo não pode estar vazio!");        
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update participantes set grupo = ?, usuario = ?, cargo where grupo = ? and usuario = ? and cargo = ?");

        pstmt.setInt(1, dtoNovo.getGrupo().getId());
        pstmt.setInt(2, dtoNovo.getUsuario().getId());
        pstmt.setInt(3, dtoNovo.getCargo());
        
        pstmt.setInt(4, dto.getGrupo().getId());
        pstmt.setInt(5, dto.getUsuario().getId());
        pstmt.setInt(6, dto.getCargo());

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
        
        GrupoDAO grupoDAO = new GrupoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        if(rs.next()){
            Participante dto = new Participante();
            
            dto.setGrupo(grupoDAO.selecionar(rs.getInt("grupo")));
            dto.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            dto.setCargo(cargo);
            
            return dto;
        }else{
            return null;
        }
    }

    /**
     * Método que lista todos os países em ordem alfabética do banco de dados
     * @author Thalia Santos de Santana
     * @param cargo
     * @return lista de países ordenados alfabeticamente
     * @throws Exception possíveis exceções que podem acontecer
     */
    public List listar(int cargo) throws Exception {
        
       Connection conexao = getConexao();

       PreparedStatement pstmt;
       pstmt = conexao.prepareStatement("select * from participantes order by nome desc");

       ResultSet rs;
       rs = pstmt.executeQuery();
       
       GrupoDAO grupoDAO = new GrupoDAO();
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       List lista;
       lista = new ArrayList();

       while (rs.next()){
            Participante dto = new Participante();
           
            dto.setGrupo(grupoDAO.selecionar(rs.getInt("grupo")));
            dto.setUsuario(usuarioDAO.selecionar(rs.getInt("usuario")));
            dto.setCargo(cargo);
           

            lista.add(dto);
       }

       return lista;
    }

    
}
