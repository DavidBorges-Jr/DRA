/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Estado implements Serializable{
    private String nome;
    private String sigla;
    private int ibge;
    
    public Estado(String nome, String sigla, int ibge){
        this.nome=  nome;
        this.sigla = sigla;
        this.ibge =  ibge;
    }
    
    public Estado(){
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the ibge
     */
    public int getIbge() {
        return ibge;
    }

    /**
     * @param ibge the ibge to set
     */
    public void setIbge(int ibge) {
        this.ibge = ibge;
    }
    
    
}
