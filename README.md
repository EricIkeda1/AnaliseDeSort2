# Análise Comparativa de Algoritmos de Ordenação II

Projeto desenvolvido em Java para comparar o desempenho de diferentes algoritmos de ordenação utilizando conjuntos de dados de diversos tamanhos e organizações.

## Objetivo

Avaliar o desempenho dos algoritmos de ordenação por meio de métricas como:

- Tempo de execução
- Número de comparações
- Número de movimentações (quando aplicável)

Os testes são realizados utilizando arquivos contendo dados ordenados, desordenados e em ordem inversa.

## Algoritmos Implementados

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort
- Heap Sort
- Counting Sort
- Radix Sort

## Estrutura do Projeto

```text
AnaliseDeSort2/
├── Dados/
│   ├── 10000_ordenado.txt
│   ├── 10000_desordenado.txt
│   ├── 10000_inverso.txt
│   ├── 100000_ordenado.txt
│   ├── ...
│   └── 1000000_inverso.txt
│
├── Sorts/
│   ├── BubbleSort.java
│   ├── CountingSort.java
│   ├── HeapSort.java
│   ├── InsertionSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   ├── RadixSort.java
│   └── SelectionSort.java
│
├── Caixa.java
├── LeituraDados.java
├── Main.java
└── README.md
```

## Conjuntos de Dados

O projeto utiliza arquivos de entrada contendo:

### Tamanhos

- 10.000 elementos
- 100.000 elementos
- 500.000 elementos
- 1.000.000 elementos

### Tipos de Entrada

- Ordenado
- Desordenado
- Ordem inversa

## Tecnologias Utilizadas

- Java
- Estrutura de Dados
- Manipulação de arquivos (.txt)

## Como Executar

1. Clone o repositório.

```bash
git clone https://github.com/EricIkeda1/AnaliseDeSort2.git
```

2. Abra o projeto em uma IDE compatível com Java.

3. Certifique-se de que a pasta `Dados` esteja na raiz do projeto.

4. Execute o arquivo `Main.java`.

## Saída

Ao executar o programa, são exibidas informações como:

- Algoritmo utilizado
- Arquivo analisado
- Tempo de execução
- Número de comparações
- Número de movimentações ou trocas

Esses resultados permitem comparar a eficiência de cada algoritmo em diferentes cenários de entrada.

## Autor
EricIkeda1
