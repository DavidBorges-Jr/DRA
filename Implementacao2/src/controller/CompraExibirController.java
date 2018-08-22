/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompraDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Compra;
import model.ItemCompra;
import view.CompraAbstractModel;
import view.TelaExibirCompras;

/**
 *
 * @author davidborges
 */
public class CompraExibirController {
    private TelaExibirCompras telaExibirCompras = new TelaExibirCompras();
    private final CompraDAO dao = new CompraDAO();
    private int codigoCompra;
    
    public CompraExibirController(){
        this.telaExibirCompras = new TelaExibirCompras();
        this.telaExibirCompras.setVisible(true);
        carregarTabela();      
        this.telaExibirCompras.btnVisualizarItensListener(new btnVisualizarItensListener());
        
    }
    
    private void carregarTabela(){ 
        List<Compra> itens = dao.listarCompras();
        CompraAbstractModel modelo = new CompraAbstractModel(itens);
        this.telaExibirCompras.SetTabelaCompras(modelo);
    }
        
    class btnVisualizarItensListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           TelaVisualizarItemCompra();
        }
    }
    
    public void TelaVisualizarItemCompra(){
        this.codigoCompra = this.telaExibirCompras.getCodigoCompra();      
        List<ItemCompra> itens = dao.consultarItensCompra(this.codigoCompra);
        ItensCompraController itensCompraController = new ItensCompraController(itens);        
    }
    
    
    
}
