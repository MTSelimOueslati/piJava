/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Velo_a_louer;
import Entities.Velo_a_vendre;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.Service_velo_a_louer;
import Services.Service_velo_a_vendre;

/**
 * FXML Controller class
 *
 * @author mh
 */
public class FXMLavendreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML private TableColumn<Velo_a_vendre, String> nombre;
    @FXML private TableColumn<Velo_a_vendre, String> prix;
    @FXML private TableColumn<Velo_a_vendre, String> marque;
    @FXML private TableColumn<Velo_a_vendre, String> description;
    
    @FXML private javafx.scene.control.TextField marque1;
         @FXML private TableColumn<Velo_a_vendre, String> id;
   @FXML private javafx.scene.control.TextField dess;
   @FXML private javafx.scene.control.TextField ID;
   @FXML private javafx.scene.control.TextField nbr;
   @FXML private javafx.scene.control.TextField prix1;
      @FXML private javafx.scene.control.TextField img;
   
   @FXML private ImageView imagep;
    
    @FXML private TableView<Velo_a_vendre> tabv;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        nombre.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Nombre"));
        prix.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Prix"));
       marque.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Marque"));
        description.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Description"));
        id.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("id"));
        
        Services.Service_velo_a_vendre ser=new Services.Service_velo_a_vendre();
        
        tabv.setItems(ser.getloc());  

    } 
    @FXML
    private void photo(ActionEvent event) throws IOException {
        
   javafx.scene.image.Image photo1;
        FileChooser fc =new FileChooser();
        File selectedfile=fc.showOpenDialog(null);
        if(selectedfile!=null){
            
        
       img.setText(selectedfile.toURI().toString());
       
      
        
       photo1 = new javafx.scene.image.Image(img.getText());
      
        
        imagep.setImage(photo1);
    
        
        }
        
        
        
        
        
        
}
    
    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
        if(prix1.getText().isEmpty()==false && marque1.getText().isEmpty()==false  && img.getText().isEmpty()==false  && dess.getText().isEmpty()==false  && nbr.getText().isEmpty()==false )
        {
        
   Velo_a_vendre p1 = new Velo_a_vendre (1,Float.valueOf(prix1.getText()),marque1.getText(),img.getText(),dess.getText(),Integer.valueOf(nbr.getText()));
  
        Service_velo_a_vendre srv = new Service_velo_a_vendre();
        srv.ajoutervelo_a_louer(p1);
        
        
    }
        else{
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information ");
alert.setHeaderText("erreur saisie champs vide");
alert.setContentText("");

alert.showAndWait();}  
    
    
} public void supprimer()
    {
        
         
         ObservableList<Velo_a_vendre> selectedRows, allPeople;
        allPeople = tabv.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tabv.getSelectionModel().getSelectedItems();
       Velo_a_vendre velo = tabv.getSelectionModel().getSelectedItem();
        
            
   
   
        Service_velo_a_vendre srv = new Service_velo_a_vendre();
        srv.supprimervelo_a_vendre(velo.getId());

        

      
       
    }
  public void update()
    {
                if(prix1.getText().isEmpty()==false && marque1.getText().isEmpty()==false  && img.getText().isEmpty()==false  && dess.getText().isEmpty()==false  && nbr.getText().isEmpty()==false )
                {
          Service_velo_a_vendre srv = new Service_velo_a_vendre();
          
          Velo_a_vendre v=new Velo_a_vendre(Integer.valueOf(ID.getText()),Float.valueOf(prix1.getText()),marque1.getText(),img.getText(),dess.getText(),Integer.valueOf(nbr.getText()));
        srv.modifiervelo_a_vendre(v);
                }
                
                else{
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information ");
alert.setHeaderText("erreur saisie champs vide");
alert.setContentText("");

alert.showAndWait();}  
    
        
        
         
    }
    


public void userClickedOnTable()
    {
        Velo_a_vendre person = tabv.getSelectionModel().getSelectedItem();
  ID.setText(String.valueOf(person.getId()));
             
           
         
         
    }
    

@FXML
    private void actualiser(ActionEvent event) throws IOException {
        
    
        nombre.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Nombre"));
        prix.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Prix"));
       marque.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Marque"));
        description.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("Description"));
        id.setCellValueFactory(new PropertyValueFactory<Velo_a_vendre, String>("id"));
        
        Services.Service_velo_a_vendre ser=new Services.Service_velo_a_vendre();
        
        tabv.setItems(ser.getloc());  
       
    
        
        }


}
