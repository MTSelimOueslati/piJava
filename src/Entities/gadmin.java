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
public class gadmin extends GUser{
    private SimpleIntegerProperty id ; 
    private SimpleStringProperty Fname ;
    private SimpleStringProperty Lname ;
    private SimpleStringProperty email ;
    private SimpleStringProperty password ;
    private SimpleStringProperty picture ;
    private SimpleIntegerProperty phone ;
    
    public gadmin() {
    }

    public gadmin(int id, String Fname, String Lname, String email,String password, String picture, int phone) {
        super(id, Fname, Lname, email,password, picture, phone);
    }

    @Override
    public String toString() {
        return "gadmin{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + '}';
    }
 
    

    
    
}
