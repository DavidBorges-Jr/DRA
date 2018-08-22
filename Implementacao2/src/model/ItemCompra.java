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

    /**
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorProdutoDiaDaCompra
     */
    public double getValorProdutoDiaDaCompra() {
        return valorProdutoDiaDaCompra;
    }

    /**
     * @param valorProdutoDiaDaCompra the valorProdutoDiaDaCompra to set
     */
    public void setValorProdutoDiaDaCompra(double valorProdutoDiaDaCompra) {
        this.valorProdutoDiaDaCompra = valorProdutoDiaDaCompra;
    }
    
    public double calcValorItem(){
        return this.valorProdutoDiaDaCompra * this.quantidade;
    }
    
}
