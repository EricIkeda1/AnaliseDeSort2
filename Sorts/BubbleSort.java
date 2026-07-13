public class BubbleSort {

    public static long comparacoes;
    public static long movimentacoes;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        boolean trocou;

        for (int i = 0; i < vetor.length - 1; i++) {
            trocou = false;

            for (int j = 0; j < vetor.length - 1 - i; j++) {
                comparacoes++;

                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;

                    movimentacoes += 3;
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }
}