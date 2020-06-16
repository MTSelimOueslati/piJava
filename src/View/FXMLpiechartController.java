/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import Utils.ConnexionBD;

/**
 * FXML Controller class
 *
 * @author mh
 */
public class FXMLpiechartController implements Initializable {
 Connection con=ConnexionBD.getinstance().getcnx();
    /**
     * Initializes the controller class.
     */
  ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
  
 

    @FXML
    private BarChart<?, ?> bchart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
  
  
  
  @FXML
    private PieChart chart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series1 = new XYChart.Series();
     try {         
         ObservableList<PieChart.Data> pieChartData1 = null;
         PreparedStatement pt;
          
         
         
         pt = con.prepareStatement("select * from velolouer GROUP by marque");
         
         ResultSet rs = pt.executeQuery();
         
         while (rs.next()) {
             
             
             pieChartData.add(new PieChart.Data(rs.getString(3),rs.getDouble(6)));
           
              series1.getData().add(new XYChart.Data(rs.getString(3), rs.getFloat(2)));  
         }
         
     } catch (SQLException ex) {
        
     }
     
        
         
       chart.setData(pieChartData);
         
         bchart.getData().addAll(series1);
         
        
 
           
 
      
    }


@FXML
    private void retour(ActionEvent event) throws IOException {
        
   
       Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLshow.fxml"));
        Scene tableViewScene = new Scene(tableViewParent,1000,700);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
  
        
        
}    
   
}
