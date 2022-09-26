
/**************************************************
 * Arquitetura de Computadores - Exercicio 3 
 * 
 * ULA 4bits
 * 
 * Integrantes: Barbara Luciano, Daniel da Silveira,
 * Erick Gonzaga, Frederico Malaquias, Luan Tadeu 
 * e Luisa Nogueira
**************************************************/

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Software {
    public static void main(String[] args) throws Exception {

        // --- ler o arquivo ---
        FileReader arq = new FileReader("testeula.ula");
        BufferedReader readArq = new BufferedReader(arq);

        // --- escrever no arquivo executavel --- 
        FileWriter out = new FileWriter("testeula.hex");
        BufferedWriter saida = new BufferedWriter(out);

        // --- variaveis ---
        String vetor[] = { "An", "nAoB", "AnB", "zeroL", "nAeB", "Bn", "AxB", "ABn", "AnoB", "nAxB", "copiaB", "AB",
            "umL", "AoBn", "AoB", "copiaA" }; // vetor que armazena as opções de operações
        String x = ""; // armazena A
        String y = ""; // armazena B

        try {
            String linha = readArq.readLine(); // armazena e le a primeira linha

            // --- loop para ler a entrada toda (enquanto nao tiver a palavra fim.) ---
            while (!linha.contains("fim.")) {
                linha = readArq.readLine(); // ler linha

                if (linha.charAt(0) == 'W') {
                    String w = ""; // armazena a operação
                    int i = 2; // contador

                    // pega tudo entre '=' e ';' e armazena em w
                    while (linha.charAt(i) != ';') {
                        w += linha.charAt(i);
                        i++;
                    }

                    int index = 0; // armazena a posição da operação de w no vetor

                    // --- percorre o vetor ---
                    for (int j = 0; j < vetor.length; j++) {

                        if (vetor[j].contains(w)) {
                            index = j;
                        }
                    }

                    w = convertHexa(Integer.toString(index)); // resposta é a posição em que a operação aparece no vetor

                    saida.write(x + y + w + "\n"); // escreve no arquivo executavel .hex

                } else if (linha.charAt(0) == 'X') {
                    x = convertHexa(linha.charAt(2) + "");
                } else if (linha.charAt(0) == 'Y') {
                    y = convertHexa(linha.charAt(2) + "");
                }
            }

        } catch (IOException except) {
            except.printStackTrace();
        }

        // --- fechar os arquivos ---
        arq.close();
        saida.close();

    }

    // --- converte de decimal para hexadecimal ---

    public static String convertHexa(String s) {

        if (s.contains("10")) {
            s = "A";
        } else if (s.contains("11")) {
            s = "B";
        } else if (s.contains("12")) {
            s = "C";
        } else if (s.contains("13")) {
            s = "D";
        } else if (s.contains("14")) {
            s = "E";
        } else if (s.contains("15")) {
            s = "F";
        }

        return s;
    }


}