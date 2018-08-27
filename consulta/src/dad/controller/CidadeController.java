/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dad.controller;

import dad.model.Cidade;
import dad.view.AdicionarCidadeView;
import dad.view.CidadeView;
import dad.view.VisualizarCidadeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import dad.remote.ICidadeService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class CidadeController {
    
    private CidadeView view;
    private ICidadeService sevico;
    private Cidade cidade;
    private  List<Cidade> listaCidade;

    public CidadeController(CidadeView view, Cidade cidade) {
        try {
            sevico = (ICidadeService) Naming.lookup("rmi://10.100.38.226/CidadeService");
        } catch (NotBoundException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.view = view;
        this.cidade = cidade;
	view.btnAddCidadeListener(new CadastraCidadeListener());
        view.btnVisualizarCidadeListener(new VisualizarCidadeListener());
        
        try {
            listarTabela();
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void listarTabela() throws RemoteException {
        listaCidade = sevico.pesquisa(cidade);
        Vector conjuntoLinhas = new Vector();
        
        for(Cidade cidade : listaCidade){
            Vector linha = new Vector();
            
            linha.add(cidade.getNome());
            linha.add(cidade.getPopulacao());
            linha.add(cidade.getIbge());
            linha.add(cidade.getFundacao());
            linha.add(cidade.getEstado());
            conjuntoLinhas.add(linha);
        }
        Vector conjuntoColuna = new Vector();
        conjuntoColuna.add("Nome");
        conjuntoColuna.add("População");
        conjuntoColuna.add("IBGE");
        conjuntoColuna.add("Fundação");
        conjuntoColuna.add("Estado");
        
        DefaultTableModel tableModel = new DefaultTableModel(conjuntoColuna, conjuntoLinhas);
        view.setTabelaCidade(tableModel);
    }
    
    class CadastraCidadeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdicionarCidadeView view = new AdicionarCidadeView();
            AdicionarCidadeController controller = new AdicionarCidadeController(view, cidade);
            view.setVisible(true);
        }
        
    }
    
     class VisualizarCidadeListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            VisualizarCidadeView cidadeView = new VisualizarCidadeView();
            int index = view.codigoCidadeClicada();
            Cidade cidade = listaCidade.get(index);
            
            VisualizarCidadeController controller = new VisualizarCidadeController(cidadeView, cidade);
            cidadeView.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
