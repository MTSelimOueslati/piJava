package View;

import Entities.Delivery;
import Utils.ConnexionBD;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class AVDeliveryAdminController implements Initializable {
     private Connection con;
    @FXML
    private JFXTreeTableView<Delivery> treeView;

    private JFXTextField idappointement;

    @FXML
    private JFXTextField idclient;

    @FXML
    private JFXTextField idbike;

    @FXML
    private JFXButton AjouterButton;

    @FXML
    private JFXButton DeleteButton;

    @FXML
    private JFXButton UpdateButton;

    @FXML
    private JFXCheckBox DoneChecked;

    @FXML
    private JFXCheckBox RejectedChecked;

    @FXML
    private JFXCheckBox onthewayChecked;

    @FXML
    private Pane pane_logout;

    @FXML
    private Pane pane_exit;

    @FXML
    private Pane pane_home;
    @FXML
    private StackPane stackepane;
    @FXML
    private JFXTextField deliveryserial;
    @FXML
    private JFXButton CreatePdf;
    
    private Connection con2 = ConnexionBD.getinstance().getcnx();
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {   
           
        loadAllDelivery("SELECT * FROM delivery");  
    }    
 
        public void loadAllDelivery(String sql){
    
        JFXTreeTableColumn<Delivery,String> deliveryserial = new JFXTreeTableColumn<>("Delivery Serial");
        deliveryserial.setPrefWidth(70);
        deliveryserial.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Delivery, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Delivery, String> param) {
                return param.getValue().getValue().deliveryserial;
            }
        });
        
         JFXTreeTableColumn<Delivery,String> idclient = new JFXTreeTableColumn<>(" Client");
        idclient.setPrefWidth(200);
        idclient.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Delivery, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Delivery, String> param) {
                return param.getValue().getValue().idclient;
            }
        });
        
         JFXTreeTableColumn<Delivery,String> idbike = new JFXTreeTableColumn<>("id Bike");
        idbike.setPrefWidth(420);
        idbike.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Delivery, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Delivery, String> param) {
                return param.getValue().getValue().idbike;
            }
        });
             
        JFXTreeTableColumn<Delivery,String> status = new JFXTreeTableColumn<>("Delivery status");
        status.setPrefWidth(160);
        status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Delivery, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Delivery, String> param) {
                return param.getValue().getValue().status;
            }
        });

                     ObservableList<Delivery> deliverys =FXCollections.observableArrayList();
        try {
            PreparedStatement ps = (PreparedStatement) con2.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            deliverys.add(new Delivery(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(AVDeliveryAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final TreeItem<Delivery> root = new RecursiveTreeItem <Delivery>(deliverys,RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(deliveryserial,idclient,idbike,status);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    
        }
    
    
    
    /***********************************************************************/
    @FXML
    void ajouterButton(ActionEvent event) {
        
        if(deliveryserial.getText().toString().equals("")){ControleSaisie();}
         else {  
         String query = "insert into delivery values(?, ?, ?, ?)";
    
           try {
               
                PreparedStatement pre = (PreparedStatement) con2.prepareStatement(query);
                pre.setString(1, deliveryserial.getText());
                pre.setString(2, idclient.getText().toString());
                pre.setString(3, idbike.getText().toString());
                pre.setString(4, "OntheWay");
                
                
               
                pre.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(AVDeliveryAdminController.class.getName()).log(Level.SEVERE, null, ex);
           }
              loadAllDelivery("SELECT * FROM delivery");
    }}

    @FXML
    void deleteButton(ActionEvent event) {
         ControleSaisie();
    String deletequery = "DELETE FROM `it-vision`.`delivery` where deliveryserial = ?";

        try {
            PreparedStatement preparedStatement = con2.prepareStatement(deletequery);

            preparedStatement.setString(1, deliveryserial.getText());
            preparedStatement.execute();
            preparedStatement.close();
            loadAllDelivery("SELECT * FROM delivery");
           
        } catch (SQLException e) { e.printStackTrace(); }
        
    }

    @FXML
    void updateButton(ActionEvent event) {
         ControleSaisie();
         String query = "UPDATE `it-vision`.`delivery` SET  idclient= ?, idbike = ?" 
                + " where deliveryserial = ? ";

        try {

            PreparedStatement preparedStatement = con2.prepareStatement(query);
            preparedStatement.setString(1, idclient.getText());
            preparedStatement.setString(2, idbike.getText());
            preparedStatement.setString(3, deliveryserial.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllDelivery("SELECT * FROM delivery");
            }catch(SQLException e){e.printStackTrace();}
    }

    public void ControleSaisie(){
if(deliveryserial.getText().toString().equals("")){
          Image image = new Image("/imgVelo/error.gif");
            Notifications notification = Notifications.create()
                    .title("Error")
                    .text("Please Select an id")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.darkStyle();
            notification.show();
        }
}
    
    @FXML
    void Done(ActionEvent event) {
          ControleSaisie();
      onthewayChecked.setSelected(false);
        RejectedChecked.setSelected(false);
         String query = "UPDATE `it-vision`.`delivery` SET status = \"Done\"" 
                + " where deliveryserial = ? ";

        try {

            PreparedStatement preparedStatement = con2.prepareStatement(query);
            preparedStatement.setString(1, deliveryserial.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllDelivery("SELECT * FROM delivery");
            }catch(SQLException e){e.printStackTrace();}
         

    }

    @FXML
    void OntheWay(ActionEvent event) {
    ControleSaisie();
             DoneChecked.setSelected(false);
        RejectedChecked.setSelected(false);
         String query = "UPDATE `it-vision`.`delivery` SET status = \"OntheWay\"" 
                + " where deliveryserial = ? ";

        try {

            PreparedStatement preparedStatement = con2.prepareStatement(query);
            preparedStatement.setString(1, deliveryserial.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllDelivery("SELECT * FROM delivery");
            }catch(SQLException e){e.printStackTrace();}
    }

   
    @FXML
    void Rejected(ActionEvent event) {
    ControleSaisie();
         onthewayChecked.setSelected(false);
        DoneChecked.setSelected(false);
         String query = "UPDATE `it-vision`.`delivery` SET status = \"Rejected\"" 
                + " where deliveryserial = ? ";

        try {

            PreparedStatement preparedStatement = con2.prepareStatement(query);
            preparedStatement.setString(1, deliveryserial.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            loadAllDelivery("SELECT * FROM delivery");
            }catch(SQLException e){e.printStackTrace();}
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
    private void CreatePdf(ActionEvent event) throws Exception {
        try {
        Document document = new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\mbm info\\Desktop\\Event\\src\\pdf\\DeliveryAdminPDF.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(4);
       table.setWidthPercentage(100);
       table.getDefaultCell().setBorder(2);
       table.addCell("deliveryserial");
       table.addCell("idclient");
       table.addCell("idbike");
       table.addCell("status");
       
        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("Delivery List ");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(p);
                  // document.add(com.itextpdf.text.Image.getInstance("C:/Users/pablo/Documents/NetBeansProjects/Pi_dev/src/Images/bank.png"));

       //Class.forName("com.mysql.jdbc.Driver");
       //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/i", "root", "");
       Statement st=con2.createStatement();
       ResultSet rs=st.executeQuery("SELECT deliveryserial,idclient,idbike,status FROM `delivery`");
       while(rs.next()){
       table.addCell(rs.getString("deliveryserial"));
       table.addCell(rs.getString("idclient")); //name in DB

       table.addCell(rs.getString("idbike"));
       table.addCell(rs.getString("status")); //name in DB
       }
       document.add(table);
        JOptionPane.showMessageDialog(
                null, " données exportées en pdf avec succés ");
               document.close();
           
            

        } catch (Exception e) {

            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
   
    }
 
    
}
