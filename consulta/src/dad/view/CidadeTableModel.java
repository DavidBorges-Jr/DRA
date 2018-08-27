/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dad.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import dad.model.Cidade;
/**
 *
 * @author Aluno
 */
public class CidadeTableModel extends AbstractTableModel{
   List<Cidade> lista = new ArrayList<>();   
   String colunas[] = {"Código IBGE", "Nome" };

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 1: return lista.get(rowIndex).getIbge();
            case 2: return lista.get(rowIndex).getNome();
        }
        return null;
    }
    
    
}
