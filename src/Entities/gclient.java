/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import Entities.GUser;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author taieb
 */
public class gclient extends GUser {
    private SimpleStringProperty Fname ;
    private SimpleStringProperty Lname ;
    private SimpleStringProperty email ;
    private SimpleStringProperty password ;
    private SimpleStringProperty picture ;
    private SimpleIntegerProperty phone ;   
    private SimpleStringProperty address ;

    public gclient() {
    }

    public gclient( String Fname, String Lname, String email,String password, String address,  int phone, String picture) {
        super( Fname, Lname, email,password, picture, phone);
        this.address = new SimpleStringProperty(address);
    }

     public gclient(int id, String Fname, String Lname, String email,String password, String address,  int phone, String picture) {
        super(id, Fname, Lname, email,password, picture, phone);
        this.address = new SimpleStringProperty(address);
    }

    

   
 
    
    
    


    public String getAddress() {
        return address.get();
    }

  /*  public void setAddress(String address) {
        this.address = address;
    } */

    @Override
    public String toString() {
        return "gclient{"  + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + ", address=" + address + '}';
    }


    
    
}
