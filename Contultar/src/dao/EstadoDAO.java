/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;
import model.Estado;

/**
 *
 * @author Aluno
 */
public class EstadoDAO {
    private Connection connection;
    public EstadoDAO(){
        this.connection = FabricaConexao.getConnection();
    }
    
}
