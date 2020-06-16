/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Challenge;
import Entities.Event;
import Services.ServiceChallenge;
import Services.ServiceEvent;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class WeeklyController implements Initializable {

    @FXML
    private Button amine;
    @FXML
    private Button me;
    @FXML
    private Button Blog;
    @FXML
    private Button Charity;
    @FXML
    private JFXButton weekly;
    @FXML
    private JFXTextField Rechercher;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> titre;
    @FXML
    private TableColumn<?, ?> Description;
    @FXML
    private TableColumn<?, ?> pic;
    @FXML
    private TableColumn<?, ?> capa;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField description;
    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXButton img;
    @FXML
    private Label imgl;

    /**@FXML   * Initializes the controller class.
     */
   
@FXML
public void back (ActionEvent Ae)
        
{
    FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Admin event.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
                
        Stage window = (Stage) ((Node) Ae.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
}

    @Override
    public void initialize(URL url, ResourceBundle rb)  {
           table.setLayoutY(600.0);
            ServiceEvent srv = new ServiceEvent();
                img.setOnAction(this::upload_1);

          
        try {
 

afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
    
    public void afficher()throws IOException, SQLException{
        ServiceChallenge srv = new ServiceChallenge();
        
            ObservableList obeListe = FXCollections.observableList(srv.readAll());
            
ServiceChallenge Ev = new ServiceChallenge();
int idd= Ev.id();

        titre.setCellValueFactory(new PropertyValueFactory<>("title"));
                Description.setCellValueFactory(new PropertyValueFactory<>("Description"));

                       pic.setCellValueFactory(new PropertyValueFactory<>("pic"));
               capa.setCellValueFactory(new PropertyValueFactory<>("nmbr_pub"));

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        

                            
//                    );ServiceEvent Ev = new ServiceEvent();
//                    
//                    donnees = FXCollections.observableArrayList(Ev.readAll());
//                    
//                    table.setItems(donnees);
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        table.setItems(obeListe);}
          
    @FXML
    public void ok(ActionEvent event) {
        
        

        String titre5 ;
                titre5=titre.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
                                          title.setText(titre5);
                 String a ;
                a=Description.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               
        
                        description.setText(a);
              
                              
                    String h ;
                h=pic.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
               
        imgl.setText(h);
                   
                                    
           }
    @FXML
     private void ajouter(ActionEvent event) throws IOException, SQLException {
        
        ServiceChallenge srv = new ServiceChallenge(); 
        System.out.println(imgl.getText());
                if (title.getText().isEmpty() || description.getText().isEmpty())
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Saisissez tous les champs");
            alert.showAndWait();

                }


        Challenge ch = new Challenge(0, title.getText(), description.getText(),imgl.getText(), 5);
        srv.ajouterChallenge(ch);
        afficher();
      
        
    }
     @FXML
     private void Rechercher() {

        Rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ServiceChallenge sn = new ServiceChallenge();
                ObservableList obeListe = FXCollections.observableList(sn.RA(newValue));
                table.setItems(obeListe);
            } catch (SQLException ex) {
                Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       

        });
    }

    @FXML
    private void upload_1(ActionEvent event) {
    
        FileChooser F = new FileChooser();
        F.setTitle("image drapeaue");
        F.getExtensionFilters().addAll();
        File selectedFile = F.showOpenDialog(imgl.getScene().getWindow());
        
        if(selectedFile != null){
            
            imgl.setText(selectedFile.getName());
        }
        
    }
      /*@FXML
  public static void choose(ActionEvent event) throws Exception
        {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null)
        {
            String fileExtension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."),selectedFile.getName().length());
           
            File source = new File(selectedFile.getPath());
            File dest = new File("C:\\wamp64\\www\\pi_bascla\\"+selectedFile.getName());
            System.out.println(selectedFile.getName());
                                       String filee ; 

                filee=selectedFile.getName();
                imgl.setText(filee);
               
           
        }}*/
   
    @FXML
    private void update(ActionEvent event) {
  


        try {
            
           int  id_ev =  Integer.parseInt(id.getCellData(table.getSelectionModel().getSelectedIndex()).toString());
                      int  cap =  Integer.parseInt(capa.getCellData(table.getSelectionModel().getSelectedIndex()).toString());

            String t =title.getText();
            String t2=description.getText();
            
            String t6 =imgl.getText();
Challenge Ch = new Challenge(id_ev, t, t2, t6, cap);
            ServiceChallenge Ev = new ServiceChallenge();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmation");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de Modifier?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
                        Ev.modifierch(id_ev, Ch);
        }
                 
            afficher();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }

    
    }

   
    
    

