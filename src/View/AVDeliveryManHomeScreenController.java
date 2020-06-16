package View;

import Entities.Delivery;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author medam
 */
public class AVDeliveryManHomeScreenController implements Initializable {

    @FXML
    private Pane pane_logout;
    @FXML
    private Pane pane_exit;
    @FXML
    private Pane pane_delivery;
    @FXML
    private Pane pane_mailer;
    @FXML
    private StackPane stackepane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    

    
    @FXML
    private void Mailer(MouseEvent event) {
    }
    
    
  



    @FXML
    private void Delivery(MouseEvent event) {
    }

   //******************************* Logout  +   Exit **********************************/ 
     
    @FXML
    private void logout(MouseEvent event) {
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
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        }catch(IOException e) {e.printStackTrace();}   
        
        Stage current = (Stage)pane_logout.getScene().getWindow();
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

    @FXML
    private void exit(MouseEvent event) {
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you want to exit ?"));
        JFXButton ok = new JFXButton("Yes");
        JFXButton Cancel = new JFXButton("Cancel");
        
        JFXDialog dialog = new JFXDialog(stackepane,dialogLayout,JFXDialog.DialogTransition.CENTER);
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            System.exit(0);  
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
    
     //******************************* Hover and Exit **********************************/ 
  
    @FXML
    private void mouse_exit_logout(MouseEvent event) {
    
    pane_logout.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_logout(MouseEvent event) {
        
    pane_logout.setStyle("-fx-background-color: #ff3b3b; -fx-background-radius: 6px;");
    }
    
    @FXML
    private void mouse_exit_exit(MouseEvent event) {
    
    pane_exit.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_exit(MouseEvent event) {
   
    pane_exit.setStyle("-fx-background-color: #ff3b3b; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_mailer(MouseEvent event) {
    pane_mailer.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_mailer(MouseEvent event) {
    pane_mailer.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }
    @FXML
    private void mouse_exit_delivery(MouseEvent event) {
    
    pane_delivery.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_delivery(MouseEvent event) {
   pane_delivery.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }
 
    
}
