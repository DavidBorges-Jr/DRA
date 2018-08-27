package dad.remote;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

import dad.model.Cidade;
import dad.model.Estado;
import java.util.List;

/**
 *
 * @author Adriano
 */
public interface ICidadeService extends Remote {
    
    public List<Cidade> pesquisa(Cidade cidade)throws RemoteException;
    public String removeCidade(Cidade cidade)throws RemoteException;
    public String alteraCidade(Cidade cidade)throws RemoteException;
    public String inserirCidade(Cidade cidade)throws RemoteException;
}
