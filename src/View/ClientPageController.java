/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class ClientPageController implements Initializable {

    @FXML
    private Button velo;
    @FXML
    private Button amine;
    @FXML
    private Button me;
    @FXML
    private Button Blog;
    @FXML
    private Button Forum;
    @FXML
    private Button logout;
    @FXML
    private Pane pane1;
    @FXML
    private Button recycle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            Stage ClientPage = new Stage();
            Parent roo = null;
            ClientPage.initStyle(StageStyle.DECORATED);
                
// TODO
    }    

    @FXML
    private void ines(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("shoppingCart.fxml"));
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
    private void OpenEvents2(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Event.fxml"));
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
    private void recycle (ActionEvent event) {
           FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("recycle.fxml"));
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
    private void amine (ActionEvent event) {
           FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AVClientHomeScreen.fxml"));
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
    private void Charity(ActionEvent event) {
               FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("charity.fxml"));
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
    
    }


   
    

