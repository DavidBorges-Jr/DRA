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
import view.TelaAdicionarProduto;

/**
 *
 * @author davidborges
 */
public class ProdutoAdicionarController {
    private final TelaAdicionarProduto telaAdicionarProduto;
    private final ProdutoDAO dao;
    
    //Construtor
    public ProdutoAdicionarController(){
        this.telaAdicionarProduto = new TelaAdicionarProduto();
        this.dao = new ProdutoDAO();
        this.telaAdicionarProduto.setVisible(true);
        this.telaAdicionarProduto.btnSalvarListener(new AddProdutoListener());
        this.telaAdicionarProduto.btnVoltar(new BtnVoltarListener());
    }
    
    //Evento do botão Adicionar Produto
    class AddProdutoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TelaAdicionarProduto();       
        }   
    }
    public void TelaAdicionarProduto(){
       try{
           Produto novoProduto = this.telaAdicionarProduto.getProduto();        
           if(dao.addProduto(novoProduto)){
               this.telaAdicionarProduto.setMensagem("Produto adicionado com sucesso!");
               this.telaAdicionarProduto.limparCampos();
               ProdutoPrincipalController controlador = new ProdutoPrincipalController();                
           }else{
               this.telaAdicionarProduto.setMensagem("Não foi possível adicionar produto!");
           }

       }catch(java.lang.NumberFormatException e){            
           this.telaAdicionarProduto.setMensagem("Todos os campos têm que ser preenchidos com o formato correto!!");
       }

   }
    
    //Evento do botão voltar
    class BtnVoltarListener implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e) {
           VoltarTela();
       }
    }
    public void VoltarTela(){
        this.telaAdicionarProduto.setVisible(false);
        ProdutoPrincipalController controlador = new ProdutoPrincipalController();
    }

    

    

}
