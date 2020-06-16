package Entities;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Delivery extends RecursiveTreeObject<Delivery>{
  
    
    public StringProperty deliveryserial;
    public StringProperty idclient;
    public StringProperty idbike;
    public StringProperty status;
    

public Delivery(){
        super();
     }

  public Delivery(String deliveryserial, String idclient, String idbike, String status) {
      this.deliveryserial = new SimpleStringProperty(deliveryserial);
      this.idclient = new SimpleStringProperty(idclient);
      this.idbike = new SimpleStringProperty(idbike);
      this.status = new SimpleStringProperty(status);
        
  }

   public StringProperty getDeliveryserial() {
        return deliveryserial;
    }

    public void setDeliveryserial(StringProperty deliveryserial) {
        this.deliveryserial = deliveryserial;
    }

    public StringProperty getIdclient() {
        return idclient;
    }

    public void setIdclient(StringProperty idclient) {
        this.idclient = idclient;
    }

    public StringProperty getIdbike() {
        return idbike;
    }

    public void setIdbike(StringProperty idbike) {
        this.idbike = idbike;
    }

    public StringProperty getStatus() {
        return status;
    }

    public void setStatus(StringProperty status) {
        this.status = status;
    }

    
    
    

}
