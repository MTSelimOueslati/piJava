
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.charity;
import Entities.recycle;
import Entities.training;
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
 * @author Asus
 */
public class servicecharity {
         Connection c=ConnexionBD.getinstance().getcnx();
         
         
    public void ajouter(charity ch){
         try{
             
             
    PreparedStatement pt= c.prepareStatement(" insert into charity (picture,description,adresse)"
        + " values (?, ?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setString(1, ch.getPicture());
           
            pt.setString(2,ch.getDescription());
            pt.setString(3,ch.getAdresse());
            
            
           pt.execute();
            
        }catch (SQLException ex)
            {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public List<charity> displayAll1() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <charity> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select * from charity");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
                 //Absence a =new Absence(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5))
                // charity ct = new charity(res.getString(1), res.getString(2), res.getString(3));
                 charity kt = new charity(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
                  
                 tab.add(kt);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
    }
      
         public void modifier (int id_charity,String picture,String description,String adresse)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update charity set picture=? , description= ? , adresse= ?  where id_charity=?");
            pt.setString(1,picture);
            pt.setString(2,description);
            pt.setString(3,adresse);
            pt.setInt(4,id_charity);
            
            
            //pt.executeUpdate();
            pt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
}
         
         
          public void supprimer(int id_charity)
     {
         try {
            PreparedStatement pt =c.prepareStatement("delete from charity where id_charity=?" );
            pt.setInt(1,id_charity);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
          
           public int displayid(String description) {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int k=0;
    
         try {
             PreparedStatement pt =c.prepareStatement("SELECT id_charity from charity where description=?");
               pt.setString(1,description);
            ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
                 k=res.getInt(1);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return k ;
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         

    /*public void ajoutercharity(charity s) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into charity (picture,description,adresse)"
        + " values (?, ?, ?)");
            
            
            pt.setString(1,s.getPicture());
            pt.setString(2, s.getDescription());
            pt.setString(3,s.getAdresse());
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     */
    public void affichercharity()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select picture, description, adresse from charity");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("picture:"+rs.getString(1)+" ,description:"+rs.getString(2)+" ,adresse:"+rs.getString(3)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
      public void modifiercharity(int id_charity,String picture,String description,String adresse)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update charity set picture= ?  , description=? , adresse=? where id_charity=?");
            
            
            pt.setString(1,picture);
            pt.setString(2,description);
            pt.setString(3,adresse);
            pt.setInt(4,id_charity);
            
            pt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }}   
         
          public void supprimercharity(int id_charity)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from charity where id_charity=?" );
            pt.setInt(1,id_charity);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
  
    public ArrayList<charity> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <charity> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select picture, description,adresse from charity");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
                 //Absence a =new Absence(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5))
     charity r = new charity(res.getString(1),res.getString(2),res.getString(3));
                 tab.add(r);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;       
         
}
}