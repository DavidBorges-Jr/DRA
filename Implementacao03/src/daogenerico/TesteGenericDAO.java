package daogenerico;

import connectionfactory.ConnectionFactory;
import dra03exercicio.Aluno;
import dra03exercicio.Curso;
import dra03exercicio.DiarioDisciplina;
import dra03exercicio.Professor;
import dra03exercicio.Turma;
import javax.persistence.EntityManager;

public class TesteGenericDAO {
    public static void main(String[] args) {       

        EntityManager manager = ConnectionFactory.getEntityManager();
        GenericDAO<Professor> profManager = new GenericDAO<>(manager);  
        GenericDAO<Curso> cursoManager = new GenericDAO<>(manager); 
        GenericDAO<Aluno> alunoManager = new GenericDAO<>(manager); 
        GenericDAO<Turma> turmaManager = new GenericDAO<>(manager);
        GenericDAO<DiarioDisciplina> disciplinaManager = new GenericDAO<>(manager);
        
       //Adicionando um professor                 
        Professor p = new Professor();
        p.setLogin("David");
        p.setSenha("123");
        p.setNome("David Junior");
        p.setArea("Computaçao");
        p.setTitulacao("Graduando");        
        profManager.save(p);   
        
        //Adicionando um curso
        Curso curso1 = new Curso();              
        curso1.setNome("TADS");        
        cursoManager.save(curso1);

        //Adicionando dois novos alunos                    
        Aluno aluno1 = new Aluno();
        aluno1.setLogin("Aluno1");
        aluno1.setNome("Aluno da linha 1");
        aluno1.setSenha("123");
        alunoManager.save(aluno1);
        
        Aluno aluno2 = new Aluno();
        aluno2.setLogin("Aluno2");
        aluno2.setNome("Aluno da linha 2");
        aluno2.setSenha("123");
        alunoManager.save(aluno2);
        
        //Adicionando um aluno a um curso
        curso1.addAluno(aluno1);
        curso1.addAluno(aluno2);
        cursoManager.update(curso1);
        
        DiarioDisciplina diario = new DiarioDisciplina();
        diario.setNomeDisciplina("Desenvolvimento Rapido de Aplicaçoes");
        diario.setProfessor(p);
        disciplinaManager.save(diario);
               
        Turma turma = new Turma();
        turma.setPeriodo(1);
        turma.setCurso(curso1);
        turma.addAluno(aluno1);
        turma.addAluno(aluno2);
        turma.addDiario(diario);
        turmaManager.save(turma);     
        
        ConnectionFactory.closeEntityFactory();
        
    }
}
