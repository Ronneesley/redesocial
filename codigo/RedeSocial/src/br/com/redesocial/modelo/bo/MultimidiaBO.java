package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.MultimidiaDAO;
import br.com.redesocial.modelo.dto.Multimidia;
import java.util.List;


/**
 * Define as regras de negócio para os usuários
 * @author Andrey Silva Ribeiro
 * @since 11/08/2017
 */
public class MultimidiaBO extends BOCRUDBase<Multimidia, MultimidiaDAO> {
     /**
     * Instancia um objeto de Multimidia DAO
     * @return instância de acesso aos dados da multimidia
     */
    
    @Override
    protected MultimidiaDAO instanciarDAO() {
        return new MultimidiaDAO();
    }
    /**
     * Validação dos atributos da multimidia
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */

    @Override
    protected void validar(Multimidia dto) throws Exception {
        //Validações
        if (dto.getMidia()== null) throw new Exception("Preencha o nome da midia");
        if (dto.getTipoConteudo().trim().equals("")) throw new Exception("Preencha o tipo de conteudo");
        if (dto.getData() == null) throw new Exception("Preencha o data da midia");

        if (dto.getAlbum() == null) throw new Exception("Preencha o nome do album");
    }
     /**
     * Validação da chave primária de um objeto multimidia
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    @Override
    protected void validarChavePrimaria(Multimidia dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
    
    public List listarFotosAlbum(int id) throws Exception{
        MultimidiaDAO dao = this.instanciarDAO();
        return dao.listarMultimidiasAlbum(id);
    }
}
