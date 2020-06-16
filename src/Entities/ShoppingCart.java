/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */


public class ShoppingCart {
     
    private String path_photo;
     private int Id_Panier;
     private double Ammount;
     private int Id_Item;
     private double price;
     private List<ShoppingCart> items;
     
     

    public ShoppingCart(){};

 /*  public synchronized void addItem(Product product) {

boolean newItem = true;
for (ShoppingCart scItem : items) {
 
if (scItem.getId_Item() == product.getId()) {

newItem = false;
items.add(scItem);
NbrEquipMax+=1;

}

else {
items.add(scItem);
NbrEquipMax+=1;

}

}

    }
   public synchronized double calculateAmount(double Price) {

double total = 0;

total+= this.getPrice();
Ammount= total;
return Ammount;

}*/

    public ShoppingCart(String path_photo, double price) {
        this.path_photo = path_photo;
        this.price = price;
    }

    public ShoppingCart(String path_photo, double Ammount, int Id_Item, double price) {
        this.path_photo = path_photo;
        this.Ammount = Ammount;
        this.Id_Item = Id_Item;
        this.price = price;
    }

    public ShoppingCart(String path_photo, int Id_Panier, double Ammount, int Id_Item, double price, List<ShoppingCart> items) {
        this.path_photo = path_photo;
        this.Id_Panier = Id_Panier;
        this.Ammount = Ammount;
        this.Id_Item = Id_Item;
        this.price = price;
        this.items = items;
    }
    
    

    public String getPath_photo() {
        return path_photo;
    }

    public int getId_Panier() {
        return Id_Panier;
    }

    public double getAmmount() {
        return Ammount;
    }

    public int getId_Item() {
        return Id_Item;
    }

    public double getPrice() {
        return price;
    }

    public List<ShoppingCart> getItems() {
        return items;
    }

    public void setPath_photo(String path_photo) {
        this.path_photo = path_photo;
    }

    public void setId_Panier(int Id_Panier) {
        this.Id_Panier = Id_Panier;
    }

    public void setAmmount(double Ammount) {
        this.Ammount = Ammount;
    }

    public void setId_Item(int Id_Item) {
        this.Id_Item = Id_Item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItems(List<ShoppingCart> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "path_photo=" + path_photo + ", Id_Panier=" + Id_Panier + ", Ammount=" + Ammount + ", Id_Item=" + Id_Item + ", Price=" + price + ", items=" + items + '}';
    }
   
   
   
}
     
     
    

