/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author davidborges
 */
public class DeserializeDemo {
    public static void main(String[]args){
        Employee e = null;
        try{
            FileInputStream fileIn = new FileInputStream("employe.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //Realizando 
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();            
        }catch(IOException i){
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Employee class not fount");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: "+e.name);
        System.out.println("Address: "+e.address);
        System.out.println("SSN: "+e.SSN);
    }
    
}
