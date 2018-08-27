package dad.controller;

import dad.model.Cidade;
import dad.view.EditarCidadeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarCidadeController {
    private EditarCidadeView view;
    private Cidade cidade;
    
    public EditarCidadeController(EditarCidadeView view, Cidade cidade){
        this.view = view;
        this.cidade = cidade;                
        view.btnAlterarCidadeListener(new btnAlterarCidadeListener());
    }
    
    public void carregarDetalhesCidade(Cidade cidade){
        view.setCampoNome(cidade.getNome());
        view.setCampoFundacao(cidade.getFundacao().toString());       
        view.setCampoPopulacao(Long.toString(cidade.getPopulacao()));        
        view.setCampoCodigoIbge(String.valueOf(cidade.getIbge()));
        view.setCampoEstado(cidade.getEstado().getNome());
    }

    class btnAlterarCidadeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {  
            //carregar cidade do banco
            Cidade cidade = new Cidade();
            carregarDetalhesCidade(cidade);
        }
        
    }
    
    class btnVoltarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
           
        }
        
    }
}
