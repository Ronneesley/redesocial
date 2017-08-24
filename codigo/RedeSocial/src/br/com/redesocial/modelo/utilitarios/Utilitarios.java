package br.com.redesocial.modelo.utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Ronneesley
 */
public class Utilitarios {

    public static byte[] lerArquivo(File arquivo) throws Exception {
        byte[] bytes;
        try (FileReader arq = new FileReader(arquivo)) {
            
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String conteudo = linha;
            
            while (linha != null) {
                linha = lerArq.readLine(); // lê da segunda até a última linha
                
                if (linha != null){
                    conteudo += linha;
                }
            }   
            
            bytes = conteudo.getBytes();
        }
        
        return bytes;
    }
}
