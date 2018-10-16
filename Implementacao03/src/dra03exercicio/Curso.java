/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra03exercicio;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Aluno
 */
@Entity
public class Curso{       
    
    @Id
    @GeneratedValue
    private Long id;
    private String nome;    
    
    @OneToMany
    @JoinTable(name ="CUR_ALU", joinColumns=@JoinColumn(name="CUR_ID"),
            inverseJoinColumns=@JoinColumn(name="ALU_ID"))
    private Collection<Aluno> alunos;
    
    public Curso(){
        this.alunos = new HashSet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }
}
