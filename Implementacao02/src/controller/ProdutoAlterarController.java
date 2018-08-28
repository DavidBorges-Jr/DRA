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
import view.TelaAlterarProduto;
import view.TelaPrincipalProduto;

/**
 *
 * @author davidborges
 */
public class ProdutoAlterarController {
    private final TelaAlterarProduto telaAlterarProduto;
    private ProdutoDAO dao;
    private Produto produto;
    
    public ProdutoAlterarController(Produto produtoAlterar){
        this.produto = produtoAlterar;
        this.telaAlterarProduto = new TelaAlterarProduto(produto);
        this.telaAlterarProduto.setVisible(true);        
        this.telaAlterarProduto.btnAlterarListener(new btnAlterarListener());
        this.telaAlterarProduto.btnVoltarListener(new btnVoltarListener());
        this.dao = new ProdutoDAO();
    }
    
    class btnAlterarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           AlterarProduto();
        }
        
    }
    
    class btnVoltarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BotaoVoltar();
            
        }
        
    }
    
    public void AlterarProduto(){
        if(this.dao.alterarProduto(this.telaAlterarProduto.getProduto())){
            this.telaAlterarProduto.exibirMensagem("Produto alterado com sucesso!");
            this.telaAlterarProduto.setVisible(false);            
            ProdutoPrincipalController controle = new ProdutoPrincipalController();
        }else{
            this.telaAlterarProduto.exibirMensagem("Não foi possível alteradar o produto!");
        };
    }
    
    public void BotaoVoltar(){
        this.telaAlterarProduto.setVisible(false);
         ProdutoPrincipalController controle = new ProdutoPrincipalController();
    }
    
}
