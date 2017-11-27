package br.com.redesocial.modelo.dao;
import br.com.redesocial.modelo.dto.TiposAtividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brener, José Gilvan e Marcos Arriel
 */
public class TiposAtividadesDAO extends DAOCRUDBase<TiposAtividades> {

    /**
     *
     * @param t
     * @throws Exception
     */
    @Override
    public void inserir(TiposAtividades t) throws Exception {
        Connection conexao = getConexao();

        if(t.getNome().trim().equals("")){
            throw new Exception("O campo atividade não pode estar vazio!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("insert into tipos_atividades (nome, restricao) values(?,?)", Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, t.getNome());
        pstmt.setBoolean(2, t.getRestricao());
        pstmt.executeUpdate();

        t.setId(getId(pstmt));
    }
    @Override
    public void alterar(TiposAtividades t) throws Exception {
        Connection conexao = getConexao();

        if (t.getNome().trim().equals("")){
            throw new Exception("O nome não pode estar vazia!");
        }

        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("update tipos_atividades set nome = ?, restricao = ? where id = ?");

        pstmt.setString(1, t.getNome());
        pstmt.setBoolean(2, t.getRestricao());
        pstmt.setInt(3, t.getId());

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
    public TiposAtividades selecionar(int id) throws Exception {
        Connection conexao = getConexao();
        PreparedStatement pstmt;
        pstmt = conexao.prepareStatement("select * from tipos_atividades where id = ?");
        pstmt.setInt(1, id);

        ResultSet rs;
        rs = pstmt.executeQuery();

        if(rs.next()){
            TiposAtividades t = new TiposAtividades();
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
}
