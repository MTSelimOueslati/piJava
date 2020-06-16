/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.ConnexionBD;
import Entities.GUser;
import Entities.gadmin;
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
 * @author taieb
 */
public class crudadmin {
    Connection con=ConnexionBD.getinstance().getcnx();

    public void ajouterPersonne(gadmin p) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into admin values ("+ p.getId()+",'"+ p.getFname()+"','"+p.getLname()+"','"+p.getEmail()+"','"+p.getPassword()+"',"+p.getPhone()+",'"+p.getPicture()+"')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    
    
    public void afficherPersonne() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from admin");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Admin [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3) +", email" +rs.getString(4)+"Password"+rs.getString(5)+", NumTel"+ rs.getInt(6)+"Image"+rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(crudadmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 public void modifierPersonne(int id, gadmin pm) {
        try {
            PreparedStatement pt = con.prepareStatement("update admin set Fname=? , Lname = ? , email = ?, password = ?, phone=?, picture = ? where idAdmin=?");
            pt.setString(1, pm.getFname());
            pt.setString(2, pm.getLname());
            pt.setString(3,pm.getEmail());
            pt.setString(4,pm.getPassword());
            pt.setInt(5, pm.getPhone());
            pt.setString(6,pm.getPicture());
            
            pt.setInt(7, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(crudadmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerPersonne(gadmin p) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from admin where idAdmin=? ");
            pt.setInt(1, p.getId());
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
