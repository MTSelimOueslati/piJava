/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.ConnexionBD;
import Entities.GUser;
import Entities.gdelivman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taieb
 */
public class cruddelivman {
    Connection con=ConnexionBD.getinstance().getcnx();

    public void ajouterPersonne(gdelivman p) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into delivman values (" + p.getId() + ",'" + p.getFname() + "','" + p.getLname() + "','" + p.getEmail() + "','" + p.getPassword() +"','"+ p.getPhone()+"','" + p.getPicture() + "'," + p.getSalary() + " )";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(cruddelivman.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
       public List<gdelivman> getAll()
    {
        List<gdelivman> g = new ArrayList<>();
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from delivman");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                gdelivman c = new gdelivman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
                g.add(c);
              //  System.out.println("Client [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3) +", email" +rs.getString(4)+"Password"+rs.getString(5)+"addresse"+rs.getString(6)+", NumTel"+ rs.getInt(7)+"Image"+rs.getString(8));
             // `iddeliv`, `Fname`, `Lname`, `email`, `password`, `phone`, `picture`, `salary`
            }
        } catch (SQLException ex) {
            Logger.getLogger(cruddelivman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
    
    
    public void afficherPersonne() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from delivman");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Delivman [id :" + rs.getInt(1) + ",nom" + rs.getString(2) + ",prenom" + rs.getString(3) +", email" +rs.getString(4)+", password"+rs.getString(5)+", NumTel"+ rs.getInt(6)+"picture"+rs.getString(7)+", Salaire"+ rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(cruddelivman.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

public void modifierPersonne(int id, gdelivman pm) {
        try {
            PreparedStatement pt = con.prepareStatement("update delivman set Fname=? , Lname = ? , email = ?, password = ?, phone=?, picture = ?,salary = ? where iddeliv=?");
            pt.setString(1, pm.getFname());
            pt.setString(2, pm.getLname());
            pt.setString(3,pm.getEmail());
            pt.setString(4,pm.getPassword());
            pt.setInt(5, pm.getPhone());
            pt.setString(6,pm.getPicture());
            pt.setInt(7,pm.getSalary());
            pt.setInt(8, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cruddelivman.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimerPersonne(gdelivman p) {
        PreparedStatement pt;
        try {
            pt = con.prepareStatement("delete from delivman where iddeliv=? ");
            pt.setInt(1, p.getId());
            pt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cruddelivman.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
