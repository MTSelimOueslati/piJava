/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Product;
import Entities.ShoppingCart;
import Entities.Velo_a_vendre;
import Services.ServiceProduct;
import Services.ServiceShoppinCart;
import Services.Service_velo_a_vendre;
import Utils.ConnexionBD;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ShoppingCartController implements Initializable {

    @FXML
    private Button RemoveFromCart;
    @FXML
    private TableView<ShoppingCart> table;
    @FXML
    private TableColumn<ShoppingCart, String> Item2;
    @FXML
    private TableColumn<ShoppingCart, Double> Price2;
    @FXML
    private Button AddToCart;
    @FXML
    private Button order;
    @FXML
    private Label total1;
    @FXML
    private TableColumn<Velo_a_vendre, String> idP;
    @FXML
    private TableColumn<Velo_a_vendre, Double> price1;
    @FXML
    private TextField text;
    @FXML
    private TableView<Velo_a_vendre> tabble1;
    
    public static ShoppingCart sc=new ShoppingCart() ;
    ObservableList<Velo_a_vendre> people = FXCollections.observableArrayList();
    Service_velo_a_vendre sp = new Service_velo_a_vendre();
    
    ObservableList<ShoppingCart> data1 = FXCollections.observableArrayList();
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;

        



Connection c=ConnexionBD.getinstance().getcnx();
    @FXML
    private Button calculer;
    @FXML
    private TextField totall;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        people.addAll(sp.getAll());
        idP.setCellValueFactory(new PropertyValueFactory<>("path_photo"));
        price1.setCellValueFactory(new PropertyValueFactory<>("price"));

       tabble1.setItems(people);
        try {
            ResultSet rs = c.createStatement().executeQuery("select path_photo, price from shoppingcart");
            while(rs.next()){
                data1.add(new ShoppingCart(rs.getString("path_photo"), rs.getDouble("price")));
                
            }
            

// TODO
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Item2.setCellValueFactory(new PropertyValueFactory<>("path_photo"));
        Price2.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(data1);
    }    
private Velo_a_vendre pc;
    @FXML
    private void displayselected(javafx.scene.input.MouseEvent event) {
        Velo_a_vendre prd = tabble1.getSelectionModel().getSelectedItem();
        Double p =0.00;
        Double p0 =0.00;
    if (prd==null){
        text.setText("No Item Selected");
    }
    else {
    String itm = prd.getPath_photo();
    Double prx = prd.getPrice();
    text.setText("Item : " + itm + ", Price : " + prx);
    }
    pc = tabble1.getSelectionModel().getSelectedItem();
    if (pc !=null){
        text2.setText(pc.getPath_photo());
        text1.setText(String.valueOf(pc.getPrice()));
        
    }
    
    }
    


    @FXML
    private void Addcart(ActionEvent event) throws SQLException {
        /*String itm = text.getText();
        String prx1 = text.getText();
         
     //   double prx = Double.parseDouble(prx1);
        
        Item2.setCellValueFactory(new PropertyValueFactory<>(itm));
        Price2.setCellValueFactory(new PropertyValueFactory<>(prx1));*/

     //   table.setItems(data1);
     
     ServiceShoppinCart scr = new ServiceShoppinCart();
     //ShoppingCart scc = new ShoppingCart(text1.getText(),));
     Double k;
        k = Double.parseDouble(text1.getText());
        System.out.println(text1.getText());
        
          ShoppingCart scc = new ShoppingCart(text2.getText(), 0, 0, k);

     
     scr.ajoutershoppingcart(scc);
       
       ShoppingCart c = table.getSelectionModel().getSelectedItem();
       table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
       
        
    }

    @FXML
    private void delete(ActionEvent event) {
        ObservableList<ShoppingCart> selectedRows, allShoppingCart;
        allShoppingCart = table.getItems();
        selectedRows = table.getSelectionModel().getSelectedItems();
        ShoppingCart s = table.getSelectionModel().getSelectedItem();
        ServiceShoppinCart sct= new ServiceShoppinCart();
        //sct.supprimershoppingcart(s.getId_Panier());
        //table.getItems().clear();
        sct.supprimershoppingcart(20);
       
       ShoppingCart c = table.getSelectionModel().getSelectedItem();
       table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
       
    }

    private void test(ActionEvent event) {
        System.out.println(text2.getText());
    }

    @FXML
    private void displayselected1(javafx.scene.input.MouseEvent event) {
        
     
    
    }
    /*public void Afficher(){
        ServiceShoppinCart sc = new ServiceShoppinCart();
        ObservableList oblist = FXCollections.observableList(sc.displayAll());
        Item2.setCellFactory(new PropertyValueFactory<>("path_photo"));
        Price2.setCellFactory(new PropertyValueFactory<>("price"));
        table.setItems(data1);
        table.setItems(oblist);
        
    }*/

    @FXML
    private void calculer(ActionEvent event) throws SQLException {
        ShoppingCart sc1 = table.getSelectionModel().getSelectedItem();
         ServiceShoppinCart sct= new ServiceShoppinCart();
         Double tt;
          //Double Ammount = sct.Calculer(Double.parseDouble(Price2.getText()));
        // totall.setText("Ammount : " + Ammount);
        tt= sct.Calculer();
         
        System.out.println(tt);
         totall.setText(String.valueOf(tt));
         sc.setAmmount(tt);
        
    }

    @FXML
    private void Order(ActionEvent event) throws IOException {
        Parent root;
        try{
        root= FXMLLoader.load(getClass().getResource("/View/Order.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();}
        
        catch (Exception Ex)
        {}
        
    }
}
