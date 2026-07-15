public class CombSort {
    public static long comparacoes = 0;
    public static long movimentacoes = 0;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        int gap = vetor.length;
        boolean trocou = true;

        while (gap > 1 || trocou) {
            gap = (gap * 10) / 13;
            if (gap < 1) gap = 1;

            trocou = false;

            for (int i = 0; i + gap < vetor.length; i++) {
                comparacoes++;
                if (vetor[i] > vetor[i + gap]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + gap];
                    vetor[i + gap] = temp;
                    movimentacoes += 3;
                    trocou = true;
                }
            }
        }
    }
}