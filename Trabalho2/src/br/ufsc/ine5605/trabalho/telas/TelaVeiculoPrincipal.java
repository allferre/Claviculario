  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author usuario
 */
public class TelaVeiculoPrincipal extends JFrame{
    
    JButton btCadastra;
    JButton btExclui;
    JButton btAltera;
    JButton btLista;
    JButton btListaAssoc;
    JButton btVolta;
    JButton btOk;
    JTextField teste;
    EventoTelaPrincipal  gerenciador = new EventoTelaPrincipal();

    public TelaVeiculoPrincipal() {
   
    inicializa();
    
    }
    
    public void inicializa(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        
        //
        btExclui = new JButton("Excluir");
        btExclui.setPreferredSize(new Dimension(150,25));
        btExclui.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 0;
        container.add(btExclui, pacote);
        //
        
        btCadastra = new JButton("Cadastrar");
        btCadastra.setPreferredSize(new Dimension(150,25));
        btCadastra.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 1;
        container.add(btCadastra, pacote);
        
        //
        btAltera  = new JButton("Alterar");
        btAltera.setPreferredSize(new Dimension(150,25));
        btAltera.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 2;
        container.add(btAltera, pacote);
        
        
         //
         
        btLista = new JButton("Listar");
        btLista.setPreferredSize(new Dimension(150,25));
        btLista.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 3;
        container.add(btLista, pacote);
        
        // 
        
        btListaAssoc = new JButton("Listar Associação");
        btListaAssoc.setPreferredSize(new Dimension( 150,25));
        btListaAssoc.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 4;
        container.add(btListaAssoc, pacote);
        
        
        //
        
        btVolta= new JButton("Voltar");
        btVolta.setPreferredSize(new Dimension( 150,25));
        btVolta.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 5;
        container.add(btVolta, pacote);
        
        /*btOk = new JButton( " Voltar ");
        btOk.addActionListener(gerenciador);
        pacote.fill = GridBagConstraints.SOUTH;
        pacote.weighty = 5 ;
        pacote.weightx = 2;
        
        
        container.add(btOk,pacote);*/
        
        
        

       
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        
    }

    private class EventoTelaPrincipal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
         
            if( e.getSource() == btCadastra){
               ControladorVeiculo.getInstancia().iniciaTelaCadastro();    
               }else if(e.getSource() == btLista){
               ControladorVeiculo.getInstancia().iniciaListaVeiculo();
            }else if ( e.getSource() == btExclui){
               ControladorVeiculo.getInstancia().iniciaTelaExcluir();  
            }else if( e.getSource() == btAltera){
                ControladorVeiculo.getInstancia().iniciaTelaAltera();
            }else if(e.getSource() == btListaAssoc){
                ControladorVeiculo.getInstancia().exibeTelaAssoc();
            }else if ( e.getSource() == btVolta){
                ControladorVeiculo.getInstancia().fechaTelaPrincipal();
            }
    }
    }
}

