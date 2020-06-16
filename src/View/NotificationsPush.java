/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author mbm info
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
*/
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;

public class NotificationsPush {
 /********************************************************************************************************************************************************************************************************************/   
    public void notifpush(String titre , String text)
    {                                        ImageView img;
Image img5 = new Image(getClass().getResource("logo-bascla.png").toString());
             Notifications notificationBuilder = Notifications.create()
                .title(titre)
                .text(text)
                .graphic(new ImageView(img5))

                .hideAfter(javafx.util.Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
           }
       });
                   
           notificationBuilder.darkStyle();
            notificationBuilder.show();
    }
    
 /********************************************************************************************************************************************************************************************************************/   
     public void notifpushno(String titre , String text)
    {
        Image img = new Image("logo-bascla.png");
             Notifications notificationBuilder = Notifications.create()
                .title(titre)
                .text(text)
                .graphic(new ImageView(img))
                .hideAfter(javafx.util.Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
           }
       });
                   
           notificationBuilder.darkStyle();
            notificationBuilder.show();
    }
     
     public void notifmain(){
          Image img = new Image("logo-bascla.png");
             Notifications notificationBuilder = Notifications.create()
                
                .graphic(new ImageView(img))
                .hideAfter(javafx.util.Duration.seconds(5))
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
           }
       });
                   
           notificationBuilder.darkStyle();
            notificationBuilder.show();
     }
    
}
