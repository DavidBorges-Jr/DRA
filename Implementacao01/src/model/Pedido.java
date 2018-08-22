/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidborges
 */
public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    
    public void addItem(ItemPedido item){
        itens.add(item);        
    }
    
    public double calcValorTotal(){
        double valorTotal = 0;
        for(ItemPedido item:itens){
            valorTotal += item.calcValorItem();
        }
        return valorTotal;
    }
         
    public void excluirItens(){
        itens.clear();
    }
        
    
}
