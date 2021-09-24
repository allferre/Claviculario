/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class TelaExibeAssocVeicFunc extends TelaExibeVeiculo{
    
    
    
     @Override
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
       
      super.getTabela().setModel(modelo);
   }
   
    
}
