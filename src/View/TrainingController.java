/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.formateur;
import Entities.training;
import Services.servicetraining;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class TrainingController implements Initializable {

    @FXML
    private TableView<formateur> tablefprmateur;
    @FXML
    private TableColumn<formateur, Integer> idfc;
    @FXML
    private TableColumn<formateur, String> nomc;
    @FXML
    private TableColumn<formateur, String> prenomc;
    @FXML
    private TableColumn<formateur, String> emailc;
    ObservableList<formateur> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<training> tabletraining;
    private TableColumn<training, Integer> idfcc;
    private TableColumn<training, String> datecc;
    private TableColumn<training, String> placecc;
    private TableColumn<training, String> desccc;
    private TableColumn<training, String> nomcc;
    
        ObservableList<training> oblist1 = FXCollections.observableArrayList();

    
    
    @FXML
    private JFXTextField idfor_text;
    @FXML
    private JFXTextField nom_text;
    @FXML
    private JFXDatePicker date_text;
    private JFXTextArea desc_text;
    @FXML
    private JFXTextField place_text;
    @FXML
    private Button addbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button editbtn;
Connection c=ConnexionBD.getinstance().getcnx();
    servicetraining srvt = new servicetraining();
    @FXML
    private TableColumn<training, String> date1;
    @FXML
    private TableColumn<training, String> place1;
    @FXML
    private TableColumn<training, Integer> idfor1;
    @FXML
    private TableColumn<training, String> nom1;
    @FXML
    private TableColumn<training, String> desc1;
    @FXML
    private Button Ecommerce;
    @FXML
    private Button amine;
    @FXML
    private Button me;
    @FXML
    private Button Blog;
    @FXML
    private Button Forum;
    @FXML
    private Button Charity;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
           ResultSet rs = c.createStatement().executeQuery("SELECT idf, namef, lastnamef, email from formateurs ");
            
            while(rs.next()){
                
                oblist.add(new formateur(rs.getInt("idf"), rs.getString("namef"), rs.getString("lastnamef"), rs.getString("email")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainingController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        idfc.setCellValueFactory(new PropertyValueFactory<>("idf"));
        nomc.setCellValueFactory(new PropertyValueFactory<>("namef"));
        prenomc.setCellValueFactory(new PropertyValueFactory<>("lastnamef"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        tablefprmateur.setItems(oblist);
        
        afficher();
        
        
    }    

    @FXML
    private void add(ActionEvent event) throws SQLException {
        
            String date = ( date_text.getValue()!= null ? date_text.getValue().toString() : "");
            //training tr= new training(date, place_text.getText(), Integer.valueOf(idfor_text.getText()), desc_text.getText(), nom_text.getText());
            training ttr = new training(date, place_text.getText(), Integer.valueOf(idfor_text.getText()), nom_text.getText(), desc_text.getText());
            srvt.ajoutertraining(ttr);
            afficher();

    }

    @FXML
    private void delete(ActionEvent event) {
        
        ObservableList<training> selectedRows, allPeople;
        allPeople = tabletraining.getItems();
        selectedRows = tabletraining.getSelectionModel().getSelectedItems();
       tab1 = tabletraining.getSelectionModel().getSelectedItem();
       
       srvt.supprimertraining(tab1.getId_tr());
       afficher();
    }
private training tab1;
    @FXML
    private void edit(ActionEvent event) {
        tab1 = tabletraining.getSelectionModel().getSelectedItem();
        String datee = ( date_text.getValue()!= null ? date_text.getValue().toString() : "");
      
          
        srvt.modifiertraining(tab1.getId_tr(), datee, place_text.getText(), Integer.valueOf(idfor_text.getText()), desc_text.getText());
       
         
        afficher();
        
    }
    
    private formateur ct;

    @FXML
    private void select(MouseEvent event) {
        ct = tablefprmateur.getSelectionModel().getSelectedItem();
        
        if(ct !=null){
            
            
            idfor_text.setText(String.valueOf(ct.getIdf()));
            nom_text.setText(ct.getNamef());      
            
        }
        
    }
    
    public void afficher()
    {
           

            ObservableList obeListe = FXCollections.observableList(srvt.displayAll5());
            
        
  
        
        date1.setCellValueFactory(new PropertyValueFactory<>("date"));
        place1.setCellValueFactory(new PropertyValueFactory<>("place"));
        idfor1.setCellValueFactory(new PropertyValueFactory<>("idf"));
       nom1.setCellValueFactory(new PropertyValueFactory<>("namef"));
        desc1.setCellValueFactory(new PropertyValueFactory<>("desc"));
        
        
        tabletraining.setItems(oblist1);
        
        tabletraining.setItems(obeListe);
        
    }
    
    

    @FXML
    private void select2(MouseEvent event) {
        
        tab1 = tabletraining.getSelectionModel().getSelectedItem();
        
        if(tab1 !=null){
            
            idfor_text.setText(String.valueOf(tab1.getIdf()));
            nom_text.setText(String.valueOf(tab1.getNamef()));
            place_text.setText(String.valueOf(tab1.getPlace()));
       desc_text.setText(String.valueOf(tab1.getDesc()));  
        }
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
           window.initStyle(StageStyle.UTILITY);
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
                Scene Donia = new Scene(root);
                
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