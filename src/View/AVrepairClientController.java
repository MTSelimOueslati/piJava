package View;

import Entities.Appointement;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author medam
 */
public class AVrepairClientController implements Initializable {

   // private Connection conn;
    @FXML
    private StackPane stackepane;

    @FXML
    private JFXTreeTableView<Appointement> treeView1;

    @FXML
    private Pane pane_logout;

    @FXML
    private Pane pane_exit;

    @FXML
    private Pane pane_home;

    @FXML
    private JFXButton CreatePdf;
    /**
     * Initializes the controller class.
     */
private Connection con6=ConnexionBD.getinstance().getcnx();


   // @Override
    public void initialize(URL url, ResourceBundle rb) {
    //  conn = DataBase.getInstance().getConnection();
        loadAllRepair("SELECT * FROM appointement WHERE state=\"Confirmed\"");    
        
    }    
    
    public void loadAllRepair(String sql){

         JFXTreeTableColumn<Appointement,String> date = new JFXTreeTableColumn<>("Repair Date");
        date.setPrefWidth(200);
        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointement, String> param) {
                return param.getValue().getValue().date;
            }
        });
        
         JFXTreeTableColumn<Appointement,String> description = new JFXTreeTableColumn<>("Repair Description");
        description.setPrefWidth(420);
        description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointement, String> param) {
                return param.getValue().getValue().description;
            }
        });
        
                     ObservableList<Appointement> appointements =FXCollections.observableArrayList();
        try {
            PreparedStatement ps = (PreparedStatement) con6.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            appointements.add(new Appointement(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(AVAdminAppointementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final TreeItem<Appointement> root = new RecursiveTreeItem <Appointement>(appointements,RecursiveTreeObject::getChildren);
        treeView1.getColumns().setAll(date,description);
        treeView1.setRoot(root);
        treeView1.setShowRoot(false);
        
    
        
    }
    
    
    @FXML
    void CreatePdf(ActionEvent event) {
        
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
    private void mouse_exit_homep(MouseEvent event) {
    pane_home.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_homep(MouseEvent event) {
    pane_home.setStyle("-fx-background-color: #56ff4a; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_logout(MouseEvent event) {
    pane_logout.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
   }

    @FXML
    private void mouse_hover_logout(MouseEvent event) {
    pane_logout.setStyle("-fx-background-color: #58fffc; -fx-background-radius: 6px;");
   }
    
    @FXML
    private void homepage(MouseEvent event) throws IOException {
        Stage home = new Stage();
        Parent root = null;
       // root = FXMLLoader.load(getClass().getResource("LOGINFXML.fxml"));
        Stage current = (Stage)pane_home.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }
    
    @FXML
    private void exit(MouseEvent event) {
      JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you want to exit !"));
        JFXButton ok = new JFXButton("ok");
        JFXButton Cancel = new JFXButton("cancel");
       
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

 


}


