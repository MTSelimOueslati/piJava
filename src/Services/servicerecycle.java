/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.charity;
import Entities.recycle;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;

/**
 *
 * @author Asus
 */
public class servicerecycle {
             Connection c=ConnexionBD.getinstance().getcnx();
             
             
              public void ajouter(recycle ch){
         try{
             
             
    PreparedStatement pt= c.prepareStatement(" insert into recycle (description,picture)"
        + " values (?, ?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setString(1, ch.getDescription());
           
            pt.setString(2,ch.getPicture());
            
            
            
           pt.execute();
            
        }catch (SQLException ex)
            {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
             

       public void ajouterrecycle(recycle r) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into recycle ( description, picture)"
        + " values ( ?, ?)");
         
            pt.setString(1, r.getDescription());
           pt.setString(2,r.getPicture());
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }          
       
       
         public void modifier (int id_recycle,String description,String picture)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update recycle set description=? , picture= ?  where id_recycle=?");
            pt.setString(1,description);
            pt.setString(2,picture);
            pt.setInt(3,id_recycle);
    
            pt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
}
         
            public void supprimer(int id_recycle)
     {
         try {
            PreparedStatement pt =c.prepareStatement("delete from recycle where id_recycle=?" );
            pt.setInt(1,id_recycle);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
       
       
     public List<recycle> displayAll5() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <recycle> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select * from recycle");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
               
                // recycle rc = new recycle(res.getString(1), res.getString(2));
                 recycle rc1= new recycle(res.getInt(1), res.getString(2), res.getString(3));
                 tab.add(rc1);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
    }  
       
       
             
      public void afficherrecycle()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select description,picture from recycle");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("recycle {description:"+rs.getString(1)+" ,picture:"+rs.getString(2)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
        
       public void modifierrecycle(int id_recycle, String description, String picture)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update recycle set description=?, picture= ?  where id_recycle=?");
         
            
            pt.setString(1,description);
             pt.setString(2,picture);
            pt.setInt(3,id_recycle);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }}   
                
         public void supprimerrecycle(int id_recycle)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from recycle where id_recycle=?" );
            pt.setInt(1,id_recycle);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
           public List<recycle> displayAll() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <recycle> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select description,picture from recycle");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
                 //Absence a =new Absence(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5))
     recycle r = new recycle(res.getString(1),res.getString(2));
                 tab.add(r);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

  
         
}
