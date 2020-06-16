/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author taieb
 */
public class LOGINFXMLController implements Initializable {

    @FXML
    private Button signin;
    @FXML
    private Button insc;
    @FXML
    private Button forgpwd;
    @FXML
    private TextField id;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void Login(ActionEvent event) throws Exception{
        
     if (id.getText().equals("admin")&& password.getText().equals("admin")){
         
         Stage primaryStage = new Stage();
         Parent root = FXMLLoader
        .load(getClass().getResource("AdminDash.fxml"));
            
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Home Page");
            primaryStage.setScene(scene);
            primaryStage.show();
     }else if(id.getText().equals("client")&& password.getText().equals("client")){
    
         Stage primaryStage = new Stage();
         Parent root = FXMLLoader
        .load(getClass().getResource("ClientPage.fxml"));
            
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Acceuil");
            primaryStage.setScene(scene);
            primaryStage.show();
     }else{
      
               Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Login");
              alert.setContentText("Login failed");
              alert.showAndWait();
     }
     }
    
    @FXML
    private void SignUp(ActionEvent event){
   
         Stage primaryStage = new Stage();
         Parent root;
         try {
             root = FXMLLoader.load(getClass().getResource("INSCFXML.fxml"));
             Scene scene = new Scene(root);
            
            primaryStage.setTitle("Sign Up Page");
            primaryStage.setScene(scene);
            primaryStage.show();
         } catch (IOException ex) {
             Logger.getLogger(LOGINFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
     
     }
    @FXML
    private void send_mail(ActionEvent event)
    {
        String host="smtp.gmail.com";  
  final String user="mohamedtaiebselim.oueslati@esprit.tn";//change accordingly  
  final String password="193JMT1089";//change accordingly  
    
  String to="mohamedtaieb.oueslati@gmail.com";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true"); 
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Pi_dev");  
     message.setText("test de l'api mail");  
       MimeMultipart multipart = new MimeMultipart("related");

         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "Reset Password";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);

         // second part (the image)
         messageBodyPart = new MimeBodyPart();
         DataSource fds = new FileDataSource(
            "D:/QRCODE/ahmed.png");

         messageBodyPart.setDataHandler(new DataHandler(fds));
         messageBodyPart.setHeader("Content-ID", "<image>");

         // add image to the multipart
         multipart.addBodyPart(messageBodyPart);

         // put everything together
         message.setContent(multipart);
    //send the message  
    
    
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    
    
}
