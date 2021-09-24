/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import br.ufsc.ine5605.trabalho.telas.TelaAlteraVeiculo;
import br.ufsc.ine5605.trabalho.telas.TelaCadastroVeiculo;
import br.ufsc.ine5605.trabalho.telas.TelaExclusaoVeiculo;
import br.ufsc.ine5605.trabalho.telas.TelaExibeAssocVeicFunc;
import br.ufsc.ine5605.trabalho.telas.TelaExibeVeiculo;
import br.ufsc.ine5605.trabalho.telas.TelaVeiculoPrincipal;
import java.util.ArrayList;



/**
 *
 * @author Thiago
 */
public class ControladorVeiculo {

   TelaVeiculoPrincipal telaPrincipal;
   TelaExibeVeiculo telaExibeVeiculo;
   TelaCadastroVeiculo telaCadastro;
   TelaExclusaoVeiculo telaExclusao;
   TelaAlteraVeiculo telaAltera;
   TelaExibeAssocVeicFunc telaAssoc;
    private ArrayList<Veiculo> listaVeiculos;
    
   
    private static ControladorVeiculo instancia;

    private ControladorVeiculo() {
        listaVeiculos = new ArrayList<>();
        //Veiculo veiculo = new Veiculo (123 , "corsa" ,"sedan" ,1998 , 198489 );
        //listaVeiculos.add(veiculo);
        telaExibeVeiculo = new TelaExibeVeiculo();
        telaPrincipal = new TelaVeiculoPrincipal();
        telaCadastro = new TelaCadastroVeiculo();
        telaExclusao = new  TelaExclusaoVeiculo();
        telaAltera = new TelaAlteraVeiculo();
        telaAssoc = new TelaExibeAssocVeicFunc();
    }
     
   
    public static ControladorVeiculo getInstancia() {
        if (instancia == null) {
            instancia = new ControladorVeiculo();
        }
        return instancia;

    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    
    public void iniciaTelaAltera(){
        telaAltera.setVisible(true);
   }
    
    public void fechaTelaAtera(){
        telaAltera.setVisible(false);
    }
    
    public void iniciaTelaExcluir(){
    telaExclusao.setVisible(true);
}
    
    public void iniciaTelaCadastro(){
        telaCadastro.setVisible(true);
    }
    
    public void fechaTelaCadastro(){
        telaCadastro.setVisible(false);
    }

    public void iniciaTelaVeiculoPrincipal() {
        telaPrincipal.setVisible(true);
    }
    
    public void fechaTelaPrincipal(){
        telaPrincipal.setVisible(false);
    }
    
    public void iniciaListaVeiculo() {
        telaExibeVeiculo.mostra();
    }
    
    public void exibeTelaAssoc(){
        telaAssoc.setVisible(true);
    }
    
    public void fechaTelaAssoc(){
        telaAssoc.setVisible(false);
    }

    public void addVeiculo(int placa, String modelo, String marca, int ano, double quilometragem) {
      
        boolean placaCadastrada = false;
        Veiculo veiculo;
        veiculo = new Veiculo(placa, modelo, marca, ano, quilometragem);

        for (Veiculo cadastrados : listaVeiculos) {
            if (cadastrados.getPlaca() == veiculo.getPlaca() && listaVeiculos.contains(cadastrados)) {
                placaCadastrada = true;
                String m = NegacaoPermissao.Status6Carro.descricaoDoStatus;
                //tela.mensagem(m);

                break;
            }
        }

        if (!placaCadastrada) {
            listaVeiculos.add(veiculo);
            String me = " Cadastrado com sucesso ";
            //tela.mensagem(me);
        }
    }

    public boolean existeEssaPlaca(int placa) {
        boolean r = false;
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca() == placa) {
                r = true;
            }
        }
        if (r == false) {
            String mensagem = NegacaoPermissao.Status5Carro.descricaoDoStatus;
            //tela.mensagem(mensagem);
            

        }

        return r;

    }

    public Veiculo pegaVeiculoPelaPlaca(int placa) {
        Veiculo saida = null;
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca() == placa) {
                saida = veiculo;
               
            }
        }
        return saida;
    }
    
    public void alteraMarca(int placa, String marca) {
        try{
        if( existeEssaPlaca(placa)){
            for(Veiculo veiculoParaAlterar : listaVeiculos) {
                if(listaVeiculos.contains(veiculoParaAlterar) && veiculoParaAlterar.getPlaca() == placa) {
                    veiculoParaAlterar.setMarca(marca);
                
               
                for (int k = 0; k < veiculoParaAlterar.getListaFuncionario().size(); k++) {
                    if(veiculoParaAlterar.getListaFuncionario().get(k).getListaVeiculos().get(k).getPlaca() == placa){
                         veiculoParaAlterar.getListaFuncionario().get(k).getListaVeiculos().get(k).setMarca(marca);
                    }
                }
               
                }
                
            }

               
        }else{
            
         String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
         //tela.mensagem(mensagem);
           
        }
    }catch( IndexOutOfBoundsException e){
    }
    }
    
    public void alteraModelo(int placa, String modelo) {
        try{
        if (existeEssaPlaca(placa)) {
            for(Veiculo veiculoParaAlterar : listaVeiculos) {
                if(listaVeiculos.contains(veiculoParaAlterar) && veiculoParaAlterar.getPlaca() == placa) {
                    veiculoParaAlterar.setModelo(modelo);
                }
                
                for (int k = 0; k < veiculoParaAlterar.getListaFuncionario().size(); k++) {
                    if(veiculoParaAlterar.getListaFuncionario().get(k).getListaVeiculos().get(k).getPlaca() == placa){
                    veiculoParaAlterar.getListaFuncionario().get(k).getListaVeiculos().get(k).setModelo(modelo);
                    }
                }
            }
        }else{
          String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
        // tela.mensagem(mensagem);
        }
    }catch( IndexOutOfBoundsException e){
        
    }
    }
       
    
             
    public void alteraMarca(int placa, int ano) {
      
        if (existeEssaPlaca(placa)) {
            for(Veiculo veiculoParaAlterar : listaVeiculos) {
                if(listaVeiculos.contains(veiculoParaAlterar) && veiculoParaAlterar.getPlaca() == placa) {
                    veiculoParaAlterar.setAno(ano);
                }
              
                for (int k = 0; k < veiculoParaAlterar.getListaFuncionario().size(); k++) {
                    try{
                    if(veiculoParaAlterar.getListaFuncionario().get(k).getListaVeiculos().get(k).getPlaca() == placa){
                    veiculoParaAlterar.getListaFuncionario().get(k).getListaVeiculos().get(k).setAno(ano);
                    }
                    }catch(IndexOutOfBoundsException e){
                        
                    }
                }
                
            }
        }else{
          String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
          //tela.mensagem(mensagem);
        }

    }
    
    
    public void delVeiculo( Veiculo veiculo ){
        Veiculo cadastrados  = null;
        Funcionario funcionario = null;
        for( int i = 0 ; i < listaVeiculos.size(); i++){
            cadastrados = listaVeiculos.get(i);
         try{  
             if( veiculo.getPlaca() == cadastrados.getPlaca()){
               for(int  k = 0; k < cadastrados.getListaFuncionario().size(); k++){
               cadastrados.getListaFuncionario().get(k).getListaVeiculos().remove(cadastrados);
               }
               
               listaVeiculos.remove(cadastrados);
           }
         }catch(NullPointerException e ){
             String mensagem = NegacaoPermissao.Status5Carro.descricaoDoStatus;
             //tela.mensagem(mensagem);
         }
           
       
        }
    }

    public void iniciaTeste() {
        
    }

 
    
    
}
