public class TesteArranjo {

    public static void main(String[] args) {

        ArranjoOrdenado arr = new ArranjoOrdenado(10, true);

        arr.inserir(5);
        arr.inserir(2);
        arr.inserir(8);

        if(arr.tamanho() == 3){
            System.out.println("Teste passou");
        } else {
            System.out.println("Teste falhou");
        }

    }
}