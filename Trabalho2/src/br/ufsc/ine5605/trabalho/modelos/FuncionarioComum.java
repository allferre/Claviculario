/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

import java.util.ArrayList;

/**
 *
 * @author info
 */
public class FuncionarioComum extends Funcionario {

    public FuncionarioComum(String nome, int matricula, int telefone, String data, String cargo) {
        super(nome, matricula, telefone, data, cargo);
    }

    @Override
    public boolean autoriza(int placa) {
        boolean r = false;

        for (int i = 0; i < getListaVeiculos().size(); i++) {
            if (getListaVeiculos().get(i).getPlaca() == placa) {
                r = true;
            }
        }
        return r;
    }

}
