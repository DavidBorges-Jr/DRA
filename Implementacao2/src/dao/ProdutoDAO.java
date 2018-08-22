/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

/**
 *
 * @author davidborges
 */
public class ProdutoDAO {
    private Connection connection;
    
    public ProdutoDAO(){
        
    }
    
    public boolean addProduto(Produto produto){
        connection = FabricaConexao.getConnection();
        String sql = "insert into produto(prodescricao, provalor, proqtde) values (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor()); 
            stmt.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterarProduto(Produto produto){
        connection = FabricaConexao.getConnection();
        String sql = "update produto "
                + " set prodescricao = ?, provalor = ?, proqtde = ? "
                + "where proid = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());   
            stmt.setInt(4, produto.getIdProduto());
            System.out.println("Consulta: "+stmt);
            stmt.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Produto> consultarProduto(){
        List<Produto> lista = new ArrayList<>(); 
        connection = FabricaConexao.getConnection();
        String sql  = "select proid, prodescricao, provalor, proqtde from produto";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Produto produto = new Produto();
                produto.setIdProduto(resultado.getInt("proid"));
                produto.setDescricao(resultado.getString("prodescricao"));
                produto.setValor(resultado.getDouble("provalor"));
                produto.setQuantidade(resultado.getInt("proqtde"));                         
                lista.add(produto);
            }
            connection.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return lista;
    }
    
    public boolean delProduto(int id){        
        connection = FabricaConexao.getConnection();
        String sql = "delete from produto where proid = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Produto visualizarProduto(int codigo){
        Produto produto = new Produto();
        connection = FabricaConexao.getConnection();
        String sql = "select proid, prodescricao, provalor, proqtde "
                + "from produto "
                + "where proid = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                produto.setIdProduto(resultado.getInt("proid"));
                produto.setDescricao(resultado.getString("prodescricao"));
                produto.setValor(resultado.getDouble("provalor"));
                produto.setQuantidade(resultado.getInt("proqtde"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
    
}
