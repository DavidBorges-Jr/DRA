package dad.model;


import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Estado implements Serializable{

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
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
    private String nome;
    private String uf;
    private int ibge;
    
    
    
    public Estado(String nome){
        this.nome=  nome;
        

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




}
