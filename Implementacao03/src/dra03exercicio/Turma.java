/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra03exercicio;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Aluno
 */
@Entity
public class Turma  implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    private int periodo;
    @OneToMany
    @JoinTable(name ="TUR_ALU", joinColumns=@JoinColumn(name="TUR_ID"),
            inverseJoinColumns=@JoinColumn(name="ALU_ID"))
    private Collection<Aluno> aluno;

    
    @OneToMany
    @JoinTable(name ="TUR_DIR", joinColumns=@JoinColumn(name="TUR_ID"),
            inverseJoinColumns=@JoinColumn(name="DIR_ID"))
    private Collection<DiarioDisciplina> dd;
        
        
    @ManyToOne
    @JoinColumn(name="cur_id")
    private Curso curso;
    
    public Turma(){
        this.dd = new HashSet();
        this.aluno = new HashSet();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public Curso getCurso(){
        return this.curso;
    }
    
    public void addDiario(DiarioDisciplina dd){
        this.dd.add(dd);        
    }
    
    public void addAluno(Aluno aluno){
        this.aluno.add(aluno);
    }
}
