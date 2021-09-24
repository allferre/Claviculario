/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Evento implements Serializable {
    String situacao;
    String motivo;
    Data data;
    AssocVeiculoFuncionario informacoes;
    int matricula;
    public Evento(AssocVeiculoFuncionario informacoesEmprestimo,String motivo,Data date,String situacao) {
        informacoes = informacoesEmprestimo;
        this.motivo = motivo;
        this.situacao = situacao;
        data = date;
    }
    public Evento(AssocVeiculoFuncionario informacoesEmprestimo,String motivo,Data date,String situacao,int matricula ) {
        informacoes = informacoesEmprestimo;
        this.motivo = motivo;
        this.situacao = situacao;
        data = date;
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
    
   
       
   

    public String getMotivo() {
        return motivo;
    }

    public AssocVeiculoFuncionario getInformacoes() {
        return informacoes;
    }
  
   
    public Data getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }
    
    
    
    
    
   
}
    

   