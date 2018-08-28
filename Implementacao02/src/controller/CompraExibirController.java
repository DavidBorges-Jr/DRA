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
    
    //método construtor
    public CompraExibirController(){
        this.telaExibirCompras = new TelaExibirCompras();
        this.telaExibirCompras.setVisible(true);
        carregarTabela();      
        this.telaExibirCompras.btnVisualizarItensListener(new btnVisualizarItensListener());
        this.telaExibirCompras.btnVoltar(new BtnVoltarListener());        
    }
    
    //define o modelo da tabela de compras, usando a classe CmpraAbstractModel como modelo
    private void carregarTabela(){ 
        List<Compra> itens = dao.listarCompras();
        CompraAbstractModel modelo = new CompraAbstractModel(itens);
        this.telaExibirCompras.SetTabelaCompras(modelo);
    }
    
    //Evento do Botão Voltar
    class BtnVoltarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            VoltarTela();
        }         
    }
    public void VoltarTela(){
        this.telaExibirCompras.setVisible(false);
        CompraPrincipalController controlador = new CompraPrincipalController();
    }
        
    //Evento do Botão Visualizar Itens
    class btnVisualizarItensListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           TelaVisualizarItemCompra();
        }
    }
    public void TelaVisualizarItemCompra(){
        this.telaExibirCompras.setVisible(false);
        this.codigoCompra = this.telaExibirCompras.getCodigoCompra();      
        List<ItemCompra> itens = dao.consultarItensCompra(this.codigoCompra);
        ItensCompraController itensCompraController = new ItensCompraController(itens);        
    }
    
    
}
