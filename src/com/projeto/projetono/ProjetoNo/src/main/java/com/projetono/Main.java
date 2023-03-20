package com.projetono;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        No<String> no1 = new No<>("Conteudo no1");

        No<String> no2 = new No<>("Conteudo no2");
        no1.setProximoNo(no2);  // Referencia nó apontando do nó 1 para o 2

        No<String> no3 = new No<>("Conteudo no3");
        no2.setProximoNo(no3);  // Referencia nó apontando do nó 2 para o 3

        No<String> no4 = new No<>("Conteudo no4");
        no3.setProximoNo(no4);  // Referencia nó apontando do nó 3 para o 4

        // no1 -> no2 -> no3 -> no4 -> null

        System.out.println(no1);
        System.out.println(no1.getProximoNo()); // como get conseguimos imprimir o proximo nó
        System.out.println(no2);

        System.out.println("-----------------------");

        System.out.println(no1);
        System.out.println(no1.getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo().getProximoNo());
        System.out.println(no1.getProximoNo().getProximoNo().getProximoNo().getProximoNo());

    }
}
