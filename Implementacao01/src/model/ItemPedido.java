/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author davidborges
 */
public class ItemPedido {
    private String produto;
    private double valor;
    private int quantidade;
    
    public ItemPedido(String produto, double valor, int quantidade){
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }   
    
    public double calcValorItem(){        
        return this.valor * this.quantidade;
    }
    
}
