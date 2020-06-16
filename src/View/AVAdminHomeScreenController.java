package View;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AVAdminHomeScreenController implements Initializable {

    @FXML
    private StackPane stackepane;
    private Pane pane_repair;
    @FXML
    private Pane pane_delivery;
    @FXML
    private Pane pane_appointement;
    @FXML
    private Pane pane_logout;
    @FXML
    private Pane pane_exit;
    @FXML
    private Pane pane_reclamation;
    @FXML
    private Pane pane_mailer;
    @FXML
    private JFXHamburger berger;
    @FXML
    private JFXDrawer bergerdrawer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
    }
     

//******************************* Other buttons **********************************/ 
   
    @FXML
    private void Reclamation(MouseEvent event) throws IOException {
    Stage rec = new Stage();
        Parent root = null;
        
        root = FXMLLoader.load(getClass().getResource("Reclamation_1.fxml"));
        Stage current = (Stage)pane_reclamation.getScene().getWindow();
        Scene scene = new Scene(root);
        rec.setScene(scene);
        rec.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        rec.show();
    }
    
    @FXML
    private void Appointement(MouseEvent event) throws IOException {
        Stage App = new Stage();
        Parent root = null;
        
        root = FXMLLoader.load(getClass().getResource("AVAdminAppointement.fxml"));
        Stage current = (Stage)pane_appointement.getScene().getWindow();
        Scene scene = new Scene(root);
        App.setScene(scene);
        App.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        App.show();
    }


    @FXML
    private void Delivery(MouseEvent event) throws IOException {
        Stage del = new Stage();
        Parent root = null;
        
        root = FXMLLoader.load(getClass().getResource("AVDeliveryAdmin.fxml"));
        Stage current = (Stage)pane_delivery.getScene().getWindow();
        Scene scene = new Scene(root);
        del.setScene(scene);
        del.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        del.show();
    
    }

    @FXML
    private void Mailer(MouseEvent event) throws IOException {
        Stage mail = new Stage();
        Parent root = null;
        
        root = FXMLLoader.load(getClass().getResource("AVMailer.fxml"));
        Stage current = (Stage)pane_mailer.getScene().getWindow();
        Scene scene = new Scene(root);
        mail.setScene(scene);
        mail.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        mail.show();
    
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
        root = FXMLLoader.load(getClass().getResource("LOGINFXML.fxml"));
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
                        
    //******************************* Mouse Hover  +  Mouse Exit **********************************/ 
    private void mouse_exit_repair(MouseEvent event) {
    pane_repair.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
   
    }

    private void mouse_hover_repair(MouseEvent event) {
    pane_repair.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
   
    }
    @FXML
    private void mouse_exit_delivery(MouseEvent event) {
    pane_delivery.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_delivery(MouseEvent event) {
    pane_delivery.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
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
    private void mouse_exit_appointement(MouseEvent event) {
    pane_appointement.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");    
    }

    @FXML
    private void mouse_hover_appointement(MouseEvent event) {
    pane_appointement.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

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
    private void mouse_exit_reclamation(MouseEvent event) {
    pane_reclamation.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_reclamation(MouseEvent event) {
    pane_reclamation.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }
    
}
