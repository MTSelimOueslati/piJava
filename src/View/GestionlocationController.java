/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.*;
import Services.Service_velo_location;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Services.Service_velo_a_louer;
import Utils.ConnexionBD;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mh
 */
public class GestionlocationController implements Initializable {
        //private Connection con = ConnectionBD.getInstance().getCnx();
        @FXML private TableColumn<location, String> i;
         @FXML private TableColumn<location, String> idvelo;
    @FXML private TableColumn<location, String> prix;
    @FXML private TableColumn<location, String> marque;
     @FXML private TableView<location> tableView;
     @FXML private DatePicker datedebut;
     @FXML private DatePicker datefin;
     @FXML private ComboBox<String> combo;
     
@FXML private TextField heuredebut;
@FXML private TextField heurefin;

@FXML private TextField heuredebut1;
 @FXML private DatePicker datedebut1;
    @FXML
    private AnchorPane heurefin1;
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
        
         tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
                
                ObservableList<location> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
       location velo = tableView.getSelectionModel().getSelectedItem();
        
                if(velo.getDate_debut().getDay()==velo.getDate_fin().getDay() && velo.getDate_debut().getMonth()==velo.getDate_fin().getMonth() ){
                
               Service_velo_location srv = new Service_velo_location();
        srv.nombreheure(velo.getId(),"chrono pour velo de id :"+velo.getId_velo());
            }}
        }
    }
});
        
        i.setCellValueFactory(new PropertyValueFactory<location, String>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<location, String>("Date_debut"));
       marque.setCellValueFactory(new PropertyValueFactory<location, String>("Date_fin"));
       idvelo.setCellValueFactory(new PropertyValueFactory<location, String>("id_velo"));
       tableView.setItems(getloc());  
       
       
       ObservableList<String> options = 
    FXCollections.observableArrayList(getid()
            
            
            
            
            
           
            
             
            
        
    );
 combo.setItems(options);
 
 
 

    }    
    @FXML
     private void Refresh(ActionEvent event) throws IOException  
    {
         i.setCellValueFactory(new PropertyValueFactory<location, String>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<location, String>("Date_debut"));
       marque.setCellValueFactory(new PropertyValueFactory<location, String>("Date_fin"));
       tableView.setItems(getloc());  
       
       
       ObservableList<String> options = 
    FXCollections.observableArrayList(getid()
        
    );
 combo.setItems(options);
    } 
    public ObservableList<location>  getloc()
    {
         Service_velo_location srv = new Service_velo_location();
        return srv.getloc();
    } 
    
    
    public ObservableList<String>  getid()
    {
         Service_velo_location srv = new Service_velo_location();
        return srv.getid();
    } 
    

    
     @FXML
    private void verifier(ActionEvent event) throws IOException, ParseException {
         SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        java.util.Date d3 = sd.parse(datedebut1.getValue().toString()+heuredebut1.getText());
        Timestamp ts=new Timestamp(d3.getTime());  
        
        
        
        
   
  
        Service_velo_location srv = new Service_velo_location();
       String warr= srv.verifier_dispo_location(ts);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information mail fournisseur");
alert.setHeaderText(warr);
alert.setContentText("");

alert.showAndWait();

    }
    
    
    
    
    
    
    @FXML
    private void ajouter(ActionEvent event) throws IOException, ParseException {
        
        if(datedebut.getValue()!=null && datefin.getValue()!=null  && combo.getValue()!=null && heuredebut.getText().isEmpty()==false &&heurefin.getText().isEmpty()==false){
         SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        java.util.Date d4 = sd.parse(datedebut.getValue().toString()+heuredebut.getText());
        Timestamp ts=new Timestamp(d4.getTime());  
        Timestamp date = new Timestamp(System.currentTimeMillis());
         SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        java.util.Date d3 = sd.parse(datefin.getValue().toString()+heurefin.getText());
        Timestamp ts1=new Timestamp(d3.getTime());  
        Service_velo_location srv = new Service_velo_location();
        
    location l=new    location(1,ts,ts1,Integer.valueOf(combo.getValue()));
  if(ts.compareTo(ts1)<0 && ts.compareTo(date)>0 ){
      
      
        if(srv.verifier_dispo_location(ts,Integer.valueOf(combo.getValue()))){
        srv.ajoutervelo_a_louer(l);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information mail fournisseur");
alert.setHeaderText("ajoute avec succes ");
alert.setContentText("");

alert.showAndWait();
        
        }else{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information ");
alert.setHeaderText("date non disponible ");
alert.setContentText("");

alert.showAndWait();
        
        }
  }
  else{
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information ");
alert.setHeaderText("erreur saisie date  ");
alert.setContentText("");

alert.showAndWait();
  
  }
    }
    else{
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information ");
alert.setHeaderText("erreur saisie champs vide");
alert.setContentText("");

alert.showAndWait();}
    
    
    }
  @ FXML
    private void supprimer(ActionEvent event) throws IOException, ParseException {
        ObservableList<location> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
       location velo = tableView.getSelectionModel().getSelectedItem();
        
            
   
   
        Service_velo_location srv = new Service_velo_location();
        srv.supprimerlocation(velo.getId());

    }
   
 
    
    
    @FXML
    private void dateajour(ActionEvent event) throws IOException, ParseException {
        
          Service_velo_location srv = new Service_velo_location();
          
        srv.metrre_a_jour_location();

    }
    
    @FXML
    private void update(ActionEvent event) throws IOException, ParseException {
        
         
        
                if(datedebut.getValue()!=null && datefin.getValue()!=null  && combo.getValue()!=null && heuredebut.getText().isEmpty()==false &&heurefin.getText().isEmpty()==false){
                    
        
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        java.util.Date d3 = sd.parse(datedebut.getValue().toString()+heuredebut.getText());
        Timestamp ts=new Timestamp(d3.getTime());  
        
         SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        java.util.Date d4 = sd.parse(datefin.getValue().toString()+heurefin.getText());
        Timestamp ts1=new Timestamp(d4.getTime());  
        
          Service_velo_location srv = new Service_velo_location();
          
          ObservableList<location> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
       location velo = tableView.getSelectionModel().getSelectedItem();
        
          location lo= new location(velo.getId(), ts, ts1,Integer.valueOf(combo.getValue()));
        srv.modifierlocation(lo);

    }
                }
  

 
    @FXML
    private void retour(ActionEvent event) throws IOException, ParseException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLshow_1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,1000,900);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    private void Ecommerce(ActionEvent event) {
    }

    @FXML
    private void OpenEvents2(ActionEvent event) {
    }
    
    
}
