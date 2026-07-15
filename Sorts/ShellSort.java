public class ShellSort {
    public static long comparacoes = 0;
    public static long movimentacoes = 0;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        int n = vetor.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = vetor[i];
                int j = i;

                while (j >= gap) {
                    comparacoes++;
                    if (vetor[j - gap] > temp) {
                        vetor[j] = vetor[j - gap];
                        movimentacoes++;
                        j -= gap;
                    } else {
                        break;
                    }
                }

                vetor[j] = temp;
                movimentacoes++;
            }
        }
    }
}