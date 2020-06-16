/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Services.ServiceEvent;
import Services.ServiceParticipants_com;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mbm info
 */
public class AdminParticController implements Initializable {

    @FXML
    private TableColumn<?, ?> NomP;
    @FXML
    private TableColumn<?, ?> PrenomP;
    @FXML
    private TableColumn<?, ?> NomE;
    @FXML
    private TableColumn<?, ?> Type;
    @FXML
    private Button Ok;
    @FXML
    private Button NO;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> idP;
    @FXML
    private TableColumn<?, ?> idE;
    @FXML
    private Button CreatePdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void Ok(ActionEvent event) throws AWTException {

        try {
            // table.getSelectionModel().getSelectedIndex();

            String ide;
            ide = idE.getCellData(table.getSelectionModel().getSelectedIndex()).toString();

            int id_ev = Integer.parseInt(ide);

            String idc;
            idc = idP.getCellData(table.getSelectionModel().getSelectedIndex()).toString();
            String nom;
            nom = NomE.getCellData(table.getSelectionModel().getSelectedIndex()).toString();

            int idcc = Integer.parseInt(idc);

            ServiceParticipants_com SP = new ServiceParticipants_com();
            SP.modifieretat(id_ev, idcc);
            NotificationsPush NP = new NotificationsPush();
            NP.notifpush("adhérer", "Vous allez participer à l'evenement");
            Notif n = new Notif();
            n.displayTray("Approvement", "Vous avez été choisir pour participer à l'evenement" + nom);
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficher() throws IOException, SQLException {
        ServiceParticipants_com srv = new ServiceParticipants_com();

        ObservableList obeListe = FXCollections.observableList(srv.afficherParticipant());

        ServiceEvent Ev = new ServiceEvent();
        int idd = Ev.id();
        idE.setCellValueFactory(new PropertyValueFactory<>("id_ev"));
        idP.setCellValueFactory(new PropertyValueFactory<>("id_cl"));
        NomP.setCellValueFactory(new PropertyValueFactory<>("nomP"));
        PrenomP.setCellValueFactory(new PropertyValueFactory<>("prenomP"));

        NomE.setCellValueFactory(new PropertyValueFactory<>("nomE"));
        Type.setCellValueFactory(new PropertyValueFactory<>("Type"));

        table.setItems(obeListe);
    }

    @FXML
    private void CreatePdf(ActionEvent event) throws Exception {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\mbm info\\Desktop\\Event\\src\\View\\PDF\\note.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.getDefaultCell().setBorder(2);
            table.addCell("Nom Evenement");
            table.addCell("Nom Participant");
            table.addCell("Prenom Participant");
            table.addCell("Type");

            com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("Liste Des participants");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(p);
            // document.add(com.itextpdf.text.Image.getInstance("C:/Users/pablo/Documents/NetBeansProjects/Pi_dev/src/Images/bank.png"));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/it-vision", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nomP,prenomP,NomE,Type FROM participant");
            while (rs.next()) {
                
                table.addCell(rs.getString("NomP"));
                table.addCell(rs.getString("PrenomP"));

                table.addCell(rs.getString("NomE"));
                table.addCell(rs.getString("Type"));
                
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

    @FXML
    private void NO(ActionEvent event) throws AWTException {
        try {
            table.getSelectionModel().getSelectedIndex();

            String ide;
            ide = idE.getCellData(table.getSelectionModel().getSelectedIndex()).toString();

            int id_ev = Integer.parseInt(ide);

            String idc;
            idc = idP.getCellData(table.getSelectionModel().getSelectedIndex()).toString();

            int idcc = Integer.parseInt(idc);

            ServiceParticipants_com SP = new ServiceParticipants_com();
            SP.supprimerpersonne(id_ev, idcc);
            Notif n = new Notif();
            n.displayTray("refus", "Vous n'avez pas été adhérer pour des raisons professionnelles");
                NotificationsPush NP = new NotificationsPush();
            NP.notifpush("refu", "Vous allez participer à l'evenement");
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminParticController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
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
           window.show();
           
       } catch (IOException ex) {
           Logger.getLogger(Test2Controller.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
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

    private void Amine (ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AVAdminHomeScreen.fxml"));
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
   

    @FXML
    private void Back(ActionEvent event) { {
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Admin event.fxml"));
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
    
}
