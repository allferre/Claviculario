/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.controladores.EntradaInvalida;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Thiago
 */
public class TelaCadastroVeiculo extends JFrame{

    ControladorVeiculo ctrlVeiculo;
    EventoVeiculo gerenciador ;

    
    JButton botaoOk;
    JButton btVolta;
    JLabel lbPlaca;
    JLabel lbModelo;
    JLabel lbAno;
    JLabel lbQuilometragem;
    JLabel lbMarca;
    JLabel lbMenuInicial;
    JLabel lbOpcaoCadastrob;
    
    
    JTextField tfPlaca;
    JTextField tfMarca;
    JTextField tfAno;
    JTextField tfQuilometragem;
    JTextField tfModelo;
    
    

    public TelaCadastroVeiculo() {
        
       
        gerenciador = new EventoVeiculo();
       inicializa();
    }
    
    

    public void inicializa() {
      
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        
       
        
        lbMarca = new JLabel( " Marca  ");
        pacote.gridx = 0;
        pacote.gridy = 0;
        container.add(lbMarca,pacote);
        
        tfMarca = new JTextField();
        tfMarca.setPreferredSize(new Dimension( 100,20));
        pacote.gridx = 1;
        pacote.gridy = 0;
        container.add(tfMarca, pacote);
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
        
        lbAno = new JLabel("Ano ");
        pacote.gridx = 0;
        pacote.gridy = 3;
        container.add(lbAno, pacote);
        
        tfAno= new JTextField();
        tfAno.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 1;
        pacote.gridy = 3;
        container.add(tfAno,pacote);
        
        //
        
        lbModelo = new JLabel("Modelo ");
        pacote.gridx = 0;
        pacote.gridy = 4;
        container.add(lbModelo, pacote);
        
        tfModelo= new JTextField();
        tfModelo.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 1;
        pacote.gridy = 4;
        container.add(tfModelo,pacote);
        //
        
        
        lbQuilometragem = new JLabel("Quilometragem ");
        pacote.gridx = 0;
        pacote.gridy = 5;
        container.add(lbQuilometragem, pacote);
        
        tfQuilometragem = new JTextField();
        tfQuilometragem.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 1;
        pacote.gridy = 5;
        container.add(tfQuilometragem ,pacote);
        
        
        //
        botaoOk = new JButton("OK");
        botaoOk.setPreferredSize( new Dimension( 120,25));
        botaoOk.addActionListener(gerenciador);
        pacote.gridx = 0;
        pacote.gridy = 7;
        container.add(botaoOk, pacote);
        
        btVolta = new JButton("Volta");
        btVolta.setPreferredSize(new Dimension( 120, 25));
        btVolta.addActionListener( gerenciador);
        pacote.gridx = 1;
        pacote.gridy = 7;
        container.add(btVolta,pacote);
        
        /*JTable tabela = new JTable();
        tabela.setPreferredScrollableViewportSize(new Dimension( 500,20)); // posiciona o scroll 
        tabela.setFillsViewportHeight(true);
        pacote.fill = GridBagConstraints.CENTER;
        pacote.gridwidth = 2;
        pacote.gridheight = 4;
        
        JScrollPane base =  new JScrollPane(tabela);
        container.add(base,pacote);*/
       
        setSize(400,300);
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
   
   public void voltaAqui(){
       setVisible(true);
   }
   
  /* public void atualiza()){
       DefaultGridBagModel modelo = 
   }*/
   
   public void limpaText(){
    tfPlaca.setText("");
    tfMarca.setText("");
    tfAno.setText("");
    tfQuilometragem.setText("");
    tfModelo.setText("");
   }
    
    private class EventoVeiculo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            
            if (e.getSource() == botaoOk) {
                if(!ControladorVeiculo.getInstancia().existeEssaPlaca(parseInt(tfPlaca.getText()))){
                int placa = parseInt(tfPlaca.getText());
                int ano =  parseInt(tfAno.getText());
                double  quilometragem = parseDouble(tfQuilometragem.getText());
                ControladorVeiculo.getInstancia().addVeiculo(placa, tfModelo.getText(), tfMarca.getText(), ano, quilometragem);
                System.out.println(ControladorVeiculo.getInstancia().getListaVeiculos().size());
                JOptionPane.showMessageDialog(null," Cadastro efetuado ");
                limpaText();
                setVisible(false);
                }else{
                    limpaText();
                    JOptionPane.showMessageDialog(null," Placa já existe, Cadastro não efetuado ");
                }
            }else{
                limpaText();
                ControladorVeiculo.getInstancia().fechaTelaCadastro();
            }
             
        }
        
    }
}
            
// tamanho da cache =  numero de linhas( igual a bloco ) * capacidade de cada linha( bloco de palavras, word  em bits) em potencia de 2   mais    16 linhas * tamanho do tag 
//calcular tamanho do tag , sempre é o tamanho do endereço - numeros de bits da word - bits de endereço - bits de word - bits de byte 
//maior associatividade maior numero de conjuntos, mia conjunto menos linha e menos conflitos 