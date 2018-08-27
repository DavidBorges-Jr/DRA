/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author davidborges
 */
public class SerializaDemo {
    public static void main(String[]args){
        Employee e = new Employee();
        e.name = "David";
        e.address = "Rua São João, 177, Monte Pascoal";
        e.SSN = 111222333;
        e.number = 101;
        
        try{
            //criando o arquivo 
            FileOutputStream fileOut = new FileOutputStream("employe.ser");
            //A classe abaixo realiza a serialização
            ObjectOutputStream out = new ObjectOutputStream(fileOut);            
            //este método serializa um objeto e envia-o para o stream de saída
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is save as employe.ser");            
        }catch(IOException i){
            i.printStackTrace();
        }
                
    }
    
}
