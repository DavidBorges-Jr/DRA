/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Compra;
import model.ItemCompra;

/**
 *
 * @author davidborges
 */
public class CompraDAO {
    private Connection connection;
    private int codigoCompra;
    
    /*
    insere um regsitro na classe compra, retornando o id de compra e salvando-o
    em codigoCompra, com isso, esse código vai ser usado para inserir o registro
    dos itens dessa compra na tabela itemcompra    
    */    
    public boolean finalizarCompra(Compra compra){        
        try {
            connection = FabricaConexao.getConnection();
            String[] comid = {"comid"};
            String sql = "INSERT INTO compra (comdata) "
                        + "VALUES (sysdate())";
            PreparedStatement stmt;
            stmt = connection.prepareStatement(sql, comid);
            stmt.execute();
            ResultSet resultados = stmt.getGeneratedKeys();
            while(resultados.next()){
                this.codigoCompra = resultados.getInt(1);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return false;        
    }    
    public int getCodigoCompra(){
        return this.codigoCompra;
    }    
       
    //retorna as compras registradas no sistema
    public List<Compra> listarCompras(){
        List<Compra> compras = new ArrayList<>();
        try {
            connection = FabricaConexao.getConnection();            
            String sql = "SELECT comid, comdata " +
                         "FROM compra";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultados = stmt.executeQuery();
            while(resultados.next()){
                Compra compra = new Compra();
                compra.setIdCompra(resultados.getInt("comid"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(resultados.getDate("comdata"));
                compra.setDataCompra(cal);  
                compras.add(compra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compras;        
    }
    
    //retorna os itens de uma compra associados ao parâmetro idCompra 
    public List<ItemCompra> consultarItensCompra(int idCompra){
        List<ItemCompra> itens = new ArrayList<>();
        try {
            connection = FabricaConexao.getConnection();
            String sql = "SELECT itemproid, itemqtde, itemvalordiacompra " 
                            +"FROM itemcompra "
                            + "WHERE itemcomid = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idCompra);
            ResultSet resultados = stmt.executeQuery();
            while(resultados.next()){
                ItemCompra item = new ItemCompra();
                item.setIdProduto(resultados.getInt("itemproid"));               
                item.setQuantidade(resultados.getInt("itemqtde"));
                item.setValorProdutoDiaDaCompra(resultados.getDouble("itemvalordiacompra"));
                itens.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }
    
}
