/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Class Employee implements the java.io.Serializable interface
 * All the fields in the class must be serializable. 
 * If a field is not serializable it must be marked as transient
 * @author davidborges
 */
public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN; //not serializable field
    public int number;
    
    public void mainCheck(){
        System.out.println("Mailing check to: "+ name + " " + address);
    }
}
