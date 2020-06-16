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
public class Order {
    private int Id_Order;
    private int nbr_Order;
    private int Ide_Panier;
    private String Name;
     private String Last_Name;
      private String Email;
      private int Number;
    private String Date;

    
       
    
    
    
    public Order ( int nbr_Order,String Name, String Last_Name,String Email,int Number,int Ide_Panier,String Date){
      
       this.nbr_Order=nbr_Order;
       this.Name=Name;
       this.Last_Name=Last_Name;
       this.Ide_Panier=Ide_Panier;
       this.Number=Number;
       this.Email=Email;
       this.Ide_Panier=Ide_Panier;
       this.Date=Date;
   }
    
    public int getId_Order() {
        return Id_Order;
    }

    public void setId_Order(int Id_Order) {
        this.Id_Order = Id_Order;
    }

    public int getnbr_Order() {
        return nbr_Order;
    }

    public void setnbr_Order(int nbr_Order) {
        this.nbr_Order = nbr_Order;
    }
     public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number=Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name= Name;
    }
     public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name= Last_Name;
    }
     public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email=Email;
    }
    
    public int getIde_Panier() {
        return Ide_Panier;
    }

    public void setIde_Panier(int Ide_Panier) {
        this.Ide_Panier = Ide_Panier;
    }
    
     public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
     
    @Override
    public String toString() {
        return "Order{" + "Id_Order=" + Id_Order + ", nbr_Order=" + nbr_Order + ", Name=" + Name +", Last_Name=" + Last_Name +", Email"+Email+", Number"+Number+", Ide_Panier"+Ide_Panier+", Date"+Date+ '}';
    }
    
}
