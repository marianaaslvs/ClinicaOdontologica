/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClinicaOdontologica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);

    public void menu() {
        //VARIAVEIS
        int opcao = 0;
        String nomepac = null, novoNome = null, dataC = null, horaC = null;
        int idadepac = 0, conveniopac = 0, novaIdade = 0, novoConvenio = 0, posicao = 0, nTrat = 0;

        Clinica cli = new Clinica();

        //INCLUINDO DADOS NAS ARRAYS
        cli.adicionarPacientesSist();
        cli.incluirDentistas();
        cli.incluirTratamentos();

        try {
            do {

                do {
                    System.out.print("""
\n***** CLINICA ODONTOLOGICA *****
Escolha uma das opcoes abaixo:
1. Cadastrar paciente
2. Alterar cadastro do paciente
3. Excluir cadastro do paciente
4. Verificar pacientes cadastrados
5. Agendar Consulta
6. Alterar Consulta
7. Excluir Consulta
8. Verificar consultas agendadas
0. Sair do Programa.\n """);
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            //CADASTRANDO O PACIENTE                    
                            System.out.print("Digite o nome do paciente: ");
                            nomepac = entrada.nextLine();

                            System.out.print("Digite a idade do paciente: ");
                            idadepac = entrada.nextInt();

                            System.out.println("""
        Qual o convenio do paciente?
        1. Amil
        2. Bradesco
        3. SulAmerica
        4. NotreDame
        5. Unimed """);
                            conveniopac = entrada.nextInt();

                            cli.adicionarPaciente(nomepac, idadepac, conveniopac);
                            break;

                        case 2:

                            //ALTERAR CADASTRO PACIENTE
                            System.out.println("Digite a posicao do paciente a ser alterado: ");
                            posicao = entrada.nextInt() - 1;
                            entrada.nextLine();
                            int tamArrayPac = cli.pacientes.size();
                            if (posicao >= 0 && posicao <= tamArrayPac) {
                                System.out.println("Digite o novo nome: ");
                                novoNome = entrada.nextLine();
                                System.out.println("Digite a nova idade: ");
                                novaIdade = entrada.nextInt();
                                System.out.println("Digite o novo Convenio: ");
                                System.out.println("""
                                       1. Amil
                                       2. Bradesco
                                       3. SulAmerica
                                       4. NotreDame
                                       5. Unimed""");
                                novoConvenio = entrada.nextInt();
                                cli.alterarPaciente(posicao, novoNome, novaIdade, novoConvenio);
                            } else {
                                System.out.println("Posicao invalida, tente novamente.");
                            }

                            break;
                        case 3:
                            //excluindo cadastro do paciente
                            cli.exibirPacientes();
                            System.out.println("Digite a posicao do paciente a ser excluido:");
                            posicao = entrada.nextInt() - 1;

                            tamArrayPac = cli.pacientes.size();
                            if (posicao >= 0 && posicao <= tamArrayPac) {
                                cli.excluirPaciente(posicao);
                            } else {
                                System.out.println("Posicao invalida, tente novamente.");
                            }

                            break;
                        case 4:
                            cli.exibirPacientes();

                            break;
                        case 5:

                            // AGENDANDO A CONSULTA
                            //data da consulta
                            System.out.println("Digite a data da consulta na seguinte maneira: DD/MM/AAAA");
                            dataC = entrada.next();

                            //hora da consulta
                            System.out.println("Digite a hora da consulta na seguinte maneira: HH:MM");
                            horaC = entrada.next();

                            //Selecionando o Tratamento e verificando se a posicao digitada pelo usuario é valida ou nao 
                            int tamArrayTrat = cli.tratamentos.size();
                            Boolean nTratB;

                            do {
                                cli.menuTratamentos();
                                System.out.println("\nDigite o tratamento desejado: ");
                                nTrat = entrada.nextInt() - 1;

                                if (nTrat >= 0 && nTrat < tamArrayTrat) {
                                    nTratB = true;
                                } else {
                                    nTratB = false;
                                    System.out.println("Numero de tratamento invalido tente novamente.");
                                }

                            } while (!nTratB);

                            //Selecionando o Dentista e verificando se a posicao digitada pelo usuario é valida ou nao.
                            int nDent = 0;
                            int tamArrayDent = cli.dentistas.size();
                            Boolean nDentB;
                            do {

                                cli.listarDentistas();
                                System.out.println("Digite o numero do dentista que vai realizar a consulta: ");
                                nDent = (entrada.nextInt() - 1);

                                if (nDent >= 0 && nDent < tamArrayDent) {
                                    nDentB = true;

                                } else {
                                    nDentB = false;
                                    System.out.println("Numero de dentista invalido, tente novamente.");
                                }
                            } while (!nDentB);

                            //Selecionando o Paciente e verificando se a posicao digitada pelo usuario é valida ou nao
                            int nPac = 0;
                            tamArrayPac = cli.pacientes.size();
                            Boolean nPacB;

                            do {
                                cli.exibirPacientes();
                                System.out.println("Digite o indice do paciente para marcar a consulta: ");
                                nPac = (entrada.nextInt() - 1);

                                if (nPac >= 0 && nPac < tamArrayPac) {
                                    nPacB = true;
                                } else {
                                    nPacB = false;
                                    System.out.println("Numero de paciente invalido, tente novamente");
                                }

                            } while (!nPacB);

                            //ADICIONANDO A ARRAY
                            cli.adicionarConsulta(dataC, horaC, nPac, nDent, nPac);

                            break;
                        case 6:
                            
                            // ALTERANDO A CONSULTA  

                            cli.listarConsulta();
                            System.out.println("Digite a consulta que quer alterar: ");
                            posicao = entrada.nextInt() - 1;
                            int tamArrayConsu = cli.consultas.size();

                            if (posicao >= 0 && posicao <= tamArrayConsu) {

                                System.out.println("Digite a nova data da consulta");
                                String novaData = entrada.next();
                                System.out.println("Digite o novo horario: ");
                                String novaHora = entrada.next();

                                cli.menuTratamentos();
                                System.out.println("Digite o novo tratamento: ");
                                int novoTrat = entrada.nextInt() - 1;

                                cli.listarDentistas();
                                System.out.println("Digite o novo dentista: ");
                                int novoDent = entrada.nextInt() - 1;

                                cli.exibirPacientes();
                                System.out.println("Digite o novo paciente: ");
                                int novoPac = entrada.nextInt() - 1;

                                cli.alterarConsulta(posicao, novaData, novaHora, novoTrat, novoDent, novoPac);

                                cli.listarConsulta();

                                System.out.println("Consulta alterada.");
                            } else {
                                System.out.println("Posicao invalida, tente novamente.");
                            }

                            break;

                        case 7:
                            //Excluindo Consulta       
                            cli.listarConsulta();
                            System.out.println("Digite a posicao da consulta que quer excluir: ");
                            posicao = entrada.nextInt() - 1;
                            tamArrayConsu = cli.consultas.size();

                            if (posicao >= 0 && posicao < +tamArrayConsu) {
                                cli.excluirConsulta(posicao);
                            } else {
                                System.out.println("Posicao invalida, tente novamente.");
                            }

                            break;

                        case 8:
                            // VERIFICANDO AS CONSULTAS         
                            cli.listarConsulta();

                            break;
                        case 0:
                            System.out.println("Encerrando o programa...");
                            break;
                        default:
                            // CASO NAO SEJA DIGITADA NENHUMA DAS OPCOES ACIMA                    
                            System.out.println("Opcao invalida, tente novamente.");
                    }
                } while (opcao < 0 || opcao > 8);

            } while (opcao != 0);

        } catch (InputMismatchException e) {
            System.out.println("Dado digitado invalido, rode o programa novamente.");

        }
    }
}
