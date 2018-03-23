package br.pcrn.deprov.dominio;

import java.io.*;
import java.nio.file.Path;

public class Arquivo {

    public Arquivo() {
    }

    public void upload(String pasta, String nomeDoArquivo,
                       InputStream arquivoCarregado) throws IOException{
        String caminhoArquivo = pasta + "/" + nomeDoArquivo;
        File novoArquivo = new File(caminhoArquivo);
        FileOutputStream saida = new FileOutputStream(novoArquivo);
        copiar(arquivoCarregado, saida);
    }

    private void copiar(InputStream origem, OutputStream destino) {
        int bite = 0;
        byte[] tamanhoMaximo = new byte[1024 * 8]; // 8KB
        try {
            // enquanto bytes forem sendo lidos
            while((bite = origem.read(tamanhoMaximo)) >= 0) {
                // pegue o byte lido e escreva no destino
                destino.write(tamanhoMaximo, 0, bite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
