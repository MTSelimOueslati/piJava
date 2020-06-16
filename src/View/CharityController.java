/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.charity;
import Services.servicecharity;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class CharityController implements Initializable {

    @FXML
    private TableView<charity> tablecharity;
    @FXML
    private TableColumn<charity, String> picture_t;
    @FXML
    private TableColumn<charity, String> description_t;
    @FXML
    private TableColumn<charity, String> adresse_t;
    @FXML
    private JFXTextField picture_text;
    @FXML
    private JFXTextField description_text;
    @FXML
    private JFXTextField adresse_text;
    @FXML
    private JFXButton addbut;
    @FXML
    private JFXButton editbtn;
    @FXML
    private JFXButton deletebtn;
    
    ObservableList<charity> oblist = FXCollections.observableArrayList();
    servicecharity srvc = new servicecharity();
    @FXML
    private TableColumn<?, ?> C5;
    

    /**
     * Initializes the controller class.
     */
     servicecharity bs = new servicecharity();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
        
        afficher();
        System.out.println(bs.displayAll());
    }    

    @FXML
    private void add(ActionEvent event) {
        
        
         String pic = picture_text.getText();
         String des = description_text.getText();
         String add = adresse_text.getText();
         
         //String hh = (h.getValue()!= null ? h.getValue().toString() : "");
         
        
        
        //charity cy = new charity(pic, des, add);
        charity cy = new charity(pic, des, add);
        srvc.ajouter(cy);
        afficher();
        
        
        
    }

    @FXML
    private void edit(ActionEvent event) {
        
        //String heure = picture_text.getText();
        //String det = description_text.getText();
        //String adt = adresse_text.getText();
        
        ct = tablecharity.getSelectionModel().getSelectedItem();
        charity da = tablecharity.getSelectionModel().getSelectedItem();
        srvc.modifier(ct.getId_charity(),picture_text.getText(),description_text.getText(),adresse_text.getText());
       
         System.err.println(srvc.displayid(description_text.getText()));
        afficher();
    }
    
    private charity ct;

    @FXML
    private void delete(ActionEvent event) {
      
        ObservableList<charity> selectedRows, allPeople;
        allPeople = tablecharity.getItems();
        selectedRows = tablecharity.getSelectionModel().getSelectedItems();
       ct = tablecharity.getSelectionModel().getSelectedItem();
       srvc.supprimer(ct.getId_charity());
       afficher();
      
      
       
    }
    
    public void afficher()
    {
           
          

            ObservableList obeListe = FXCollections.observableList(bs.displayAll1());
            
        //id_t.setCellValueFactory(new PropertyValueFactory<>("id_Absence"));
        //id_user.setCellValueFactory(new PropertyValueFactory<>("ide_user"));
        
        picture_t.setCellValueFactory(new PropertyValueFactory<>("picture"));
        description_t.setCellValueFactory(new PropertyValueFactory<>("description"));
        adresse_t.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        C5.setCellValueFactory(new PropertyValueFactory<>("id_charity"));
        
        tablecharity.setItems(oblist);
        
        tablecharity.setItems(obeListe);
        
    }

    
    @FXML
    private void select(MouseEvent event) {
        
        ct = tablecharity.getSelectionModel().getSelectedItem();
        
        if(ct !=null){
            
            
            picture_text.setText(ct.getPicture());
            description_text.setText(ct.getDescription());
            adresse_text.setText(ct.getAdresse());
            
            
            
        }
    }@FXML 
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
