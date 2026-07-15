public class GnomeSort {
    public static long comparacoes = 0;
    public static long movimentacoes = 0;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        int i = 1;

        while (i < vetor.length) {
            comparacoes++;
            if (i == 0 || vetor[i] >= vetor[i - 1]) {
                i++;
            } else {
                int temp = vetor[i];
                vetor[i] = vetor[i - 1];
                vetor[i - 1] = temp;
                movimentacoes += 3;
                i--;
            }
        }
    }
}