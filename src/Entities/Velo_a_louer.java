/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.*;


/**
 *
 * @author mh
 */
public class Velo_a_louer{
    
     private   SimpleIntegerProperty id;
    private SimpleFloatProperty prix;
    private SimpleStringProperty marque;
    private SimpleStringProperty path_photo;
    private SimpleStringProperty description;
    private SimpleIntegerProperty nombre;
    
    
    

   public Velo_a_louer(int id,float prix,String marque,String path,String des,int nbr)
           
 {
     this.id=new SimpleIntegerProperty(id);
     this.prix=new SimpleFloatProperty(prix);
     this.marque=new SimpleStringProperty(marque);
     this.path_photo=new SimpleStringProperty(path);
     this.description=new SimpleStringProperty(des);
     this.nombre=new SimpleIntegerProperty(nbr);
    




}
   
    
    
    
    
    
    
    
    public int getId() {
        return id.get();
    }

    /**
     * @param id the id to set
     */
    

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix.get();
    }

    /**
     * @param prix the prix to set
     */
    

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque.get();
    }

    /**
     * @param marque the marque to set
     */
    

    /**
     * @return the path_photo
     */
    public String getPath_photo() {
        return path_photo.get();
    }

    /**
     * @param path_photo the path_photo to set
     */
    

    /**
     * @return the description
     */
    public String getDescription() {
        return description.get();
    }

    /**
     * @param description the description to set
     */
    

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre.get();
    }

    /**
     * @param nombre the nombre to set
     */
   

    /**
     * @return the date_debut
     */
    

    /**
     * @return the date_fin
     */
    
}
