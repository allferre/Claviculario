/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

/**
 *
 * @author usuario
 */
public class AssocVeiculoFuncionario {
    private Veiculo veiculo;
    private Funcionario funcionario;
   

    public AssocVeiculoFuncionario(Veiculo veiculo, Funcionario funcionario) {
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioComum funcionario) {
        this.funcionario = funcionario;
    }

}
    
    
    
    
    
    
    
   
