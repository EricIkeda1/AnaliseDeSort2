public class HeapSort {

    public static long comparacoes;
    public static long movimentacoes;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        int tamanho = vetor.length;

        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(vetor, tamanho, i);
        }

        for (int i = tamanho - 1; i > 0; i--) {
            trocar(vetor, 0, i);
            heapify(vetor, i, 0);
        }
    }

    private static void heapify(int[] vetor, int tamanho, int raiz) {
        int maior = raiz;
        int esquerda = 2 * raiz + 1;
        int direita = 2 * raiz + 2;

        if (esquerda < tamanho) {
            comparacoes++;
            if (vetor[esquerda] > vetor[maior]) {
                maior = esquerda;
            }
        }

        if (direita < tamanho) {
            comparacoes++;
            if (vetor[direita] > vetor[maior]) {
                maior = direita;
            }
        }

        if (maior != raiz) {
            trocar(vetor, raiz, maior);
            heapify(vetor, tamanho, maior);
        }
    }

    private static void trocar(int[] vetor, int i, int j) {
        if (i == j) return;

        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;

        movimentacoes += 3;
    }
}