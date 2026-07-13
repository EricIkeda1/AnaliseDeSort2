public class SelectionSort {

    public static long comparacoes;
    public static long movimentacoes;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        int tamanho = vetor.length;

        for (int i = 0; i < tamanho - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < tamanho; j++) {
                comparacoes++;

                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            if (menor != i) {
                int aux = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = aux;

                movimentacoes += 3;
            }
        }
    }
}