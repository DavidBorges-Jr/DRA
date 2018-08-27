package dad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import dad.model.Cidade;
import dad.model.Estado;
import dad.view.AdicionarCidadeView;

public class AdicionarCidadeController {

	private AdicionarCidadeView theView;
	private Cidade cidade;
	private Estado estado;
	
	public AdicionarCidadeController (AdicionarCidadeView view, Cidade cidade) {
		this.theView = view;
		this.cidade = cidade;
		view.btnAddCidadeListener(new CadastraCidadeListener());
                view.btnVoltarListener(new VoltarCidadeListener());
	}
	
	class CadastraCidadeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String nome = theView.getCampoNome();
			Date fundacao = Date.valueOf(theView.getCampoFundacao());
			Long populacao = Long.parseLong(theView.getCampoPopulacao());
			String codigoIbge = theView.getCampoCodigoIbge();
			estado = new Estado(theView.getCampoEstado());
		}
	}
        
        class VoltarCidadeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           theView.dispose();
        }
            
        }
}