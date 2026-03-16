public class ArranjoOrdenado {

    private int[] elementos;
    private int tamanho;
    private boolean crescente;

    public ArranjoOrdenado(int capacidade, boolean crescente) {
        elementos = new int[capacidade];
        tamanho = 0;
        this.crescente = crescente;
    }

    public void inserir(int valor) {

        if (tamanho == elementos.length) return;

        int i = tamanho - 1;

        if (crescente) {

            while (i >= 0 && elementos[i] > valor) {
                elementos[i + 1] = elementos[i];
                i--;
            }

        } else {

            while (i >= 0 && elementos[i] < valor) {
                elementos[i + 1] = elementos[i];
                i--;
            }

        }

        elementos[i + 1] = valor;
        tamanho++;
    }

    public int tamanho() {
        return tamanho;
    }
}