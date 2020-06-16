/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author helmi
 */
public class Product {
    private int id;
    private double price;
    private String marque;
    private String Path_photo;
    private int nombre;

    public Product(int id, double price, String marque, String Path_photo, int nombre) {
        this.id = id;
        this.price = price;
        this.marque = marque;
        this.Path_photo = Path_photo;
        this.nombre = nombre;
    }

    
    
    
    
    public Product(double price, String marque, String Path_photo, int nombre) {
        this.price = price;
        this.marque = marque;
        this.Path_photo = Path_photo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getMarque() {
        return marque;
    }

    public String getPath_photo() {
        return Path_photo;
    }

    public int getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPath_photo(String Path_photo) {
        this.Path_photo = Path_photo;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", price=" + price + ", marque=" + marque + ", Path_photo=" + Path_photo + ", nombre=" + nombre + '}';
    }
    

    
    
    
}

    
