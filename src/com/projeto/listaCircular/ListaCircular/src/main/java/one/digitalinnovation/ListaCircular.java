package one.digitalinnovation;

public class ListaCircular<T> {

        private No<T> cabeça;
        private No<T> cauda;
        private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeça = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
            No<T> novoNo = new No<>(conteudo);
            if(this.tamanhoLista == 0){
                this.cabeça = novoNo;
                this.cauda = this.cabeça;
                this.cabeça.setProximoNo(cauda);
            }else{
                novoNo.setProximoNo(this.cauda); // esta apontando para tras da cauda
                this.cabeça.setProximoNo(novoNo); // cabeça aponta para o novo nó
                this.cauda = novoNo; // referencia de cauda aponta para novo nó
            }
            this.tamanhoLista++;
        }

        public void remove(int index){
            if (index >= this.tamanhoLista)
                throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista");
            No<T> noAuxiliar = this.cauda;
            if (index == 0){
                this.cauda = this.cauda.getProximoNo(); // cauda passa a receber o proximo nó a frente dela
                this.cabeça.setProximoNo(this.cauda); //aponta para nova cauda
            }else if(index == 1){
                this.cauda.setProximoNo(this.cauda.getProximoNo()); // setando o proximo de indice 1 e pulamos ele, assim excluindo o nó 1
            }else{
                for (int i = 0; i < index-1; i++){
                    noAuxiliar = noAuxiliar.getProximoNo();
                }
                noAuxiliar.setProximoNo(noAuxiliar.getProximoNo().getProximoNo());
            }
            this.tamanhoLista--;
        }

        public T get(int index){
            return this.getNo(index).getConteudo();
        }

        private No<T> getNo(int index){
            if (this.isEmpty())
                throw new IndexOutOfBoundsException("A lista esta vazia");

            if (index == 0){ // testa se o indice é 0
                return this.cauda; // entra pela cauda
            }

            No<T> noAuxiliar = this.cauda;
            for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            //for(int i = 0; (i < index) && (noAuxiliar != null); i++){ nenhum getProximoNo vai ser null em lista circular
                noAuxiliar = noAuxiliar.getProximoNo();
            }

            return noAuxiliar;

        }

        public boolean isEmpty(){
            return this.tamanhoLista == 0 ? true: false;
        }

        public int size(){
           return this.tamanhoLista;
        }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.cauda; // começa a imprimir pela cauda
        for(int i = 0; i < this.size(); i++){
            strRetorno = "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += this.size() != 0 ? "(Retorna ao inicio)" : "[]";

        return strRetorno;
    }
}
