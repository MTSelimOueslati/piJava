/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.participants;
import Entities.training;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;  
import javax.mail.internet.*;

/**
 *
 * @author Asus
 */
public class serviceparticipants {
  
         Connection c=ConnexionBD.getinstance().getcnx();

   public void ajouterparticipants(participants p) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into participants (ide_client)"
        + " values (?)");
            
        
            pt.setInt(1,p.getIde_client());
        
 
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
 
 public List<participants> getAll()  {
     List<participants> p = new ArrayList<>();
     PreparedStatement pt ;
  try {
      pt = c.prepareStatement(" select * from participants");
      ResultSet rs = pt.executeQuery();
      while (rs.next()) {
          participants px = new participants(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
          p.add(px);
      } 
    } catch (SQLException ex){
              Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
 }
   return p;
 }
   
   
   public ArrayList<participants> displayAll8() {
      // L'id du freelancer dans la requette est statique il faut le changer (session) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ArrayList <participants> tab = new ArrayList ();     
        
    
         try {
             PreparedStatement pt =c.prepareStatement("select id_part, clients.id_client , clients.name, clients.lastname, clients.numero_tel from participants inner join clients on clients.id_client=participants.ide_client");
               ResultSet res= pt.executeQuery();
             while(res.next())
                 
             {
                 participants part = new participants(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getInt(5));
                 
                 tab.add(part);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       return tab;
    } 
   
   
   
   
   
   
 public void afficherparticipants()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from participants");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("participants {idpart:"+rs.getInt(1)+" ,ide_client:"+rs.getInt(2)+" ,:"+" ,name:"+rs.getString(3)+" ,lastname:"+rs.getString(4)+" ,numero_tel:"+rs.getInt(5)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
  public void modifierparticipants(int idpart, int ide_client, String name, String lastname, int numero_tel)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update participants set ide_client=? , name=?, lastname= ?, numero_tel=? where id_part=?");
            
           
            pt.setInt(1,ide_client);
             pt.setString(2,name);
             pt.setString(3,lastname);
              pt.setInt(4,numero_tel);  
            pt.setInt(5,idpart);

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
   

      
  }
         
      
        public void supprimerparticipants(participants p)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from participants where id_part=?" );
            pt.setInt(1,p.getIdpart());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       

  public int   rechercheid( int nombre)
             
     {
     int id=0;
     PreparedStatement pt;
        try {
            pt = c.prepareStatement("select * from  participants where name=? ");
            pt.setInt(1,nombre);
            
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                id=rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
     }
     
   public void maxpart( )
              
      {
       PreparedStatement pt;
        try {

            pt = c.prepareStatement("select MAX(nbr_part) from participants  ");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println( "l'id :"+rechercheid( rs.getInt(1))+" a plus de prticipants avec : "+rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      }
           
    public void search() {
    
    Connection c=ConnexionBD.getinstance().getcnx();
    {
        PreparedStatement pt;
        try {

            pt = c.prepareStatement("select idpart,name_part,nbr_part from participants ");
            ResultSet rs = pt.executeQuery();
            ResultSetMetaData resultMeta = rs.getMetaData();
          String nom = "";
      String xxx = "";
   
   
         
            while (rs.next()) {
                String i=rs.getString("name_part");
                
                
              if(!xxx.equals(rs.getString("name_part"))){
          xxx = rs.getString("name_part");
          System.out.println("name_part : " + xxx + " :"); 
          
          
          System.out.println("\t name_part: " + rs.getString("name_part") );
        }
        System.out.println("\t" +  " nbr_part :"+  rs.getInt("nbr_part"));
            
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    }
}     
         
}

   