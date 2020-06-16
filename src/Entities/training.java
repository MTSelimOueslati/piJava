/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Asus
 */
public class training {
    
    private int id_tr ; 
    private  String date ;
    private String place ; 
    private int idf;
    private String namef;
    private String desc ;
    
    
    
   

    public training(String date, String place, int idf, String desc) {
        
       // this.id_tr=id_tr;
        this.date = date;
        this.place = place;
        this.idf = idf;
        this.desc =desc;
        
    }

    public training(String date, String place, int idf, String namef, String desc) {
        this.date = date;
        this.place = place;
        this.idf = idf;
        this.namef = namef;
        this.desc = desc;
    }

    public training(int id_tr, String date, String place, int idf, String namef, String desc) {
        this.id_tr = id_tr;
        this.date = date;
        this.place = place;
        this.idf = idf;
        this.namef = namef;
        this.desc = desc;
    }

    public String getNamef() {
        return namef;
    }

    public void setNamef(String namef) {
        this.namef = namef;
    }


    
    
    
  
    public int getId_tr() {
        return id_tr;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public int getIdf() {
        return idf;
    }

    public String getDesc() {
        return desc;
    }

    public void setId_tr(int id_tr) {
        this.id_tr = id_tr;
    }

    public void setDate(String date) {
        this.date =date;
    }

    public void setPlace(String place) {
        this.place =place;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public void setDesc(String desc) {
        this.desc =desc;
    }
    
     
    
}
