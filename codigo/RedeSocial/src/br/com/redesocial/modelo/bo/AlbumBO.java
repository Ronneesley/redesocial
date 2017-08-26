package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.AlbumDAO;
import br.com.redesocial.modelo.dto.Album;

/**
 * @author Andrey Silva Ribeiro
 * @since 11/08/2017
 */
public class AlbumBO extends BOCRUDBase<Album, AlbumDAO> {
    
    /**
     * Instancia um objeto de album DAO
     * @return instância de acesso aos dados do país
     */
    
    @Override
    protected AlbumDAO instanciarDAO() {
        return new AlbumDAO();
    }

    /**
     * Validação dos atributos do album
     * @param dto objeto em questão que será validado
     * @throws Exception validações encontradas
     */
    @Override
    protected void validar(Album dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do album");
        if  (dto.getData() == null) throw new Exception("Preencha o data do album");

        if (dto.getUsuario() == null) throw new Exception("Preencha o nome do usuário");
    }

    /**
     * Validação da chave primária de um objeto album
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    
    @Override
    protected void validarChavePrimaria(Album dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
}
