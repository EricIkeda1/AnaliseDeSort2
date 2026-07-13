import java.util.Random;

public class QuickSort {

    public static long comparacoes;
    public static long movimentacoes;

    private static final Random random = new Random();

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        if (vetor.length > 1) {
            quickSort(vetor, 0, vetor.length - 1);
        }
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = inicio + random.nextInt(fim - inicio + 1);

            trocar(vetor, indicePivo, fim);

            int pivo = particionar(vetor, inicio, fim);

            quickSort(vetor, inicio, pivo - 1);
            quickSort(vetor, pivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            comparacoes++;

            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }

        trocar(vetor, i + 1, fim);

        return i + 1;
    }

    private static void trocar(int[] vetor, int i, int j) {
        if (i == j) return;

        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;

        movimentacoes += 3;
    }
}