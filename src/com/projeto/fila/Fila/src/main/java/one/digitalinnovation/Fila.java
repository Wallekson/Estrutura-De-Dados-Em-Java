package one.digitalinnovation;
public class Fila<T> { // Generico Wild Card

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null; // a fila inicia vazia
    }

    public void enqueue(T object){ // novo objeto na fila
        // public void enqueue(No novoNo){ // novo objeto na fila
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila); // A referencia de entrada do novo nó era a referencia do antigo ultimo nó
        refNoEntradaFila = novoNo; // referencia de entrada da fila passa a ser novoNo que é o ultimo nó agora
    }

    public T first() {
        if (!this.isEmpty()) { // se a fila não estiver vazia
            No primeiroNo = refNoEntradaFila;
            while (true) {                              // se primeiro nó for diferente de null, então existe
                if (primeiroNo.getRefNo() != null) {     // outro nó a frente dele
                    primeiroNo = primeiroNo.getRefNo(); // Ele passa a ser o primeiro nó
                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null; // se a fila estiver vazia
    }


    public T dequeue() {
        if (!this.isEmpty()) { // se a fila não estiver vazia
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    noAuxiliar.setRefNo(null); // setamos o proximo nó como primeiro, com a referencia apontando
                    break;                      // para null
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null; // se a fila estiver vazia
    }
    public boolean isEmpty() {
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
       String stringRetorno = "";
       No noAuxiliar = refNoEntradaFila;

       if (refNoEntradaFila != null) {
            while (true){
                stringRetorno += "[No[objeto=" + noAuxiliar.getObject() + "]} --->";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();

                } else{
                    stringRetorno += null;
                    break;
                }
            }
       } else {
           stringRetorno = "null";

       }

       return stringRetorno;
    }
}
