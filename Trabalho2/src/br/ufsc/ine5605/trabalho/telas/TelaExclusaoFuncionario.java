/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author usuario
 */
public class TelaExclusaoFuncionario extends JFrame{
    ControladorFuncionario ctrlFuncionario;
    EventoVeiculo gerenciador ;
    
    Scanner sc;
    
    JButton botaoOk;
   
    JLabel lbMatricula;
    
    
    
    
    
    JTextField tfMatricula;
    
    
    

    public TelaExclusaoFuncionario(ControladorFuncionario ctrl) {
        ctrlFuncionario = ctrl;
        sc = new Scanner(System.in);
        gerenciador = new EventoVeiculo();
        inicializa();
    }
    
    

    public void inicializa() {
      
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        
        //
        lbMatricula = new JLabel(" Matricula  ");
        pacote.gridx = 0;
        pacote.gridy = 2;
        container.add(lbMatricula, pacote);
        
        
        tfMatricula=  new JTextField();
        
        
        tfMatricula.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 1;
        pacote.gridy = 2;
        container.add(tfMatricula,pacote);
        
      
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
    
    public String mensagem( String mensagem){
        String m = mensagem;
        return m;
    }
    
   public boolean analisaString(String entrada){
       boolean saida = false; 
       char letra = ' ';
       for( int i = 0 ; i < entrada.length() - 1 ; i++ ){
           letra =  entrada.charAt(i);
           if( Character.isDigit(letra)){
               saida = true;
               
           }
       }
   
       return saida;
   }
   
  /* public void atualiza()){
       DefaultGridBagModel modelo = 
   }*/
    
    private class EventoVeiculo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            if (e.getSource() == botaoOk) {
                int matricula = parseInt(tfMatricula.getText());
                Funcionario excluido = ControladorFuncionario.getInstancia().pegaFuncionarioPelaMatricula(matricula);
                ControladorFuncionario.getInstancia().delFuncionario(excluido);
                System.out.println(ControladorFuncionario.getInstancia().getListaFuncionario().size());
            }
        }
    }
}
