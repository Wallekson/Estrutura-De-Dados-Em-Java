package one.digitalinnovation;

public class ArvoreBinaria <T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() { //construtor
        this.raiz = null;
    }

    public void inserir(T conteudo) { // conteudo do tipo generico
        BinNo<T> novoNo = new BinNo<>(conteudo); // nó do conteudo
        raiz = inserir(raiz, novoNo); // metodo publico chama o metodo abaixo
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) { // se a arvore estiver vazia
            return novoNo; // retorna novoNo como raiz
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) { // estamos comparando o conteudo do novo nó
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo)); // insere nó atual a esquerda se for menor que 0                                                               // com o conteudo do nó atual
        } else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo)); // se não insere a direita
        }
        return atual;
    }

    public void exibirInOrdem() {
        System.out.println("\n Exibindo InOrdem ");
        exibirInOrdem(this.raiz); // exibindo em ordem a partir da raiz
    }

    private void exibirInOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirInOrdem(atual.getNoEsq()); // visita o da esquerda
            System.out.print(atual.getConteudo() + ","); // exibe o atual
            exibirInOrdem(atual.getNoDir()); // visita o da direita
        }
    }

    public void exibirPosOrdem() {
        System.out.println("\n Exibindo PosOrdem ");
        exibirPosOrdem(this.raiz); // exibindo em ordem a partir da raiz
    }

    private void exibirPosOrdem(BinNo<T> atual) {  // PósOrdem visita antes de exibir
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsq()); // visita o da esquerda
            exibirPosOrdem(atual.getNoDir()); // visita o da direita
            System.out.print(atual.getConteudo() + ","); // exibe o atual
        }
    }

    public void exibirPreOrdem() {
        System.out.println("\n Exibindo PreOrdem ");
        exibirPreOrdem(this.raiz); // exibindo em ordem a partir da raiz
    }

    private void exibirPreOrdem(BinNo<T> atual) {  // PreOrdem exibe antes de visitar
        if (atual != null) {
            System.out.print(atual.getConteudo() + ","); // exibe o atual
            exibirPreOrdem(atual.getNoEsq()); // visita o da esquerda
            exibirPreOrdem(atual.getNoDir()); // visita o da direita
        }
    }

    public void remover(T conteudo) {
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)) { // se tiver vazia vai esbarra em nll
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0) { // correndo a arvore procurando o conteudo
                    atual = atual.getNoEsq();  // vai para o nó da esquerda                                                // comparando para ver se vai para esquerda ou direita
                } else {
                    atual = atual.getNoDir();  // vai para o nó da direita                                                // comparando para ver se vai para esquerda ou direita
                }
            }

            if (atual == null) {
                System.out.println("Conteudo não encontrado. Bloco Try");
            }

            if (pai == null){
                if (atual.getNoDir() == null){ // se tenho o da direita como nulo
                    this.raiz = atual.getNoEsq(); // pego o da esquerda

                }else if(atual.getNoEsq() == null){ // se tenho o da esquerda como nulo
                    this.raiz = atual.getNoDir(); // pego o da direita

                }else {
                    for (temp = atual, filho = atual.getNoEsq();
                         filho.getNoDir() != null; temp = filho, filho = filho.getNoEsq()
                    ) {
                        if (filho != atual.getNoEsq()) {
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }


            } else if (atual.getNoDir() == null) {  //se a referencia a direta for null
                if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(atual.getNoEsq());
                }else {
                    pai.setNoDir(atual.getNoEsq());
                }

            } else if (atual.getNoEsq() == null) {
                if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(atual.getNoDir());
                }else {
                    pai.setNoDir(atual.getNoDir());
                }

            }else {
                for (
                        temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ) {
                    if (filho != atual.getNoEsq()) {
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());
                    if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(filho);
                    } else {
                        pai.setNoDir(filho);
                    }

                }
            }
        }catch (NullPointerException erro){
            System.out.println("Conteudo não encontrado. Bloco Catch");

        }


    }
}