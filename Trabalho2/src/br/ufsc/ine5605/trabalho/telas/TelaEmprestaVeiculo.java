/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorClaviculario;
import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.controladores.NegacaoPermissao;
import br.ufsc.ine5605.trabalho.modelos.AssocVeiculoFuncionario;
import br.ufsc.ine5605.trabalho.modelos.Data;
import br.ufsc.ine5605.trabalho.modelos.Diretor;
import br.ufsc.ine5605.trabalho.modelos.Emprestimo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author usuario
 */
public class TelaEmprestaVeiculo extends JFrame{
   private  JButton btok;
   private JButton btDevolve;
   private  JTextField tfMatricula;
   private  JTextField tfPlaca;
   private  JLabel lbMatricula;
   private  JLabel lbPlaca;
   private  GerenciadorBotoes gerenciador;
    
    public TelaEmprestaVeiculo() {
     
        gerenciador = new GerenciadorBotoes();
    
        inicializa();
    }
    
    public void inicializa() {
      
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        lbMatricula= new JLabel( "Matricula");
        pacote.gridx = 0;
        pacote.gridy = 0;
        container.add(lbMatricula,pacote);
        
        tfMatricula = new JTextField();
        tfMatricula.setPreferredSize(new Dimension( 100,20));
        pacote.gridx = 1;
        pacote.gridy = 0;
        container.add(tfMatricula, pacote);
        //
        lbPlaca = new JLabel("Placa");
        pacote.gridx = 0;
        pacote.gridy = 2;
        container.add(lbPlaca, pacote);
        
        tfPlaca = new JTextField();
        tfPlaca.setPreferredSize(new Dimension(100,20));
        pacote.gridx = 1;
        pacote.gridy = 2;
        container.add(tfPlaca,pacote);
        
        btok = new JButton("Emprestar");
        pacote.gridx = 0;
        pacote.gridy = 3;
        btok.setPreferredSize(new Dimension( 100,20));
        btok.addActionListener(gerenciador);
        container.add(btok, pacote);
        
        btDevolve= new JButton("Emprestar");
        pacote.gridx = 1;
        pacote.gridy = 3;
        btDevolve.setPreferredSize(new Dimension( 100,20));
        btDevolve.addActionListener(gerenciador);
        container.add(btDevolve, pacote);
        
        
        
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
     
    
    
}

    private class GerenciadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == btok) {
                if (ControladorFuncionario.getInstancia().matriculaFuncionarioExiste(parseInt(tfMatricula.getText()))) {

                    if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(parseInt(tfMatricula.getText())) instanceof Diretor == false) {

                        if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(parseInt(tfMatricula.getText())).getBloqueio().isBloqueado() == false) {

                            if (ControladorPrincipal.getInstancia().getCtrlF().numeroDeCarrosAcessados(parseInt(tfMatricula.getText())) == 0) {
                                     JOptionPane.showMessageDialog(null, "  Funcionaio não tem carro cadastrado ");
                            } else if (ControladorPrincipal.getInstancia().getCtrlF().numeroDeCarrosAcessados(parseInt(tfMatricula.getText())) >= 1) {

                                if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(parseInt( tfPlaca.getText()))) {

                                    if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(parseInt(tfMatricula.getText())).autoriza(parseInt( tfPlaca.getText()))) {

                                        if (!ControladorPrincipal.getInstancia().getCtrlE().verificaSeCarroEstaEmprestado(parseInt( tfPlaca.getText()))) {
                                                 JOptionPane.showMessageDialog(null," Carro empretado com sucesso ");
                                        } else {
                                            JOptionPane.showMessageDialog(null,"Carro já esta emprestado");
                                        }
                                            // mensagem de carro esta emprestado.
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Funcionario não autorizado ");// funcionario nao autorizado.
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, " Placa não existe ");
                                 // placa não existe
                                }
                            }else{
                            JOptionPane.showMessageDialog(null," Funcionario Bloqueado ");
                        }
                    }else{
                         if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(parseInt(tfPlaca.getText()))) {
                             
                             if (!ControladorPrincipal.getInstancia().getCtrlE().verificaSeCarroEstaEmprestado(parseInt(tfPlaca.getText()))) {
                             
                             if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(parseInt(tfMatricula.getText())).autoriza(parseInt(tfPlaca.getText()))) {
                             JOptionPane.showMessageDialog(null," Carro emprestado com sucesso ");
                             
                            }else{
                                 
                             }
                             }else{
                                 JOptionPane.showMessageDialog(null, " Carro esta emprestado ");
                             }
                         }else{
                             JOptionPane.showMessageDialog(null, " Placa não existe ");
                         }
                    }
// diretor
                }else{// matricula nao existe 
                    JOptionPane.showMessageDialog(null, " Matricula não existe");
                }
            }else if( e.getSource() == btDevolve ){
                
                if (ControladorPrincipal.getInstancia().getCtrlF().matriculaFuncionarioExiste(parseInt(tfMatricula.getText()))) {

                    if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(parseInt(tfPlaca.getText()))) {
                        if (ControladorPrincipal.getInstancia().getCtrlE().verificaSeCarroEstaEmprestado(parseInt(tfPlaca.getText()))) {
                                 JOptionPane.showMessageDialog(null, " Veiculo emprestado com sucesso ! ");
                        } else {
                              JOptionPane.showMessageDialog(null, " Carro já esta emprestado  ");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, " Placa não existe ");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, " Matricula não existe ");
                   // ALTEREI
                }
            } 
        }
    }
}


                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                                        