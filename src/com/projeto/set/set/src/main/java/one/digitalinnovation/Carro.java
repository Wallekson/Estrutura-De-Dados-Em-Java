package one.digitalinnovation;

import java.util.Objects;

public class Carro implements Comparable<Carro> {

    String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // testa se esse objeto é igual ao outro, se a referencia de memória é igual
        if (o == null || getClass() != o.getClass()) return false; // se o objeto é null, e se a classe dos dois são diferentes
        Carro carro = (Carro) o;
       return Objects.equals(marca, carro.marca);// compara se os dois são iguais

    }

    @Override
    public int hashCode() { //retorna o atributo
        return Objects.hash(marca);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Carro o) {
//        if (this.marca.length() < o.marca.length()){
//            return -1;
//        } else if (this.marca.length() > o.marca.length()) {
//            return 1;
//        }
//        return 0;
//    }

    @Override
    public int compareTo(Carro o) {
        return this.getMarca().compareTo(o.getMarca()); // comparando em ordem alfabetica
    }
}
