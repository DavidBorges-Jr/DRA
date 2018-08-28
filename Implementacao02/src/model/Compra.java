/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author davidborges
 */
public class Compra {
    private int idCompra;
    private Calendar dataCompra;
    private List<ItemCompra> itens;
    
    public Compra(){
        itens = new ArrayList<>();
    }
    
    public int getIdCompra() {
        return idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    public List<ItemCompra> getItens() {
        return itens;
    }
    
    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }
    
    public double calcValorTotal(){
        double soma = 0;
        for(ItemCompra item: this.itens){
            soma += item.calcValorItem();
            System.out.println("Valor total: "+ item.calcValorItem());
        }
        return soma;        
    }
    
    public void addItemLista(ItemCompra item){
        this.itens.add(item);        
        
    }
    
    public Calendar getDataCompra() {
        return dataCompra;
    }
    
    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }
    
}
