/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controller.PedidoController;
import model.Pedido;
import view.RegistrarPedido;

/**
 *
 * @author davidborges
 */
public class Main {
    public static void main(String args[]){
        Pedido pedido = new Pedido();
        RegistrarPedido tela = new RegistrarPedido();        
        PedidoController controladorPedido;
        controladorPedido = new PedidoController(pedido, tela);
        tela.setVisible(true);
        
    }
    
}
