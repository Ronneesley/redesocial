/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.ArtigoDAO;
import br.com.redesocial.modelo.dto.Artigo;

/**
 *@author Ianka Talita Bastos de Assis
 * @since 30/08/2017
 */
public class ArtigoBO extends BOCRUDBase<Artigo, ArtigoDAO> {
   
    /**
     * Instância um objeto de artigo DAO
     * @return instância de acesso aos dados de artigo
     */    
    @Override
    protected ArtigoDAO instanciarDAO(){
        return new ArtigoDAO();
    }
    
    /**
     * Validação dos atributos do artigo
     * @param dto objeto que será validado
     * @throws Exception possíveis exceções que podem acontecer
     */
    @Override
    protected void validar(Artigo dto) throws Exception {
        // Validações
        if (dto.getIdioma() == null) throw new Exception("Preencha o idioma do artigo.");
        if (dto.getRevista() == null) throw new Exception("Preencha a revista do artigo.");
        if (dto.getISSN() == null) throw new Exception("Preencha o ISSN do artigo.");
        if (dto.getAutor() == null) throw new Exception("Preencha o nome do autor do artigo.");
        if (dto.getData() == null) throw new Exception("Preencha a data do artigo.");
        if (dto.getAreaConhecimento() == null) throw new Exception("Preencha a área de conhecimento do artigo.");
        if (dto.getTitulo().trim().equals("")) throw new Exception("Preencha o título do artigo.");
        if (dto.getResumo() == null) throw new Exception("Preencha o resumo do artigo.");
        if (dto.getURL() == null) throw new Exception("Preencha a URL do artigo.");
        // private byte[] artigo;
    }
    
    /**
     *Validação da chave primária do artigo
     * @param dto objeto em questão
     * @throws Exception validação se a chave não foi preenchida
     */
    @Override
    protected void validarChavePrimaria (Artigo dto) throws Exception {
        if (dto.getId() == null) throw new Exception ("Preencha o campo id.");
    }
}
