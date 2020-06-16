package View;
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
public class AVClientHomeScreenController implements Initializable {

    @FXML
    private StackPane stackepane;
    @FXML
    private Pane pane_logout;
    @FXML
    private Pane pane_repair;
    @FXML
    private Pane pane_delivery;
    @FXML
    private Pane pane_mailer;
    @FXML
    private Pane pane_appointement;
    @FXML
    private Pane pane_reclamation;
    @FXML
    private Pane pane_exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
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
    @FXML
    private void mouse_exit_repair(MouseEvent event) {
    pane_repair.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
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

    @FXML
    private void Appointement(MouseEvent event) throws IOException {
        Stage Appoint = new Stage();
        Parent root = null;

        root = FXMLLoader.load(getClass().getResource("AVClientAppointement.fxml"));
        Stage current = (Stage)pane_appointement.getScene().getWindow();
        Scene scene = new Scene(root);
        Appoint.setScene(scene);
        Appoint.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        Appoint.show();
    }

    @FXML
    private void Reclamation(MouseEvent event) throws IOException {
        Stage reclam = new Stage();
        Parent root = null;

        root = FXMLLoader.load(getClass().getResource("AVReclamationClient.fxml"));
        Stage current = (Stage)pane_repair.getScene().getWindow();
        Scene scene = new Scene(root);
        reclam.setScene(scene);
        reclam.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        reclam.show();
    }

    @FXML
    private void Repair(MouseEvent event) throws IOException {
    
        Stage Repair = new Stage();
        Parent root = null;

        root = FXMLLoader.load(getClass().getResource("AVrepairClient.fxml"));
        Stage current = (Stage)pane_repair.getScene().getWindow();
        Scene scene = new Scene(root);
        Repair.setScene(scene);
        Repair.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        Repair.show();
        
    }

    @FXML
    private void Delivery(MouseEvent event) {
    
    }

    
    @FXML
    private void Mailer(MouseEvent event) throws IOException {
        
    Stage mail = new Stage();
    Parent root = null;
        
     root = FXMLLoader.load(getClass().getResource("AVMailer.fxml"));
     Stage current = (Stage)pane_repair.getScene().getWindow();
     Scene scene = new Scene(root);
     mail.setScene(scene);
     mail.initStyle(StageStyle.TRANSPARENT);
     current.hide();
     mail.show();
 }
   
    
}
