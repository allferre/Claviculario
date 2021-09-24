/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author usuario
 */
public class Data {
private Date diaMesAno;
private Date hora;
private Locale local;

public Data() {
    
    local = new Locale("pt","BR");
    diaMesAno = new Date();
    hora = new Date();
}

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setDiaMesAno(Date diaMesAno) {
        this.diaMesAno = diaMesAno;
    }
    
    public Date getDiaMesAno() {
        return diaMesAno;
    }
    
    public String mostraData(){ 
    String s = " ";
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy E",local);
     s =  sdf.format(this.diaMesAno);
     return s;
    }
        
    public String mostraHora(){
        String r = " ";
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss",local);
        r =  sdf.format(this.hora);
        return r;
    }
}

