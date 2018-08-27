/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Cidade;
import model.Estado;

/**
 *
 * @author Aluno
 */
public class CidadeDAO {
    Connection connection;
    public CidadeDAO(){
        this.connection = FabricaConexao.getConnection();
    }
    
    public boolean  cadastrar(Cidade cidade){
        String sql = "INSERT INTO CIDADE VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cidade.getNome());
            ps.setLong(2, cidade.getPopulacao());
            ps.setDate(3, new java.sql.Date(cidade.getFundacao().getTimeInMillis()));
            ps.setInt(4, cidade.getIbge());
            ps.setString(5, cidade.getEstado().getNome());
            ps.execute();
            
            connection.close();
            return true;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Cidade> listar(String valorBuscado){
        String sql = "SELECT cidade.nome, populacao, fundacao, estado.nome FROM CIDADE INNER JOIN estado on cidestado = estado.id WHERE NOME LIKE ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, '%'+valorBuscado+'%');
            ResultSet rs = ps.executeQuery();
            
            List<Cidade> listaCidades = new ArrayList<Cidade>();
            
            while(rs.next()){
                Cidade cidade = new Cidade();
                
                cidade.setNome(rs.getString("nome"));
                cidade.setPopulacao(rs.getLong("populacao"));
                DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                format.format(rs.getDate("fundacao"));
                cidade.setFundacao(format.getCalendar());
                cidade.setIbge(rs.getInt("codigoIbge"));
                Estado estado = new Estado();
                estado.setNome(rs.getString("nome"));
                cidade.setEstado(estado);
                listaCidades.add(cidade);
            }
            ps.close();
            connection.close();
            return listaCidades;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public boolean alterar(Cidade cidade){
        String sql = "UPDATE cidade SET nome=?, populacao=? fundacao=? codigoIbge=? cidestado=? WHERE id=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cidade.getNome());
            ps.setLong(2, cidade.getPopulacao());
            ps.setDate(3, new java.sql.Date(cidade.getFundacao().getTimeInMillis()));
            ps.setInt(4, cidade.getIbge());
            ps.setString(5, cidade.getEstado().getNome());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public boolean excluir(String idCidade){
        String sql = "DELETE FROM CIDADE WHERE nome=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, idCidade);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
}
