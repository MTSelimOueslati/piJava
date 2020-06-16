/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.recycle;
import Services.servicerecycle;
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
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class RecycleController implements Initializable {

    @FXML
    private TableView<recycle> tablerecycle;
    @FXML
    private TableColumn<recycle, String> descco;
    @FXML
    private TableColumn<recycle, String> iamgec;
    @FXML
    private JFXTextField description_text;
    @FXML
    private JFXTextField image_text;
    @FXML
    private JFXButton addbut;
    @FXML
    private JFXButton deletebt;
    @FXML
    private JFXButton editbu;
    
    ObservableList<recycle> oblist = FXCollections.observableArrayList();
    servicerecycle srvr = new servicerecycle();
    @FXML
    private TableColumn<?, ?> C3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        afficher();
    }    

    @FXML
    private void add(ActionEvent event) {
        
         String des = description_text.getText();
         String pic = image_text.getText();
         
        recycle ry = new recycle(des, pic);
        
        
        srvr.ajouter(ry);
        afficher();
        
    }

    @FXML
    private void delete(ActionEvent event) {
        
        ObservableList<recycle> selectedRows, allPeople;
        allPeople = tablerecycle.getItems();
        selectedRows = tablerecycle.getSelectionModel().getSelectedItems();
       ct = tablerecycle.getSelectionModel().getSelectedItem();
       
       srvr.supprimer(ct.getId_recycle());
       afficher();
    }

    private recycle ct;
    @FXML
    private void edit(ActionEvent event) {
        
        ct = tablerecycle.getSelectionModel().getSelectedItem();
      
        
        srvr.modifier(ct.getId_recycle(), description_text.getText(), image_text.getText());
       
         
        afficher();
    }
    
     public void afficher()
    {
           
          

            ObservableList obeListe = FXCollections.observableList(srvr.displayAll5());
            
        //id_t.setCellValueFactory(new PropertyValueFactory<>("id_Absence"));
        //id_user.setCellValueFactory(new PropertyValueFactory<>("ide_user"));
        
        descco.setCellValueFactory(new PropertyValueFactory<>("description"));
        iamgec.setCellValueFactory(new PropertyValueFactory<>("picture"));
        C3.setCellValueFactory(new PropertyValueFactory<>("id_recycle"));
      
        
        tablerecycle.setItems(oblist);
        
        tablerecycle.setItems(obeListe);
        
    }

    @FXML
    private void select(MouseEvent event) {
        
        ct = tablerecycle.getSelectionModel().getSelectedItem();
        
        if(ct !=null){
            
            
            
            description_text.setText(ct.getDescription());
            image_text.setText(ct.getPicture());
    }
    
}  @FXML 
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
