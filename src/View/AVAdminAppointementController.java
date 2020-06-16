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

public class AVAdminAppointementController implements Initializable {

    @FXML
    private JFXTreeTableView<Appointement> treeView;
    @FXML
    private JFXTextField idappointement;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField description;
    

    /************ CONNENCTION *******/
    
    
    @FXML
    private StackPane stackepane;
    @FXML
    private Pane pane_logout;
    @FXML
    private Pane pane_exit;
    @FXML
    private Pane pane_home;
    @FXML
    private JFXCheckBox confirmedChecked;
    @FXML
    private JFXCheckBox deniedChecked;
    @FXML
    private JFXCheckBox pendingChecked;
    @FXML
    private JFXButton AjouterButton;
    @FXML
    private JFXButton DeleteButton;
    @FXML
    private JFXButton UpdateButton;
    
    
      private  Connection con=ConnexionBD.getinstance().getcnx();

      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
// con = DataBase.getInstance().getConnection();
        loadAllAppointement("SELECT * FROM appointement");
    }    
    
      public void loadAllAppointement(String sql){
    
        JFXTreeTableColumn<Appointement,String> idappointement = new JFXTreeTableColumn<>("Appointement Id");
        idappointement.setPrefWidth(70);
        idappointement.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointement, String> param) {
                return param.getValue().getValue().idappointement;
            }
        });
        
         JFXTreeTableColumn<Appointement,String> date = new JFXTreeTableColumn<>("Appointement Date");
        date.setPrefWidth(200);
        date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointement, String> param) {
                return param.getValue().getValue().date;
            }
        });
        
         JFXTreeTableColumn<Appointement,String> description = new JFXTreeTableColumn<>("Appointement Description");
        description.setPrefWidth(420);
        description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointement, String> param) {
                return param.getValue().getValue().description;
            }
        });
             
        JFXTreeTableColumn<Appointement,String> state = new JFXTreeTableColumn<>("Appointement State");
        state.setPrefWidth(160);
        state.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Appointement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Appointement, String> param) {
                return param.getValue().getValue().state;
            }
        });

                     ObservableList<Appointement> appointements =FXCollections.observableArrayList();
        try {
          PreparedStatement ps;
            ps = con.prepareStatement(sql);
           
              
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            appointements.add(new Appointement(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(AVAdminAppointementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final TreeItem<Appointement> root = new RecursiveTreeItem <Appointement>(appointements,RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(idappointement,date,description,state);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        
    }
      
    @FXML
    private void ajouterButton(ActionEvent event) {
        ControleSaisie();
        String query = "insert into appointement values(?, ?, ?, ?)";
    
           try {
             
               PreparedStatement pre = (PreparedStatement) con.prepareStatement(query);
           
                pre.setString(1, idappointement.getText());
                pre.setString(2, date.getText().toString());
                pre.setString(3, description.getText().toString());
                 pre.setString(4, "Pending");
                
                
               // pre.setRowId(1, idappointement.getText());
              
                pre.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(AVAdminAppointementController.class.getName()).log(Level.SEVERE, null, ex);
           }
              loadAllAppointement("SELECT * FROM appointement");
     }

    @FXML
    private void deleteButton(ActionEvent event) {
    ControleSaisie();
        String deletequery = "DELETE FROM `it-vision`.`appointement` where idappointement = ?";

        try {
            //PreparedStatement  = con.prepareStatement(deletequery);
             //PreparedStatement  = (PreparedStatement) con.getcnx().prepareCall(deletequery);
              PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(deletequery);
              
            preparedStatement.setString(1, idappointement.getText());
            preparedStatement.execute();
            preparedStatement.close();
            loadAllAppointement("SELECT * FROM appointement");
           
        } catch (SQLException e) { e.printStackTrace(); }
        
    }

    @FXML
    private void updateButton(ActionEvent event) {
     ControleSaisie();
     String query = "UPDATE `it-vision`.`appointement` SET date = ?, description = ?" 
                + " where idappointement = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
          
            preparedStatement.setString(1, date.getText());
            preparedStatement.setString(2, description.getText());
            preparedStatement.setString(3, idappointement.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllAppointement("SELECT * FROM appointement");
            }catch(SQLException e){e.printStackTrace();}
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
        root = FXMLLoader.load(getClass().getResource("AdminDash.fxml"));
        Stage current = (Stage)pane_home.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }
   
    
    
public void ControleSaisie(){
if(idappointement.getText().toString().equals("")){
          Image image = new Image("/imgVelo/error.gif");
            Notifications notification = Notifications.create()
                    .title("Error")
                    .text("Please Select an id")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_RIGHT)
                    .graphic(new ImageView(image));
            notification.darkStyle();
            notification.show();
        }
}
    
    @FXML
    private void ConfirmedAppointemet(ActionEvent event) {
    
        ControleSaisie();
        deniedChecked.setSelected(false);
        pendingChecked.setSelected(false);
         String query = "UPDATE `it-vision`.`appointement` SET state = \"Confirmed\"" 
                + " where idappointement = ? ";

        try {

           PreparedStatement preparedStatement = con.prepareStatement(query);
             
           
            preparedStatement.setString(1, idappointement.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllAppointement("SELECT * FROM appointement");
            }catch(SQLException e){e.printStackTrace();}
    
        
            
    }


    @FXML
    private void DeniedAppointement(ActionEvent event) {
        ControleSaisie();
        confirmedChecked.setSelected(false);
        pendingChecked.setSelected(false);
        
        String query = "UPDATE `it-vision`.`appointement` SET state = \"Denied\"" 
                + " where idappointement = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            
           
            preparedStatement.setString(1, idappointement.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllAppointement("SELECT * FROM appointement");
            }catch(SQLException e){e.printStackTrace();}
        
    }

    @FXML
    private void PendingAppointement(MouseEvent event) {
        ControleSaisie();
        deniedChecked.setSelected(false);
        confirmedChecked.setSelected(false);
        
                String query = "UPDATE `it-vision`.`appointement` SET state = \"Pending\"" 
                + " where idappointement = ? ";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            
           
            preparedStatement.setString(1, idappointement.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllAppointement("SELECT * FROM appointement");
            }catch(SQLException e){e.printStackTrace();}
        
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


    
}
  