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
import view.TelaVisualizarProduto;

/**
 *
 * @author davidborges
 */
public class ProdutoVisualizarController {
    TelaVisualizarProduto telaVisualizarProduto;
    Produto produto;
  
    public ProdutoVisualizarController(Produto produto){
        this.produto = produto;
        this.telaVisualizarProduto = new TelaVisualizarProduto(produto);
        this.telaVisualizarProduto.setVisible(true);
        this.telaVisualizarProduto.btnAlterarListener(new BtnAlterarProduto());
        this.telaVisualizarProduto.btnExcluirListener(new BtnExcluirProduto() );
        this.telaVisualizarProduto.btnVoltar(new BtnVoltarListener());
    } 
    
    class BtnAlterarProduto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TelaAlterarProduto();
        }
        
    }
     class BtnExcluirProduto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {            
            ExcluirProduto();
        }
        
    }
     
     class BtnVoltarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            VoltarTela();
        }
         
     }
     
     public void VoltarTela(){
         this.telaVisualizarProduto.setVisible(false);
         ProdutoPrincipalController controle = new ProdutoPrincipalController();
     }
          
     public void ExcluirProduto(){
         ProdutoDAO dao = new ProdutoDAO();
         if(dao.delProduto(this.produto.getIdProduto())){
            this.telaVisualizarProduto.exibirMensagem("Produto excluído com sucesso!");            
            ProdutoPrincipalController controle = new ProdutoPrincipalController();
         }else{
             this.telaVisualizarProduto.exibirMensagem("Não foi possível excluir o produto!");
         }
     }
    
     
      public void TelaAlterarProduto(){
        ProdutoAlterarController produtoAlterarController;
        produtoAlterarController = new ProdutoAlterarController(this.produto);
        this.telaVisualizarProduto.setVisible(false);
    }
}
