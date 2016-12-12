/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLIT;

import Framework.DeliveryManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLModul1DeliveryController implements Initializable {

    @FXML
    private TextArea modul1Tekst;
    @FXML
    private Button btn1;
    @FXML
    private TextField headerModule1;
    
    
    private final DeliveryManager deliveryManager = new DeliveryManager();
    @FXML
    private Label logDeliveryLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
            
    @FXML
    private void handleModul1Delivery(ActionEvent event) throws IOException {
        this.deliveryManager.besvarelse(this.headerModule1.getText(), this.modul1Tekst.getText());
                    
            {

            System.out.println("Levering fullført");
                    
            
        }
 
    }
}




