import java.util.Random;

public class ExperimentoInsercao {

    static final int TAM = 100000;
    static final int EXEC = 100;

    public static void main(String[] args) {

        testarInsercao(true);
        testarInsercao(false);

    }

    public static void testarInsercao(boolean crescente) {

        long[] tempos = new long[EXEC];
        Random rand = new Random();

        for (int i = 0; i < EXEC; i++) {

            ArranjoOrdenado arr = new ArranjoOrdenado(TAM, crescente);

            long t1 = System.nanoTime();

            for (int j = 0; j < TAM; j++) {

                int valor = rand.nextInt(TAM);

                arr.inserir(valor);
            }

            long t2 = System.nanoTime();

            tempos[i] = t2 - t1;
        }

        calcular(tempos, crescente);
    }

    public static void calcular(long[] tempos, boolean crescente) {

        double soma = 0;

        for (long t : tempos) soma += t;

        double media = soma / tempos.length;

        double soma2 = 0;

        for (long t : tempos)
            soma2 += Math.pow(t - media, 2);

        double desvio = Math.sqrt(soma2 / tempos.length);

        System.out.println("\nOrdenação: " + (crescente ? "Crescente" : "Decrescente"));
        System.out.println("Média: " + media);
        System.out.println("Desvio: " + desvio);
    }

}