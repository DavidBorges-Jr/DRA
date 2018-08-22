/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import controller.Controller;
import view.TelaInicial;

/**
 *
 * @author davidborges
 */
public class main {
    public static void main(String args[]){
        TelaInicial telaInicial = new TelaInicial();
        Controller controller = new Controller(telaInicial);
        telaInicial.setVisible(true);
        
    }
    
    
}
