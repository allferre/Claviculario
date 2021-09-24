/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

import br.ufsc.ine5605.trabalho.telas.TelaPrincipal;

/**
 *
 * @author usuario
 */
public class ControladorPrincipal {
    private  static ControladorPrincipal instancia;
    private TelaPrincipal telaPrincipal;
    private ControladorFuncionario ctrlF;
    private  ControladorVeiculo ctrlV;
    private ControladorClaviculario ctrlC;
    private ControladorEvento ctrlEv;
    private ControladorEmprestimo ctrlE;
    
    private ControladorPrincipal() {
        ctrlF = ControladorFuncionario.getInstancia();
        ctrlV = ControladorVeiculo.getInstancia();
        telaPrincipal = new TelaPrincipal(this);
        ctrlC = ControladorClaviculario.getInstancia();
        ctrlEv = ControladorEvento.getInstancia();
        ctrlE = ControladorEmprestimo.getInstancia();
        }
    
    public static  ControladorPrincipal getInstancia() {
        if(instancia == null) {
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }
    
    public void inicia() {
        telaPrincipal.exibeMenu();
    }

    public ControladorEmprestimo getCtrlE() {
        return ctrlE;
    }
    
    public void exibeMenuInicial() {
        telaPrincipal.setVisible(true);
    }

        

    
    
    public ControladorFuncionario getCtrlF() {
        return ctrlF;
    }

    public ControladorVeiculo getCtrlV() {
        return ctrlV;
    }

    public ControladorClaviculario getCtrlC() {
        return ctrlC;
    }

    public ControladorEvento getCtrlEv() {
        return ctrlEv;
    }
    
    
    
    
    
    
}

