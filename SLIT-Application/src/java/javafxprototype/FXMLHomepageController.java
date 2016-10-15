/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototype;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLHomepageController implements Initializable {

    @FXML
    private Button modul1Button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.modul1Button.setText("Test1");
    }   
    
}