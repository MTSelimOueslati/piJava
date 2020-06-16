/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Bill;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ServiceBill {
     Connection c=ConnexionBD.getinstance().getcnx();
      
     public void ajouterBill(Bill b) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into bill (Ammount, Id_Item, Price, Id_Client, Name, Last_Name)"
        + " values (?, ?, ?,?,?,?)");
           
            pt.setFloat(1,b.getAmmount());
            pt.setInt(2,b.getId_Item());
            pt.setFloat(3,b.getPrice());
            pt.setInt(4,b.getId_Client());
            pt.setString(5,b.getName());
             pt.setString(6,b.getLast_Name());
          
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void afficherBill()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from bill");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("bill {Id_Bill:"+rs.getInt(1)+" ,Ammount:"+rs.getFloat(2)+" ,Id_Item:"+rs.getInt(3)+" ,Price:"+rs.getFloat(4)+" ,Id_Client:"+rs.getInt(5)+" ,Name:"+rs.getString(6)+" ,Last_Name:"+rs.getString(7)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void modifierBill (float Ammount,int Id_Item, float Price,int Id_Client,int Id_Bill,String Name, String Last_Name)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update bill set Id_Item= ? , Price= ? ,Id_Client= ?, Ammount= ?, Name= ?, Last_Name= ?   where Id_Bill=?");
            pt.setInt(1,Id_Item);
            pt.setFloat(2,Price);
            pt.setInt(3,Id_Client);
            pt.setFloat(4,Ammount);
            pt.setString(5,Name);
            pt.setString(6,Last_Name);
            pt.setInt(7,Id_Bill);
       
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
}
       
       public void supprimerBill(int Id_Bill)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from bill where Id_Bill=?" );
            pt.setInt(1,Id_Bill);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
