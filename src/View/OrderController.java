/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Bill;
import Entities.Order;
import Services.ServiceOrder;
import Utils.mailing;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class OrderController implements Initializable {

    @FXML
    private Button confirm;
    @FXML
    private TextField name;
    @FXML
    private TextField Ln;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
public static Bill b=new Bill();
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
private void confirm(ActionEvent event) throws MessagingException{
String input = number.getText ();
int nb = Integer.parseInt(input);

String Nom= name.getText();
String Lname=Ln.getText();
String mail=email.getText();
b.setName(Nom);
b.setLast_Name(Lname);
        System.out.println("confirm");
        Parent root;
        try{
        root= FXMLLoader.load(getClass().getResource("/View/Bill.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        }
        
        catch (IOException Ex)
        {Ex.printStackTrace();}
        
    



ServiceOrder sr = new ServiceOrder();
Order o = new Order(90,Nom,Lname,mail,nb,22,"20/02/2020");
//sr.ajouterOrder(o);
//sr.supprimerOrder(43);

//mailing.sendMail("ines.jeddey@esprit.tn");


}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
