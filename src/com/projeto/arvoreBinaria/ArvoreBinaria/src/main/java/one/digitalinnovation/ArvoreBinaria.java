package one.digitalinnovation;

public class ArvoreBinaria <T extends Comparable<T>>{

    private BinNo<T> raiz;
    public ArvoreBinaria(){ //construtor
        this.raiz = null;
    }

    public void inserir(T conteudo) { // conteudo do tipo generico
        BinNo<T> novoNo = new BinNo<>(conteudo); // nó do conteudo
        this.raiz = inserir(raiz, novoNo); // metodo publico chama o metodo abaixo
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if(atual == null){ // se a arvore estiver vazia
            return novoNo; // retorna novoNo como raiz
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) { // estamos comparando o conteudo do novo nó
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo)); // insere nó atual a esquerda se for menor que 0                                                               // com o conteudo do nó atual
        }else{
            atual.setNoDir(inserir(atual.getNoDir(), novoNo)); // se não insere a direita
        }
        return atual;
    }

    public void exibirInOrdem(){
        System.out.println("\n Exibindo InOrdem");
        exibirInOrdem(this.raiz); // exibindo em ordem a partir da raiz
    }

    private void exibirInOrdem(BinNo<T> atual){
        if (atual != null){
            exibirInOrdem(atual.getNoEsq()); // visita o da esquerda
            System.out.println(atual.getConteudo() + ","); // exibe o atual
            exibirInOrdem(atual.getNoDir()); // visita o da direita
        }
    }
    public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrdem");
        exibirPosOrdem(this.raiz); // exibindo em ordem a partir da raiz
    }

    private void exibirPosOrdem(BinNo<T> atual){  // PósOrdem visita antes de exibir
        if (atual != null){
            exibirPosOrdem(atual.getNoEsq()); // visita o da esquerda
            exibirPosOrdem(atual.getNoDir()); // visita o da direita
            System.out.println(atual.getConteudo() + ","); // exibe o atual
        }
    }

    public void exibirPreOrdem(){
        System.out.println("\n Exibindo PreOrdem");
        exibirPreOrdem(this.raiz); // exibindo em ordem a partir da raiz
    }

    private void exibirPreOrdem(BinNo<T> atual){  // PreOrdem exibe antes de visitar
        if (atual != null){
            System.out.println(atual.getConteudo() + ","); // exibe o atual
            exibirPreOrdem(atual.getNoEsq()); // visita o da esquerda
            exibirPreOrdem(atual.getNoDir()); // visita o da direita
        }
    }
}
