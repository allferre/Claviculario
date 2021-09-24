/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

import br.ufsc.ine5605.trabalho.modelos.AssocVeiculoFuncionario;
import br.ufsc.ine5605.trabalho.modelos.Emprestimo;
import br.ufsc.ine5605.trabalho.telas.TelaEmprestaVeiculo;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ControladorEmprestimo {
   ArrayList<Emprestimo> listaEmprestimo;
   ArrayList<Emprestimo> devolucoes;
 
   private static ControladorEmprestimo instancia ;
    
   private  ControladorEmprestimo() {
    
        this.listaEmprestimo = new ArrayList<>();
        devolucoes = new ArrayList<>();
    }

    public static ControladorEmprestimo getInstancia() {
        if( instancia == null){
            instancia = new ControladorEmprestimo();
        }
        return instancia;
    }
    
   
    public void addEmprestimo(Emprestimo emprestimo){
        listaEmprestimo.add(emprestimo);
    }

    public ArrayList<Emprestimo> getListaEmprestimo() {
        return listaEmprestimo;
    }
    
    public boolean verificaSeCarroEstaEmprestado(int placa){
        boolean r = false;
        Emprestimo emprestimo = null ;
        for( int i = 0;  i <  listaEmprestimo.size(); i++){
            emprestimo = listaEmprestimo.get(i);
            if( emprestimo.getInfoEmprestimo().getVeiculo().getPlaca() == placa){
                r = true;
            }
        }
        return r;
        
    }
    
    public Emprestimo pegaEmprestimoPelaPlaca(int placa ){
        Emprestimo emprestimo = null ;
        Emprestimo saida = null ;
        for( int i = 0 ; i < listaEmprestimo.size() ; i++ ){
            emprestimo = listaEmprestimo.get(i);
            if( emprestimo.getInfoEmprestimo().getVeiculo().getPlaca() == placa){
                saida = listaEmprestimo.get(i);
            }
        }
        
        return saida;
    }

    public ArrayList<Emprestimo> getDevolucoes() {
        return devolucoes;
    }
    
    
    
}
    
    
   
    
   

