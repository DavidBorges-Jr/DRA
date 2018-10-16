/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra03exercicio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Aluno
 */
@Entity
public class Professor extends Usuario {
        
    private String titulacao;
    private String area;
    
    @OneToOne
    @JoinColumn(name="dd_id")
    private DiarioDisciplina dd;

    public Professor(String titulacao, String area) {
        this.titulacao = titulacao;
        this.area = area;
    }

    public Professor() {
 }
    
    
        
    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
