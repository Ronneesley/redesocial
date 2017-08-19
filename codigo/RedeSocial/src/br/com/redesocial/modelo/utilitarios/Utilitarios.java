package br.com.redesocial.modelo.utilitarios;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Ronneesley
 */
public class Utilitarios {

    public static byte[] lerArquivo(File arquivo) throws Exception {
        FileReader arq = new FileReader(arquivo);
        BufferedReader lerArq = new BufferedReader(arq);

        String conteudo = lerArq.readLine(); 
        while (conteudo != null) {
            conteudo = lerArq.readLine(); // lê da segunda até a última linha
        }
        
        byte[] bytes = conteudo.getBytes();
        
        arq.close();
        
        return bytes;
    }
}
