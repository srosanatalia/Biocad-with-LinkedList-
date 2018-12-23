package Biocad.Model;

import java.util.Calendar;

public class Agendamento {
    
    //Atributos da classe Agendamento:
    private int codigoGuiche; //Código do guichê
    private Calendar data; //Data
    private int ordem; //Ordem
    private String tituloEleitor; //Título de Eleitor
    private double concatenacao_CDO; //concatenação CDO (código + data + ordem).
    private double concatenacao_CD; //concatenação CD (código + data).
    int dia; //Dia do mês
    
    public Agendamento (int codigoGuiche, Calendar data, int ordem, String tituloEleitor) { //Construtor
        this.codigoGuiche = codigoGuiche;
        this.data = data;
        this.ordem = ordem;
        this.tituloEleitor = tituloEleitor;
        
        dia = data.get(Calendar.DAY_OF_MONTH); //Recebe valor referente ao dia do mês.
        
        /*concatenacao_CDO -> (código + data + ordem):
          Concatena dados para fins de comparação. Faz-se necessário multiplicar o dia por 0.01,
          pois caso o dia do mês seja menor que 10, é adicionado um zero a esquerda para que não
          haja diferença em quantidade de casas decimais se comparado a outros valores concatenados.
          Mutiplica-se ordem por 0.00001 para que este assuma o valor da terceira e quarta casa decimal
          do valor de concatenacao.
        
          concatenacao_CD -> (código + data):
          Concatena dados para fins de comparação. Faz-se necessário multiplicar o dia por 0.01,
          pois caso o dia do mês seja menor que 10, é adicionado um zero a esquerda para que não
          haja diferença em quantidade de casas decimais se comparado a outros valores concatenados.
          Multiplica-sepor 100, para que seja uma concatenação sem casas decimais.
        */
        this.concatenacao_CDO = codigoGuiche + (dia * 0.01) + (ordem * 0.0001);
        this.concatenacao_CD = (codigoGuiche + (dia * 0.01)) * 100;

    }

    public int getCodigoGuiche() {
        return codigoGuiche;
    }

    public void setCodigoGuiche(int codigoGuiche) {
        this.codigoGuiche = codigoGuiche;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public double getConcatenacao_CDO() {
        return concatenacao_CDO;
    }

    public void setConcatenacao_CDO(double concatenacao_CDO) {
        this.concatenacao_CDO = concatenacao_CDO;
    }

    public double getConcatenacao_CD() {
        return concatenacao_CD;
    }

    public void setConcatenacao_CD(double concatenacao_CD) {
        this.concatenacao_CD = concatenacao_CD;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }  
}
