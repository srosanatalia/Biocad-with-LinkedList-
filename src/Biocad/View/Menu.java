/*******************************************************************************
Autor: NATÁLIA SILVA ROSA
Componente Curricular: Algoritmos II
Concluido em: 05/10/2017
Declaro que este codigo foi elaborado por mim de forma individual e nao contem nenhum
trecho de codigo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e paginas ou documentos eletronicos da Internet. Qualquer trecho de codigo
de outra autoria que não a minha esta destacado com uma citacao para o autor e a fonte
do codigo, e estou ciente que estes trechos nao serao considerados para fins de avaliacao.
******************************************************************************************/
package Biocad.View;


import Biocad.Controller.BiocadController;
import Biocad.Model.Agendamento;
import Biocad.Model.Eleitor;
import Biocad.Model.Guiche;
import Biocad.Util.Console;
import Biocad.Util.Iterador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

public class Menu {
    
    public static void main (String [] args){
        
        BiocadController objeto = new BiocadController(); //Criação de objeto do tipo BiocadController

        int opcao = 0; //Controla as opções do menu.
        boolean retorno = true; //Controla o retorno ao menu principal.
        int codigo = 0; //Controla o código do guichê.
        
        do{
            System.out.println ("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
                              + "*  (1) Adicionar Guichê de Atendimento;                 *\n"                 
                              + "*  (2) ListarGuichês;                                   *\n"
                              + "*  (3) Buscar guichês;                                  *\n"
                              + "*  (4) Adicionar eleitor;                               *\n"
                              + "*  (5) Verificar guichê disponível;                     *\n"
                              + "*  (6) Agendar horário para eleitor;                    *\n"
                              + "*  (7) Listar eleitores agendados no dia por guichê;    *\n"
                              + "*  (8) Sair;                                            *\n"
                              + "* * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
            System.out.print("Insira uma opção: ");

            try {opcao = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

            switch( opcao )
            {           
                case 1: //Adicionar Guichê de Atendimento  

                    int numeroSala = 0; //Número da sala
                    int corredor = 0; // Corredor
                    String atendente = null; //Nome do atendente

                    System.out.print ("\nInsira o número da sala: ");
                    try {numeroSala = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                    System.out.print ("Insira o corredor: ");
                    try {corredor = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                    System.out.print ("Insira o atendente: ");
                    try {atendente = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                    codigo = codigo +1; //Gera automaticamente o código do guichê.
                    
                    objeto.cadastrarGuiche(codigo, numeroSala, corredor, atendente); //Cria guichê.    
                break;

                case 2: //Listar Guichês
                    
                    //Percorre a lista de guichê e printa enquanto houver próximo.
                    
                    Iterador listagemGuiche = objeto.listarGuiche(); 
                    
                    while (listagemGuiche.temProximo()){ 
                        Guiche guicheAtual = (Guiche) listagemGuiche.obterProximo();
                        System.out.println("\nGUICHÊ "+guicheAtual.getCodigo()+":");
                        System.out.println("Número da sala: "+guicheAtual.getNumeroSala());
                        System.out.println("Número do corredor: "+guicheAtual.getCorredor());
                        System.out.println("Atendente: "+guicheAtual.getAtendente());
                    }
                break;

                case 3: //Buscar guichês
                    int codigo_busca_1 = 0; //Código do guichê procurado.
                    
                    System.out.print ("\nInsira o codigo do guichê que deseja procurar: ");
                    try {codigo_busca_1 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                    
                    //Procura guichê pelo código, caso encontre é mostrado para o usuário. Caso não encontre, é printada uma mensagem de erro.
                    Guiche atual_busca = objeto.obterGuiche(codigo_busca_1);
                    if (atual_busca == null){
                        System.out.println("**Este guichê não está cadastrado.**");
                    }
                    else{

                        System.out.println("\nGUICHÊ "+atual_busca.getCodigo()+":");
                        System.out.println("Número da sala: "+atual_busca.getNumeroSala());
                        System.out.println("Número do corredor: "+atual_busca.getCorredor());
                        System.out.println("Atendente: "+atual_busca.getAtendente());
                    }
                    
                break;

                case 4: //Adicionar eleitor
                    String nome = null; //Nome do Eleitor
                    String titulo = null; //Título do eleitor
                    String nomeMae = null; //Nome da mãe do eleitor
                    String nomePai = null; //Nome do pai do eleitor
                    String dataNasc = null; //Data de nascimento do eleitor
                    String telefone = null; //Telefone do eleitor

                    System.out.print ("\nInsira o nome do eleitor: ");
                    try {nome = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                    System.out.print ("Insira o título do eleitor: ");
                    try {titulo = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                    
                    Eleitor verificarEleitor = objeto.obterEleitor(titulo);
                    
                    if (verificarEleitor == null){ //Verifica se o título do eleitor já está cadastrado.
                        System.out.print ("Insira o nome da mãe do eleitor: ");
                        try {nomeMae = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                        System.out.print ("Insira o nome do pai do eleitor: ");
                        try {nomePai = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                        System.out.print ("Insira a data de nascimento do eleitor no formato (dd/MM/yyyy): ");
                        try {dataNasc = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                        System.out.print ("Insira o número do telefone: ");
                        try {telefone = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                        
                        objeto.cadastrarEleitor(nome, titulo, nomeMae, nomePai, dataNasc, telefone);
                    }
                    
                    else{
                        
                        System.out.println("**Este eleitor já está cadastrado.**\n");
                    } 

                break;
                
                case 5: //Verifica guichê disponível
                    int codigo_busca_2 = 0; //Código do guichê procurado.
                    int dia_1 = 0; //Recebe dia do mês
                    int ordem_1 = 0; //Recebe ordem de agendamento
                    
                    System.out.print ("\nInsira o código do guichê: ");
                    try {codigo_busca_2 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                        
                    //Verifica a existência do guichê:
                        
                    Guiche verificaGuiche_3 = objeto.obterGuiche(codigo_busca_2);
                    if (verificaGuiche_3 == null){
                        System.out.println("**Este guichê não está cadastrado.**\n");
                    }
                    else{
                        System.out.print ("Insira o dia no formato dd: ");
                        try {dia_1 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                        
                        Calendar data = Calendar.getInstance(); //Intancia data do sistema.

                        data.add(Calendar.MONTH, 1); //Já que os agendamentos se tratam do mês seguinte, acrescenta-se um mês ao atual.

                        data.set(Calendar.DAY_OF_MONTH, dia_1);
                        
                        System.out.print ("Escolha a ordem do atendimento (1 a 32): ");
                        try {ordem_1 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                        //Percorro lista de agendamento pra ver se existe algum agendamento que possua mesmo guichê, dia e ordem:

                        boolean verificaAgendamento_3 = objeto.verificarGuiche(data, ordem_1, codigo_busca_2);
                        if (verificaAgendamento_3 == false){
                            System.out.println("**O horário solicitado está disponível!**\n.");
                        }
                        else{
                            System.out.println("**O horário solicitado não está disponível!**\n.");
                        }
                    }    
                break;

                case 6: //Agendar horário para eleitor
                    
                    int codigo_busca_3 = 0; //Código do guichê procurado.
                    int dia_2 =0; //Recebe dia do mês
                    int ordem_2 = 0; //Recebe ordem de agendamento
                    String tituloEleitor = null; //Título do eleitor
                    
                    Calendar data_atual = Calendar.getInstance(); //Instancia a data atual do sistema
                    
                    if((data_atual.get(Calendar.DAY_OF_MONTH)) == 20){ //Agendamentos só são liberados no dia 20 do mês
                    
                        System.out.print ("\nInsira o código do guichê: ");
                        try {codigo_busca_3 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                        
                        //Verifica a existência do guichê:
                        
                        Guiche verificaGuiche = objeto.obterGuiche(codigo_busca_3);
                        if (verificaGuiche == null){
                            System.out.println("**Este guichê não está cadastrado.**\n");
                        }
                        else{ //Caso o guichê exista, prossegue o agendamento.
                            
                            //Verificar se eleitor já está cadastrado:
                            
                            System.out.print ("Insira o título do eleitor: ");
                            try {tituloEleitor = Console.readString();} catch (IOException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                            
                            Eleitor verificaEleitor = objeto.obterEleitor(tituloEleitor);
                            if(verificaEleitor != null){//Caso eleitor cadastrado, prossegue agendamento:

                                System.out.print ("Insira o dia do agendamento no formato dd: ");
                                try {dia_2 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                                
                                Calendar data_agendamento = Calendar.getInstance(); //Intancia data do sistema.

                                data_agendamento.add(Calendar.MONTH, 1); //Já que os agendamentos se tratam do mês seguinte, acrescenta-se um mês ao atual.

                                data_agendamento.set(Calendar.DAY_OF_MONTH, dia_2); //Altera data para a digitada pelo usuário
                                
                                if(((data_agendamento.get(Calendar.DAY_OF_WEEK)) != 1) && ((data_agendamento.get(Calendar.DAY_OF_WEEK)) != 7)){ //Verifica se a data escolhida não é final de semana.

                                    System.out.print ("Escolha a ordem do atendimento (1 a 32): ");
                                    try {ordem_2 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}

                                    //Percorre-se lista de agendamento para verificar se existe algum agendamento que possua mesmo guichê, dia e ordem:

                                    boolean verificaAgendamento_2 = objeto.verificarGuiche(data_agendamento, ordem_2, codigo_busca_3);
                                    if (verificaAgendamento_2 == false){ //Caso não haja outro agendamento correspondente, este é validado.
                                        System.out.println("**O horário solicitado está disponível!**\n.");
                                        objeto.agendarHorario(codigo_busca_3, data_agendamento, ordem_2, tituloEleitor);
                                        System.out.println("**Agendamento realizado com sucesso!**\n");

                                    }
                                    else{ //Caso já exista um agendamento para mesmo guichê, dia e ordem:
                                        System.out.println("**O horário solicitado não está disponível!**\n.");

                                        //Forneço outras opções de horário para aquele guichê:

                                        int controle = 0;//Auxiliar que indica caso todos os agendamentos de um guichê já estejam ocupados.
                                        
                                        Calendar hora = Calendar.getInstance(); //Instancia data do sistema
                                        hora.set(Calendar.HOUR_OF_DAY, 8); //Modifica-se hora para 8h 
                                        hora.set(Calendar.MINUTE, 00); //Modifica-se minutos para 00mm 
                                        hora.set(Calendar.SECOND, 00); //Modifica-se segundos para 00s
                                        
                                        for (int i = 1; i<33; i++){ //Numéro máximo de agendamentos em um dia, é 32
                                            //Percorre-se lista de agendamento para verificar se existe algum agendamento que possua mesmo guichê, dia e ordem, considerando ordem como i.
                                            boolean verificaAgendamento_3 = objeto.verificarGuiche(data_agendamento, i, codigo_busca_3); 
                                            if (verificaAgendamento_3 == false){
                                                if (hora.get(Calendar.HOUR_OF_DAY) != 12){ //É retirado a hora do dia correspondente às 12h (horário de almoço).
                                                    System.out.println("("+(i)+") - "+"Horário:"+ hora.get(Calendar.HOUR_OF_DAY)+":"+hora.get(Calendar.MINUTE)+" h  ");
                                                }
                                                else{//Caso o horário seja igual a 12h, decrementa, para que esta verificação do for seja invalidada, porém ainda assim seja adicionado 15 minutos ao horário.
                                                    i--; 
                                                }  
                                                controle = controle +1; //Se entrar pelo menos uma vez neste laço if, significa que existe pelo menos 1 horário disponível neste guichê.
                                            }
                                            hora.add(Calendar.MINUTE, 15); //Acrescenta-se 15 minutos.
                                        }
                                        if (controle == 0){ //Se controle igual a 0, signfica que todos os horários para determinado guichê estão ocupados.
                                            System.out.println("**Todos os horários para este guichê estão ocupados.**\n");
                                        }
                                        else{ //Se pelo menos um horário disponível, agendamento é validado.
                                            System.out.print("Escolha, dentre as opções acima, um novo horário: ");
                                            try {ordem_2 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}  

                                            objeto.agendarHorario(codigo_busca_3, data_agendamento, ordem_2, tituloEleitor);
                                            System.out.println("**Agendamento realizado com sucesso!**\n");
                                        }
                                    }
                                    
                                }
                                else{
                                    System.out.println("**Não é possível realizar agendamentos para finais de semana.**\n");
                                }

                            }
                            else{
                                System.out.println("**Este eleitor não está cadastrado. Favor, realizar o cadastro antes de prosseguir.**\n");
                            }
                        }
                    }
                    
                    else{
                        System.out.println ("**Os agendamentos só são liberados no dia 20.**\n");
                    }   
                break;

                case 7: //Listar eleitores agendados no dia por guichê
                    int codigo_busca_4 = 0; //Código do guichê procurado.
                    int dia_3 = 0; //Recebe dia do mês
                    double concatenacao; //Recebe concatenação de código e dia do mês.
                    System.out.print ("\nInsira o código do guichê: ");
                    try {codigo_busca_4 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                        
                    //Verifica a existência do guichê:
                        
                    Guiche verificaGuiche_2 = objeto.obterGuiche(codigo_busca_4);
                    if (verificaGuiche_2 == null){ //Se não existir tal guichê:
                        System.out.println("**Este guichê não está cadastrado.**\n");
                    }
                    else{ //Se guichê existir:
                        System.out.print ("Insira o dia no formato dd: ");
                        try {dia_3 = Console.readInt();} catch (IOException | NumberFormatException ex) {Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);}
                        
                        Calendar data = Calendar.getInstance(); //Intancia data do sistema.

                        data.add(Calendar.MONTH, 1); //Já que os agendamentos se tratam do mês seguinte, acrescenta-se um mês ao atual.

                        data.set(Calendar.DAY_OF_MONTH, dia_3); //Altera data para a digitada pelo usuário
                        
                        /*Concatenacao dos dados inseridos pelo usuário:
                        Concatena dados para fins de comparação. Faz-se necessário multiplicar o dia por 0.01,
                        pois caso o dia do mês seja menor que 10, é adicionado um zero a esquerda para que não
                        haja diferença em quantidade de casas decimais se comparado a outros valores concatenados.
                        Multiplica-sepor 100, para que seja uma concatenação sem casas decimais, tal qual o atributo
                        concatenacao_CD da classe Agendamento.*/
                        concatenacao = codigo_busca_4 + (dia_3 * 0.01);
                        concatenacao = concatenacao * 100;
                        
                        //Procura agendamentos para um guichê em um determinado dia:
                        Iterador verificaAgendamento = objeto.listarEleitoresAgendados(codigo_busca_4, data);
                        
                        if (verificaAgendamento == null){ //Se não existirem agendamentos referentes:
                            System.out.println("**Não existem eleitores cadastrados para o dia e guichê solicitados.**");        
                        }
                        else{ //Caso existam agendamentos, é mostrado ao usuário:
                            while (verificaAgendamento.temProximo()){
                                Agendamento atual = (Agendamento) verificaAgendamento.obterProximo();
                                
                                for (int i = 1; i <33; i++){
                                    if (atual.getOrdem() == i){
                                        if (atual.getConcatenacao_CD() == concatenacao){
                                            System.out.println("\nTítulo do eleitor:"+atual.getTituloEleitor());
                                            System.out.println("Guichê: "+atual.getCodigoGuiche());
                                            System.out.println("Data: "+atual.getData().get(Calendar.DAY_OF_MONTH)+"/"+atual.getData().get(Calendar.MONTH));
                                            System.out.println("Ordem: "+atual.getOrdem());
                                        }
                                    }
                                }
                                
                            }
                            
                        }
                    }
                break;
                    
                case 8: //Sair
                    retorno = false; 
                break;

                default:
                    System.out.println("**Insira uma opção válida!**");
            }
            
        } while (retorno); //Retorna ao menu, caso retorno == true;
   
    }

    
}
