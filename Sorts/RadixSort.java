public class RadixSort {

    public static long comparacoes;
    public static long movimentacoes;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        if (vetor.length == 0) return;

        int maior = encontrarMaior(vetor);

        for (int exp = 1; maior / exp > 0; exp *= 10) {
            countingSort(vetor, exp);
        }
    }

    private static int encontrarMaior(int[] vetor) {
        int maior = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            comparacoes++;

            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        return maior;
    }

    private static void countingSort(int[] vetor, int exp) {
        int tamanho = vetor.length;
        int[] saida = new int[tamanho];
        int[] contador = new int[10];

        for (int i = 0; i < tamanho; i++) {
            int indice = (vetor[i] / exp) % 10;
            contador[indice]++;
            movimentacoes++;
        }

        for (int i = 1; i < 10; i++) {
            contador[i] += contador[i - 1];
        }

        for (int i = tamanho - 1; i >= 0; i--) {
            int indice = (vetor[i] / exp) % 10;
            saida[contador[indice] - 1] = vetor[i];
            contador[indice]--;
            movimentacoes++;
        }

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = saida[i];
            movimentacoes++;
        }
    }
}