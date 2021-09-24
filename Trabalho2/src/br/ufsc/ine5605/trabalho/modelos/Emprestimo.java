/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Emprestimo  implements Serializable {
    Evento relatorio;
    AssocVeiculoFuncionario infoEmprestimo;
    ControladorFuncionario ctrlCadastro = ControladorFuncionario.getInstancia();
    Data date;
    
    public Emprestimo(AssocVeiculoFuncionario info,Data data){
        infoEmprestimo = info;
        this.relatorio= relatorio; 
        date = data;
    }

    public AssocVeiculoFuncionario getInfoEmprestimo() {
        return infoEmprestimo;
    }

    public Data getDate() {
        return date;
    }
    
    
}
