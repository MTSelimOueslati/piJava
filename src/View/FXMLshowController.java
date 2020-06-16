/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import entities.Personne;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//import services.ServicePersonne;
import Utils.ConnexionBD;
import Entities.*;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import Services.*;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mh
 */
public class FXMLshowController implements Initializable {

    /**
     * Initializes the controller class.
     */
       // private Connection con = ConnectionBD.getInstance().getCnx();
        
@FXML private Button detailedPersonViewButton;
     @FXML private Button updateButton;
     @FXML private Button Refresh;
     @FXML private ImageView viewphoto;
             @FXML private ImageView  qrView;
       @FXML private TextField nom;
        @FXML private TextField id;
         @FXML private TextField prenom;
          @FXML private TextField nbr ;
          
    @FXML private TableView<Velo_a_louer> tableView;
    
    @FXML private TableColumn<Velo_a_louer, String> i;
    @FXML private TableColumn<Velo_a_louer, String> prix;
    @FXML private TableColumn<Velo_a_louer, String> marque;
    @FXML private TableColumn<Velo_a_louer, String> description;
    @FXML private TableColumn<Velo_a_louer, String> nombre;
    @FXML private TableColumn<Velo_a_louer, String> etat;
    
    
    @FXML private TextField filterField;
    @FXML
    private Button Ecommerce;
    @FXML
    private Button amine;
    @FXML
    private Button me;
    @FXML
    private Button Blog;
    @FXML
    private Button Forum;
    @FXML
    private Button Charity;
    
    
    
    
    
    
    @FXML
    private void gestionlocation(ActionEvent event) throws IOException {
       
       
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Gestionlocation.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,1200,900);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
       
    }
    
    
   
   @FXML
    private void stat(ActionEvent event) throws IOException {
       
       
        
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLpiechart.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,800,650);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   @FXML
    private void ajouter(ActionEvent event) throws IOException {
       
       
        
    
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ajouterFXML.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,650,430);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        
       
    }
    @FXML
    private void mailforn(ActionEvent event) throws IOException {
       
       
        Service_velo_a_louer srv = new Service_velo_a_louer();
        String warr=srv.VerifierProduits();
        
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information mail fournisseur");
alert.setHeaderText(warr);
alert.setContentText("succes");

alert.showAndWait();
   
       
    }
   
    
       
   public ObservableList<Velo_a_louer>  getPeople()
    {
         
          Service_velo_a_louer srv = new Service_velo_a_louer();
     
        return srv.getPeople();
    } 
   
    @FXML
      public void update()
    {
        
          Service_velo_a_louer srv = new Service_velo_a_louer();
        srv.modifiervelo_a_louer(Float.valueOf(nom.getText()),prenom.getText(),Integer.valueOf(nbr.getText()),Integer.valueOf(id.getText()));
        
        
        
         
    }
      @FXML
    public void userClickedOnTable()
    {
        javafx.scene.image.Image photo1;
        Service_velo_a_louer ser=new Service_velo_a_louer();
       this.detailedPersonViewButton.setDisable(false);
        this.updateButton.setDisable(false);
         Velo_a_louer person = tableView.getSelectionModel().getSelectedItem();
         
         prenom.setText(person.getDescription());
         nom.setText(String.valueOf(person.getPrix()));
         id.setText(String.valueOf(person.getId()));
         nbr.setText(String.valueOf(person.getNombre()));
         id.setDisable(true);
         System.out.println(ser.getpath(Integer.valueOf(id.getText())));
          photo1 = new javafx.scene.image.Image(ser.getpath(Integer.valueOf(id.getText())));
         viewphoto.setImage(photo1);
         
         QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "id: "+id.getText()+"  "+" \n prix:"+nom.getText()+"\n "+"description:"+prenom.getText()+" \n"+"nombre:"+nbr.getText();
        
        int width = 500;
        int height = 500;
        String fileType = "png";
         
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
             
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
             
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
             
            qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
             
        } catch (WriterException ex) {
            //Logger.getLogger(JavaFX_QRCodeWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }
    
    @FXML
    public void Refresh()
    {
        i.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("prix"));
       marque.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("marque"));
        description.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("description"));
       nombre.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("nombre"));
        etat.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("path_photo"));
       
               
  
  this.detailedPersonViewButton.setDisable(true);
  this.updateButton.setDisable(true);
   FilteredList<Velo_a_louer> filteredData = new FilteredList<>(getPeople(), b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
				
				     
				     else  
				    	 return false; // Does not match.
                                
			});
		});
   SortedList<Velo_a_louer> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		
               
tableView.setItems(sortedData); 
    }
    
    
    @FXML
    public void deleteButtonPushed()
    {
        
         
         ObservableList<Velo_a_louer> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
       Velo_a_louer velo = tableView.getSelectionModel().getSelectedItem();
        
            
   
   
        Service_velo_a_louer srv = new Service_velo_a_louer();
        srv.supprimervelo(velo.getId());

        

      
       
    }
    
    
    
   @Override
    
    public void initialize(URL url, ResourceBundle rb) {
                
         i.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("prix"));
       marque.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("marque"));
        description.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("description"));
       nombre.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("nombre"));
        etat.setCellValueFactory(new PropertyValueFactory<Velo_a_louer, String>("path_photo"));
       
       FilteredList<Velo_a_louer> filteredData = new FilteredList<>(getPeople(), b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(desc -> {
				
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (desc.getDescription().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
				
				     
				     else  
				    	 return false; // Does not match.
                                
			});
		});
       SortedList<Velo_a_louer> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		
               
tableView.setItems(sortedData);  
  
  
  this.detailedPersonViewButton.setDisable(true);
  this.updateButton.setDisable(true);
  
    } 
@FXML 
     private void OpenEvents2 (ActionEvent event)
    {
       FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Admin event.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.initStyle(StageStyle.UTILITY);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
 @FXML
    private void logout(ActionEvent event) {
  
     FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("LOGINFXML.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       }    
    }

    @FXML
    private void Ecommerce(ActionEvent event) {
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("FXMLshow_1.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

    @FXML
    private void user(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AFFICHERFXML.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
    }

    @FXML
    private void Amine (ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AVAdminHomeScreen.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
    }
    @FXML
    private void training (ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("training.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
    @FXML
    private void charity (ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("charity.fxml"));
            try {
                Parent root = loader.load();         
                Scene Donia = new Scene(root,1200,800);
                
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(Donia);
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
    
}
