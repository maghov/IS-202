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
import javafx.stage.Stage;
import Framework.ModuleManager;
import static java.awt.Color.red;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLIS109Controller implements Initializable {

    @FXML
    private Tab Module1;
    @FXML
    private Label showModule1Name;
    @FXML
    private Label showModule1Task;
       
    @FXML
    private Tab Module2;
    @FXML
    private Label showModule2Name;
    @FXML
    private Label showModule2Task;
   
    private final ModuleManager moduleManager = new ModuleManager();
    @FXML
    private Label showModule1Resources;
    @FXML
    private Label showModuleFrist;
    @FXML
    private Circle test;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        

}
 
    
    @FXML
    private void handleBackTask(ActionEvent event)throws IOException {
        Parent VelgFag_page_parent = FXMLLoader.load(getClass().getResource("FXMLVelgFag.fxml"));
           Scene VelgFag_page_scene = new Scene(VelgFag_page_parent);
           Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           app_stage.setScene(VelgFag_page_scene);
           app_stage.show();
    }   




    private void handleModule2Task(Event event) {
        this.showModule2Task.setText(this.moduleManager.getModuleTaskByInt(2));
        this.showModule2Name.setText(this.moduleManager.getModuleNameByInt(2));
    }

    private void handleModule1Task(Event event) {
        this.showModule1Name.setText(this.moduleManager.getModuleNameByInt(1));
        this.showModule1Task.setText(this.moduleManager.getModuleTaskByInt(1));
        this.showModule1Resources.setText(this.moduleManager.getModuleResourcesByInt(1));
        Paint green = null;
        this.test.setFill(green);

    }
}