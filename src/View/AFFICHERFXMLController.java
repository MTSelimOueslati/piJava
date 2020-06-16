/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static com.jfoenix.svg.SVGGlyphLoader.clear;
import Entities.gclient;
import Entities.gdelivman;
import Entities.gform;
import Entities.grespevent;
import Entities.grespmaint;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.crudClient;
import Services.crudadmin;
import Services.cruddelivman;
import Services.crudform;
import Services.crudrespevent;
import Services.crudrespmaint;
import javafx.scene.Node;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author taieb
 */
public class AFFICHERFXMLController implements Initializable {

    @FXML
    private TableView<gclient> table;
    @FXML
    private TextField idC;
    @FXML
    private TextField FnameC;
    @FXML
    private TextField LnameC;
    @FXML
    private TextField emailC;
    @FXML
    private TextField passwordC;
    @FXML
    private TextField phoneC;
    @FXML
    private TextField addressC;
    @FXML
    private Button pictureC;
    @FXML
    private Button addC;
    @FXML
    private Button updateC;
    @FXML
    private Button deleteC;
    @FXML
    private TextField ide;
    @FXML
    private TextField FnameE;
    @FXML
    private TextField emailE;
    @FXML
    private TextField salaryE;
    @FXML
    private TextField phoneE;
    @FXML
    private Button pictureE;
    @FXML
    private TextField LnameE;
    @FXML
    private TextField passwordE;
    @FXML
    private TextField idD;
    @FXML
    private TextField FnameD;
    @FXML
    private TextField LnameD;
    @FXML
    private TextField emailD;
    @FXML
    private TextField passwordD;
    @FXML
    private Button pictureD;
    @FXML
    private TextField phoneD;
    @FXML
    private TextField salaryD;
    @FXML
    private TextField idM;
    @FXML
    private TextField phoneM;
    @FXML
    private Button pictureM;
    @FXML
    private TextField passwordM;
    @FXML
    private TextField FnameM;
    @FXML
    private TextField LnameM;
    @FXML
    private TextField emailM;
    @FXML
    private TextField salaryM;
    @FXML
    private TextField idT;
    @FXML
    private TextField emailT;
    @FXML
    private TextField LnameT;
    @FXML
    private TextField phoneT;
    @FXML
    private TextField FnameT;
    @FXML
    private Button pictureT;
    @FXML
    private TextField passwordT;
    @FXML
    private Button diploma;
    @FXML
    private Button addE;
    @FXML
    private Button addT;
    @FXML
    private Button updateD;
    @FXML
    private Button addD;
    @FXML
    private Button deleteD;
    @FXML
    private Button addM;
    @FXML
    private Button updateM;
    @FXML
    private Button deleteM;
    @FXML
    private Button deleteE;
    @FXML
    private Button updateE;
    @FXML
    private Button updateT;
    @FXML
    private Button deleteT;
    @FXML
    private TableColumn<gclient, String> colfname;
    @FXML
    private TableColumn<gclient, String> collname;
    @FXML
    private TableColumn<gclient, String> colemail;
    @FXML
    private TableColumn<gclient, String> coladr;
    @FXML
    private TableColumn<gclient, String> colpicture;
    @FXML
    private TableColumn<?, ?> colph;
    @FXML
    private TableView<gform> table1;
    @FXML
    private TableColumn<gform, String> colfname1;
    @FXML
    private TableColumn<gform, String> collname1;
    @FXML
    private TableColumn<gform, String> colemail1;
    @FXML
    private TableColumn<gform, Integer> colph1;
    @FXML
    private TableColumn<gform, String> colpicture1;
    @FXML
    private TableView<grespevent> table2;
    @FXML
    private TableColumn<grespevent, String> colfname2;
    @FXML
    private TableColumn<grespevent, String> collname2;
    @FXML
    private TableColumn<grespevent, String> colemail2;
    @FXML
    private TableColumn<grespevent, Integer> colph2;
    @FXML
    private TableColumn<grespevent, String> colpicture2;
    @FXML
    private TableView<grespmaint> table21;
    @FXML
    private TableColumn<grespmaint, String> colfname21;
    @FXML
    private TableColumn<grespmaint, String> collname21;
    @FXML
    private TableColumn<grespmaint, String> colemail21;
    @FXML
    private TableColumn<grespmaint, Integer> colph21;
    @FXML
    private TableColumn<grespmaint, String> colpicture21;
    @FXML
    private TableView<gdelivman> table22;
    @FXML
    private TableColumn<gdelivman, String> colfname22;
    @FXML
    private TableColumn<gdelivman, String> collname22;
    @FXML
    private TableColumn<gdelivman, String> colemail22;
    @FXML
    private TableColumn<gdelivman, Integer> colph22;
    @FXML
    private TableColumn<gdelivman, String> colpicture22;
    @FXML
    private TableColumn<gdelivman, Integer> colsalary22;
    @FXML
    private TableColumn<grespmaint, Integer> colsalary21;
    @FXML
    private TableColumn<grespevent, Integer> colsalary2;
    @FXML
    private TableColumn<gform, String> coldiploma;
    @FXML
    private AnchorPane image;
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

    
    @FXML
    private void ok(ActionEvent event) {
                     //iid = integer id
            String inputphone = phoneC.getText();        
            int iphone = Integer.parseInt(inputphone);      //iphone = integer phone
            
            
            String FirstN = FnameC.getText();
            String LastN = LnameC.getText();
            String emailc = emailC.getText();
            String pwd = passwordC.getText();
            String adr = addressC.getText();
            String pic = pictureC.getText();
            crudClient sp = new crudClient();
            gclient p = new gclient( FirstN, LastN, emailc, pwd, adr, iphone, pic);
             Pattern p2 = Pattern.compile("((?=.*[a-z])(?=.*[A-Z]).{6,15})");
        Matcher m2 = p2.matcher(passwordC.getText());
        if (m2.matches()) {
            
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le mot de passe \n il doit contenir au moins une lettre en minuscule, une en majuscule et de longeur entre 6 à 15 caractéres");
            alert.showAndWait();
           
        }
            
        if (idC.getText().isEmpty() | FnameC.getText().isEmpty() | emailC.getText().isEmpty() | phoneC.getText().isEmpty() | addressC.getText().isEmpty() | passwordC.getText().isEmpty() | pictureC.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("Il faut saisir dans tous les champs");
            alert.showAndWait();
           
        }    
        
        
            Pattern p1 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p1.matcher(emailC.getText());
        if (m.find() && m.group().equals(emailC.getText())) {
            
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le mail");
            alert.showAndWait();
            
        }
            
            sp.ajouterPersonne(p);
            
            
    }
    
    @FXML
    private void ok2(ActionEvent event) {
         String input1 = ide.getText();
            int iid1 = Integer.parseInt(input1);            //iid = integer id
            String inputphone = phoneE.getText();        
            int iphone1 = Integer.parseInt(inputphone);      //iphone = integer phone
            String inputSalaire = salaryE.getText();
            int isalaire = Integer.parseInt(inputSalaire);
            
            String FirstNE = FnameE.getText();
            String LastNE = LnameE.getText();
            String emailEv = emailE.getText();
            String pwdE = passwordE.getText();
            String picE = pictureE.getText();
            crudrespevent spe = new crudrespevent();
            grespevent pe = new grespevent(iid1, FirstNE, LastNE, emailEv, pwdE, iphone1,picE, isalaire);
            spe.ajouterPersonne(pe);
            
    }
    @FXML
    private void ok3(ActionEvent event) {
         String input3 = idM.getText();
            int iid3 = Integer.parseInt(input3);            //iid = integer id
            String inputphonee = phoneM.getText();        
            int iphone3 = Integer.parseInt(inputphonee);      //iphone = integer phone
            String inputSalaire3 = salaryM.getText();
            int isalaire3 = Integer.parseInt(inputSalaire3);
            
            String FirstNM = FnameM.getText();
            String LastNM = LnameM.getText();
            String emailEm = emailM.getText();
            String pwdM = passwordM.getText();
            String picM = pictureM.getText();
            crudrespmaint spe3 = new crudrespmaint();
            grespmaint pe3 = new grespmaint(iid3, FirstNM, LastNM, emailEm, pwdM, iphone3,picM, isalaire3);
            spe3.ajouterPersonne(pe3);
            
    }
    
    @FXML
    private void ok4(ActionEvent event) {
         String input4 = idD.getText();
            int iid4 = Integer.parseInt(input4);            //iid = integer id
            String inputphone4 = phoneD.getText();        
            int iphone4 = Integer.parseInt(inputphone4);      //iphone = integer phone
            String inputSalaire4 = salaryD.getText();
            int isalaire4 = Integer.parseInt(inputSalaire4);
            
            String FirstND = FnameD.getText();
            String LastND = LnameD.getText();
            String emailEd = emailD.getText();
            String pwdD = passwordD.getText();
            String picD = pictureD.getText();
            cruddelivman sped = new cruddelivman();
            gdelivman ped = new gdelivman(iid4, FirstND, LastND, emailEd, pwdD, iphone4,picD, isalaire4);
            sped.ajouterPersonne(ped);
            
    }


    @FXML
    private void ok5(ActionEvent event) {
         String input5 = idT.getText();
            int iid5 = Integer.parseInt(input5);            //iid = integer id
            String inputphone5 = phoneT.getText();        
            int iphone5 = Integer.parseInt(inputphone5);      //iphone = integer phone

            
            String FirstNT = FnameT.getText();
            String LastNT = LnameT.getText();
            String emailTr = emailT.getText();
            String pwdT = passwordT.getText();
            String picT = pictureT.getText();
            String Diplome = diploma.getText();
            crudform spf = new crudform();
            gform pef = new gform(iid5, FirstNT, LastNT, emailTr, pwdT, picT, iphone5, Diplome);
            spf.ajouterPersonne(pef);
            
    }

    @FXML
    private void modifT(ActionEvent event) {
         String input5 = idT.getText();
            int iid5 = Integer.parseInt(input5);            //iid = integer id
            String inputphone5 = phoneT.getText();        
            int iphone5 = Integer.parseInt(inputphone5);      //iphone = integer phone

            
            String FirstNT = FnameT.getText();
            String LastNT = LnameT.getText();
            String emailTr = emailT.getText();
            String pwdT = passwordT.getText();
            String picT = pictureT.getText();
            String Diplome = diploma.getText();
            crudform spf = new crudform();
            gform pef = new gform(iid5, FirstNT, LastNT, emailTr, pwdT, picT, iphone5, Diplome);
            spf.modifierPersonne(iid5,pef);
            
    }    
    
   @FXML
    private void modifD(ActionEvent event) {
         String input8 = idD.getText();
            int iid8 = Integer.parseInt(input8);            //iid = integer id
            String inputphone8 = phoneD.getText();        
            int iphone8 = Integer.parseInt(inputphone8);      //iphone = integer phone
            String inputSalaire8 = salaryD.getText();
            int isalaire8 = Integer.parseInt(inputSalaire8);
            
            String FirstND = FnameD.getText();
            String LastND = LnameD.getText();
            String emailEd = emailD.getText();
            String pwdD = passwordD.getText();
            String picD = pictureD.getText();
            cruddelivman sped = new cruddelivman();
            gdelivman ped = new gdelivman(iid8, FirstND, LastND, emailEd, pwdD, iphone8,picD, isalaire8);
            sped.modifierPersonne(iid8, ped);
            
    }

    @FXML
    private void ModifM(ActionEvent event) {
         String input3 = idM.getText();
            int iid3 = Integer.parseInt(input3);            //iid = integer id
            String inputphonee = phoneM.getText();        
            int iphone3 = Integer.parseInt(inputphonee);      //iphone = integer phone
            String inputSalaire3 = salaryM.getText();
            int isalaire3 = Integer.parseInt(inputSalaire3);
            
            String FirstNM = FnameM.getText();
            String LastNM = LnameM.getText();
            String emailEm = emailM.getText();
            String pwdM = passwordM.getText();
            String picM = pictureM.getText();
            crudrespmaint spe3 = new crudrespmaint();
            grespmaint pe3 = new grespmaint(iid3, FirstNM, LastNM, emailEm, pwdM, iphone3,picM, isalaire3);
            spe3.modifierPersonne(iid3, pe3);
            
    }

    @FXML
    private void modifE(ActionEvent event) {
         String input1 = ide.getText();
            int iid1 = Integer.parseInt(input1);            //iid = integer id
            String inputphone = phoneE.getText();        
            int iphone1 = Integer.parseInt(inputphone);      //iphone = integer phone
            String inputSalaire = salaryE.getText();
            int isalaire = Integer.parseInt(inputSalaire);
            
            String FirstNE = FnameE.getText();
            String LastNE = LnameE.getText();
            String emailEv = emailE.getText();
            String pwdE = passwordE.getText();
            String picE = pictureE.getText();
            crudrespevent spe = new crudrespevent();
            grespevent pe = new grespevent(iid1, FirstNE, LastNE, emailEv, pwdE, iphone1,picE, isalaire);
            spe.modifierPersonne(iid1, pe);
            
    }

    @FXML
    private void modifC(ActionEvent event) {
         String input = idC.getText();
            int iid = Integer.parseInt(input);            //iid = integer id
            String inputphone = phoneC.getText();        
            int iphone = Integer.parseInt(inputphone);      //iphone = integer phone
            
            
            String FirstN = FnameC.getText();
            String LastN = LnameC.getText();
            String emailc = emailC.getText();
            String pwd = passwordC.getText();
            String adr = addressC.getText();
            String pic = pictureC.getText();
            crudClient sp = new crudClient();
            gclient p = new gclient(iid, FirstN, LastN, emailc, pwd, adr, iphone, pic);
            sp.modifierPersonne(iid, p);
          
    } 
    
   
    
    
    
   @FXML
    private void deletbtn(ActionEvent event) {
         ObservableList<gclient> selectedRows, allPeople;
        allPeople = table.getItems();
        selectedRows = table.getSelectionModel().getSelectedItems();
       gclient gc = table.getSelectionModel().getSelectedItem();
       crudClient cc= new crudClient();
       cc.supprimerPersonne(gc);
    }

    private void Logout(ActionEvent event){
         Stage primaryStage = new Stage();
         Parent root;
         try {
             root = FXMLLoader
                     .load(getClass().getResource("LOGINFXML.fxml"));
             
             Scene scene = new Scene(root);
             primaryStage.close();
             
             
            
            primaryStage.setScene(scene);
            primaryStage.show();
                

         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }
     }
    
       
    ObservableList<gclient> data = FXCollections.observableArrayList();
    ObservableList<gform> data1 = FXCollections.observableArrayList();
    ObservableList<grespevent> data2 = FXCollections.observableArrayList();
    ObservableList<grespmaint> data3 = FXCollections.observableArrayList();
    ObservableList<gdelivman> data4 = FXCollections.observableArrayList();
    crudClient ss = new crudClient();
    crudform sf = new crudform();
    crudrespevent se = new crudrespevent();
    crudrespmaint sm = new crudrespmaint();
    cruddelivman sd = new cruddelivman();
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
      data.addAll(ss.getAll());
    //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    colfname.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    collname.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
    //colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
    coladr.setCellValueFactory(new PropertyValueFactory<>("address"));
    colph.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colpicture.setCellValueFactory(new PropertyValueFactory<>("picture"));
    
    table.setItems(data);    
    
      data4.addAll(sd.getAll());
    //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    colfname22.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    collname22.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    colemail22.setCellValueFactory(new PropertyValueFactory<>("email"));
    //colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
   // coladr.setCellValueFactory(new PropertyValueFactory<>("address"));
    colph22.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colpicture22.setCellValueFactory(new PropertyValueFactory<>("picture"));
    colsalary22.setCellValueFactory(new PropertyValueFactory<>("salary"));
    
    //`iddeliv`, `Fname`, `Lname`, `email`, `password`, `phone`, `picture`, `salary`
    table22.setItems(data4); 
    
        
    data3.addAll(sm.getAll());
    //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    colfname21.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    collname21.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    colemail21.setCellValueFactory(new PropertyValueFactory<>("email"));
    //colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
   // coladr.setCellValueFactory(new PropertyValueFactory<>("address"));
    colph21.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colpicture21.setCellValueFactory(new PropertyValueFactory<>("picture"));
    colsalary21.setCellValueFactory(new PropertyValueFactory<>("salary"));
    
    //`iddeliv`, `Fname`, `Lname`, `email`, `password`, `phone`, `picture`, `salary`
    table21.setItems(data3); 
    
    
    
        
    data2.addAll(se.getAll());
    //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    colfname2.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    collname2.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    colemail2.setCellValueFactory(new PropertyValueFactory<>("email"));
    //colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
   // coladr.setCellValueFactory(new PropertyValueFactory<>("address"));
    colph2.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colpicture2.setCellValueFactory(new PropertyValueFactory<>("picture"));
    colsalary2.setCellValueFactory(new PropertyValueFactory<>("salary"));
    
    //`iddeliv`, `Fname`, `Lname`, `email`, `password`, `phone`, `picture`, `salary`
    table2.setItems(data2); 
    
   data1.addAll(sf.getAll());
    //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    colfname1.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    collname1.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    colemail1.setCellValueFactory(new PropertyValueFactory<>("email"));
    //colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
   // coladr.setCellValueFactory(new PropertyValueFactory<>("address"));
    colph1.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colpicture1.setCellValueFactory(new PropertyValueFactory<>("picture"));
    coldiploma.setCellValueFactory(new PropertyValueFactory<>("diploma"));
    //`iddeliv`, `Fname`, `Lname`, `email`, `password`, `phone`, `picture`, `salary`
    table1.setItems(data1); 
    
    
    }
  /*  @FXML
     private void Rechercher() {
        Rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ServiceEvent sn = new ServiceEvent();
                ObservableList obeListe = FXCollections.observableList(sn.RA(newValue));
                table.setItems(obeListe);
            } catch (SQLException ex) {
                Logger.getLogger(AdminEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    } */

    @FXML
    private void deletbtnD(ActionEvent event) {
        ObservableList<gdelivman> selectedRows, allPeople;
        allPeople = table22.getItems();
        selectedRows = table22.getSelectionModel().getSelectedItems();
       gdelivman gc = table22.getSelectionModel().getSelectedItem();
       cruddelivman cc= new cruddelivman();
       cc.supprimerPersonne(gc);
    }

    @FXML
    private void deletbtnM(ActionEvent event) {
        ObservableList<grespmaint> selectedRows, allPeople;
        allPeople = table21.getItems();
        selectedRows = table21.getSelectionModel().getSelectedItems();
       grespmaint gc = table21.getSelectionModel().getSelectedItem();
       crudrespmaint cc = new crudrespmaint();
       cc.supprimerPersonne(gc);
    }

    
     @FXML
    private void upload_1(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            diploma.setText(f.toString());
        }
    }
    
    
     @FXML
    private void upload_2(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            pictureT.setText(f.toString());
        }
    }
    
    
    
    
    
    
    @FXML
    private void deletbtnE(ActionEvent event) {
          ObservableList<grespevent> selectedRows, allPeople;
        allPeople = table2.getItems();
        selectedRows = table2.getSelectionModel().getSelectedItems();
       grespevent gc = table2.getSelectionModel().getSelectedItem();
       crudrespevent cc = new crudrespevent();
       cc.supprimerPersonne(gc);
    }

    @FXML
    private void deletbtnT(ActionEvent event) {
         ObservableList<gform> selectedRows, allPeople;
        allPeople = table1.getItems();
        selectedRows = table1.getSelectionModel().getSelectedItems();
       gform gc = table1.getSelectionModel().getSelectedItem();
       crudform cc = new crudform();
       cc.supprimerPersonne(gc);
       
      // afficher();
        
    }

  
    private void afficher(){
           data1.addAll(sf.getAll());
    //colid.setCellValueFactory(new PropertyValueFactory<>("id"));
    colfname1.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    collname1.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    colemail1.setCellValueFactory(new PropertyValueFactory<>("email"));
    //colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
   // coladr.setCellValueFactory(new PropertyValueFactory<>("address"));
    colph1.setCellValueFactory(new PropertyValueFactory<>("phone"));
    colpicture1.setCellValueFactory(new PropertyValueFactory<>("picture"));
    coldiploma.setCellValueFactory(new PropertyValueFactory<>("diploma"));
    //`iddeliv`, `Fname`, `Lname`, `email`, `password`, `phone`, `picture`, `salary`
    table1.setItems(data1); 
    }

    @FXML
    private void upload_3(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            pictureC.setText(f.toString());
        }
    }

    @FXML
    private void upload_D(ActionEvent event) {
     FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            pictureD.setText(f.toString());
        }
    }

    @FXML
    private void upload_M(ActionEvent event) {
    FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            pictureM.setText(f.toString());
        }
    }

    @FXML
    private void upload_E(ActionEvent event) {
    FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            pictureE.setText(f.toString());
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
