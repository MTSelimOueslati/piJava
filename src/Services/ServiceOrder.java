/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Order;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ServiceOrder {
     Connection c=ConnexionBD.getinstance().getcnx();
     
     
        public void ajouterOrder(Order o) {
        Statement st;
        try {
            st = c.createStatement();
            String req = " INSERT INTO `order`(`nbr_Order`, `Name`,`Last_Name`,`Email`,`Number`, `Ide_Panier`, `Date`) VALUES(" +o.getnbr_Order()  + ",'" + o.getName()+ "','" + o.getLast_Name()+"','"+ o.getEmail()+"','"+o.getNumber()+"','"+ o.getIde_Panier()+"','" + o.getDate()+ "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
        public void afficherOrder() {
        PreparedStatement pt;
        try {

            pt = c.prepareStatement("SELECT * FROM `order`");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("order [Id_Order :" + rs.getInt(1) + ",nbr_Order:" + rs.getInt(2) + ",Name:" + rs.getString(3)+ ",Last_Name:" + rs.getString(4)+ ",Email:" + rs.getString(5)+",Number:" + rs.getInt(6)+",Ide_Panier:" + rs.getInt(7)+ ",Date:" + rs.getString(8)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

   
    }
         public void modifierOrder(int Id_Order, int nbr_Order, String Name, String Last_Name,String Email,int Number, int Ide_Panier,String Date) {
        try {
            PreparedStatement pt = c.prepareStatement("UPDATE `order` SET `nbr_Order`=? , `Name`=? , `Last_Name`=? , `Email`=? ,`Number`=? ,`Ide_Panier`=? , `Date`=? where Id_Order=?");
            pt.setInt(1, nbr_Order);
            pt.setString(2, Name);
            pt.setString(3, Last_Name);
            pt.setString(4, Email);
            pt.setInt(5, Number);
            pt.setInt(6, Ide_Panier);
            pt.setString(7, Date);
            pt.setInt(8, Id_Order);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void supprimerOrder(int Id_Order) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("DELETE FROM `order` WHERE Id_Order=? ");
            pt.setInt(1,Id_Order);
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
     

