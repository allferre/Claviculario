/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class TelaExclusaoVeiculo extends JFrame{
    ControladorVeiculo ctrlVeiculo;
    EventoVeiculo gerenciador ;
    
    Scanner sc;
    
    JButton botaoOk;
   
    JLabel lbPlaca;
    
    
    
    
    
    JTextField tfPlaca;
    
    
    

    public TelaExclusaoVeiculo() {
    
       
        gerenciador = new EventoVeiculo();
        inicializa();
    }
    
    

    public void inicializa() {
      
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        
        //
        lbPlaca = new JLabel(" Placa  ");
        pacote.gridx = 0;
        pacote.gridy = 2;
        container.add(lbPlaca, pacote);
        
        
        tfPlaca=  new JTextField();
        
        
        tfPlaca.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 1;
        pacote.gridy = 2;
        container.add(tfPlaca,pacote);
        
      
        //
        
       
        
        
        //
        botaoOk = new JButton("OK");
        botaoOk.addActionListener(gerenciador);
       
        pacote.gridx = 1;
        pacote.gridy = 7;
        container.add(botaoOk, pacote);
        
        
       
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public String getTfPlaca(){
        return tfPlaca.getText();
    }
    
    public String mensagem( String mensagem){
        String m = mensagem;
        return m;
    }
 
    private class EventoVeiculo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            if (e.getSource() == botaoOk) {
                int placa  = parseInt(tfPlaca.getText());
             
                Veiculo excluido = ControladorVeiculo.getInstancia().pegaVeiculoPelaPlaca(placa);
               
                if( !ControladorVeiculo.getInstancia().existeEssaPlaca(placa)){
                    JOptionPane.showMessageDialog(null, " Veiculo não excluido,pois não existe nos registros  ");
                }else{
                    JOptionPane.showMessageDialog(null, " Excluido com sucesso ");
                    ControladorVeiculo.getInstancia().delVeiculo(excluido);
                }
                 System.out.println(ControladorVeiculo.getInstancia().getListaVeiculos().size());
            }
        }
    }
}

