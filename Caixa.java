public class Caixa {

    private String algoritmo;
    private String arquivo;
    private long comparacoes;
    private long movimentacoes;
    private double tempo;

    public Caixa() {
    }

    public Caixa(String algoritmo, String arquivo, long comparacoes, long movimentacoes, double tempo) {
        this.algoritmo = algoritmo;
        this.arquivo = arquivo;
        this.comparacoes = comparacoes;
        this.movimentacoes = movimentacoes;
        this.tempo = tempo;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(long comparacoes) {
        this.comparacoes = comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(long movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Algoritmo: " + algoritmo +
                "\nArquivo: " + arquivo +
                "\nTempo: " + String.format("%.4f", tempo) + " ms" +
                "\nComparações: " + comparacoes +
                "\nMovimentações: " + movimentacoes;
    }
}