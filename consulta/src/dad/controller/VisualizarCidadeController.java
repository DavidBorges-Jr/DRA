package dad.controller;

import dad.model.Cidade;
import dad.view.VisualizarCidadeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarCidadeController {
    private VisualizarCidadeView view;
    private Cidade cidade;

    VisualizarCidadeController(VisualizarCidadeView view, Cidade cidade) {
        this.view = view;
        this.cidade = cidade;       
        //Carregar cidade
        view.setName(cidade.getNome());
        view.setRotuloFundacao(cidade.getFundacao().toString());
        view.setRotuloPopulacao(String.valueOf(cidade.getPopulacao()));
        view.setRotuloEstado(cidade.getEstado().getNome());
        view.setCodigoIbge(String.valueOf(cidade.getIbge()));
        view.setRotuloUf(cidade.getEstado().getUf());
        view.setRotuloIbgeEstado(String.valueOf(cidade.getEstado().getIbge()));
    }
    
    
    class btnEditarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }

}
