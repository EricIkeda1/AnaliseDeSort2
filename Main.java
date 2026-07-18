import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String[] arquivos = {
            "Dados/10000_ordenado.txt",
            "Dados/10000_desordenado.txt",
            "Dados/10000_inverso.txt",
            "Dados/100000_ordenado.txt",
            "Dados/100000_desordenado.txt",
            "Dados/100000_inverso.txt",
            "Dados/500000_ordenado.txt",
            "Dados/500000_desordenado.txt",
            "Dados/500000_inverso.txt",
            "Dados/1000000_ordenado.txt",
            "Dados/1000000_desordenado.txt",
            "Dados/1000000_inverso.txt"
    };

    static ArrayList<String> resultados = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = -1;

        do {
            System.out.println("\n========== ANÁLISE DE SORTS ==========");
            System.out.println("1 - Bubble Sort");
            System.out.println("2 - Selection Sort");
            System.out.println("3 - Insertion Sort");
            System.out.println("4 - Merge Sort");
            System.out.println("5 - Quick Sort");
            System.out.println("6 - Heap Sort");
            System.out.println("7 - Radix Sort");
            System.out.println("8 - Counting Sort");
            System.out.println("9 - Shell Sort");
            System.out.println("10 - Comb Sort");
            System.out.println("11 - Shaker Sort");
            System.out.println("12 - Gnome Sort");
            System.out.println("13 - Cocktail Sort");
            System.out.println("14 - Tim Sort");
            System.out.println("15 - Executar TODOS");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número de 0 a 15.");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    executarBubbleTodosArquivos();
                    break;
                case 2:
                    executarSelectionTodosArquivos();
                    break;
                case 3:
                    executarInsertionTodosArquivos();
                    break;
                case 4:
                    executarMergeTodosArquivos();
                    break;
                case 5:
                    executarQuickTodosArquivos();
                    break;
                case 6:
                    executarHeapTodosArquivos();
                    break;
                case 7:
                    executarRadixTodosArquivos();
                    break;
                case 8:
                    executarCountingTodosArquivos();
                    break;
                case 9:
                    executarShellTodosArquivos();
                    break;
                case 10:
                    executarCombTodosArquivos();
                    break;
                case 11:
                    executarShakerTodosArquivos();
                    break;
                case 12:
                    executarGnomeTodosArquivos();
                    break;
                case 13:
                    executarCocktailTodosArquivos();
                    break;
                case 14:
                    executarTimTodosArquivos();
                    break;
                case 15:
                    executarTodos();
                    salvarResultados();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }

    public static void executarBubbleTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Bubble Sort", "O(n^2)", 1);
    }

    public static void executarSelectionTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Selection Sort", "O(n^2)", 2);
    }

    public static void executarInsertionTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Insertion Sort", "O(n^2)", 3);
    }

    public static void executarMergeTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Merge Sort", "O(n log n)", 4);
    }

    public static void executarQuickTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Quick Sort", "O(n log n)", 5);
    }

    public static void executarHeapTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Heap Sort", "O(n log n)", 6);
    }

    public static void executarRadixTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Radix Sort", "O(d(n + k))", 7);
    }

    public static void executarCountingTodosArquivos() {
        for (String caminho : arquivos) {
            System.out.println("========================================");
            System.out.println("Arquivo: " + obterNomeArquivo(caminho));
            System.out.println();
            executarCounting(caminho);
        }
    }

    public static void executarShellTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Shell Sort", "O(n log n) a O(n^2)", 8);
    }

    public static void executarCombTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Comb Sort", "O(n^2)", 9);
    }

    public static void executarShakerTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Shaker Sort", "O(n^2)", 10);
    }

    public static void executarGnomeTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Gnome Sort", "O(n^2)", 11);
    }

    public static void executarCocktailTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Cocktail Sort", "O(n^2)", 12);
    }

    public static void executarTimTodosArquivos() {
        executarAlgoritmoEmTodosOsArquivos("Tim Sort", "O(n log n)", 13);
    }

    private static void executarAlgoritmoEmTodosOsArquivos(String algoritmo, String complexidade, int tipoAlgoritmo) {
        for (String caminho : arquivos) {
            System.out.println("========================================");
            System.out.println("Arquivo: " + obterNomeArquivo(caminho));
            System.out.println();
            executarAlgoritmo(caminho, algoritmo, complexidade, tipoAlgoritmo);
        }
    }

    public static void executarTodos() {
        System.out.println("\nExecutando todos os algoritmos...\n");

        int totalPassos = arquivos.length;
        int passoAtual = 0;

        for (String caminho : arquivos) {
            String nomeArquivo = obterNomeArquivo(caminho);

            System.out.println("========================================");
            System.out.println("Arquivo: " + nomeArquivo);
            System.out.println();

            executarAlgoritmo(caminho, "Bubble Sort", "O(n^2)", 1);
            executarAlgoritmo(caminho, "Selection Sort", "O(n^2)", 2);
            executarAlgoritmo(caminho, "Insertion Sort", "O(n^2)", 3);
            executarAlgoritmo(caminho, "Merge Sort", "O(n log n)", 4);
            executarAlgoritmo(caminho, "Quick Sort", "O(n log n)", 5);
            executarAlgoritmo(caminho, "Heap Sort", "O(n log n)", 6);
            executarAlgoritmo(caminho, "Radix Sort", "O(d(n + k))", 7);
            executarCounting(caminho);
            executarAlgoritmo(caminho, "Shell Sort", "O(n log n) a O(n^2)", 8);
            executarAlgoritmo(caminho, "Comb Sort", "O(n^2)", 9);
            executarAlgoritmo(caminho, "Shaker Sort", "O(n^2)", 10);
            executarAlgoritmo(caminho, "Gnome Sort", "O(n^2)", 11);
            executarAlgoritmo(caminho, "Cocktail Sort", "O(n^2)", 12);
            executarAlgoritmo(caminho, "Tim Sort", "O(n log n)", 13);

            passoAtual++;
            mostrarProgresso(passoAtual, totalPassos);
            System.out.println();
        }
    }

    private static void mostrarProgresso(int atual, int total) {
        int porcentagem = (int) ((atual * 100.0) / total);
        int barras = porcentagem / 5;

        StringBuilder sb = new StringBuilder();
        sb.append("\rCarregando: [");

        for (int i = 0; i < 20; i++) {
            if (i < barras) sb.append("█");
            else sb.append("-");
        }

        sb.append("] ").append(porcentagem).append("%");
        System.out.print(sb.toString());

        if (atual == total) {
            System.out.println();
        }
    }

    private static void executarAlgoritmo(String caminho, String algoritmo, String complexidade, int tipoAlgoritmo) {
        int[] vetor = LeituraDados.lerArquivo(caminho);
        if (vetor == null || vetor.length == 0) return;

        int[] copia = LeituraDados.copiarVetor(vetor);

        switch (tipoAlgoritmo) {
            case 1:
                BubbleSort.comparacoes = 0;
                BubbleSort.movimentacoes = 0;
                break;
            case 2:
                SelectionSort.comparacoes = 0;
                SelectionSort.movimentacoes = 0;
                break;
            case 3:
                InsertionSort.comparacoes = 0;
                InsertionSort.movimentacoes = 0;
                break;
            case 4:
                MergeSort.comparacoes = 0;
                MergeSort.movimentacoes = 0;
                break;
            case 5:
                QuickSort.comparacoes = 0;
                QuickSort.movimentacoes = 0;
                break;
            case 6:
                HeapSort.comparacoes = 0;
                HeapSort.movimentacoes = 0;
                break;
            case 7:
                RadixSort.comparacoes = 0;
                RadixSort.movimentacoes = 0;
                break;
            case 8:
                ShellSort.comparacoes = 0;
                ShellSort.movimentacoes = 0;
                break;
            case 9:
                CombSort.comparacoes = 0;
                CombSort.movimentacoes = 0;
                break;
            case 10:
                ShakerSort.comparacoes = 0;
                ShakerSort.movimentacoes = 0;
                break;
            case 11:
                GnomeSort.comparacoes = 0;
                GnomeSort.movimentacoes = 0;
                break;
            case 12:
                CocktailSort.comparacoes = 0;
                CocktailSort.movimentacoes = 0;
                break;
            case 13:
                TimSort.comparacoes = 0;
                TimSort.movimentacoes = 0;
                break;
        }

        long inicio = System.nanoTime();

        switch (tipoAlgoritmo) {
            case 1:
                BubbleSort.ordenar(copia);
                break;
            case 2:
                SelectionSort.ordenar(copia);
                break;
            case 3:
                InsertionSort.ordenar(copia);
                break;
            case 4:
                MergeSort.ordenar(copia);
                break;
            case 5:
                QuickSort.ordenar(copia);
                break;
            case 6:
                HeapSort.ordenar(copia);
                break;
            case 7:
                RadixSort.ordenar(copia);
                break;
            case 8:
                ShellSort.ordenar(copia);
                break;
            case 9:
                CombSort.ordenar(copia);
                break;
            case 10:
                ShakerSort.ordenar(copia);
                break;
            case 11:
                GnomeSort.ordenar(copia);
                break;
            case 12:
                CocktailSort.ordenar(copia);
                break;
            case 13:
                TimSort.ordenar(copia);
                break;
        }

        long fim = System.nanoTime();
        double tempoMs = (fim - inicio) / 1_000_000.0;

        long comparacoes = 0;
        long movimentacoes = 0;
        boolean usarTrocas = false;

        switch (tipoAlgoritmo) {
            case 1:
                comparacoes = BubbleSort.comparacoes;
                movimentacoes = BubbleSort.movimentacoes;
                usarTrocas = true;
                break;
            case 2:
                comparacoes = SelectionSort.comparacoes;
                movimentacoes = SelectionSort.movimentacoes;
                usarTrocas = true;
                break;
            case 3:
                comparacoes = InsertionSort.comparacoes;
                movimentacoes = InsertionSort.movimentacoes;
                break;
            case 4:
                comparacoes = MergeSort.comparacoes;
                movimentacoes = MergeSort.movimentacoes;
                break;
            case 5:
                comparacoes = QuickSort.comparacoes;
                movimentacoes = QuickSort.movimentacoes;
                usarTrocas = true;
                break;
            case 6:
                comparacoes = HeapSort.comparacoes;
                movimentacoes = HeapSort.movimentacoes;
                usarTrocas = true;
                break;
            case 7:
                comparacoes = RadixSort.comparacoes;
                movimentacoes = RadixSort.movimentacoes;
                break;
            case 8:
                comparacoes = ShellSort.comparacoes;
                movimentacoes = ShellSort.movimentacoes;
                break;
            case 9:
                comparacoes = CombSort.comparacoes;
                movimentacoes = CombSort.movimentacoes;
                break;
            case 10:
                comparacoes = ShakerSort.comparacoes;
                movimentacoes = ShakerSort.movimentacoes;
                break;
            case 11:
                comparacoes = GnomeSort.comparacoes;
                movimentacoes = GnomeSort.movimentacoes;
                break;
            case 12:
                comparacoes = CocktailSort.comparacoes;
                movimentacoes = CocktailSort.movimentacoes;
                break;
            case 13:
                comparacoes = TimSort.comparacoes;
                movimentacoes = TimSort.movimentacoes;
                break;
        }

        imprimirResultado(algoritmo, complexidade, caminho, tempoMs, comparacoes, movimentacoes, usarTrocas);
    }

    private static void executarCounting(String caminho) {
        int[] vetor = LeituraDados.lerArquivo(caminho);
        if (vetor == null || vetor.length == 0) return;

        int[] copia = LeituraDados.copiarVetor(vetor);
        CountingSort countingSort = new CountingSort();

        long inicio = System.nanoTime();
        countingSort.ordenar(copia);
        long fim = System.nanoTime();

        double tempoMs = (fim - inicio) / 1_000_000.0;

        imprimirResultado(
                "Counting Sort",
                "O(n + k)",
                caminho,
                tempoMs,
                countingSort.getComparacoes(),
                countingSort.getMovimentacoes(),
                false
        );
    }

    private static void imprimirResultado(String algoritmo, String complexidade, String caminho, double tempoMs, long comparacoes, long movimentacoes, boolean usarTrocas) {
        StringBuilder sb = new StringBuilder();
        sb.append(algoritmo).append(" - ").append(complexidade).append("\n");
        sb.append(String.format(Locale.US, "Tempo: %.4f ms%n", tempoMs));
        sb.append("Comparações: ").append(comparacoes).append("\n");

        if (usarTrocas) {
            sb.append("Trocas: ").append(movimentacoes).append("\n\n");
        } else {
            sb.append("Movimentações: ").append(movimentacoes).append("\n\n");
        }

        String resultado = sb.toString();
        System.out.print(resultado);
        resultados.add("Arquivo: " + obterNomeArquivo(caminho) + "\n\n" + resultado);
    }

    private static String obterNomeArquivo(String caminho) {
        String nome = caminho.replace("\\", "/");
        return nome.substring(nome.lastIndexOf('/') + 1);
    }

    public static void salvarResultados() {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado para salvar.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resultados.txt"))) {
            for (String resultado : resultados) {
                bw.write("========================================\n");
                bw.write(resultado);
            }
            System.out.println("Arquivo resultados.txt gerado com sucesso.");
            resultados.clear();
        } catch (IOException e) {
            System.out.println("Erro ao salvar resultados: " + e.getMessage());
        }
    }
}