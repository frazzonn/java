import java.util.Random;

public class Experimento {

    static final int CAPACIDADE = 100000;
    static final int EXECUCOES = 100;

    public static void main(String[] args) {

        executarExperimento(true);   // crescente
        executarExperimento(false);  // decrescente

    }

    public static void executarExperimento(boolean crescente) {

        long[] tempos = new long[EXECUCOES];
        Random random = new Random();

        for (int i = 0; i < EXECUCOES; i++) {

            ArranjoOrdenado arr = new ArranjoOrdenado(CAPACIDADE, crescente);

            long T1 = System.nanoTime();

            for (int j = 0; j < CAPACIDADE; j++) {

                int valor = random.nextInt(100000);

                arr.inserir(valor);
            }

            long T2 = System.nanoTime();

            tempos[i] = T2 - T1;
        }

        calcularEstatisticas(tempos, crescente);
    }

    public static void calcularEstatisticas(long[] tempos, boolean crescente) {

        double soma = 0;

        for (long t : tempos) {
            soma += t;
        }

        double media = soma / tempos.length;

        double somaQuadrados = 0;

        for (long t : tempos) {
            somaQuadrados += Math.pow(t - media, 2);
        }

        double desvioPadrao = Math.sqrt(somaQuadrados / tempos.length);

        System.out.println("\nOrdenação: " + (crescente ? "Crescente" : "Decrescente"));
        System.out.println("Tempo médio: " + media);
        System.out.println("Desvio padrão: " + desvioPadrao);
    }
}