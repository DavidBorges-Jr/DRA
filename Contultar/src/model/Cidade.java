/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class Cidade implements Serializable{
    private String nome;
    private long populacao;
    private Calendar fundacao;
    private int ibge;
    private Estado estado;
    
    public Cidade(String nome, long populacao, Calendar fundacao, int ibge, Estado estado){
        this.nome = nome;
        this.populacao = populacao;
        this.fundacao = fundacao;
        this.ibge = ibge;
        this.estado = estado;
    }
    
    public Cidade(){
        
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
     * @return the populacao
     */
    public long getPopulacao() {
        return populacao;
    }

    /**
     * @param populacao the populacao to set
     */
    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    /**
     * @return the fundacao
     */
    public Calendar getFundacao() {
        return fundacao;
    }

    /**
     * @param fundacao the fundacao to set
     */
    public void setFundacao(Calendar fundacao) {
        this.fundacao = fundacao;
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

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
