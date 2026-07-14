import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraDados {

    public static int[] lerArquivo(String caminho) {
        ArrayList<Integer> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] partes = linha.split(",");
                for (String parte : partes) {
                    parte = parte.trim();
                    if (!parte.isEmpty()) {
                        lista.add(Integer.parseInt(parte));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao ler arquivo " + caminho + ": " + e.getMessage());
            return new int[0];
        }

        int[] resultado = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            resultado[i] = lista.get(i);
        }
        return resultado;
    }

    public static int[] copiarVetor(int[] original) {
        if (original == null) return new int[0];
        int[] copia = new int[original.length];
        System.arraycopy(original, 0, copia, 0, original.length);
        return copia;
    }
}