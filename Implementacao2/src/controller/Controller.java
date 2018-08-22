/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Compra;
import model.Produto;
import view.TelaInicial;
import view.TelaPrincipalCompra;
import view.TelaPrincipalProduto;

/**
 *
 * @author davidborges
 */
public class Controller {
    TelaInicial telaInicial = new TelaInicial();
    
    public Controller(TelaInicial telaInicial){
        this.telaInicial = telaInicial;
        this.telaInicial.setVisible(true);
        this.telaInicial.btnModuloProdutoListener(new btnModuloProdutoListener());
        this.telaInicial.btnModuloCompras(new btnModuloCompras());
    }
    
    class btnModuloProdutoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            TelaPrincipalProduto();            
        }
        
    }
    
    class btnModuloCompras implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            TelaPrincipalCompra();            
        }
        
    }
    
    public void TelaPrincipalProduto(){
        TelaPrincipalProduto telaPrincipalProduto = new TelaPrincipalProduto();
        Produto produto = new Produto(); 
        ProdutoPrincipalController controle = new ProdutoPrincipalController(telaPrincipalProduto, produto);
        telaPrincipalProduto.setVisible(true);
    }
   
    public void TelaPrincipalCompra(){
        TelaPrincipalCompra telaPrincipalCompra = new TelaPrincipalCompra();
        Compra compra = new Compra();
        CompraPrincipalController controle = new CompraPrincipalController(telaPrincipalCompra, compra);
        telaPrincipalCompra.setVisible(true);
    }
}
