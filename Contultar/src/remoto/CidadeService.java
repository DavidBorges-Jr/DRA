/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import dao.CidadeDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import model.Cidade;
import model.Estado;

/**
 *
 * @author Adriano
 */
public class CidadeService extends UnicastRemoteObject implements ICidadeService {

    public CidadeService() throws RemoteException {
        super();
    }

    @Override
    public String removeCidade(Cidade cidade) throws RemoteException {
        try{
            CidadeDAO dao = new CidadeDAO();
            dao.excluir(cidade.getNome());
            return "Excluido com sucesso!!!";
        }catch(Exception e){
            throw new RemoteException("erro no remove",e);
        }
    }

    @Override
    public String alteraCidade(Cidade cidade) throws RemoteException {
       try{
            CidadeDAO dao = new CidadeDAO();
            dao.alterar(cidade);
            return "Alterado com sucesso!!!";
        }catch(Exception e){
            throw new RemoteException("erro no alterar",e);
        }
    }

    @Override
    public String inserirCidade(Cidade cidade) throws RemoteException {
        try{
            CidadeDAO dao = new CidadeDAO();
            dao.cadastrar(cidade);
            return "Cadastrado com sucesso!!!";
        }catch(Exception e){
            throw new RemoteException("erro no Cadastrado",e);
        }
    }

    @Override
    public List<Cidade> pesquisa(Cidade cidade) throws RemoteException {
        try {

            List<Cidade> cidades = new ArrayList<Cidade>();
            CidadeDAO dao = new CidadeDAO();

            cidades= dao.listar(cidade.getNome());
            
            return cidades;
        } catch (Exception e) {
              throw new RemoteException("erro na lista",e);
              
        }
    }

}
