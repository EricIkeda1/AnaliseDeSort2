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
            System.out.println("9 - Executar TODOS");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número de 0 a 9.");
                scanner.nextLine();
                opcao = -1;
                continue;
            }

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
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Bubble Sort");
        }
    }

    public static void executarSelectionTodosArquivos() {
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Selection Sort");
        }
    }

    public static void executarInsertionTodosArquivos() {
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Insertion Sort");
        }
    }

    public static void executarMergeTodosArquivos() {
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Merge Sort");
        }
    }

    public static void executarQuickTodosArquivos() {
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Quick Sort");
        }
    }

    public static void executarHeapTodosArquivos() {
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Heap Sort");
        }
    }

    public static void executarRadixTodosArquivos() {
        for (String caminho : arquivos) {
            executarUmArquivo(caminho, "Radix Sort");
        }
    }

    public static void executarCountingTodosArquivos() {
        for (String caminho : arquivos) {
            executarCountingArquivo(caminho);
        }
    }

    public static void executarTodos() {
        System.out.println("\nExecutando todos os algoritmos...\n");

        for (String caminho : arquivos) {
            String nomeArquivo = caminho.replace("\\", "/");
            nomeArquivo = nomeArquivo.substring(nomeArquivo.lastIndexOf('/') + 1);

            System.out.println("========================================");
            System.out.println("Arquivo: " + nomeArquivo);
            System.out.println();

            executarUmArquivo(caminho, "Bubble Sort");
            executarUmArquivo(caminho, "Selection Sort");
            executarUmArquivo(caminho, "Insertion Sort");
            executarUmArquivo(caminho, "Merge Sort");
            executarUmArquivo(caminho, "Quick Sort");
            executarUmArquivo(caminho, "Heap Sort");
            executarUmArquivo(caminho, "Radix Sort");
            executarCountingArquivo(caminho);

            System.out.println();
        }
    }

    private static void executarUmArquivo(String caminho, String algoritmo) {
        int[] vetor = LeituraDados.lerArquivo(caminho);
        if (vetor == null || vetor.length == 0) return;

        int[] copia = LeituraDados.copiarVetor(vetor);

        long inicio = System.nanoTime();
        long comparacoes = 0;
        long movimentacoes = 0;
        boolean usarTrocas = false;

        if (algoritmo.equals("Bubble Sort")) {
            BubbleSort.comparacoes = 0;
            BubbleSort.movimentacoes = 0;
            BubbleSort.ordenar(copia);
            comparacoes = BubbleSort.comparacoes;
            movimentacoes = BubbleSort.movimentacoes;
            usarTrocas = true;
        } else if (algoritmo.equals("Selection Sort")) {
            SelectionSort.comparacoes = 0;
            SelectionSort.movimentacoes = 0;
            SelectionSort.ordenar(copia);
            comparacoes = SelectionSort.comparacoes;
            movimentacoes = SelectionSort.movimentacoes;
            usarTrocas = true;
        } else if (algoritmo.equals("Insertion Sort")) {
            InsertionSort.comparacoes = 0;
            InsertionSort.movimentacoes = 0;
            InsertionSort.ordenar(copia);
            comparacoes = InsertionSort.comparacoes;
            movimentacoes = InsertionSort.movimentacoes;
        } else if (algoritmo.equals("Merge Sort")) {
            MergeSort.comparacoes = 0;
            MergeSort.movimentacoes = 0;
            MergeSort.ordenar(copia);
            comparacoes = MergeSort.comparacoes;
            movimentacoes = MergeSort.movimentacoes;
        } else if (algoritmo.equals("Quick Sort")) {
            QuickSort.comparacoes = 0;
            QuickSort.movimentacoes = 0;
            QuickSort.ordenar(copia);
            comparacoes = QuickSort.comparacoes;
            movimentacoes = QuickSort.movimentacoes;
            usarTrocas = true;
        } else if (algoritmo.equals("Heap Sort")) {
            HeapSort.comparacoes = 0;
            HeapSort.movimentacoes = 0;
            HeapSort.ordenar(copia);
            comparacoes = HeapSort.comparacoes;
            movimentacoes = HeapSort.movimentacoes;
            usarTrocas = true;
        } else if (algoritmo.equals("Radix Sort")) {
            RadixSort.comparacoes = 0;
            RadixSort.movimentacoes = 0;
            RadixSort.ordenar(copia);
            comparacoes = RadixSort.comparacoes;
            movimentacoes = RadixSort.movimentacoes;
        }

        long fim = System.nanoTime();
        double tempoMs = (fim - inicio) / 1_000_000.0;

        imprimirResultado(algoritmo, caminho, tempoMs, comparacoes, movimentacoes, usarTrocas);
    }

    private static void executarCountingArquivo(String caminho) {
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
                caminho,
                tempoMs,
                countingSort.getComparacoes(),
                countingSort.getMovimentacoes(),
                false
        );
    }

    private static void imprimirResultado(String algoritmo, String caminho, double tempoMs, long comparacoes, long movimentacoes, boolean usarTrocas) {
        StringBuilder sb = new StringBuilder();
        sb.append(algoritmo).append("\n");
        sb.append(String.format(Locale.US, "Tempo: %.4f ms%n", tempoMs));
        sb.append("Comparações: ").append(comparacoes).append("\n");

        if (usarTrocas) {
            sb.append("Trocas: ").append(movimentacoes).append("\n\n");
        } else {
            sb.append("Movimentações: ").append(movimentacoes).append("\n\n");
        }

        String resultado = sb.toString();
        System.out.print(resultado);
        resultados.add("Arquivo: " + obterNomeArquivo(caminho) + "\n" + resultado);
    }

    private static String obterNomeArquivo(String caminho) {
        String nomeArquivo = caminho.replace("\\", "/");
        return nomeArquivo.substring(nomeArquivo.lastIndexOf('/') + 1);
    }

    public static void salvarResultados() {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado para salvar.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resultados.txt"))) {
            String arquivoAtual = "";
            for (String resultado : resultados) {
                if (!resultado.startsWith("Arquivo: " + arquivoAtual)) {
                    bw.write("========================================\n");
                }
                bw.write(resultado);
            }
            System.out.println("Arquivo resultados.txt gerado com sucesso.");
            resultados.clear();
        } catch (IOException e) {
            System.out.println("Erro ao salvar resultados: " + e.getMessage());
        }
    }
}