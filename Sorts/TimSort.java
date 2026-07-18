public class TimSort {

    public static long comparacoes = 0;
    public static long movimentacoes = 0;
    private static final int MIN_RUN = 32;

    public static void ordenar(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        int minRun = calcularMinRun(n);

        for (int i = 0; i < n; i += minRun) {
            int fim = Math.min(i + minRun - 1, n - 1);
            insertionSort(arr, i, fim);
        }

        for (int tamanho = minRun; tamanho < n; tamanho *= 2) {
            for (int esquerda = 0; esquerda < n; esquerda += 2 * tamanho) {
                int meio = Math.min(esquerda + tamanho - 1, n - 1);
                int direita = Math.min(esquerda + 2 * tamanho - 1, n - 1);

                if (meio < direita) {
                    merge(arr, esquerda, meio, direita);
                }
            }
        }
    }

    private static int calcularMinRun(int n) {
        int r = 0;
        while (n >= MIN_RUN) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    private static void insertionSort(int[] arr, int esquerda, int direita) {
        for (int i = esquerda + 1; i <= direita; i++) {
            int chave = arr[i];
            int j = i - 1;

            while (j >= esquerda) {
                comparacoes++;
                if (arr[j] <= chave) {
                    break;
                }
                arr[j + 1] = arr[j];
                movimentacoes++;
                j--;
            }

            arr[j + 1] = chave;
            movimentacoes++;
        }
    }

    private static void merge(int[] arr, int esquerda, int meio, int direita) {
        int tam1 = meio - esquerda + 1;
        int tam2 = direita - meio;

        int[] left = new int[tam1];
        int[] right = new int[tam2];

        for (int i = 0; i < tam1; i++) {
            left[i] = arr[esquerda + i];
            movimentacoes++;
        }

        for (int j = 0; j < tam2; j++) {
            right[j] = arr[meio + 1 + j];
            movimentacoes++;
        }

        int i = 0, j = 0, k = esquerda;

        while (i < tam1 && j < tam2) {
            comparacoes++;
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
            movimentacoes++;
        }

        while (i < tam1) {
            arr[k++] = left[i++];
            movimentacoes++;
        }

        while (j < tam2) {
            arr[k++] = right[j++];
            movimentacoes++;
        }
    }
}