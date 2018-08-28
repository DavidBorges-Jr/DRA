/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.ItemCompra;
import model.Produto;
import view.TelaVisualizarItemCompra;

/**
 *
 * @author davidborges
 */
public class ItensCompraController {
    private final TelaVisualizarItemCompra telaVisualizarItemCompra;
    private final List<ItemCompra> itens;
    
    public ItensCompraController(List<ItemCompra> itens){
        System.out.println("Tô aqui");
        this.telaVisualizarItemCompra = new TelaVisualizarItemCompra();
        this.itens = itens;        
        ProdutoDAO dao = new ProdutoDAO();           
        for(ItemCompra item: this.itens){                      
            Produto produto = dao.visualizarProduto(item.getIdProduto());
            String produtoFormatado = "PRODUTO: \nDescrição: "+produto.getDescricao()+"\nValor: R$"+item.getValorProdutoDiaDaCompra() + "\nQuantidade: " + item.getQuantidade();            
            this.telaVisualizarItemCompra.setItensCompra(produtoFormatado);
        }
        this.telaVisualizarItemCompra.setVisible(true);
        this.telaVisualizarItemCompra.btnVoltar(new BtnVoltarListener());
        
        
    }
    
     class BtnVoltarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            VoltarTela();
        }
         
     }
     
     public void VoltarTela(){
         this.telaVisualizarItemCompra.setVisible(false);         
         CompraExibirController controlador = new CompraExibirController();
     }
    
}
