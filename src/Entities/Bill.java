/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ACER
 */
public class Bill {
    private int Id_Bill;
    private float Ammount;
    private int Id_Item;
    private  int Id_Client;
    private String Name;
    private String Last_Name;
    private float Price;
    
    
    public Bill(){};
    
     public Bill (float Ammount,int Id_Item, int Id_Client,float Price,String Name, String Last_Name){
    
         this.Ammount=Ammount;
         this.Id_Item=Id_Item;
        this.Price=Price;
        this.Id_Client=Id_Client;
        this.Name=Name;
        this.Last_Name=Last_Name;
       
        
    }
      public int getId_Bill() {
        return Id_Bill;
    }

    public void setId_Bill(int Id_Bill) {
        this.Id_Bill = Id_Bill;
    }

    public int getId_Item() {
        return Id_Item;
    }

    public void setId_Item(int Id_Item) {
        this.Id_Item=Id_Item;
    }
     public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price=Price;
    }
    
       public int getId_Client() {
        return Id_Client;
    }
      public void setId_Client(int Id_Client) {
        this.Id_Client=Id_Client;
    }

    public float getAmmount() {
        return Ammount;
    }

    public void setAmmount(float Ammount) {
        this.Ammount = Ammount;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name=Name;
    }
     public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name=Last_Name;
    }
    @Override
     public String toString() {
        return "Bill{" + "Id_Bill=" + Id_Bill + ", Name"+Name+ ", Last_Name"+Last_Name+ ", Ammount"+Ammount+", Id_Client=" +Id_Client+", Id_Item=" + Id_Item +", Price=" + Price + '}';
    }
    
     
}
