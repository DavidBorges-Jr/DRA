/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import model.Cidade;
import model.Estado;

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
