/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

/**
 *
 * @author info
 */
public class Diretor extends Funcionario {

    public Diretor(String nome, int matricula, int telefone,String data,String cargo) {
        super(nome, matricula, telefone,data,cargo);
        setCargo("DIRETOR");
        
    }
    
@Override
    public boolean autoriza(int placa){
        return true;
    }
   

    
}
