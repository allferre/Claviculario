/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class ExibeVeiculo extends JFrame {
    
   ArrayList<Veiculo> lista = ControladorVeiculo.getInstancia().getListaVeiculos();

    public ExibeVeiculo() {
    
        exibeVeiculos();
        
    }
    
    
    public void exibeVeiculos(){
        
        /*Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        
        String[] colunas = new String[] { " Placa " , " Marca ", " Modelo ",};
        
       String[][] linhas = new String[][]{
    {"Rodrigo","28","Masculino"},
    {"Maria","30","Feminino"}
      };
        
        JTable tabela = new JTable();
        DefaultTableModel modelo = new DefaultTableModel(linhas, colunas);
        tabela.setModel(modelo);
        JScrollPane rolagem = new JScrollPane();
        rolagem.add(tabela);
        this.add(rolagem);
       container.add(tabela);*/
    
    }
    
   
   
    
}
