/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

import br.ufsc.ine5605.trabalho.mapeadores.MapeadorFuncionario;
import br.ufsc.ine5605.trabalho.modelos.Diretor;
import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import br.ufsc.ine5605.trabalho.modelos.FuncionarioComum;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import br.ufsc.ine5605.trabalho.telas.TelaExclusaoFuncionario;
import br.ufsc.ine5605.trabalho.telas.TelaCadastroFuncionario;
import br.ufsc.ine5605.trabalho.telas.TelaExibeFuncionarios;
import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author info
 */
public class ControladorFuncionario implements Serializable{

    private final HashMap<Integer,Funcionario> listaFuncionario;
    private MapeadorFuncionario mapeadorFuncionario;
    TelaCadastroFuncionario tela;
    TelaExclusaoFuncionario telaExclusao;
    private static ControladorFuncionario instancia;

    public ControladorFuncionario() {
        listaFuncionario = new HashMap<>();
        mapeadorFuncionario = new MapeadorFuncionario();
        tela = new TelaCadastroFuncionario(this);
        telaExclusao = new TelaExclusaoFuncionario(this);
   

    }

    public static ControladorFuncionario getInstancia() {
        if (instancia == null) {
            instancia = new ControladorFuncionario();
        }
        return instancia;
    }

    public HashMap<Integer, Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }
    
    public Collection<Funcionario> pegaListaDoMapeador(){
       return mapeadorFuncionario.getListaFuncionario();
    }
    
  /* public ArrayList<Funcionario> transformaParaArray(){
       ArrayList<Funcionario> entrada= new ArrayList<Funcionario>(listaFuncionario.values());
       
       ArrayList<Integer> saida = ;
       Fucionario func = null;
      for( int i = 0 ; i < entrada.size(); i ++){
       saida.add(entrada.get(i).getMatricula());
      
    }*/
    
    

    

    public void iniciar() {
       //TelaExibeFuncionarios teste = new TelaExibeFuncionarios();
        //teste.atualiza();
        //teste.setVisible(true);
        
        tela.exibeMenuInicial();
    }
    
    public void loadDados() {
        mapeadorFuncionario.load();
    }

    public MapeadorFuncionario getMapeadorFuncionario() {
        return mapeadorFuncionario;
    }
    
   
    
   

    public void addFuncionario(String nome, int matr, int telefone, String cargo, String data) {
        boolean matriculaCadastrada = false;
        FuncionarioComum funcionario;
       
        
        if(listaFuncionario.get(matr) == null){
          funcionario = new FuncionarioComum(nome, matr, telefone, cargo, data);
          listaFuncionario.put(matr, funcionario);
          mapeadorFuncionario.put(funcionario);
          mapeadorFuncionario.persist();
           
          
            System.out.println(" Funcionario cadastrado ");
        }else{
            System.out.println(" Funcionario ja cadastrado ");
        }
        
        
        
    }

    public boolean matriculaFuncionarioExiste(int matricula) { // verifica se existe uma matricula fornecida
        boolean matriculaExiste = false;
        for (Funcionario func : mapeadorFuncionario.getListaFuncionario()) {
            if (matricula == func.getMatricula()) {
                matriculaExiste = true;
            }
        }
        return matriculaExiste;
    }

    public Funcionario pegaFuncionarioPelaMatricula(int matricula) { //retorna objeto funcionario
        Funcionario funcionario = null;
        for (Funcionario func : mapeadorFuncionario.getListaFuncionario()) {
            if (func.getMatricula() == matricula) {
                funcionario = func;
            }
        }
        return funcionario;
    }

    public boolean matriculaDiretorExiste(int matricula) { // verifica se existe um diretor com aquela matrícula
        boolean matriculaExiste = false;
        for (Funcionario func : mapeadorFuncionario.getListaFuncionario()) {
            if (matricula == func.getMatricula()) {
                matriculaExiste = true;
            }
        }
        return matriculaExiste;
    }

  

    public Veiculo pegaCarroEspecifico(int placa, int matricula) {
        Funcionario f = pegaFuncionarioPelaMatricula(matricula);
        Veiculo saida = null;
        for (int i = 0; i < f.getListaVeiculos().size(); i++) {
            if (placa == f.getListaVeiculos().get(i).getPlaca()) {
                saida = f.getListaVeiculos().get(i);
            }
        }
        return saida;

    }

    public int numeroDeCarrosAcessados(int matricula) {
        int n = 0;
        for (Funcionario f : mapeadorFuncionario.getListaFuncionario()) {
            if (matricula == f.getMatricula()) {
                n = f.getListaVeiculos().size();
            }
        }
        return n;
    }

    public void addDiretor(String nome, int matr, int tel, String data, String cargo) {
        

        if( listaFuncionario.get(matr) == null){
            Diretor diretor = new Diretor(nome, matr, tel, data, cargo);
            listaFuncionario.put(matr,diretor);
        }else{
            System.out.println(" Funcionario já existe ");
        }
    }

    public void delFuncionario(Funcionario funcionario) {
        Funcionario cadastrados = null;
        Veiculo veiculo = null;
        String mensagem  = "";
       
        
        if( listaFuncionario.get(funcionario.getMatricula()) != null){
            listaFuncionario.remove(funcionario.getMatricula());
            
        }else{
            System.out.println( "Funcionario nao existe ");
        }
    }

    public void exibeListaFuncionario() {
        tela.exibeListaFuncionarioComum();
    }

    public void exibeVeiculosFuncionario(FuncionarioComum funcionario) {
        tela.exibeVeiculosFuncionario(funcionario);
    }

    public Funcionario pegaDiretorPelaMatricula(int matricula) {
        Funcionario funcionario = null;
       
        if( listaFuncionario.get(matricula ) == null){
          
            System.out.println(" Funcionario nao existe ");
            
        }else{
            funcionario = listaFuncionario.get(matricula);
        }
        return funcionario;

    }

    public void desbloqueia(int matricula) {
        String m = " ";
        if (pegaFuncionarioPelaMatricula(matricula).getBloqueio().isBloqueado() == true) {
            pegaFuncionarioPelaMatricula(matricula).getBloqueio().desbloqueia();
            m = " Funcionario desbloqueado ";
            tela.mensagem(m);
        } else {
            m = " Funcionario não esta desbloqueado ";
            tela.mensagem(m);
        }
    }

    public void alteraNome(int matricula, String nome) {
     try{
        if (matriculaFuncionarioExiste(matricula)) {
            for (Funcionario funcionarioParaAlterar : mapeadorFuncionario.getListaFuncionario()) {
                if (/*listaFuncionario.contains(funcionarioParaAlterar)*/  funcionarioParaAlterar.getMatricula() == matricula) {
                    funcionarioParaAlterar.setNome(nome);
                String mensagem = NegacaoPermissao.StatusFuncionario8.descricaoDoStatus;
                tela.mensagem(mensagem);
                 if(funcionarioParaAlterar instanceof Diretor == false){
                for (int k = 0; k < funcionarioParaAlterar.getListaVeiculos().size(); k++) {
                    if(funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).getMatricula() == matricula ){
                    funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).setNome(nome);
                    }
                }
                }
                    
                }

            }
        } else {
          String mensagem = NegacaoPermissao.Status2Funcionario.descricaoDoStatus;
          tela.mensagem(mensagem);
        }
   
    
     }catch(IndexOutOfBoundsException e){
         
     }
   }

    public void alteraCargo(int matricula, String cargo) {
        try{
        if (matriculaFuncionarioExiste(matricula)) {
            for (Funcionario funcionarioParaAlterar : mapeadorFuncionario.getListaFuncionario()) {
                if (listaFuncionario.containsValue(funcionarioParaAlterar) && funcionarioParaAlterar.getMatricula() == matricula) {
                    funcionarioParaAlterar.setCargo(cargo);
                 String mensagem = NegacaoPermissao.StatusFuncionario8.descricaoDoStatus;
                tela.mensagem(mensagem);

                for (int k = 0; k < funcionarioParaAlterar.getListaVeiculos().size(); k++) {
                    if(funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).getMatricula() == matricula){
                        funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).setCargo(cargo);
                    }
                }
                
                }

            }
        } else {
          String mensagem = NegacaoPermissao.Status2Funcionario.descricaoDoStatus;
          tela.mensagem(mensagem);
        }
    }catch(IndexOutOfBoundsException e){
        
    }
    
}


    public void alteraTelefone(int matricula, int telefone) {
      try{
        if (matriculaFuncionarioExiste(matricula)) {
            for (Funcionario funcionarioParaAlterar : mapeadorFuncionario.getListaFuncionario()) {
                if (listaFuncionario.containsValue(funcionarioParaAlterar) && funcionarioParaAlterar.getMatricula() == matricula) {
                    funcionarioParaAlterar.setTelefone(telefone);
                 String mensagem = NegacaoPermissao.StatusFuncionario8.descricaoDoStatus;
                tela.mensagem(mensagem);

                for (int k = 0; k < funcionarioParaAlterar.getListaVeiculos().size(); k++) {
                    if(funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).getMatricula() == matricula ){
                        funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).setTelefone(telefone);
                        
                    }
                }
                }
            }
        } else { 
          String mensagem = NegacaoPermissao.Status2Funcionario.descricaoDoStatus;
          tela.mensagem(mensagem);

        }
      }catch(IndexOutOfBoundsException e ){
          
      }
    }

        
   

    public void alteraDataNascimento(int matricula, String dataNascimento) {
        try{
        if (matriculaFuncionarioExiste(matricula)) {
            for (Funcionario funcionarioParaAlterar : mapeadorFuncionario.getListaFuncionario()) {
                if (listaFuncionario.containsValue(funcionarioParaAlterar) && funcionarioParaAlterar.getMatricula() == matricula) {
                    funcionarioParaAlterar.setDataNascimento(dataNascimento);
                 String mensagem = NegacaoPermissao.StatusFuncionario8.descricaoDoStatus;
                tela.mensagem(mensagem);

                for (int k = 0; k < funcionarioParaAlterar.getListaVeiculos().size(); k++) {
                    if(funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).getMatricula() == matricula ){
                    funcionarioParaAlterar.getListaVeiculos().get(k).getListaFuncionario().get(k).setDataNascimento(dataNascimento);
                
                    }
                }
            }
        } 
    }else{
         String mensagem = NegacaoPermissao.Status2Funcionario.descricaoDoStatus;
          tela.mensagem(mensagem);
        }
        }catch(IndexOutOfBoundsException e){
            
        }
    }
        
        
        public Collection<Funcionario> retornaObjetoSalvo(){
          
           
          return mapeadorFuncionario.getListaFuncionario();
        }  
}


