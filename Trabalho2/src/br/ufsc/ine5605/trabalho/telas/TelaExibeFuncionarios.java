package br.ufsc.ine5605.trabalho.telas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 09655917940
 */
public class TelaExibeFuncionarios extends JFrame{
    
    private ControladorPrincipal ctrl;
    private GerenciaBotoes gerenciador;
   private Collection<Funcionario> listaCandidatos ;
    
    //Componentes
    

    private JButton btVolta;
    JTable tabela ;
    JScrollPane base;
    public TelaExibeFuncionarios() {
       
        gerenciador = new GerenciaBotoes();
        
        listaCandidatos = ControladorFuncionario.getInstancia().pegaListaDoMapeador();
        init();
       
      
    }

    public  void init() {
        
        //Definir Container e Layout
        Container container = getContentPane();
        container.setLayout( new GridBagLayout());
        GridBagConstraints pacote = new GridBagConstraints();
        
        btVolta = new JButton( " Voltar ao menu principal ");
        btVolta.addActionListener(gerenciador);
        pacote.gridx = 1;
        pacote.gridy = 0;
        
        container.add(btVolta,pacote);
        
        tabela = new JTable();
        tabela.setPreferredScrollableViewportSize(new Dimension(500,70));
        tabela.setFillsViewportHeight(true);
        pacote.fill = GridBagConstraints.CENTER;
        pacote.gridwidth = 2;
        pacote.gridheight = 5;
        pacote.gridx = 0;
        pacote.gridy = 5;
        
        base = new JScrollPane( tabela);
        container.add(base,pacote);
        
         
       
        setLocationRelativeTo(null);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        atualiza();
        
        
    }

   
  
    // classe precisa de uma implementação de actionlistener,outra opção
   
   public void atualiza(){
      DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn(" Nome ");
       modelo.addColumn(" Matricula ");
       modelo.addColumn(" Cargo ");
       modelo.addColumn(" Telegone ");
       modelo.addColumn(" Data nascimento ");
       
       
      
       
       for(Funcionario funcionario : listaCandidatos){
           
           modelo.addRow(new Object[]{funcionario.getNome(),funcionario.getMatricula(),funcionario.getCargo(),funcionario.getTelefone(),funcionario.getDataNascimento()});
       }
       
       tabela.setModel(modelo);
       
   }
    private class GerenciaBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          if(e.getSource() == btVolta){
            setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            
            
            
          }
        }
    
  }
}


