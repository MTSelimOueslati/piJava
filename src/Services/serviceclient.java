/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Client;
import Utils.ConnexionBD;
//import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
//import sun.util.logging.PlatformLogger;

/**
 *
 * @author Asus
 */
public class serviceclient {
             Connection c=ConnexionBD.getinstance().getcnx();

   public List<Client> displayAll() throws SQLException{
       
       ArrayList <Client> tabc = new ArrayList();
       try {
       PreparedStatement pt = c.prepareStatement("SELECT id_client, name, lastname, numero_tel");
       ResultSet res = pt.executeQuery();
       while (res.next()) {
           Client ct = new Client(res.getInt(1), res.getString(2), res.getString(3));
           
       }
        }catch (SQLException ex)
            {
            java.util.logging.Logger.getLogger(serviceclient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     return tabc;  
   }           
             
             
             
             
}
