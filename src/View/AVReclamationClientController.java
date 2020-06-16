package View;

import Entities.Reclamation;
import Utils.ConnexionBD;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author medam
 */
public class AVReclamationClientController implements Initializable {
    
    @FXML
    private JFXTreeTableView<Reclamation> treeView;
    @FXML
    private JFXTextField objetreclamation;
    @FXML
    private JFXButton AjouterButton;
    @FXML
    private JFXButton DeleteButton;
    @FXML
    private JFXButton UpdateButton;
    
    private Connection con;
    @FXML
    private JFXTextField description;
    @FXML
    private Pane pane_logout;
    @FXML
    private Pane pane_exit;
    @FXML
    private Pane pane_home;
    @FXML
    private StackPane stackepane;
    @FXML
    private JFXButton CreatePdf;
   
   
      
     private    Connection con4 =ConnexionBD.getinstance().getcnx();
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //con = DataBase.getInstance().getConnection();
    loadAllReclamation("SELECT * FROM reclamation");   
    
    }  
    
     public void loadAllReclamation(String sql){
    
        JFXTreeTableColumn<Reclamation,String> objetreclamation = new JFXTreeTableColumn<>("Reclamation object");
        objetreclamation.setPrefWidth(200);
        objetreclamation.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reclamation, String> param) {
                return param.getValue().getValue().objetreclamation;
            }
        });
        
         JFXTreeTableColumn<Reclamation,String> description = new JFXTreeTableColumn<>("Reclamation Description");
        description.setPrefWidth(550);
        description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Reclamation, String> param) {
                return param.getValue().getValue().description;
            }
        });
        
        
        ObservableList<Reclamation> reclamations =FXCollections.observableArrayList();
        
        try {
            PreparedStatement ps = (PreparedStatement) con4.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            reclamations.add(new Reclamation(rs.getString(1)+"",rs.getString(2)));
            }
        
        } catch (SQLException ex) { ex.printStackTrace();
        }
        
        final TreeItem<Reclamation> root = new RecursiveTreeItem <Reclamation>(reclamations,RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(objetreclamation,description);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
       
        
    }

    @FXML
    private void ajouterReclamation(MouseEvent event) {
        
        try {
            PreparedStatement pre = con4.prepareStatement("INSERT INTO `it-vision`.`reclamation` ( `objetreclamation`, `description`) VALUES ( ?, ?);");
            pre.setString(1, objetreclamation.getText());
            pre.setString(2, description.getText());
            pre.executeUpdate(); 
            loadAllReclamation("SELECT * FROM reclamation");
        } catch (SQLException ex) {  ex.printStackTrace();
        }
    }

    @FXML
    private void DeleteReclamation(MouseEvent event) {
    String deletequery = "DELETE FROM `it-vision`.`reclamation` where objetreclamation = ?";

        try {
            PreparedStatement preparedStatement = con4.prepareStatement(deletequery);
            preparedStatement.setString(1, objetreclamation.getText());
            preparedStatement.execute();
            preparedStatement.close();
          loadAllReclamation("SELECT * FROM reclamation");  
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @FXML
    private void UpdateReclamation(MouseEvent event) {
        
       String query = "UPDATE `it-vision`.`reclamation` SET description = ? "
                + " where objetreclamation = ? ";

        try {

            PreparedStatement preparedStatement = con4.prepareStatement(query);
            preparedStatement.setString(1, description.getText());
            preparedStatement.setString(2, objetreclamation.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            loadAllReclamation("SELECT * FROM reclamation"); 
            
        }catch(SQLException e){e.printStackTrace();}
        
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
    private void mouse_exit_exit(MouseEvent event) {
        pane_exit.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    
    }

    @FXML
    private void mouse_hover_exit(MouseEvent event) {
    pane_exit.setStyle("-fx-background-color: #ff3b3b; -fx-background-radius: 6px;");
    
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
    private void mouse_exit_homep(MouseEvent event) {
    pane_home.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_homep(MouseEvent event) {
    pane_home.setStyle("-fx-background-color: #56ff4a; -fx-background-radius: 6px;");
    }

    @FXML
    private void homepage(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AVClientHomeScreen.fxml"));
        
        } catch (IOException ex) {
            Logger.getLogger(AVReclamationClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage current = (Stage)pane_home.getScene().getWindow();
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        current.hide();
        home.show();
    }

    //add jar : itextpdf-5.5.1.jar
    @FXML  //JFXButton → fx:id : CreatePdf  // On Action : CreatePdf
    private void CreatePdf(ActionEvent event) throws Exception {
        try {
        Document document = new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\mbm info\\Desktop\\Event\\src\\pdf\\ReclamationClientPDF.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(2);
       table.setWidthPercentage(100);
       table.getDefaultCell().setBorder(2);
       table.addCell("objetreclamation");
       table.addCell("description");
       
        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("Reclamation List ");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(p);
                  // document.add(com.itextpdf.text.Image.getInstance("C:/Users/pablo/Documents/NetBeansProjects/Pi_dev/src/Images/bank.png"));

      Statement st=con4.createStatement();
       ResultSet rs=st.executeQuery("SELECT objetreclamation,description FROM `reclamation`");
       while(rs.next()){
       table.addCell(rs.getString("objetreclamation"));
       table.addCell(rs.getString("description")); //name in DB

       
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

