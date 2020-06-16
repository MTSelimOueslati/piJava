/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author mh
 */
public class Velo_a_vendre {
    
     private int id;
    private double price;
    private String marque;
    private String path_photo;
    private String description;
    private int nombre;

    public Velo_a_vendre(int id, double prix,String marque,String path_photo,String des,int nb)
            
    {
        this.id=id;
        this.price=price;
        this.marque=marque;
        this.path_photo=path_photo;
        this.description=des;
        this.nombre=nb;
    
    
    
    }

    public Velo_a_vendre(int id, double price, String marque, String path_photo, int nombre) {
        this.id = id;
        this.price = price;
        this.marque = marque;
        this.path_photo = path_photo;
        this.nombre = nombre;
    }

    public Velo_a_vendre(int id, String marque, String description, int nombre) {
        this.id = id;
        this.marque = marque;
        this.description = description;
        this.nombre = nombre;
    }
    public Velo_a_vendre(){};
    
    
    
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the prix
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double price) {
        this.price = price;
    }

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the path_photo
     */
    public String getPath_photo() {
        return path_photo;
    }

    /**
     * @param path_photo the path_photo to set
     */
    public void setPath_photo(String path_photo) {
        this.path_photo = path_photo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    
}
