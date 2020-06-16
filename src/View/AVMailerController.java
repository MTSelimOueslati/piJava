package View;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;



public class AVMailerController implements Initializable {

    @FXML
    private JFXTextField mail_description;
    @FXML
    private JFXTextField mailaddress;
    @FXML
    private JFXPasswordField mailpassword;
    @FXML
    private JFXTextField mail_subject;
    @FXML
    private Pane pane_exit;
    @FXML
    private StackPane stackepane;
    @FXML
    private Pane pane_logout1;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
    }    

    @FXML
    private void SendMail(MouseEvent event) {
                
        if(mailaddress.getText().toString().equals("")){
       
            Image image = new Image("/imgVelo/error.gif");
            Notifications notification = Notifications.create()
                    .title("Email Address is Empty")
                    .text("Please Enter Your Email Address !")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.darkStyle();
            notification.show();
        }else if(mailpassword.getText().toString().equals("")){
       
            Image image = new Image("/imgVelo/error.gif");
            Notifications notification = Notifications.create()
                    .title("Password is Empty")
                    .text("Please Enter Your Email Password ! ")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.darkStyle();
            notification.show();
        }else if(!mailpassword.getText().toString().equals("") & !mailaddress.getText().toString().equals("")
                & !mail_subject.getText().toString().equals("") & !mail_description.getText().toString().equals("")){
        
        try {
            String host=mailaddress.getText();  //← my email address
            final String user=mailaddress.getText();//← my email address
            final String password=mailpassword.getText();  //← my email-password
            
            String to="mohamedamine.bentaieb@esprit.tn";//→ the EMAIL i want to send TO → TO ADMIN
            
            // session object
            Properties props = new Properties();
            props.put("mail.smtp.ssl.trust", "*");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user,password);
                        }
                    });
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Subject : " + mail_subject.getText());
            message.setText(" Contacting Administration : ");
            //Html code in email :
            message.setContent(
                    "<h1 style =\"color:red\" > " + mail_description.getText() + "  </h1>","text/html");

            //send the message
            Transport.send(message);

           // System.out.println("message sent successfully via mail ... !!! ");
            Image image = new Image("/imgVelo/sent.png");
            Notifications notification = Notifications.create()
                    .title("Sent Successfully")
                    .text("Email Sent Successfully to Administration !")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.darkStyle();
            notification.show();
            
        } catch (MessagingException ex) {
            Logger.getLogger(AVMailerController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }else{  Image image = new Image("/imgVelo/error.gif");
            Notifications notification = Notifications.create()
                    .title("Error")
                    .text("Please Check Your TextFields ")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.darkStyle();
            notification.show();}
    }

    //Mouse hover actions ma9loubin :) 
    @FXML
    private void mouse_exit_mail(MouseEvent event) {
    pane_exit.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_mail(MouseEvent event) {
    pane_exit.setStyle("-fx-background-color: #ff3b3b; -fx-background-radius: 6px;");
    }

    @FXML
    private void MailExit(MouseEvent event) {
        Stage current = (Stage)pane_exit.getScene().getWindow();        
            current.hide();
            
            }

    @FXML
    private void mouse_exit_logout(MouseEvent event) {
    pane_logout1.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    
    }

    @FXML
    private void mouse_hover_logout(MouseEvent event) {
    pane_logout1.setStyle("-fx-background-color: #ff3b3b; -fx-background-radius: 6px;");
    
    }

    @FXML
    private void MailLogout(MouseEvent event) {
              JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Alret"));
        dialogLayout.setBody(new Text("Do you want to Logout ?"));
        JFXButton ok = new JFXButton("Yes");
        JFXButton Cancel = new JFXButton("Cancel");
        
        JFXDialog dialog = new JFXDialog(stackepane,dialogLayout,JFXDialog.DialogTransition.CENTER);
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            // move you back to loginscreen
        Stage login = new Stage();
        Parent root = null;
        try{
        root = FXMLLoader.load(getClass().getResource("LOGINFXML.fxml"));
        }catch(IOException e) {e.printStackTrace();}   
        
        Stage current = (Stage)pane_logout1.getScene().getWindow();
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        login.show(); 
            
            }
        });
       
        Cancel.setOnAction(new EventHandler<ActionEvent>(){
           @Override
            public void handle(ActionEvent event) {
              
            dialog.close();
            }
        });
        dialogLayout.setActions(ok,Cancel);
        dialog.show();  
    
    }
        }
    
 