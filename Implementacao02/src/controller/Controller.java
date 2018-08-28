/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaInicial;

/**
 *
 * @author davidborges
 */
public class Controller {
    private final TelaInicial telaInicial;
    
    public Controller(){
        this.telaInicial = new TelaInicial();
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
        this.telaInicial.setVisible(false);
        ProdutoPrincipalController controle = new ProdutoPrincipalController();
    }
   
    public void TelaPrincipalCompra(){
        this.telaInicial.setVisible(false);
        CompraPrincipalController controle = new CompraPrincipalController();
    }
}
