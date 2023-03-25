package one.digitalinnovation;

import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {

        Queue<Carro> queueCarros = new LinkedList();


        queueCarros.add(new Carro("Ford"));
        queueCarros.add(new Carro("Chevrolet"));
        queueCarros.add(new Carro("Fiat"));

        System.out.println(queueCarros.add(new Carro("Peugeout"))); // adiciona, porem se não adicionar da um erro
        System.out.println(queueCarros);

        System.out.println(queueCarros.offer(new Carro("Renault"))); // adiciona, porem se não adicionar retorna false
        System.out.println(queueCarros);

        System.out.println(queueCarros.peek()); // pega o primeiro elemento da fila, porem não remove
        System.out.println(queueCarros);

        System.out.println(queueCarros.poll()); // retira o primeiro elemento da fila
        System.out.println(queueCarros);

        System.out.println(queueCarros.isEmpty()); // se a fila esta vazia

        System.out.println(queueCarros.size()); //tamanho

    }

}
