/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Velo_a_louer;
import Utils.ConnexionBD;
import Entities.location;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author mh
 */
public class Service_velo_location {
    private static int heure=0,minute=1,seconde=1;
   Connection con=ConnexionBD.getinstance().getcnx();

    
     public void ajoutervelo_a_louer(location vl) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into  location  (idlocation,date_debut,date_fin) Values (" + vl.getId_velo()+ ",'" + vl.getDate_debut()+ "' , '"+vl.getDate_fin()+  " '  )";
               PreparedStatement pt = con.prepareStatement("update velolouer set etat=?  where id=?");
                 pt.setString(1,"non Libre" );
            
          
            pt.setInt(2, vl.getId());
                pt.executeUpdate();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
     public void   nombreheure(int id ,String s)
             
     {
         int nombre_heure=0;
         int nombre_minute=0;
         	  int heure=0,minute=0,seconde=1;

          PreparedStatement pt;
        try {

            pt = con.prepareStatement("select EXTRACT(HOUR FROM date_debut  ),EXTRACT(HOUR FROM date_fin  ),EXTRACT(MINUTE FROM date_debut  ),EXTRACT(MINUTE FROM date_fin  ) from location where id=?");
            
           pt.setInt(1, id);
           ResultSet rs = pt.executeQuery();
            while (rs.next()) {
            nombre_heure=Math.abs(rs.getInt(2)-rs.getInt(1));
                      nombre_minute=Math.abs(rs.getInt(4)-rs.getInt(3))+1;
             
                
            }
        
            Service_velo_location.heure=nombre_heure;
            Service_velo_location.minute=nombre_minute;
            
            int delais=1000;
		ActionListener tache_timer;

		
		 JLabel Label1 = new JLabel(heure+":"+minute+":"+seconde); /* déclarer final car une classe interne va acceder à ce composant */
		 
		
		JFrame fenetre = new JFrame(s);
		JPanel Panel1 = new JPanel();

		
		
		Label1.setBorder(new EmptyBorder(10,135,10,10));
		fenetre.getContentPane().add(Label1,"Center");
		fenetre.getContentPane().add(Panel1,"South");
		tache_timer= new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
                            if(Service_velo_location.heure<0)
                            {
				Label1.setText(0+":"+0+":"+0);
                                
                            }
                            else
                            
                                Service_velo_location.seconde--;
				if(Service_velo_location.seconde==0)
				{
					Service_velo_location.seconde=60;
					Service_velo_location.minute--;
				}
				if(Service_velo_location.minute==0)
				{
					Service_velo_location.minute=60;
					Service_velo_location.heure--;
				}
				Label1.setText(Service_velo_location.heure+":"+Service_velo_location.minute+":"+Service_velo_location.seconde);/* rafraichir le label */
                          
			}
                        
                        
                        
                        
		};
                 Timer timer1= new Timer(delais,tache_timer);
		
                
                
                
                
		     timer1.start();
                
		       
                
               
		
		
		fenetre.pack();
		fenetre.setLocation(800,200);  
		fenetre.setSize(700,100);  
		fenetre.show();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }
	

     
     }
     
     
     public void supprimerlocation(int id) {
        PreparedStatement pt;
         PreparedStatement pt2;
        try {
            pt = con.prepareStatement("delete from location where id=? ");
            pt.setInt(1, id);
            pt.executeUpdate();
            
            pt2= con.prepareStatement("update velolouer set etat=?  where id=?");
                 pt2.setString(1," Libre" );
            
          
            pt2.setInt(2, id);
                pt2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_location.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
      public void metrre_a_jour_location() {
        PreparedStatement pt;
         Timestamp date = new Timestamp(System.currentTimeMillis());
        try {
           pt = con.prepareStatement("select date_fin,idlocation  from location ");
            
          
           ResultSet rs = pt.executeQuery();
            while (rs.next()) {
            if(rs.getTimestamp(1).compareTo(date)<0)
            {
             supprimerlocation(rs.getInt(2));
            
            }
             
                
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_location.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
      public String verifier_dispo_location(Timestamp date) {
        PreparedStatement pt;
         int verif=0;
         String v="";
        try {
           pt = con.prepareStatement("select date_fin,date_debut  from location ");
            
          
           ResultSet rs = pt.executeQuery();
            while (rs.next()) {
            if(rs.getTimestamp(1).compareTo(date)>=0 && rs.getTimestamp(2).compareTo(date)<0)
            {
                verif=1;
            
            }
           
                
            }
            
            if(verif==0)
            {
                System.err.println("date dispo");
                v="date dispo";
            }
            else
            {
                System.err.println("date non  dispo choisir autre date svp");
                
             v="date non  dispo choisir autre date svp";
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_location.class.getName()).log(Level.SEVERE, null, ex);
        }
return v;
    }
      
       public Boolean verifier_dispo_location(Timestamp date,int id) {
        PreparedStatement pt;
         int verif=0;
         Boolean v=false;
        try {
           pt = con.prepareStatement("select date_fin,date_debut  from location where idlocation=? ");
            
          
            pt.setInt(1, id);
           ResultSet rs = pt.executeQuery();
            while (rs.next()) {
            if(rs.getTimestamp(1).compareTo(date)>=0 && rs.getTimestamp(2).compareTo(date)<=0)
            {
                verif=1;
            
            }
           
                
            }
            
            if(verif==0)
            {
                System.err.println("date dispo");
                v=true;
            }
            else
            {
                System.err.println("date non  dispo choisir autre date svp");
                
             v=false;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_location.class.getName()).log(Level.SEVERE, null, ex);
        }
return v;
    }
      
      
      
      
      
      
      
      
      
      
      
      
      public void affichervelo_en_cours_location() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from location ");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println("velo a louer  [id :" + rs.getInt(1) +  ",date_debut" + rs.getString(2)+ ",date_fin" + rs.getString(3)+ "]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void modifierlocation(location Vl) {
        try {
            PreparedStatement pt = con.prepareStatement("update location set date_debut=?,date_fin=?,idlocation=?  where id=?");
            
            
            pt.setTimestamp(1, Vl.getDate_debut());
            
          
            pt.setTimestamp(2, Vl.getDate_fin());
            pt.setInt(3, Vl.getId_velo());
            pt.setInt(4, Vl.getId());
            
            
            
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   public ObservableList<location>  getloc()
    {
         ObservableList<location> people = FXCollections.observableArrayList();
         PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from location");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                
                
                people.add(new location(rs.getInt(1),rs.getTimestamp(2),rs.getTimestamp(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            
        }

     
        return people;
    } 
   public ObservableList<String>  getid()
    {
         ObservableList<String> people = FXCollections.observableArrayList();
         PreparedStatement pt;
        try {

            pt = con.prepareStatement("select id from velolouer");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                
                
                people.add(String.valueOf(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            
        }

     
        return people;
    } 
   
   
  
}
