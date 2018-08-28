/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompraDAO;
import dao.ItemCompraDAO;
import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Compra;
import model.ItemCompra;
import model.Produto;
import view.TelaPrincipalCompra;

/**
 *
 * @author davidborges
 */
public class CompraPrincipalController {
    private final TelaPrincipalCompra telaPrincipalCompra;
    private final Compra compra;
    
    public CompraPrincipalController(){
        this.telaPrincipalCompra = new TelaPrincipalCompra();
        this.telaPrincipalCompra.setVisible(true);
        this.compra = new Compra();   
        this.telaPrincipalCompra.btnAddItemListener(new btnAddItemListener());
        this.telaPrincipalCompra.btnFinalizarCompraListener(new btnFinalizarCompraListener());
        carregarProdutos();
        this.telaPrincipalCompra.btnComprasAnterioresListener(new btnComprasAnterioresListener());
        this.telaPrincipalCompra.btnVoltar(new btnVoltarListener());    
    }
    
    //Métodos da classe Controlador
    private void carregarProdutos(){
        ProdutoDAO dao = new ProdutoDAO();
        this.telaPrincipalCompra.getListaProdutos(dao.consultarProduto());        
    }
    
    //Evento do botão Compras Anteriores
    class btnComprasAnterioresListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ComprasAnteriores ();            
        }        
    }    
    private void ComprasAnteriores(){
        this.telaPrincipalCompra.setVisible(false);
        CompraExibirController compraExibirController = new CompraExibirController();
    }
    
    //Evento do Botão Adicionar Item da Compra
    class btnAddItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            addItem();
        }        
    }
    public void addItem(){
        try{            
            ItemCompra item = new ItemCompra();
            item.setIdProduto(this.telaPrincipalCompra.getProdutoSelecionado());
            int qtde = this.telaPrincipalCompra.addQtde(); 
            item.setQuantidade(qtde);            
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = dao.visualizarProduto(item.getIdProduto());
            item.setValorProdutoDiaDaCompra(produto.getValor());
            String produtoFormatado = "##PRODUTO##: \nDescrição: "
                    +produto.getDescricao()
                    +"\nValor Unitário: R$"+produto.getValor()
                    +"\nValor Total: R$"+produto.getValor()*item.getQuantidade()
                    +"\nQuantidade: "
                    +item.getQuantidade(); 
            this.telaPrincipalCompra.setAreaItensCompra(produtoFormatado);
            this.compra.addItemLista(item);
            double valor = this.compra.calcValorTotal();
            this.telaPrincipalCompra.setRotuloValorTotal(String.valueOf(valor));
        }catch(java.lang.NumberFormatException e){
            this.telaPrincipalCompra.enviarMensagem("Somente números podem ser preenchidos neste campo!");            
        }        
    }
    
    //Evento do Botão Finalizar Compra
    class btnFinalizarCompraListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FinalizarCompra();
        }        
    }
     public void FinalizarCompra(){        
        CompraDAO dao = new CompraDAO();
        dao.finalizarCompra(this.compra);
        int codigoCompra = dao.getCodigoCompra();
        ItemCompraDAO dao2 = new ItemCompraDAO();
        boolean finalizado = false;
        for(ItemCompra item : compra.getItens()){            
            item.setIdCompra(codigoCompra);
            finalizado = dao2.registrarItem(item);
        }
        if(finalizado){
            this.telaPrincipalCompra.enviarMensagem("Compra finalizada com sucesso!");
        }else{
            this.telaPrincipalCompra.enviarMensagem("Não foi possível finalizar a compra!");
        }    
    }
    
    //Evento do Botão Voltar
    class btnVoltarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            VoltarTela();
        }        
    }
    public void VoltarTela(){
        this.telaPrincipalCompra.setVisible(false);
        Controller controlador = new Controller();
    }
}
