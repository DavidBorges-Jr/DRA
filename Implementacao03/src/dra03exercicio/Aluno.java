/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra03exercicio;

import java.util.Collection;
import javax.persistence.Entity;;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Aluno
 */

@Entity
public class Aluno extends Usuario {

    
    private String situacao;

    
    @OneToMany
    @JoinTable(name ="ALU_PRO", joinColumns=@JoinColumn(name="ALU_ID"),
            inverseJoinColumns=@JoinColumn(name="PROF_ID"))
    private Collection<Professor> professores;
    
        
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
   
}
