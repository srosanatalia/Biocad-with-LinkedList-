package Biocad.Controller;

import Biocad.Model.Guiche;
import Biocad.Model.Eleitor;
import Biocad.Model.Agendamento;
import Biocad.Util.Iterador;
import java.util.Calendar;
import Biocad.Util.ListaEncadeada;

public class BiocadController {
    
    private ListaEncadeada guiche; //Atributo do tipo ListaEncadeada
    private ListaEncadeada eleitor; //Atributo do tipo ListaEncadeada
    private ListaEncadeada agendamento; //Atributo do tipo ListaEncadeada
    
    public BiocadController (){ //Construtor
        this.guiche = new ListaEncadeada ();
        this.eleitor = new ListaEncadeada ();
        this.agendamento = new ListaEncadeada ();
    }
    
    public Guiche cadastrarGuiche(int codigo, int numeroSala, int corredor, String atendente) {
        //Cria um novo guichê e insere no final da lista do tipo guichê.
        Guiche cadastrarGuiche = new Guiche (codigo, numeroSala, corredor, atendente); 
        this.guiche.inserirFinal(cadastrarGuiche);
        
        return cadastrarGuiche;
    }

    public Guiche obterGuiche(int codigo) {
        /*Utiliza o iterador para percorrer a lsta guiche, enquanto houver próximo, ele
        compara os códigos e retorna os objetos que possuirem atributo código semelhantes.*/
        Iterador procurarGuiche = this.guiche.iterador();
        
        while(procurarGuiche.temProximo()){
            Guiche atual = (Guiche) procurarGuiche.obterProximo();
            
            if (atual.getCodigo() == codigo){
                return atual;
            }   
        }
        
        return null;
    }
    
    
    public Eleitor obterEleitor(String titulo) {
        /*Utiliza o iterador para percorrer a lsta eleitor, enquanto houver próximo, ele
        compara os títulos e retorna os objetos que possuirem atributo título semelhantes.*/
        Iterador procurarEleitor = this.eleitor.iterador();
        
        while(procurarEleitor.temProximo()){
            Eleitor atual = (Eleitor) procurarEleitor.obterProximo();
            
            if (atual.getTitulo().equals(titulo)){
                return atual;
            }   
        }
        
        return null;
    }
    
    public Iterador listarGuiche() {
        //retorna a lista do tipo guichê
        
        return this.guiche.iterador(); 
    }

    public Eleitor cadastrarEleitor(String nome, String titulo, String nomeMae, String nomePai, String dataNasc, String telefone) {
        //Cria um novoeleitor e insere no final da lista do tipo eleitor.
        Eleitor cadastrarEleitor = new Eleitor (nome, titulo, nomeMae, nomePai, dataNasc, telefone);
        this.eleitor.inserirFinal(cadastrarEleitor);
        
        return cadastrarEleitor;
    }
  

    public Agendamento agendarHorario(int codigoGuiche, Calendar data, int ordem, String tituloEleitor) {
        //Cria um novo agendamento e insere no final da lista do tipo agendamento.
        Agendamento agendarHorario = new Agendamento (codigoGuiche, data, ordem, tituloEleitor);
        this.agendamento.inserirFinal(agendarHorario);
                
        return agendarHorario;
    }

    public  Iterador listarEleitoresAgendados(int codigoGuiche, Calendar data) { 
        
        int dia;
        double concatenacao;
        dia = data.get(Calendar.DAY_OF_MONTH); //Variável dia recebe apenas o valor referente ao dia do mês.
        
        /*Concatena dados para fins de comparação. Faz-se necessário multiplicar o dia por 0.01,
          pois caso o dia do mês seja menor que 10, é adicionado um zero a esquerda para que não
          haja diferença em quantidade de casas decimais se comparado a outros valores concatenados.
          Multiplica-sepor 100, para que seja uma concatenação sem casas decimais, tal qual o atributo
          concatenacao_CD da classe Agendamento.*/
        concatenacao = (codigoGuiche + (dia * 0.01)) * 100;
        
        Iterador procurarAgendamento = this.agendamento.iterador();
        
        while(procurarAgendamento.temProximo()){
            Agendamento atual = (Agendamento) procurarAgendamento.obterProximo();
            
            if (atual.getConcatenacao_CD() == concatenacao){ //Verifica se existem eleitores agendados para determinada data em um dado guichê.
                return  this.agendamento.iterador(); //Caso exista, retorna um objeto do tipo interador.
            }   
        }
        
        return null; // Caso não exista, retorna null.
    }

    public boolean verificarGuiche(Calendar data, int ordem, int codigoGuiche) { 
        
        int dia;
        double concatenacao;
        dia = data.get(Calendar.DAY_OF_MONTH);
        
        /*Concatena dados para fins de comparação. Faz-se necessário multiplicar o dia por 0.01,
          pois caso o dia do mês seja menor que 10, é adicionado um zero a esquerda para que não
          haja diferença em quantidade de casas decimais se comparado a outros valores concatenados.
          Mutiplica-se ordem por 0.00001 para que este assuma o valor da terceira e quarta casa decimal
          do valor de concatenacao.*/
        
        concatenacao = codigoGuiche + (dia * 0.01) + (ordem * 0.0001); 
        
        Iterador procurarAgendamento = this.agendamento.iterador();
        
        while(procurarAgendamento.temProximo()){
            Agendamento atual = (Agendamento) procurarAgendamento.obterProximo();
            
            if (atual.getConcatenacao_CDO() == concatenacao){ //Verifica se existem eleitores agendados para determinada data e ordem em um dado guichê.
                return true; //Caso exista, retorna true.
            }   
        }       
        return false;
    }
 
}
