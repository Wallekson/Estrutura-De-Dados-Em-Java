package one.digitalinnovation;

public class Main {

    public static void main(String[] args) {

        Fila<String> minhaFila = new Fila<>(); //dessa forma instanciamos a fila para enfileirar apenas Strings

        minhaFila.enqueue("primeiro");
        //minhaFila.enqueue(new No("primeiro")); antes de refatorar
        minhaFila.enqueue("segundo");
        minhaFila.enqueue("terceiro");
        minhaFila.enqueue("quarto");

        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());

        System.out.println(minhaFila);

        minhaFila.enqueue("ultimo");

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());

        System.out.println(minhaFila);
    }
}
