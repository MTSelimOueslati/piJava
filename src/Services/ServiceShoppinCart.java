/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.ShoppingCart;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ServiceShoppinCart {
    
    Connection c=ConnexionBD.getinstance().getcnx();
    
    public void ajoutershoppingcart(ShoppingCart sc) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into shoppingcart (path_photo, Ammount, Id_Item, price)"
        + " values (?, ?, ?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setString(1,sc.getPath_photo());
            pt.setDouble(2,sc.getAmmount());
            pt.setInt(3,sc.getId_Item());
            pt.setDouble(4,sc.getPrice());
           
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void affichershoppingcart()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from shoppingcart");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("shoppingcart {id_Panier:"+rs.getInt(1)+" ,path_photo:"+rs.getString(2)+" ,Ammount:"+rs.getFloat(3)+" ,Id_Item:"+rs.getInt(4)+" ,Price:"+rs.getDouble(5)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void modifiershoppingcart (int Id_Panier,String path_photo, int Id_Item, double Ammount, double price)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update shoppingcart set path_photo=?, Ammount=?, Id_Item=?, price=?  where Id_Panier=?");
            pt.setString(1,path_photo);
            pt.setDouble(2,Ammount);
            pt.setInt(3,Id_Item);
            pt.setDouble(4,price);
            pt.setInt(5,Id_Panier);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
}
        public void supprimershoppingcart(int Id_Panier)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from shoppingcart where Id_Panier=?" );
            pt.setInt(1,Id_Panier);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public List<ShoppingCart> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <ShoppingCart> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select path_photo, price from shoppingcart");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
               ShoppingCart s = new ShoppingCart(res.getString(1),res.getDouble(2));
                 tab.add(s);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        public void supprimershoppingcart1(ShoppingCart s)
    {
        PreparedStatement pt;
        try {
            pt =c.prepareStatement("delete from shoppingcart where Id_Panier=?" );
            pt.setInt(1,s.getId_Panier());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public double Calculer () throws SQLException{
           
            double Ammount = 0.00;
         PreparedStatement pt =c.prepareStatement("select price from shoppingcart");
             ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("price"+ rs.getDouble(1));
                Ammount+=rs.getDouble(1);
                System.out.println(Ammount);
            }
            return Ammount;
        }
       
    
}
