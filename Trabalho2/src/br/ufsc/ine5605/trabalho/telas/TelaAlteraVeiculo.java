/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class TelaAlteraVeiculo extends JFrame{
   private  JButton btNome;
    JButton btMatricula;
    JButton btTelefone;
    JButton btCargo;
    JButton btDataNascimento;
    
    JTextField tfNome;
    
    JTextField tfTelefone;
    JTextField tfCargo;
    JTextField tfDataNascimento;
    JTextField tfMatricula;
    
    JLabel lbMatricula;
    GerenciadorBotoes gerenciador;

    public TelaAlteraVeiculo() {
    
      gerenciador = new GerenciadorBotoes();
      init();
    }

    public void init(){
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        
        
        btNome = new JButton("Nome");
        btNome.setPreferredSize(new Dimension( 100,25));
        btNome.addActionListener(gerenciador);
        pacote.fill = GridBagConstraints.EAST;
        pacote.gridx = 0;
        pacote.gridy = 0;
        container.add(btNome, pacote);
        
        tfNome= new JTextField();
        tfNome.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 2;
        pacote.gridy = 0;
        container.add(tfNome,pacote);
        //
        
        btTelefone = new JButton("Telefone");
        btTelefone.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 1;
        container.add(btTelefone, pacote);
        
        tfTelefone= new JTextField();
        tfTelefone.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 2;
        pacote.gridy = 1;
        container.add(tfTelefone,pacote);
        
        //
        btDataNascimento  = new JButton("Data de Nascimento ");
        btDataNascimento.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 2;
        container.add(btDataNascimento , pacote);
        
        tfDataNascimento= new JTextField();
        tfDataNascimento.setPreferredSize(new Dimension( 100,20));
        pacote.gridx = 2;
        pacote.gridy = 2;
        container.add(tfDataNascimento,pacote);
        
        btCargo  = new JButton("Cargo");
        btCargo .addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 3;
        container.add(btCargo , pacote);
        
        tfDataNascimento= new JTextField();
        tfDataNascimento.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 2;
        pacote.gridy = 3;
        container.add(tfDataNascimento,pacote);
        
        setSize(600,400);
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    
    
    
    
    private static class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            
        }

        
    }
    
    
    
    
    
    
    
}
