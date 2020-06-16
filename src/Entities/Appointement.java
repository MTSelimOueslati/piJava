package Entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;


public class Appointement extends RecursiveTreeObject<Appointement>{
    
    public StringProperty idappointement;
    public StringProperty date;
    public StringProperty description;
    public StringProperty state;

    
    public Appointement(){
        super();
     }

    public Appointement(String idappointement, String date, String description,String state) {
        this.idappointement = new SimpleStringProperty(idappointement);
        this.date = new SimpleStringProperty(date);
        this.description = new SimpleStringProperty(description);
            this.state = new SimpleStringProperty(state);
    
        
    }
}
    /*public Appointement(String date, String description) {
     
        this.date = new SimpleStringProperty(date);
        this.description = new SimpleStringProperty(description);
          
    
        
    }*/
    
