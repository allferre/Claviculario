/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorClaviculario;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class TelaClavicularioPrincipal extends JFrame{
   
    JButton btEmpresta;
    JButton btDevolve;
    JButton btListaDev;
    JTextField teste;
    EventoTelaPrincipal  gerenciador ;

    public TelaClavicularioPrincipal() {
    gerenciador = new EventoTelaPrincipal();
    inicializa();
    
    }
    
    public void inicializa(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        //
        btEmpresta = new JButton("Emprestar");
        btEmpresta.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 7;
        container.add(btEmpresta, pacote);
        //
        btDevolve = new JButton("Listar Devoluções");
        btDevolve.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 7;
        container.add(btDevolve, pacote);
        //
        btListaDev = new JButton("Listar");
        btListaDev.addActionListener(gerenciador);
        pacote.gridx = 3;
        pacote.gridy = 7;
        container.add(btListaDev, pacote);
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
   
    }

    private class EventoTelaPrincipal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
         
            if( e.getSource() == btEmpresta){
                  ControladorClaviculario.getInstancia().iniciaEmprestimo();
               }else if(e.getSource() == btDevolve){
                   
                 }else if ( e.getSource() == btListaDev){
                     
                 }
        }
    }
}
            