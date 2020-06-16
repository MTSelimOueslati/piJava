/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class HomepageController implements Initializable {

    @FXML
    private JFXButton tr;
    @FXML
    private JFXButton part;
    @FXML
    private JFXButton chart;
    @FXML
    private JFXButton rec;
    @FXML
    private Pane MainPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void trainingButton(ActionEvent event) {
    }

    @FXML
    private void participantsButton(ActionEvent event) {
    }

    @FXML
    private void charityButton(ActionEvent event) {
    }

    @FXML
    private void recycleButton(ActionEvent event) {
    }
    
}
