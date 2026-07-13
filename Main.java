import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        int opcao;

        do {
            System.out.println("\n========== ANÁLISE DE SORTS ==========");
            System.out.println("1 - Bubble Sort");
            System.out.println("2 - Selection Sort");
            System.out.println("3 - Insertion Sort");
            System.out.println("4 - Merge Sort");
            System.out.println("5 - Quick Sort");
            System.out.println("6 - Heap Sort");
            System.out.println("7 - Radix Sort");
            System.out.println("8 - Executar TODOS");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha: ");

            try {
                opcao = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida.");
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
                    executarTodos();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    salvarResultados();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void executarBubbleTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            BubbleSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Bubble Sort", caminho, BubbleSort.comparacoes, BubbleSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarSelectionTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            SelectionSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Selection Sort", caminho, SelectionSort.comparacoes, SelectionSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarInsertionTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            InsertionSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Insertion Sort", caminho, InsertionSort.comparacoes, InsertionSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarMergeTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            MergeSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Merge Sort", caminho, MergeSort.comparacoes, MergeSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarQuickTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            QuickSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Quick Sort", caminho, QuickSort.comparacoes, QuickSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarHeapTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            HeapSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Heap Sort", caminho, HeapSort.comparacoes, HeapSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarRadixTodosArquivos() {
        for (String caminho : arquivos) {
            int[] vetor = Leituradedados.lerArquivo(caminho);
            if (vetor.length == 0) continue;

            int[] copia = Leituradedados.copiarVetor(vetor);

            long inicio = System.nanoTime();
            RadixSort.ordenar(copia);
            long fim = System.nanoTime();

            double tempoMs = (fim - inicio) / 1_000_000.0;

            Caixa caixa = new Caixa("Radix Sort", caminho, RadixSort.comparacoes, RadixSort.movimentacoes, tempoMs);
            System.out.println(caixa);
            System.out.println("-----------------------------------");

            resultados.add(caixa.toString());
        }
    }

    public static void executarTodos() {
        executarBubbleTodosArquivos();
        executarSelectionTodosArquivos();
        executarInsertionTodosArquivos();
        executarMergeTodosArquivos();
        executarQuickTodosArquivos();
        executarHeapTodosArquivos();
        executarRadixTodosArquivos();
    }

    public static void salvarResultados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resultados.txt"))) {
            for (String resultado : resultados) {
                bw.write(resultado);
                bw.newLine();
                bw.newLine();
            }
            System.out.println("Arquivo resultados.txt gerado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar resultados: " + e.getMessage());
        }
    }
}