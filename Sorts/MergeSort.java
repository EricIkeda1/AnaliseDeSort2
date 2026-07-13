public class MergeSort {

    public static long comparacoes;
    public static long movimentacoes;

    public static void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        if (vetor.length > 1) {
            mergeSort(vetor, 0, vetor.length - 1);
        }
    }

    private static void mergeSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);

            merge(vetor, esquerda, meio, direita);
        }
    }

    private static void merge(int[] vetor, int esquerda, int meio, int direita) {
        int tamanhoEsquerda = meio - esquerda + 1;
        int tamanhoDireita = direita - meio;

        int[] vetorEsquerda = new int[tamanhoEsquerda];
        int[] vetorDireita = new int[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {
            vetorEsquerda[i] = vetor[esquerda + i];
            movimentacoes++;
        }

        for (int j = 0; j < tamanhoDireita; j++) {
            vetorDireita[j] = vetor[meio + 1 + j];
            movimentacoes++;
        }

        int i = 0;
        int j = 0;
        int k = esquerda;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            comparacoes++;

            if (vetorEsquerda[i] <= vetorDireita[j]) {
                vetor[k] = vetorEsquerda[i];
                i++;
            } else {
                vetor[k] = vetorDireita[j];
                j++;
            }

            movimentacoes++;
            k++;
        }

        while (i < tamanhoEsquerda) {
            vetor[k] = vetorEsquerda[i];
            i++;
            k++;
            movimentacoes++;
        }

        while (j < tamanhoDireita) {
            vetor[k] = vetorDireita[j];
            j++;
            k++;
            movimentacoes++;
        }
    }
}