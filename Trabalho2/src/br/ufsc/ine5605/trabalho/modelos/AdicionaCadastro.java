package br.ufsc.ine5605.trabalho.modelos;

import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author usuario
 */
public class AdicionaCadastro {

    public AdicionaCadastro() {
    
    ControladorPrincipal.getInstancia().getCtrlV().addVeiculo(123, "  fit " , " wolk ", 1990 , 1681981);
    ControladorPrincipal.getInstancia().getCtrlV().addVeiculo(1234," jeep   " , " compass do tio  jean  ", 1990 , 1681981);
    ControladorPrincipal.getInstancia().getCtrlV().addVeiculo(12345," golf " , " honda  ", 1990 , 1681981);
    
    
    ControladorPrincipal.getInstancia().getCtrlF().addFuncionario("Thiago", 001 , 819618 , "180798" , "estagiario" );
    ControladorPrincipal.getInstancia().getCtrlF().addFuncionario("joao", 002, 819618 , "050694" , "escravo ");
    ControladorPrincipal.getInstancia().getCtrlF().addFuncionario("lucas", 003 , 819618 , "010380" , "motorista");
    ControladorPrincipal.getInstancia().getCtrlF().addDiretor("Alexandre Gonçalves Senhor do Python ", 004 , 819618 , "054280" , " tudo é diretor ");
    
   
    
    }
    
    
   
}
