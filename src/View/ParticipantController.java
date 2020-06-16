/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Client;
import Entities.participants;
import Entities.training;
import Services.serviceparticipants;
import Utils.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class ParticipantController implements Initializable {

    @FXML
    private TableView<Client> tableclient;
    @FXML
    private TableColumn<Client, Integer> idcc;
    @FXML
    private TableColumn<Client, String> namec;
    @FXML
    private TableColumn<Client, String> lnamec;
    @FXML
    private TableColumn<Client, Integer> phc;
        ObservableList<Client> oblist = FXCollections.observableArrayList();
        ObservableList<participants> oblist1 = FXCollections.observableArrayList();

    
    @FXML
    private TableView<participants> tablepart;
    @FXML
    private TableColumn<participants, Integer> idp;
    @FXML
    private TableColumn<participants, String> namep;
    @FXML
    private TableColumn<participants, String> lnamep;
    @FXML
    private TableColumn<participants, Integer> php;
    @FXML
    private JFXTextField idc_text;
    @FXML
    private JFXTextField nametext;
    @FXML
    private JFXTextField lasttext;
    @FXML
    private JFXTextField phonetext;

    Connection c=ConnexionBD.getinstance().getcnx();
    serviceparticipants srvp = new serviceparticipants();
    @FXML
    private JFXButton addbt;
    @FXML
    private JFXButton editbt;
    @FXML
    private JFXButton delbt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
           ResultSet rs = c.createStatement().executeQuery("SELECT id_client, name, lastname, numero_tel from clients ");
            
            while(rs.next()){
                
                oblist.add(new Client(rs.getInt("id_client"), rs.getString("name"), rs.getString("lastname"), rs.getInt("numero_tel")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        idcc.setCellValueFactory(new PropertyValueFactory<>("id_client"));
        namec.setCellValueFactory(new PropertyValueFactory<>("name"));
        lnamec.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phc.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
        
        tableclient.setItems(oblist);
        
        //afficher();
        
    }    
     public void afficher()
    {
           

            ObservableList obeListe = FXCollections.observableList(srvp.displayAll8());
            
        
  
        
        idp.setCellValueFactory(new PropertyValueFactory<>("ide_client"));
        namep.setCellValueFactory(new PropertyValueFactory<>("name"));
        lnamep.setCellValueFactory(new PropertyValueFactory<>("lastname"));
       php.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
        
        
        tablepart.setItems(oblist1);
        
        tablepart.setItems(obeListe);
        
    } 
private Client tab2;
    @FXML
    private void add(ActionEvent event) throws SQLException {
        
            participants ppt = new participants(Integer.valueOf(idc_text.getText()), nametext.getText(), lasttext.getText(), Integer.valueOf(phonetext.getText()));
            srvp.ajouterparticipants(ppt);
            afficher();
    }

    @FXML
    private void click(MouseEvent event) {
        
           tab2 = tableclient.getSelectionModel().getSelectedItem();
        
        if(tab2 !=null){
            
            idc_text.setText(String.valueOf(tab2.getId_client()));
            nametext.setText(String.valueOf(tab2.getName()));
            lasttext.setText(String.valueOf(tab2.getLastname()));
            phonetext.setText(String.valueOf(tab2.getNumero_tel()));  
        }
    }
    
private participants tab3;
    @FXML
    private void edit(ActionEvent event) {
         tab3 = tablepart.getSelectionModel().getSelectedItem();
 
        srvp.modifierparticipants(tab3.getIdpart(), Integer.valueOf(idc_text.getText()), nametext.getText(), lasttext.getText(), Integer.valueOf(phonetext.getText()));
      
        afficher();
        
    }

    @FXML
    private void clicked(MouseEvent event) {
        
         tab3 = tablepart.getSelectionModel().getSelectedItem();
        
        if(tab3 !=null){
            
           idc_text.setText(String.valueOf(tab2.getId_client()));
            nametext.setText(String.valueOf(tab2.getName()));
            lasttext.setText(String.valueOf(tab2.getLastname()));
            phonetext.setText(String.valueOf(tab2.getNumero_tel()));  
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        
        ObservableList<participants> selectedRows, allPeople;
        allPeople = tablepart.getItems();
        selectedRows = tablepart.getSelectionModel().getSelectedItems();
       tab3 = tablepart.getSelectionModel().getSelectedItem();
       
       srvp.supprimerparticipants(tab3);
       afficher();
    }
    
}
