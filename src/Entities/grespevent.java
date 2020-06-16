/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author taieb
 */
public class grespevent extends GUser {
 private SimpleIntegerProperty id ; 
    private SimpleStringProperty Fname ;
    private SimpleStringProperty Lname ;
    private SimpleStringProperty email ;
    private SimpleStringProperty password ;
    private SimpleStringProperty picture ;
    private SimpleIntegerProperty salary ;

    public grespevent() {
    }

    public grespevent( int id, String Fname, String Lname, String email,String password,  int phone,String picture,int salary) {
        super(id, Fname, Lname, email,password, picture, phone);
        this.salary = new SimpleIntegerProperty(salary);
    }



    public int getSalary() {
        return salary.get();
    }

    /*public void setSalary(int salary) {
        this.salary = salary;
    }*/

    @Override
    public String toString() {
        return "grespevent{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture  + ", salary=" + salary + '}';
    }

  
}
