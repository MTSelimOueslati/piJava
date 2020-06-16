/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import Entities.gclient;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import Services.crudClient;

/**
 * FXML Controller class
 *
 * @author taieb
 */
public class INSCFXMLController implements Initializable {

    @FXML
    private TextField FnameC;
    @FXML
    private Button pictureC;
    @FXML
    private TextField PhoneC;
    @FXML
    private TextField LnameC;
    @FXML
    private TextField AddressC;
    @FXML
    private TextField emailC;
    @FXML
    private TextField passwordC;
    @FXML
    private Button ok;
    @FXML
    private AnchorPane image;

    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    @FXML
    private void upload_1(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            pictureC.setText(f.toString());
        }
    }
      

    
    
    
    @FXML
    private void ok(ActionEvent event) {
//         String input = id.getText();
         //   int iid = Integer.parseInt(input);            //iid = integer id
            String inputphone = PhoneC.getText();        
            int iphone = Integer.parseInt(inputphone);      //iphone = integer phone
            
            
            String FirstN = FnameC.getText();
            String LastN = LnameC.getText();
            String emailc = emailC.getText();
            String pwd = passwordC.getText();
            String adr = AddressC.getText();
            String pic = pictureC.getText();
            crudClient sp = new crudClient();
            gclient p = new gclient( FirstN, LastN, emailc, pwd, adr, iphone, pic);
            
             Pattern p2 = Pattern.compile("((?=.*[a-z])(?=.*[A-Z]).{6,15})");
        Matcher m2 = p2.matcher(passwordC.getText());
        if (m2.matches()) {
            
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validaiton");
            alert.setHeaderText(null);
            alert.setContentText("Verify Password \n it must contain at least one lower case letter , one upper case letter and it must be between 6 to 15 letters");
            alert.showAndWait();
           
        }
            
        if (FnameC.getText().isEmpty() | emailC.getText().isEmpty() | PhoneC.getText().isEmpty() | AddressC.getText().isEmpty() | passwordC.getText().isEmpty() | pictureC.getText().isEmpty() ) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validation");
            alert.setHeaderText(null);
            alert.setContentText("All fields must not be null");
            alert.showAndWait();
           
        }    
        
        
            Pattern p1 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p1.matcher(emailC.getText());
        if (m.find() && m.group().equals(emailC.getText())) {
            
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validation");
            alert.setHeaderText(null);
            alert.setContentText("Verify your email");
            alert.showAndWait();
            
        }
            sp.ajouterPersonne(p);
            
            
    }
    
}
