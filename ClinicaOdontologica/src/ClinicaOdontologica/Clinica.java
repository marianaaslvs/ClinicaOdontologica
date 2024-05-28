/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClinicaOdontologica;

import java.util.ArrayList;

public class Clinica {

//GERENCIADOR DE PACIENTE
    ArrayList<Paciente> pacientes = new ArrayList<>();

// ADICIONAR NOVOS PACIENTES SISTEMA[
    public void adicionarPacientesSist() {
        pacientes.add(new Paciente("Luiza dos Santos", 17, 3));
        pacientes.add(new Paciente("Carlos Oliveira", 45, 2));
        pacientes.add(new Paciente("Mariana Lima", 30, 1));
        pacientes.add(new Paciente("Fernanda Costa", 22, 5));
        pacientes.add(new Paciente("Joao Silva", 50, 4));
        pacientes.add(new Paciente("Paula Souza", 27, 2));
        pacientes.add(new Paciente("Ricardo Pereira", 35, 3));
        pacientes.add(new Paciente("Ana Martins", 40, 1));
        pacientes.add(new Paciente("Roberto Almeida", 29, 4));
        pacientes.add(new Paciente("Gabriela Ramos", 33, 5));

    }

// USUARIOS ADICIONAR NOVO PACIENTE A ARRAY
    public void adicionarPaciente(String nome, int idade, int convenio) {
        Paciente novoPaciente = new Paciente(nome, idade, convenio);
        pacientes.add(novoPaciente);
    }

    public void exibirPacientes() {
        String strconv = "Null";
        int pos = 1;
        for (Paciente paciente : pacientes) {
            switch (paciente.convenio) {
                case 1:
                    strconv = "Amil";
                    break;
                case 2:
                    strconv = "Bradesco";
                    break;
                case 3:
                    strconv = "SulAmerica";
                    break;
                case 4:
                    strconv = "NotreDame";
                    break;
                case 5:
                    strconv = "Unimed";
                    break;
                default:
                    strconv = "Sem convenio";
                    break;
            }
            System.out.println(pos + ". " + "Nome: " + paciente.nome + ", Idade: " + paciente.idade + ", Convenio: " + strconv);
            pos++;
        }
    }

    public void alterarPaciente(int posicao, String novoNome, int novaIdade, int novoConvenio) {

        Paciente paciente = pacientes.get(posicao);
        paciente.nome = novoNome;
        paciente.idade = novaIdade;
        paciente.convenio = novoConvenio;

    }

    public void excluirPaciente(int posicao) {
        pacientes.remove(posicao);
    }

//GERENCIADOR DE DENTISTA
    ArrayList<Dentista> dentistas = new ArrayList<>();

    public void incluirDentistas() {
        dentistas.add(new Dentista("Dr. Marco Antonio Silva", "SP-12345"));
        dentistas.add(new Dentista("Dra. Livia Carvalho Rocha", "SP-23456"));
        dentistas.add(new Dentista("Dr. Renato Guimaraes", "SP-34567"));
        dentistas.add(new Dentista("Dra. Camila Fernandes Tavares", " SP-45678"));
        dentistas.add(new Dentista("Dr. Lucas Mendonca Barros", "SP-56789"));
        dentistas.add(new Dentista("Dra. Sofia Correia Lima", "SP-67890"));
    }

    public void listarDentistas() {
        System.out.println("***** LISTA DE DENTISTAS *****");
        int pos = 1;
        for (Dentista d : dentistas) {
            System.out.println(pos + ". " + "Nome do Dentista: " + d.nome + " |CRO: " + d.cro);
            pos++;
        }
    }

//GERENCIADOR DE TRATAMENTO
    ArrayList<Tratamento> tratamentos = new ArrayList<>();

    public void menuTratamentos() {
        System.out.println("***** TRATAMENTOS DISPONIVEIS *****");
        int pos = 1;
        for (Tratamento t : tratamentos) {
            System.out.printf("\n" + pos + ". " + t.nomeTrat + " $%.2f", t.valorTrat);
            pos++;

        }
    }

    public void incluirTratamentos() {
        tratamentos.add(new Tratamento("Consulta de avaliacao", 250));
        tratamentos.add(new Tratamento("Limpeza Dental", 250));
        tratamentos.add(new Tratamento("Obturacao Simples (Amalgama ou Resina)", 250));
        tratamentos.add(new Tratamento("Extracao Dentaria Simples", 200));
        tratamentos.add(new Tratamento("Tratamento de Canal(Endodontia)", 1000));
        tratamentos.add(new Tratamento("Coroa Dentaria (Protese Fixa)", 1650));
        tratamentos.add(new Tratamento("Clareamento Dental a Laser", 1000));
        tratamentos.add(new Tratamento("Implante Dentario", 3500));
        tratamentos.add(new Tratamento("Aparelho Ortodontico Fixo(Tratamento Completo)", 5000));
        tratamentos.add(new Tratamento("Cirurgia de Gengiva(Gengivoplastia/Gengivectomia)", 1500));
        tratamentos.add(new Tratamento("Protese Dentaria Removivel(Dentadura)", 1900));

    }

    //GERENCIADOR CONSULTA
    ArrayList<Consulta> consultas = new ArrayList<>();

    public void adicionarConsulta(String d, String h, int t, int de, int p) {
        Consulta c = new Consulta();

        c.data = d;
        c.hora = h;

        Tratamento tr = tratamentos.get(t);
        c.tratamento = tr;

        Dentista dr = dentistas.get(de);
        c.dentista = dr;

        Paciente pt = pacientes.get(p);
        c.paciente = pt;

        consultas.add(c);

    }

    public void listarConsulta() {
        int tam = consultas.size();
        if (tam < 1) {
            System.out.println("Sem consultas agendadas.");
        } else {
            int pos = 1;
            System.out.println("***** CONSULTAS MARCADAS *****");
            for (Consulta c : consultas) {
                System.out.println("________________________________________________________________________________");
                System.out.printf("\n|" + pos + ". " + "Nome Paciente: " + c.paciente.nome + "| Dentista: " + c.dentista.nome + "\nData: " + c.data + "| Hora: " + c.hora + "| Tratamento: " + c.tratamento.nomeTrat + "| Valor Tratamento: R$%.2f|\n", c.tratamento.valorTrat);

                pos++;
            }
            System.out.println("________________________________________________________________________________");
        }
    }

    public void alterarConsulta(int posicao, String d, String h, int t, int dent, int pac) {

        Consulta consulta = consultas.get(posicao);

        consulta.data = d;
        consulta.hora = h;

        Tratamento tr = tratamentos.get(t);
        consulta.tratamento = tr;

        Dentista dr = dentistas.get(dent);
        consulta.dentista = dr;

        Paciente pt = pacientes.get(pac);
        consulta.paciente = pt;
    }

    public void excluirConsulta(int posicao) {

        consultas.remove(posicao);

    }
}
