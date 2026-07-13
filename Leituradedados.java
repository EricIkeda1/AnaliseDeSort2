import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leituradedados {

    public static int[] lerArquivo(String caminho) {
        ArrayList<Integer> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] numeros = linha.split(",");

                for (String numero : numeros) {
                    numero = numero.trim();
                    if (numero.isEmpty()) continue;

                    try {
                        lista.add(Integer.parseInt(numero));
                    } catch (NumberFormatException e) {
                        // ignora valor inválido
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + caminho + " - " + e.getMessage());
            return new int[0];
        }

        int[] vetor = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            vetor[i] = lista.get(i);
        }

        return vetor;
    }

    public static int[] copiarVetor(int[] vetor) {
        int[] copia = new int[vetor.length];
        System.arraycopy(vetor, 0, copia, 0, vetor.length);
        return copia;
    }
}