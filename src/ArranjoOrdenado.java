public class ArranjoOrdenado {

    private int[] dados;
    private int tamanho;
    private boolean crescente;

    public ArranjoOrdenado(int capacidade, boolean crescente) {
        dados = new int[capacidade];
        tamanho = 0;
        this.crescente = crescente;
    }

    public void inserir(int valor) {

        int i = tamanho - 1;

        if (crescente) {

            while (i >= 0 && dados[i] > valor) {
                dados[i + 1] = dados[i];
                i--;
            }

        } else {

            while (i >= 0 && dados[i] < valor) {
                dados[i + 1] = dados[i];
                i--;
            }

        }

        dados[i + 1] = valor;
        tamanho++;
    }

    public void excluir(int valor) {

        int pos = -1;

        for (int i = 0; i < tamanho; i++) {
            if (dados[i] == valor) {
                pos = i;
                break;
            }
        }

        if (pos != -1) {

            for (int i = pos; i < tamanho - 1; i++) {
                dados[i] = dados[i + 1];
            }

            tamanho--;
        }
    }

    public int tamanho() {
        return tamanho;
    }

}