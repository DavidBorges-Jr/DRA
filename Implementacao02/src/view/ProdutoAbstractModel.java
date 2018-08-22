/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author davidborges
 */
public class ProdutoAbstractModel extends AbstractTableModel
{
    private final List<Produto> lista;
    private final String[] colunas;
    private final int opcaoTela;

    public ProdutoAbstractModel(List<Produto> lista, int opcaoTela){ 
        this.opcaoTela = opcaoTela;
        if(this.opcaoTela == 1){
            colunas = new String[3];
            this.colunas[0] = "Código";
            this.colunas[1] = "Produto";
            this.colunas[2] = "Quantidade";
        }else{
            colunas = new String[2];
            this.colunas[0] = "Código";
            this.colunas[1] = "Produto";            
        }
        this.lista = lista;
        
    }
    
    @Override
    public int getRowCount() {   
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int row){
        return this.colunas[row];        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = lista.get(rowIndex);
        if(this.opcaoTela == 1){            
            switch(columnIndex){            
            case 0: return produto.getIdProduto();
            case 1: return produto.getDescricao();
            case 2: return produto.getQuantidade();
            }       
            return null;
        }else{
            switch(columnIndex){            
                case 0: return produto.getIdProduto();
                case 1: return produto.getDescricao();
                case 2: return produto.getQuantidade();
            }   
            return null;
        }
    }
        
    
}
