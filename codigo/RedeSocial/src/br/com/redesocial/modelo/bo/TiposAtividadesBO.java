package br.com.redesocial.modelo.bo;
import br.com.redesocial.modelo.dao.TiposAtividadesDAO;
import br.com.redesocial.modelo.dto.TiposAtividades;

/**
 *
 * @author Brener, Jose Gilvan e Marcos Arriel
 */
public class TiposAtividadesBO extends BOCRUDBase<TiposAtividades, TiposAtividadesDAO>{

    /**
     *
     * @return
     */
    @Override
    protected TiposAtividadesDAO instanciarDAO() {
        return new TiposAtividadesDAO();
    }

    /**
     *
     * @param dto
     * @throws Exception
     */
    @Override
    protected void validar(TiposAtividades dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o nome da atividade");
        if (dto.getRestricao() == null) throw new Exception("Preencha a restricao da atividade");
    }

    /**
     *
     * @param dto
     * @throws Exception
     */
    @Override
    protected void validarChavePrimaria(TiposAtividades dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
}
