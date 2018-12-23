package Biocad.Model;

public class Guiche {
    
    //Atributos da classe Guichê:
    private int codigo;//Código do guichê
    private int numeroSala; //Número da sala
    private int corredor; //Corredor
    private String atendente; //Nome do atendente
    
    //Construtor:
    public Guiche (int codigo, int numeroSala, int corredor, String atendente) {

        this.codigo = codigo;
        this.numeroSala = numeroSala;
        this.corredor = corredor;
        this.atendente = atendente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCorredor() {
        return corredor;
    }

    public void setCorredor(int corredor) {
        this.corredor = corredor;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }
    
    
    
}
