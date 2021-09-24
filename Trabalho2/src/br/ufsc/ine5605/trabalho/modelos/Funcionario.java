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
 * @author info
 */
public abstract class Funcionario implements Autorizavel,Serializable {

    private ControleBloqueio bloqueio;
    private  String nome;
    private int matricula;
    private int telefone;
    private String cargo;
    private String dataNascimento;
    private final ArrayList<Veiculo> listaVeiculos;
    private final ArrayList<Evento>listaEventos;
    private final ArrayList<Emprestimo> listaEmprestimo;

    public Funcionario(String nome, int matricula, int telefone, String data, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.dataNascimento = data;
        this.cargo = cargo;
        listaVeiculos = new ArrayList<>();
        bloqueio = new ControleBloqueio();
        listaEventos = new ArrayList<>();
        listaEmprestimo = new ArrayList<>();
    }
    public ArrayList<Emprestimo> getListaEmprestimo() {
        return listaEmprestimo;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        listaEmprestimo.add(emprestimo);
    }

    public void delEmprestimo(Emprestimo emprestimo) {
        listaEmprestimo.remove(emprestimo);
    }

    public ControleBloqueio getBloqueio() {
        return bloqueio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void addVeiculo(Veiculo veiculo) {
        Veiculo veic = null;
        if (listaVeiculos.isEmpty() && veiculo != null) {
            listaVeiculos.add(veiculo);
            if (!veiculo.getListaFuncionario().contains(this)) {
                veiculo.getListaFuncionario().add(this);

            }
        } else {

            try {
                for (int i = 0; i < listaVeiculos.size(); i++) {
                    veic = listaVeiculos.get(i);
                    if (!listaVeiculos.contains(veiculo) && veic.getPlaca() != veiculo.getPlaca()) {
                        listaVeiculos.add(veiculo);
                    }
                    if (!veiculo.getListaFuncionario().contains(this)) {
                        veiculo.getListaFuncionario().add(this);
                    }
                }
            } catch (NullPointerException e) {
                
            }
        }
    }
    
    public void removeVeiculo(Veiculo veiculo ){
      Veiculo cadastrados = null ;
     if( veiculo != null){
      for( int i =0 ; i < listaVeiculos.size(); i++){  
        cadastrados = listaVeiculos.get(i);
          if(listaVeiculos.contains(veiculo) && cadastrados.getPlaca() == veiculo.getPlaca()){
          listaVeiculos.remove(veiculo);
         }
          
         if(veiculo.getListaFuncionario().contains(this)){
             veiculo.getListaFuncionario().remove(this);
         }
      }
     }
        
        
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }
    
    public void addEvento( Evento evento ){
        if( evento != null){
        listaEventos.add(evento);
        }
    }
}
