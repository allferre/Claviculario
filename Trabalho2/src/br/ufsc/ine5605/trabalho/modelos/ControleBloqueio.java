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
public class ControleBloqueio implements Serializable {
    boolean bloqueado = false;
    int controle = 0;
    
    public ControleBloqueio() {
    
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    

    public int getControle() {
        return controle;
    }
    
    public void addTentativa(int i ) {
        controle += i;
    }
    
    public void desbloqueia(){
        if( bloqueado == true ){
            bloqueado = false;
        }
    }
    
    
}
