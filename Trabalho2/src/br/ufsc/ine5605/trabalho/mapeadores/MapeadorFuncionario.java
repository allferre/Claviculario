package br.ufsc.ine5605.trabalho.mapeadores;


import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.modelos.Funcionario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class MapeadorFuncionario {
    HashMap<Integer,Funcionario> cacheFuncionario = new HashMap<>();
   
    private final String  filename= "Funcionario.dat";

    public MapeadorFuncionario() {
         load();
    }
    
    
    
    public Funcionario get(Integer matricula){
        return cacheFuncionario.get(matricula);
    }
    
    
    public void put(Funcionario funcionario){
        cacheFuncionario.put(funcionario.getMatricula(), funcionario);
    }
    
    public void persist() {
        
        
        try {
           FileOutputStream fout = new FileOutputStream(filename);
        
            ObjectOutputStream memoria = new ObjectOutputStream(fout);
            
            memoria.writeObject(cacheFuncionario);
            
            memoria.flush();
            fout.flush();
            
            memoria.close();
            fout.close();
            
        } 
        catch( FileNotFoundException exc){
            System.out.println(exc);
        
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    
    public void load(){
        try{
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream saidaMemoria = new ObjectInputStream( fin);
            
            this.cacheFuncionario =  (HashMap<Integer,Funcionario>) saidaMemoria.readObject();
            saidaMemoria.close();
            fin.close();
           
            
            
        }catch( ClassNotFoundException ex){
            System.out.println(ex);
        }catch( FileNotFoundException e){
           
            System.out.println(e);
        }catch(IOException exc){
            System.out.println(exc);
        }
        
      
    }
    
    public Map<Integer,Funcionario> pegaListaAtualizada(){
        
        load();
        return cacheFuncionario;
        
        
    }
    
    
    public Collection<Funcionario> getListaFuncionario(){
        cacheFuncionario =  ControladorFuncionario.getInstancia().getListaFuncionario();
        return this.cacheFuncionario.values();
        
    }
}
