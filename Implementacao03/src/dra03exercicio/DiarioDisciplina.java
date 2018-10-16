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
public class DiarioDisciplina  implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nomeDisciplina;
    
    @OneToOne
    @JoinColumn(name="prof_id")
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public Professor Professor(){
        return this.professor;
    }
    
    
}
