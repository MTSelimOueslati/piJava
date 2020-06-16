/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Velo_a_louer;
import java.awt.AWTException;
import java.awt.Button;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.management.Notification;
import org.controlsfx.control.Notifications;
import Services.*;


/**
 * FXML Controller class
 *
 * @author mh
 */
public class AjouterFXMLController implements Initializable {
    
   @FXML private javafx.scene.control.TextField img;
   @FXML private javafx.scene.control.TextField prix;
@FXML private ImageView imgv;
@FXML private ImageView imageview;
   @FXML private javafx.scene.control.TextField marque;
   @FXML private javafx.scene.control.TextArea des;
   @FXML private javafx.scene.control.TextField nbr;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          javafx.scene.image.Image photo;
           photo = new javafx.scene.image.Image("83159905_176950960063317_6467597685460303872_n.png");
             imgv.setImage(photo);
          
    }    

    @FXML
    private void importerimage(ActionEvent event) throws IOException {
        
   javafx.scene.image.Image photo1;
        FileChooser fc =new FileChooser();
        File selectedfile=fc.showOpenDialog(null);
        if(selectedfile!=null){
            
        
       img.setText(selectedfile.toURI().toString());
        photo1 = new javafx.scene.image.Image(img.getText());
      
        
        imageview.setImage(photo1);
    
        
        }
        
        
        
        
}
    @FXML
    private void Ajouter(ActionEvent event) throws IOException, AWTException {
        
       if(prix.getText().isEmpty()==false && marque.getText().isEmpty()==false  && img.getText().isEmpty()==false  && des.getText().isEmpty()==false  && nbr.getText().isEmpty()==false )
       {
        
   Velo_a_louer p1 = new Velo_a_louer (1,Integer.valueOf(prix.getText()),marque.getText(),img.getText(),des.getText(),Integer.valueOf(nbr.getText()));
  
        Service_velo_a_louer srv = new Service_velo_a_louer();
        srv.ajoutervelo_a_louer(p1);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText("ajoute  avec succes");
alert.setContentText("succes");

alert.showAndWait();
Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLshow_1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,1000,700);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
  
  
 TrayIconDemo td = new TrayIconDemo();
            
                td.displayTray();
          
        
}
  else{
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information ");
alert.setHeaderText("erreur saisie champs vide");
alert.setContentText("");

alert.showAndWait();}  
    
}
    

@FXML 
     private void OpenEvents2 (ActionEvent event)
    {
       FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Admin event.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
@FXML
    private void logout(ActionEvent event) {
  
     FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("LOGINFXML.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       }    
    }

    @FXML
    private void Ecommerce(ActionEvent event) {
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("FXMLshow_1.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

    @FXML
    private void user(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AFFICHERFXML.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
    }

    @FXML
    private void Amine (ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AVAdminHomeScreen.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
    }
    @FXML
    private void training (ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("training.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
    @FXML
    private void charity (ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("charity.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
    
}