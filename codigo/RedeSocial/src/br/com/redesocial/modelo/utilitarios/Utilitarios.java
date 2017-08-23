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
            String conteudo = lerArq.readLine();
            while (conteudo != null) {
                conteudo = lerArq.readLine(); // lê da segunda até a última linha
            }   bytes = conteudo.getBytes();
        }
        
        return bytes;
    }
}
