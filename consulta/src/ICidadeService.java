
import dad.model.Cidade;
import java.rmi.Remote;
import java.rmi.RemoteException;


import java.util.List;

/**
 *
 * @author Adriano
 */
public interface ICidadeService extends Remote {
    
    //public Cidade consultaCidade(String nome, long populacao, Calendar fundacao, int IBGE, Estado estado)  throws RemoteException;

    public List<Cidade> pesquisa(Cidade cidade)throws RemoteException;
    public String removeCidade(Cidade cidade)throws RemoteException;
    public String alteraCidade(Cidade cidade)throws RemoteException;
    public String inserirCidade(Cidade cidade)throws RemoteException;
}
