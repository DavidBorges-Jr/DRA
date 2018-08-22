/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemCompra;

/**
 *
 * @author davidborges
 */
public class ItemCompraDAO {
    private Connection connection;
    
    public boolean registrarItem(ItemCompra item){
        try {
            connection = FabricaConexao.getConnection();
            String sql = "INSERT INTO itemcompra (itemproid, itemprocomid, itemqtde, itemvalordiacompra) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);     
            stmt.setInt(1, item.getIdProduto());
            stmt.setInt(2, item.getIdCompra());            
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getValorProdutoDiaDaCompra());
            stmt.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
