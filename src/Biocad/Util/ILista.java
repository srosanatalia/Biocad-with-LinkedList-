package Biocad.Util;


public interface ILista {

    public boolean estaVazia();

    public int obterTamanho();

    public void inserirInicio(Object dado);

    public void inserirFinal(Object dado);

    public Object removerInicio();

    public Object removerFinal();

    public Object recuperar(int index);

    public Iterador iterador();
}
