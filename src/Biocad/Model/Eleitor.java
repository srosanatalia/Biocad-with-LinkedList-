package Biocad.Model;

public class Eleitor {
    
    //Atributos da classe Eleitor:
    private String nome; //Nome do eleitor.
    private String titulo; //Título do eleitor.
    private String nomeMae; //Nome da mãe do eleitor.
    private String nomePai; //Nome do pai do eleitor
    private String dataNasc; //Data de nascimento do eleitor.
    private String telefone; //Número de telefone do eleitor.

    
    //Construtor
    public Eleitor (String nome, String titulo, String nomeMae, String nomePai, String dataNasc, String telefone){
        this.nome = nome;
        this.titulo = titulo;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
