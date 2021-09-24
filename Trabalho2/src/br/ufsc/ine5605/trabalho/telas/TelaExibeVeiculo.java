/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class TelaExibeVeiculo extends JFrame{
    private ControladorPrincipal ctrl;
    private GerenciaBotoes gerenciador;

    private JButton btVolta;


    private JScrollPane base;
    private JTable tabela = new JTable();
    
    public TelaExibeVeiculo() {
    
        gerenciador = new GerenciaBotoes();
     
    

      
    }

    public  void init() {
        
        //Definir Container e Layout
        
        Container container = getContentPane();
        container.setLayout( new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        /*btVolta = new JButton( " Voltar ao menu principal ");
        btVolta.addActionListener(gerenciador);
        pacote.gridx = 1;
        pacote.gridy = 0;
        
        container.add(btVolta,pacote);*/
        
      
        tabela.setPreferredScrollableViewportSize(new Dimension(500,70));
        tabela.setFillsViewportHeight(true);
        
        
       
        
        base = new JScrollPane( tabela);
        container.add(base,pacote);
        
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        atualiza();
        

    }
   
    public void mostra(){
        setVisible(true);
        
        init();
    }
   
  
    // classe precisa de uma implementação de actionlistener,outra opção
   
  /*public void atualiza(){
      DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn(" Placa ");
       modelo.addColumn(" Modelo ");
       modelo.addColumn(" Marca ");
       modelo.addColumn(" Quilometragem ");
       modelo.addColumn(" Ano ");
       
       
      
    
       for(Veiculo veiculo  : ControladorVeiculo.getInstancia().getListaVeiculos()){
           
           modelo.addRow(new Object[]{veiculo.getPlaca(),veiculo.getModelo(),veiculo.getMarca(),veiculo.getQuilometragemAtual(),veiculo.getAno()});
       }
       
       tabela.setModel(modelo);
       
   }*/
    public void atualiza (){
        DefaultTableModel modelo = new DefaultTableModel();
       Veiculo veiculo = null;
        
       for (int i= 0; i <ControladorVeiculo.getInstancia().getListaVeiculos().size(); i++) {
           veiculo = ControladorVeiculo.getInstancia().getListaVeiculos().get(i);
          
           modelo.addColumn(veiculo.getPlaca());
           
            for (int k = 0; k < veiculo.getListaFuncionario().size(); k++) {
                
                  modelo.addRow(new Object[]{null});
                  modelo.setValueAt(veiculo.getListaFuncionario().get(k).getNome(),k,i);
                 
              
            }
           
       }
       
     tabela.setModel(modelo);
   }
   
  
   
   
    public JTable getTabela() {
        return tabela;
    }
   
  
    private class GerenciaBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          if(e.getSource() == btVolta){
            
            
            
            
            
          }
        }
    
  }
}
