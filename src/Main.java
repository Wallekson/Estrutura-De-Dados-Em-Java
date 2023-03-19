import com.projeto.atribuicaoreferencia.MeuObj;

public class Main {
    public static void main(String[] args){

        int intA = 1;
        int intB = intA;

        System.out.println("intA= " + intA + " intB= " + intB);
        intA = 2; // tipos primitivos o Java copia extamente o valor em memória
        System.out.println("intA= " + intA + " intB= " + intB); // Ou seja intA passa a ser 2 e intB continua como 1

        MeuObj objA = new MeuObj(1);
        MeuObj objB = objA; // estão apontando para o mesmo endereço de memória MeuObj
        System.out.println("ObjA= " + objA + " ObjB= " + objB);
        objA.setNum(2); // em objetos o Java copia a referecia e não o valor em memória
        System.out.println("ObjA= " + objA + " ObjB= " + objB); // Ou seja objA passa ser 2 e objB tambem 2

    }
}