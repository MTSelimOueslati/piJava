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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helmi
 */
public class ServiceProduct {
    
     Connection c=ConnexionBD.getinstance().getcnx();
    
    public void ajouterProduct(Product p) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into velovendre (price,  marque, Path_photo,  nombre)"
        + " values (?, ?, ?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setDouble(1,p.getPrice());
            pt.setString(2,p.getMarque());
            pt.setString(3,p.getPath_photo());
            pt.setInt(4,p.getNombre());
           
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Product> getAll(){
        List<Product> pr= new ArrayList<>();
        PreparedStatement pt;
        try {
            pt=c.prepareStatement("select * from velovendre");
            ResultSet rs= pt.executeQuery();
            while (rs.next()){
            Product prd = new Product(rs.getInt(1),rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            pr.add(prd);
            }
        } catch (SQLException ex) {            
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
    
    
       public void afficherProduct()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from velovendre");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("velovendre {id:"+rs.getInt(1)+" ,Price:"+rs.getDouble(2)+" ,marque:"+rs.getString(3)+" ,path_photo:"+rs.getString(4)+" ,nombre:"+rs.getInt(5)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void modifierProduct(int id, double price, String marque, String path_photo, int nombre)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update velovendre set price=?, marque=?, path_photo=?, nombre=?  where id=?");
            pt.setDouble(1,price);
            pt.setString(2,marque);
            pt.setString(3,path_photo);
            pt.setInt(4,nombre);
            pt.setInt(5,id);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
}
        public void supprimerProduct(int id)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from velovendre where id=?" );
            pt.setInt(1,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
            public void supprimerProduct1(Product p)
    {
        PreparedStatement pt;
        try {
            pt =c.prepareStatement("delete from velovendre where id=?" );
            pt.setInt(1,p.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
}
