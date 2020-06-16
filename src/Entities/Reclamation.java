package Entities;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reclamation extends RecursiveTreeObject<Reclamation>{
   //  reclamation : objetreclamation  +  description  
    
    public StringProperty objetreclamation;
    public StringProperty description;
    
    
    public Reclamation(){
        super();
     }

    public Reclamation(String objetreclamation, String description) {
        this.objetreclamation = new SimpleStringProperty(objetreclamation);
        this.description = new SimpleStringProperty(description);
        
    }

    public StringProperty getObjetreclamation() {
        return objetreclamation;
    }

    public void setObjetreclamation(StringProperty objetreclamation) {
        this.objetreclamation = objetreclamation;
    }

    public StringProperty getDescription() {
        return description;
    }

    public void setDescription(StringProperty description) {
        this.description = description;
    }

    
    
    
}
