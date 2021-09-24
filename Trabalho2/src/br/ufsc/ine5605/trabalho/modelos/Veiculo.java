/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Veiculo implements Serializable{
    int placa;
    String modelo;
    String marca;
    int ano;
    double quilometragemAtual;
    ArrayList<Funcionario> listaFuncionario;
   

    public Veiculo(int placa, String modelo, String marca, int ano, double quilometragemAtual) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.quilometragemAtual = quilometragemAtual;
        listaFuncionario = new ArrayList<>();
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragemAtual() {
        return quilometragemAtual;
    }
    
    public boolean quilometragemEhvalida(double quilometragemDevolucao ){
        boolean saida = false;
         
        if( quilometragemDevolucao > this.quilometragemAtual){
            saida = true;
        }
        return saida;
    }
            
    public void atualizaQuiloemtragem(double quilometragemDevolucao) {
        double caminhoPercorrido = quilometragemDevolucao -  this.quilometragemAtual;
        this.quilometragemAtual += caminhoPercorrido;
    }
    
    public void addFuncionario(FuncionarioComum funcionario){
        for( Funcionario func : listaFuncionario){
            if(! listaFuncionario.contains(funcionario) && funcionario.getMatricula() != func.getMatricula()){
                  listaFuncionario.add(funcionario);
            }
            if( ! funcionario.getListaVeiculos().contains(this)){
                funcionario.getListaVeiculos().add(this);
            }
        }
    }
    
   

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }
    
   
 

    public void setListaFuncionario(ArrayList<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

   
    
    
}
