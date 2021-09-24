 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorClaviculario;
import br.ufsc.ine5605.trabalho.modelos.Emprestimo;
import br.ufsc.ine5605.trabalho.controladores.ControladorEmprestimo;
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class TelaClaviculario {

    Scanner sc;
    ControladorClaviculario clav;

    public TelaClaviculario(ControladorClaviculario clav) {
        this.clav = clav;
        sc = new Scanner(System.in);
    }

    public void exibeMenuInicial() {
        int opcao = -1;
        int i = 0;
        do {
            System.out.println(" 1 para efetuar um emprestimo ");
            System.out.println(" 2 para devolver uma chave ");
            System.out.println(" 3 para listar os emprestimos ");
            System.out.println(" 4 para listar devoluções ");
            System.out.println(" 0 para encerrar ");

            try {
                if (i > 0) {
                    sc.nextLine();
                }
                opcao = sc.nextInt();
                i = 0;
            } catch (InputMismatchException e) {
                System.out.println(" Digitou letra ou algum caracter especial, favor digitar somente numeros ");
                System.out.println(" Repita a operação ");
                System.out.println(" ----------------------------------------------------------------------- ");
                opcao = -1;
                i++;
            }
            if (opcao > 4) {
                System.out.println(" Digite apenas numeros listados ");
                System.out.println(" Repita a operação");
                System.out.println(" ------------------------------ ");
                 opcao = -1;
                 i++;
            }
            switch (opcao) {
                case 1:
                    pedeMatricula();
                    break;
                case 2:
                    devolucaoChave();
                    break;
                case 3:
                    listaEmprestimo();
                    break;
                case 4:
                    listaDevolucoes();
                    break;
            }

           
        } while (opcao != 0);
    }

    public int pedeMatricula() {
      
        int matr = 0;

        System.out.println(" Digite sua matricula ");

        try {

            matr = sc.nextInt();
            clav.liberaChaves(matr);
        } catch (InputMismatchException e) {
            System.out.println(" ------------------------------------ ");
            System.out.println(" Digitou letra, digite apenas números ");
            System.out.println(" ------------------------------------ ");
            sc.nextLine();
        }
       
       

        return matr;
    }

    public int PedePlaca() {
        int placa = 0;
        System.out.println(" Digite a placa do carro");
        try {
            placa = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Digitou letra, digite apenas numeros ");
        }
        return placa;
    }

    public void listaEmprestimo() {
        if (ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().isEmpty()) {
            System.out.println(" Nenhum emprestimo efetuado ");
        } else {
            Emprestimo empre = null;
            for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().size(); i++) {
                try {
                    System.out.println(" -------------------------------------------------------------------------------------------------------------------");

                    System.out.println(" Nome funcionario: " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getInfoEmprestimo().getFuncionario().getNome());
                    System.out.println(" Matricula funcionario: " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getInfoEmprestimo().getFuncionario().getMatricula());
                    System.out.println(" Placa com o Funcionario: " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getInfoEmprestimo().getVeiculo().getPlaca());
                    System.out.println(" Modelo do carro: " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getInfoEmprestimo().getVeiculo().getModelo());
                    System.out.println(" Marca do carro:  " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getInfoEmprestimo().getVeiculo().getMarca());
                    System.out.println(" Data do emprestimo:  " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getDate().mostraData());
                    System.out.println(" Hora do emprestimo:  " + ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().get(i).getDate().mostraHora());
                    System.out.println(" -------------------------------------------------------------------------------------------------------------------");
                } catch (NullPointerException e) {

                }
            }
        }
    }
    
    public void listaDevolucoes(){
        if (ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().isEmpty()) {
            System.out.println(" Nenhuma devolução efetuada ");
        } else {
            Emprestimo empre = null;
            for (int i = 0; i < ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().size(); i++) {
                try {
                    System.out.println(" -------------------------------------------------------------------------------------------------------------------");

                    System.out.println(" Nome funcionario: " + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getInfoEmprestimo().getFuncionario().getNome());
                    System.out.println(" Matricula funcionario:" + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getInfoEmprestimo().getFuncionario().getMatricula());
                    System.out.println(" Placa com o Funcionario:" + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getInfoEmprestimo().getVeiculo().getPlaca());
                    System.out.println(" Modelo do carro:" + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getInfoEmprestimo().getVeiculo().getModelo());
                    System.out.println(" Ano do carro:" + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getInfoEmprestimo().getVeiculo().getMarca());
                    System.out.println(" Data do emprestimo:" + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getDate().mostraData());
                    System.out.println(" Hora do emprestimo:" + ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().get(i).getDate().mostraHora());
                    System.out.println(" -------------------------------------------------------------------------------------------------------------------");
                } catch (NullPointerException e) {

                }
            }
        }
    }
    
   
        
    

    public void devolucaoChave() {
        int matr = 0;
        System.out.println(" Digite sua matricula ");
        try {
            matr = sc.nextInt();
           
        } catch (InputMismatchException e) {
            System.out.println(" Digitou caracter inválido ");
        }

        clav.devolveChave(matr);
    }

    public Double pedeQuilometragem() {
        double quilometragem = 0.0;
        try {
            System.out.println(" Quilometragem ao final do percurso ");
            quilometragem = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(" Digite apenas números ");
        }
        return quilometragem;
    }

    public void mensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
 
//funcoinario bloqueado nao pode ter veículo excluído