package one.digitalinnovation;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }
    public void push(No novoNo) {
        No refAuxiliar = refNoEntradaPilha; // guarda a referencia
        refNoEntradaPilha = novoNo; // nova referencia sera para o novo nó
        refNoEntradaPilha.setRefNo(refAuxiliar); // referencia do próximo nó é a antiga referencia de topo
    }

    public No pop(){
        if (!this.isEmpty()) { // se a pilha não tiver vazia
            No noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha;
            refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }
    public No top() {
        return refNoEntradaPilha;
    }
    public boolean isEmpty(){

//        if (refNoEntradaPilha == null) {
//            return true;
//        }
//
//        return false;
        return refNoEntradaPilha == null ? true : false;

    }
}