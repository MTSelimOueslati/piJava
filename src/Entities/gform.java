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
public class gform extends GUser{
 private SimpleIntegerProperty id ; 
    private SimpleStringProperty Fname ;
    private SimpleStringProperty Lname ;
    private SimpleStringProperty email ;
    private SimpleStringProperty password ;
    private SimpleStringProperty picture ;   
    private SimpleStringProperty diploma;
    private SimpleIntegerProperty phone;

    public gform() {
    }

    
    
    public gform( int id, String Fname, String Lname, String email,String password, String picture, int phone, String diploma) {
        super(id, Fname, Lname, email,password, picture, phone);
        this.diploma =new SimpleStringProperty(diploma);
    }

    public gform( int id, String Fname, String Lname, String email,String password, int phone, String picture,  String diploma) {
        super(id, Fname, Lname, email,password, picture, phone);
        this.diploma =new SimpleStringProperty(diploma);
    }

    public String getDiploma() {
        return diploma.get();
    }

  /*  public void setDiploma(String diploma) {
        this.diploma = diploma;
    } */

    @Override
    public String toString() {
        return "gform{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture  + ", diploma=" + diploma + '}';
    }


    
}
