/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

/**
 *
 * @author usuario
 */
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFrame;

public class TelaPrincipal  extends JFrame{

    private ControladorPrincipal ctrlPrincipal;

    Scanner sc = new Scanner(System.in);

    public TelaPrincipal(ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
    
    public void exibeMenu() {

        int opcao = -1;
        int i = 0;
        do {
            System.out.println(" ---------------------------------------------------");
            System.out.println(" Digite 1 para operações com funcionarios ");
            System.out.println(" Digite 2 para operações com veiculos ");
            System.out.println(" Digite 3 para operações de emprestimos e devoluções ");
            System.out.println(" Digite 4 para listar relatorios ");
            System.out.println(" Digite 5 para teste das telas");
            System.out.println(" Digite 0 para encerrar o programa");
            System.out.println(" ---------------------------------------------------");
            try {
                if (i > 0) {
                    sc.nextLine();
                }
                opcao = sc.nextInt();
                i = 0;
            } catch (InputMismatchException e) {
                System.out.println(" Caracter inválido, favor repetir a operação ");
               
                opcao = -1;
                i++;
            }
            if (opcao > 5) {
                System.out.println(" Número inválido, digite apenas os números listados");
                System.out.println(" Repita a operação ");
                opcao = -1;
                i++;
            }
            switch (opcao) {
                case 1:
                    ctrlPrincipal.getCtrlF().iniciar();
                    break;
                case 2:
                    ctrlPrincipal.getCtrlV().iniciaTelaVeiculoPrincipal();
                    break;
                case 3:
                    ctrlPrincipal.getCtrlC().iniciaEmprestimo();
                    break;
                case 4:
                    ctrlPrincipal.getCtrlEv().inicia();
                    break;
               
                
            }

        } while (opcao != 0);
    }
}
