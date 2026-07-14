public class CountingSort {

    private long comparacoes;
    private long movimentacoes;

    public void ordenar(int[] vetor) {
        comparacoes = 0;
        movimentacoes = 0;

        if (vetor == null || vetor.length < 2) return;

        int maior = vetor[0];
        int menor = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            comparacoes += 2;

            if (vetor[i] > maior) {
                maior = vetor[i];
            }

            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        int range = maior - menor + 1;
        int[] contagem = new int[range];
        int[] saida = new int[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            contagem[vetor[i] - menor]++;
            movimentacoes++;
        }

        for (int i = 1; i < range; i++) {
            contagem[i] += contagem[i - 1];
            comparacoes++;
        }

        for (int i = vetor.length - 1; i >= 0; i--) {
            int indice = vetor[i] - menor;
            saida[contagem[indice] - 1] = vetor[i];
            contagem[indice]--;
            movimentacoes++;
        }

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = saida[i];
            movimentacoes++;
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public void resetar() {
        comparacoes = 0;
        movimentacoes = 0;
    }
}