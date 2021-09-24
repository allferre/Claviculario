/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.modelos.Evento;
import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorEvento;
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class TelaEvento {

    Scanner sc;
    ControladorEvento ctrlRelatorio;

    public TelaEvento(ControladorEvento ctrlRelatorio) {
        this.sc = new Scanner(System.in);
        this.ctrlRelatorio = ctrlRelatorio;
        ControladorFuncionario ctrlCadastro = ControladorFuncionario.getInstancia();
    }

    public void exibeMenuInicial() {
        int opcao = 0;
        int i = 0;
        do {
            System.out.println(" Digite 1 para listar emprestimos permitidos ");
            System.out.println(" Digite 2 para listar emprestimos negados por falta de autorizacao");
            System.out.println(" Digite 3 para listar emprestimos negados por funcionario estar bloqueado ");
            System.out.println(" Digite 4 para listar emprestimo  negados por  placa nao existir ");
            System.out.println(" Digite 5 para listar emprestimos negados  por matricula nao existir");
            System.out.println(" Digite 6 para filtrar emprestimos negados por veículo estar indisponível");
            System.out.println(" Digite 7 para filtrar relatorios de um funcionario pela matricula ");
            System.out.println(" Digite 8 para filtrar relatórios pela placa do veículo ");
            System.out.println(" Digite 0 para encerrar a operação");
            try {
                if (i > 0) {
                    sc.nextLine();
                }
                opcao = sc.nextInt();
                i = 0;
            } catch (InputMismatchException e) {
                System.out.println(" Caracter inválido ");
                System.out.println(" ---------------- ");
                
                opcao = -1;
                i++;
            }

            if (opcao > 8) {
                System.out.println(" Digite apenas os números listados ");
                opcao = -1;
                i++;
            }
            switch (opcao) {
                case 1:
                    listaRelatorio();
                    break;
                case 2:
                    listaNegadosSemAutorizacao();
                    break;
                case 3:
                    listaNegadosBloqueio();
                    break;
                case 4:
                    listaNegadosPlacaInexistente();
                    break;
                case 5 :
                   listaNegadosMatriculaInexistente();
                   break;
                case 6:
                    listaNegadosPorstarEmprestado();
                    break;
                case 7:
                    filtraPelaMatricula();
                    break;
                case 8 : 
                    filtraPelaPlaca();
                    break;
            }

        } while (opcao != 0);

    }

    public void listaRelatorio() {
        if (ctrlRelatorio.getPermitidos().isEmpty()) {
            System.out.println(" Sem lista de emprestimos permitidos ");
            System.out.println(" -------------------------------------  ");
        } else {
            for (Evento relatorio : ctrlRelatorio.getPermitidos()) {
                System.out.println(" -------------------------------------------------------------------------------------");
                System.out.println("  Data do emprestimo : " + relatorio.getData().mostraData());
                System.out.println("  Hora do emprestimo : " + relatorio.getData().mostraHora());
                System.out.println("  Nome do Funcionario: " + relatorio.getInformacoes().getFuncionario().getNome());
                System.out.println("  Matricula: " + relatorio.getInformacoes().getFuncionario().getMatricula());
                System.out.println("  Placa do veiculo: " + relatorio.getInformacoes().getVeiculo().getPlaca());
                System.out.println("  Modelo do veiculo: " + relatorio.getInformacoes().getVeiculo().getModelo());
                System.out.println("  Ano do veiculo: " + relatorio.getInformacoes().getVeiculo().getAno());
                System.out.println("  Situação Empretismo: " + relatorio.getMotivo());
                System.out.println(" --------------------------------------------------------------------------------------");
            }

        }

    }

    public void listaNegadosSemAutorizacao() {
        if (ctrlRelatorio.getListaNegadoAutorizacao().isEmpty()) {
            System.out.println(" Sem lista de empréstimos negados por falta de autorização");
        } else {
            for (Evento relatorio : ctrlRelatorio.getListaNegadoAutorizacao()) {

                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + relatorio.getData().mostraData());
                System.out.println(" Hora da tentativa: " + relatorio.getData().mostraData());
                System.out.println(" Matricula do Funcionario: " + relatorio.getInformacoes().getFuncionario().getMatricula());
                try {
                    System.out.println(" Nome do funcionario " + relatorio.getInformacoes().getFuncionario().getNome());
                    System.out.println(" Placa do Veiculo " + relatorio.getInformacoes().getVeiculo().getPlaca());
                    System.out.println(" Modelo : " + relatorio.getInformacoes().getVeiculo().getModelo());
                    System.out.println(" Marca do Veiculo : " + relatorio.getInformacoes().getVeiculo().getMarca());
                    System.out.println(" Ano: " + relatorio.getInformacoes().getVeiculo().getAno());
                } catch (NullPointerException e) {

                }
                System.out.println(" Situação Empretismo: Funcionario não autorizado  ");
                System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }

    }

    public void listaNegadosBloqueio() {
        if (ctrlRelatorio.getListaNegadoAcessoBloqueado().isEmpty()) {
            System.out.println(" Sem lista de empréstimos negados por bloqueio ");
        } else {
            for (Evento relatorio : ctrlRelatorio.getListaNegadoAcessoBloqueado()) {

                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + relatorio.getData().mostraData());
                System.out.println(" Hora da tentativa: " + relatorio.getData().mostraData());
                System.out.println(" Nome do funcionario :" + relatorio.getInformacoes().getFuncionario().getNome());
                System.out.println(" Matricula do Funcionario: " + relatorio.getInformacoes().getFuncionario().getMatricula());
                System.out.println(" Situação Empretismo: Negado por Funcionario estar bloqueado  ");
                System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }

    }

    public void listaNegadosPlacaInexistente() {
        if (ctrlRelatorio.getListaNegadoPlacaInexistente().isEmpty()) {
            System.out.println(" Sem lista de empréstimos negados por placa não existir");
        } else {
            for (Evento relatorio : ctrlRelatorio.getListaNegadoPlacaInexistente()) {

                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + relatorio.getData().mostraData());
                System.out.println(" Hora da tentativa: " + relatorio.getData().mostraHora());
                System.out.println(" Matricula do Funcionario: " + relatorio.getInformacoes().getFuncionario().getMatricula());
              
                System.out.println(" Nome Funcionario " + relatorio.getInformacoes().getFuncionario().getNome());
                System.out.println(" Situação Empretismo: " + relatorio.getMotivo());
                System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }
    }

    public void listaNegadosMatriculaInexistente() {
        if (ctrlRelatorio.getListaNegadoMatriculaInexistente().isEmpty()) {
            System.out.println(" Sem lista de empréstimos negados por matrícula não existir  ");
        } else {
            for (Evento relatorio : ctrlRelatorio.getListaNegadoMatriculaInexistente()) {

                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + relatorio.getData().mostraData());
                System.out.println(" Hora da tentativa: " + relatorio.getData().mostraHora());
                System.out.println(" Matricula que tentou colocar: " + relatorio.getMatricula());
                System.out.println(" Situação Empretismo: Acesso negado " );
                System.out.println(" Motivo: Matricula não existe " );
                System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }

    }
    
    
    public void listaNegadosPorstarEmprestado(){
        if( ctrlRelatorio.getListaNegadosPorEstarEmprestado().isEmpty()){
            System.out.println(" Sem lista de empréstimo por carro estar emprestado " );
            
        }else {
            for(Evento evento : ctrlRelatorio.getListaNegadosPorEstarEmprestado()){
                System.out.println(" ------------------------------------------------------------------------------------------------- ");
                System.out.println(" Veiculo: ");
                System.out.println(" Placa: " + evento.getInformacoes().getVeiculo().getPlaca());
                System.out.println(" Modelo: "+ evento.getInformacoes().getVeiculo().getModelo());
                System.out.println(" Ano: "+ evento.getInformacoes().getVeiculo().getAno());
                System.out.println(" Nome: "+ evento.getInformacoes().getFuncionario().getNome());
                System.out.println(" Matricula: " + evento.getInformacoes().getFuncionario().getMatricula());
                System.out.println(" Data: " + evento.getData().mostraData());
                System.out.println(" Hora: " + evento.getData().mostraHora());
                System.out.println(" Acesso negado - Veículo indisponível - ");
                System.out.println(" -------------------------------------------------------------------------------------------------- ");
            }
        }
    }

    public void filtraPelaMatricula() {
        int matr = 0;
        Evento eventos = null;
        System.out.println(" Digite a matricula do funcionario que voce deseja filtrar ");
        try {
            matr = sc.nextInt();
            if(!ControladorPrincipal.getInstancia().getCtrlF().matriculaFuncionarioExiste(matr)){
                System.out.println(" Funcionario não cadastrado");
            }
        } catch (InputMismatchException e) {
            System.out.println(" Caracter invalido, favor repetir digitando somente numeros ");
        }

        for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoAcessoBloqueado().size(); i++) {
           eventos = ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoAcessoBloqueado().get(i);
            if (eventos.getInformacoes().getFuncionario().getMatricula() == matr) {
                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + eventos.getData().mostraData());
                System.out.println(" Hora da tentativa: " + eventos.getData().mostraHora());
                System.out.println(" Nome do funcionario: " + eventos.getInformacoes().getFuncionario().getNome());
                System.out.println(" Matricula do Funcionario: " + eventos.getInformacoes().getFuncionario().getMatricula());
                System.out.println(" Sem placa informada, pois funcionario teve sua matrícula bloqueada ");
                System.out.println(" Situação Empretismo: Negado por Funcionario estar bloqueado  ");
                System.out.println(" ------------------------------------------------------------ ");
            }
        }

        for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoAutorizacao().size(); i++) {
           eventos = ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoAutorizacao().get(i);
            if (eventos.getInformacoes().getFuncionario().getMatricula() == matr) {
                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + eventos.getData().mostraData());
                System.out.println(" Hora da tentativa: " + eventos.getData().mostraHora());
                System.out.println(" Nome do funcionário: " + eventos.getInformacoes().getFuncionario().getNome());
                System.out.println(" Matricula do Funcionario: " + eventos.getInformacoes().getFuncionario().getMatricula());
                try {
                    System.out.println(" Placa do Veiculo " + eventos.getInformacoes().getVeiculo().getPlaca());
                    System.out.println(" Modelo : " + eventos.getInformacoes().getVeiculo().getModelo());
                    System.out.println(" Marca do Veiculo : " + eventos.getInformacoes().getVeiculo().getMarca());
                    System.out.println(" Ano: " + eventos.getInformacoes().getVeiculo().getAno());
                } catch (NullPointerException e) {

                }
                System.out.println(" Situação Empretismo: Negado por falta de autorização ");
                System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }

        for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoPlacaInexistente().size(); i++) {
            eventos = ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoPlacaInexistente().get(i);
            if(eventos.getInformacoes().getFuncionario().getMatricula() == matr){
            System.out.println(" --------------------------------------------------------------------------------------- ");
            System.out.println(" Data da tentativa: " + ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoPlacaInexistente().get(i).getData().mostraData());
            System.out.println(" Hora da tentativa: " + ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoPlacaInexistente().get(i).getData().mostraHora());
            System.out.println(" Matricula do Funcionario: " + eventos.getInformacoes().getFuncionario().getMatricula());
            System.out.println(" Nome Funcionario " + eventos.getInformacoes().getFuncionario().getNome());
            System.out.println(" Situação Empretismo: " + eventos.getMotivo());
            System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }
        
       for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getPermitidos().size(); i++) {
            eventos = ControladorPrincipal.getInstancia().getCtrlEv().getPermitidos().get(i);
            if (eventos.getInformacoes().getFuncionario().getMatricula() == matr) {
                System.out.println(" -------------------------------------------------------------------------------------");
                System.out.println("  Data do emprestimo : " + eventos.getData().mostraData());
                System.out.println("  Hora do emprestimo : " + eventos.getData().mostraHora());
                System.out.println("  Nome do Funcionario: " + eventos.getInformacoes().getFuncionario().getNome());
                System.out.println("  Matricula: " + eventos.getInformacoes().getFuncionario().getMatricula());
                System.out.println("  Placa do veiculo: " + eventos.getInformacoes().getVeiculo().getPlaca());
                System.out.println("  Modelo do veiculo: " + eventos.getInformacoes().getVeiculo().getModelo());
                System.out.println("  Ano do veiculo: " + eventos.getInformacoes().getVeiculo().getAno());
                System.out.println("  Situação Empretismo: " + eventos.getMotivo());
                System.out.println(" --------------------------------------------------------------------------------------");
            }
        }

        for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadosPorEstarEmprestado().size(); i++) {
           eventos = ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadosPorEstarEmprestado().get(i);
            if(eventos.getInformacoes().getFuncionario().getMatricula() == matr){

            System.out.println(" -------------------------------------------------------------------------------------");
            
            System.out.println("  Nome do Funcionario: ");
            System.out.println("  Matricula: " + eventos.getInformacoes().getFuncionario().getMatricula());
            System.out.println("  Placa do veiculo: " + eventos.getInformacoes().getVeiculo().getPlaca());
            System.out.println("  Modelo do veiculo: " + eventos.getInformacoes().getVeiculo().getModelo());
            System.out.println("  Ano do veiculo: " + eventos.getInformacoes().getVeiculo().getAno());
            System.out.println("  Situação Empretismo: " + eventos.getMotivo());
            System.out.println("  Data tentativa  " + eventos.getData().mostraData());
            System.out.println("  SHora tentativa : " + eventos.getData().getHora());
            System.out.println(" Acesso Negado - Veículo Indisponível -  ");
            System.out.println(" --------------------------------------------------------------------------------------");
           }
           }
    }
    
    
    public void filtraPelaPlaca(){
        int placa = 0;
        Evento eventos = null;
        System.out.println(" Digite a placa do veículo  que voce deseja filtrar ");
        try {
            placa = sc.nextInt();
            if(!ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(placa)){
                
            }
        } catch (InputMismatchException e) {
            System.out.println(" Caracter invalido, favor repetir digitando somente numeros ");
        }

        for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoAutorizacao().size(); i++) {
            eventos = ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadoAutorizacao().get(i);
            if (eventos.getInformacoes().getVeiculo().getPlaca() == placa) {
                System.out.println(" --------------------------------------------------------------------------------------- ");
                System.out.println(" Data da tentativa: " + eventos.getData().mostraData());
                System.out.println(" Hora da tentativa: " + eventos.getData().mostraData());
                System.out.println(" Matricula do Funcionario: " + eventos.getInformacoes().getFuncionario().getMatricula());
                try {
                    System.out.println(" Placa do Veiculo " + eventos.getInformacoes().getVeiculo().getPlaca());
                    System.out.println(" Modelo : " + eventos.getInformacoes().getVeiculo().getModelo());
                    System.out.println(" Marca do Veiculo : " + eventos.getInformacoes().getVeiculo().getMarca());
                    System.out.println(" Ano: " + eventos.getInformacoes().getVeiculo().getAno());
                } catch (NullPointerException e) {

                }
                System.out.println(" Situação Empretismo: Negado por falta de autorização ");
                System.out.println(" ----------------------------------------------------------------------------------------- ");
            }
        }

        for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getPermitidos().size(); i++) {
            eventos = ControladorPrincipal.getInstancia().getCtrlEv().getPermitidos().get(i);
            if (eventos.getInformacoes().getVeiculo().getPlaca() == placa) {
                System.out.println(" -------------------------------------------------------------------------------------");
                System.out.println("  Data do emprestimo : " + eventos.getData().mostraData());
                System.out.println("  Hora do emprestimo : " + eventos.getData().mostraHora());
                System.out.println("  Nome do Funcionario: " + eventos.getInformacoes().getFuncionario().getNome());
                System.out.println("  Matricula: " + eventos.getInformacoes().getFuncionario().getMatricula());
                System.out.println("  Placa do veiculo: " + eventos.getInformacoes().getVeiculo().getPlaca());
                System.out.println("  Modelo do veiculo: " + eventos.getInformacoes().getVeiculo().getModelo());
                System.out.println("  Ano do veiculo: " + eventos.getInformacoes().getVeiculo().getAno());
                System.out.println("  Situação Empretismo: " + eventos.getMotivo());
                System.out.println(" --------------------------------------------------------------------------------------");
            }
        }
        
         for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadosPorEstarEmprestado().size(); i++) {
           eventos = ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadosPorEstarEmprestado().get(i);
            if(eventos.getInformacoes().getVeiculo().getPlaca() == placa){

            System.out.println(" -------------------------------------------------------------------------------------");
            
            System.out.println("  Nome do Funcionario: "+ eventos.getInformacoes().getFuncionario().getNome());
            System.out.println("  Matricula: " + eventos.getInformacoes().getFuncionario().getMatricula());
            System.out.println("  Placa do veiculo: " + eventos.getInformacoes().getVeiculo().getPlaca());
            System.out.println("  Modelo do veiculo: " + eventos.getInformacoes().getVeiculo().getModelo());
            System.out.println("  Ano do veiculo: " + eventos.getInformacoes().getVeiculo().getAno());
            System.out.println("  Situação empréstimo: Emprestimo negado ");
            System.out.println("  Motivo : Veiculo está indisponível ");
            System.out.println(" --------------------------------------------------------------------------------------");
           }
           }
    }
}

