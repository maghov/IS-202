/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLIT;

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
import javafx.stage.Stage;
import Framework.ModuleManager;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLIS109Controller implements Initializable {

     @FXML
    private Tab Module2;
    @FXML
    private Label showModule2Task;
    @FXML
    private Label showModule2Name;
    
    private final ModuleManager moduleManager = new ModuleManager();
   

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.showModule2Task.setText(this.moduleManager.getModuleTaskByInt(2));
        this.showModule2Name.setText(this.moduleManager.getModuleNameByInt(2));
    }   
    
    @FXML
    private void handleBackTask(ActionEvent event) throws IOException {
        
        Parent VelgFag_page_parent = FXMLLoader.load(getClass().getResource("FXMLVelgFag.fxml"));
        Scene VelgFag_page_scene = new Scene(VelgFag_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(VelgFag_page_scene);
        app_stage.show();
        
        
    }
    
}
    