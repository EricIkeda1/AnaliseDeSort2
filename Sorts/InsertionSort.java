public class InsertionSort {

    public static long comparacoes;
    public static long movimentacoes;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        int tamanho = vetor.length;

        for (int i = 1; i < tamanho; i++) {
            int chave = vetor[i];
            movimentacoes++;

            int j = i - 1;

            while (j >= 0) {
                comparacoes++;

                if (vetor[j] > chave) {
                    vetor[j + 1] = vetor[j];
                    movimentacoes++;
                    j--;
                } else {
                    break;
                }
            }

            vetor[j + 1] = chave;
            movimentacoes++;
        }
    }
}