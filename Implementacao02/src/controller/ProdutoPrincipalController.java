/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Produto;
import view.TelaPrincipalProduto;

/**
 *
 * @author davidborges
 */
public final class ProdutoPrincipalController { 
    private final TelaPrincipalProduto telaPrincipalProduto;
    private final ProdutoDAO dao;
    
    //construtor
    public ProdutoPrincipalController(){
        this.telaPrincipalProduto = new TelaPrincipalProduto();
        this.telaPrincipalProduto.setVisible(true);
        this.dao = new ProdutoDAO();
        carregarProdutos();
        this.telaPrincipalProduto.btnAddProduto(new AddItemListener());
        this.telaPrincipalProduto.btnVisualizarProduto(new BtnVisualizarProduto() );
        this.telaPrincipalProduto.btnVoltar(new BtnVoltarListener());
    }        
    
    public void carregarProdutos(){
        this.telaPrincipalProduto.getListaProdutos(dao.consultarProduto());        
    }
    
    //Evento do botão Adicionar Item
    class AddItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TelaAdicionar();            
        }    
    }
    public void TelaAdicionar(){
        this.telaPrincipalProduto.setVisible(false);
        ProdutoAdicionarController produtoAddController = new ProdutoAdicionarController(); 
    }
    
    //Evento do Botão Visualizar Produto
    class BtnVisualizarProduto implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e) {
           TelaVisualizarProduto();
       }
    }

    //Evento do Botão Voltar
    class BtnVoltarListener implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e) {
           VoltarTela();
       }
    }
    public void VoltarTela(){
         this.telaPrincipalProduto.setVisible(false);
         Controller controlador = new Controller();
    }
        
    
       
    
   
    
    public void TelaVisualizarProduto(){
        int codigo = this.telaPrincipalProduto.getCodigoProdutoSelectionado();
        Produto produtoVisualizado = dao.visualizarProduto(codigo);
        ProdutoVisualizarController produtoVisualizarController  ;
        produtoVisualizarController = new ProdutoVisualizarController(produtoVisualizado);
        this.telaPrincipalProduto.setVisible(false);
    }
       
  
}
