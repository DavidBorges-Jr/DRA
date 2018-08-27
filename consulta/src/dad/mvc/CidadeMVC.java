package dad.mvc;
import dad.controller.CidadeController;
import dad.model.Cidade;
import dad.view.CidadeView;


public class CidadeMVC {

    
    public static void main(String[] args){
        
        CidadeView view = new CidadeView();
        Cidade cidade = new Cidade();
        
        CidadeController cidadeController =
                new CidadeController(view,cidade);
        view.setVisible(true);
    }
}
