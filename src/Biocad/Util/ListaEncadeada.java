package Biocad.Util;

public class ListaEncadeada implements ILista{
    
    private No cabeca; //Primeira célula da lista

    private class No{ //Classe referente aos nós da lista encadeada;
        private Object dado;
        private No proximo;  
        
        public No(Object dado){
            this.dado = dado;
        }
        
        public No getProximo(){
            return proximo;
        }
        
        public void setProximo(No proximo){
            this.proximo = proximo;
        }
        
        public Object getDado(){
            return dado;
        }
        
        public void setDado(Object dado){
            this.dado = dado;
        }
    } 
    
    private No getNo(int index) { //Método auxiliar retorna o nó associado a posição		
        
        if (index>= 0 && index< obterTamanho()) { //Se posição maior ou igual a zero e menor que tamanho da lista.
            No n = cabeca;
            for (int i = 0; i < index; i++) {
                n = n.getProximo();
            }
            return n; 
        }
        return null;
    } 
    
    @Override
    public boolean estaVazia(){
        return obterTamanho() == 0; //Se tamanho == 0, lista vazia.
    }

    @Override
    public int obterTamanho(){ //Obtém tamanho da lista:
        int contador = 0;
        for (No i = cabeca; i != null; i = i.getProximo()){
        contador++; //obterTamanho tem sempre 1+ tamanho da lista
        }
        return contador; 
    }
    
    @Override
    public void inserirInicio(Object dado){ //Insere no início da lista
        No temp = cabeca;
        cabeca = new No(dado);
        cabeca.setProximo(temp);
    }
    
    @Override
    public void inserirFinal(Object dado){ //Insere no final da lista
        if (estaVazia()) { //Se vazia, adiciona o primeiro elemento
            cabeca = new No(dado);
        } 
        else {
        No n = getNo(obterTamanho() - 1); //Como obterTamanho tem sempre 1+, decrementa em 1 ao adicionar no final da lista.
        n.setProximo(new No(dado)); 
        } 
    }
    
    @Override
    public Object removerInicio(){ //Remover não imlementado;
        return null;
    }
    
    @Override
    public Object removerFinal(){ //Remover não implementado;
        return null;
    }
    
    @Override
    public Object recuperar(int index){ //Recupera nó de um determinado index;
        No n = getNo(index);
        return n;
    }
    
    @Override
    public Iterador iterador(){ //Método iterador
        return new ListIterador();
    }
    
    public void set(int index, Object dado) { //Altera conteúdo de um determinado nó.
        No n = getNo(index);
        if (n != null) {
            n.setDado(dado);
        }
    }
    
    public Object get(int index) { //Retorna conteúdo de um determinado nó.
        No n = getNo(index);
        if (n != null) {
            return n.getDado();
        }
        return null;
    }
    
    private class ListIterador implements Iterador { //Classe iterador.
        private int posicao = 0; //Inicializa posição
        @Override
        public boolean temProximo() { //Se nó acossiado a uma posição for diferente de null, significa que tem próximo.
            return getNo(posicao) != null;
        }
        
        @Override
        public Object obterProximo() { //Retorna nó de determinada posição
            Object dado = get(posicao);
            posicao++;
            return dado;
        }
    } 
    
}
