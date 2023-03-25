package one.digitalinnovation;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Main{
    public static void main(String[] args) {

      Set<Carro> hashSetCarros = new HashSet<>(); // HashSet não preserva a ordem de inserção

      hashSetCarros.add(new Carro("Ford"));
      hashSetCarros.add(new Carro("Chevrolet"));
      hashSetCarros.add(new Carro("Fiat"));
      hashSetCarros.add(new Carro("Peugeot"));
      hashSetCarros.add(new Carro("Zip"));
      hashSetCarros.add(new Carro("Alpha Romeo"));

        System.out.println(hashSetCarros);

        Set<Carro> treeSetCarros = new TreeSet<>(); // como estamos tratando de arvores, precisamos adicionar o metodo compareTo
                                                    // no Carro.java implementamos o metodo compareTo e agora é possivel imprimir em ordem
        treeSetCarros.add(new Carro("Ford")); // conforme o tamanho da String
        treeSetCarros.add(new Carro("Chevrolet"));
        treeSetCarros.add(new Carro("Fiat"));
        treeSetCarros.add(new Carro("Peugeot"));
        treeSetCarros.add(new Carro("Zip"));
        treeSetCarros.add(new Carro("Alpha Romeo"));

        System.out.println(treeSetCarros);








    }

}
