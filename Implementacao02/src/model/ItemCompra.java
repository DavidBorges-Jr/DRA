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
public class ItemCompra {
    private int idCompra;
    private int idProduto;
    private int quantidade;
    private double valorProdutoDiaDaCompra;
    
    public int getIdCompra() {
        return idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    
    public int getIdProduto() {
        return idProduto;
    }
    
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getValorProdutoDiaDaCompra() {
        return valorProdutoDiaDaCompra;
    }
    
    public void setValorProdutoDiaDaCompra(double valorProdutoDiaDaCompra) {
        this.valorProdutoDiaDaCompra = valorProdutoDiaDaCompra;
    }
    
    public double calcValorItem(){
        return this.valorProdutoDiaDaCompra * this.quantidade;
    }
    
}
