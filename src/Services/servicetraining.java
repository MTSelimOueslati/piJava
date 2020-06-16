/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.charity;
import Entities.training;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class servicetraining {
    
     Connection c=ConnexionBD.getinstance().getcnx();
    
    public void ajoutertraining(training t) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into training (date,place,idf,description)"
        + " values (?, ?, ?, ?)");
            
            
            pt.setString(1,t.getDate());
            pt.setString(2,t.getPlace());
            pt.setInt(3,t.getIdf());
             pt.setString(4,t.getDesc());
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(servicetraining.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public List<training> displayAll5() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <training> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select id_tr, date, place, formateurs.idf , formateurs.namef, description from training inner join formateurs on formateurs.idf=training.idf");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
                 
                 training tk = new training(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), res.getString(6));
                 
                 tab.add(tk);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(servicetraining.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
    }
    
       public void affichertraining()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from training");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("training {id:"+rs.getInt(1)+" ,date:"+rs.getString(2)+" ,place:"+rs.getString(3)+" ,ide_formateur:"+rs.getInt(4)+" ,desctiption:"+rs.getString(5)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicetraining.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
  public void modifiertraining(int id_tr,String date,String place,int idf,String desc)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update training set date= ? , place= ?  ,idf=? ,description=?  where id_tr=?");
            
            pt.setString(1,date);
            pt.setString(2,place);
            pt.setInt(3,idf);
            pt.setString(4,desc);
            pt.setInt(5,id_tr);
            
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicetraining.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}      
       
        public void supprimertraining(int id_tr)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from training where id_tr=?" );
            pt.setInt(1,id_tr);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicetraining.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
    

        
        
        
        
        
        
        
}
