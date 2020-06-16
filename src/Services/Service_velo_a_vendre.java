/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Product;
import Entities.Velo_a_vendre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.ConnexionBD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mh
 */
public class Service_velo_a_vendre {
    
    Connection con=ConnexionBD.getinstance().getcnx();

    public void ajoutervelo_a_louer(Velo_a_vendre vl) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into  velovendre (price,marque,path_photo,description,nombre) Values (" + vl.getPrice() + ",'" + vl.getMarque() + "','" + vl.getPath_photo()+  "','" + vl.getDescription() +"'," + vl.getNombre() + "   )";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void modifiervelo_a_vendre(Velo_a_vendre Vl) {
        try {
            PreparedStatement pt = con.prepareStatement("update velovendre set price=?,marque=?,path_photo=?,description=?,nombre=?  where id=?");
            
            
            pt.setDouble(1, Vl.getPrice());
            pt.setString(2,  Vl.getMarque());
            pt.setString(3,  Vl.getPath_photo());
            pt.setString(4, Vl.getDescription());
            pt.setInt(5, Vl.getNombre());
            pt.setInt(6, Vl.getId());
            
            
            
            
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void affichervelo_a_vendre() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from velovendre ORDER BY price,nombre");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println("velo a louer  [id :" + rs.getInt(1) + ",price" + rs.getDouble(2) + ",marque" + rs.getString(3)+ ",Description" + rs.getString(5)+ ",Nombre total des bike:" + rs.getInt(6)+"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimervelo_a_vendre(  int id) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from velovendre where id=? ");
            pt.setInt(1,id);
            pt.executeUpdate();

        } catch (SQLException ex) {
           
        }
        
       

    }
    
   public ObservableList<Velo_a_vendre>  getloc()
    {
         ObservableList<Velo_a_vendre> people = FXCollections.observableArrayList();
         PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from velovendre");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                
                
                people.add(new Velo_a_vendre(rs.getInt(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
            }
        } catch (SQLException ex) {
            
        }

     
        return people;
    } 
     
     
    public List<Velo_a_vendre> getAll(){
        List<Velo_a_vendre> pr= new ArrayList<>();
        PreparedStatement pt;
        try {
            pt=con.prepareStatement("select * from velovendre");
            ResultSet rs= pt.executeQuery();
            while (rs.next()){
            Velo_a_vendre prd = new Velo_a_vendre(rs.getInt(1),rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(6));
            pr.add(prd);
            }
        } catch (SQLException ex) {            
            Logger.getLogger(Service_velo_a_vendre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }  
    
}
