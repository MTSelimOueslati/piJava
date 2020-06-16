/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Services.ServiceBill;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class BillController implements Initializable {

    @FXML
    private AnchorPane nom;
    @FXML
    private TextField name;
    @FXML
    private TextField last;
    @FXML
    private TextField a;
    @FXML
    private Button CreatePdf;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        name.setText(OrderController.b.getName());
        last.setText(OrderController.b.getLast_Name());
        a.setText(String.valueOf(ShoppingCartController.sc.getAmmount()));
        // TODO
    }    
   /* public void Afficher(){
        ServiceBill b = new ServiceBill();
       
        name.setCellFactory(new PropertyValueFactory<>("path_photo"));
        Price2.setCellFactory(new PropertyValueFactory<>("price"));
        table.setItems(data1);
        table.setItems(oblist);*/

    @FXML
    private void CreatePdf(ActionEvent event) 
        throws Exception {
        try {
         Document document = new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\mbm info\\Desktop\\Event\\src\\pdf\\Bill.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(3);
       table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(2);
       table.addCell("Name");
       table.addCell("Last Name");
       table.addCell("Ammount");
              
    
      
        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("Your Bill");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(p);
                  // document.add(com.itextpdf.text.Image.getInstance("C:/Users/pablo/Documents/NetBeansProjects/Pi_dev/src/Images/bank.png"));

       Class.forName("com.mysql.jdbc.Driver");
//       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bascla", "root", "");
//       Statement st=con.createStatement();
//       ResultSet rs=st.executeQuery("SELECT Name,Last_Name, Ammount FROM `bill`");
       
       table.addCell(name.getText());
       table.addCell(last.getText());

       table.addCell(a.getText());
       
       
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
        
    }

