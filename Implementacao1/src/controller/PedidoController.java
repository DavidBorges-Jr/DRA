/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ItemPedido;
import model.Pedido;
import view.RegistrarPedido;

/**
 *
 * @author davidborges
 */
public class PedidoController {
    private Pedido pedido = new Pedido();
    private RegistrarPedido pedidoTela = new RegistrarPedido();
    
    public PedidoController(Pedido pedido, RegistrarPedido pedidoTela){
        this.pedido = pedido;
        this.pedidoTela = pedidoTela;        
        pedidoTela.btnAddItemListener(new AddItemListener());
        pedidoTela.btnExcluirItemListener(new ExcluirItensListener());
    }
    
    class AddItemListener implements ActionListener{      
        @Override
        public void actionPerformed(ActionEvent e) {
            String produto = pedidoTela.nomeProduto();
            double valor = 0.0;
            int qtde = 0;
            try{
                valor = Double.parseDouble(pedidoTela.valorProduto());
                qtde = Integer.parseInt(pedidoTela.qtdeProduto());   
                ItemPedido item = new ItemPedido(produto, valor, qtde);
                pedido.addItem(item);
                pedidoTela.exibirProduto(produto+"\n");
                String valorTotal = String.valueOf(pedido.calcValorTotal());
                pedidoTela.setValorTotal(valorTotal);
                pedidoTela.exibirMensagem("Produto adicionado com sucesso!");
                pedidoTela.limparCampos();
            }catch(NumberFormatException ex){
                pedidoTela.exibirMensagem("Somente números podem ser preenchidos!!");
            }
            
        }
    }
    
  
    class ExcluirItensListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pedido.excluirItens();
            pedidoTela.limparAreaTextoItens();
        }

    }
}
    
    
    
