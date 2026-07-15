public class CocktailSort {
    public static long comparacoes = 0;
    public static long movimentacoes = 0;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        boolean trocou = true;
        int inicio = 0;
        int fim = vetor.length - 1;

        while (trocou) {
            trocou = false;

            for (int i = inicio; i < fim; i++) {
                comparacoes++;
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    movimentacoes += 3;
                    trocou = true;
                }
            }

            if (!trocou) break;
            fim--;
            trocou = false;

            for (int i = fim; i > inicio; i--) {
                comparacoes++;
                if (vetor[i - 1] > vetor[i]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = temp;
                    movimentacoes += 3;
                    trocou = true;
                }
            }

            inicio++;
        }
    }
}