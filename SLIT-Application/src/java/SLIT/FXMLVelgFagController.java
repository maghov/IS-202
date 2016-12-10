/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLIT;

import DataModel.UserDataModel;
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
import DataModel.UserDataModel;
import Framework.UserManager;






/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLVelgFagController implements Initializable {
    
    public static UserDataModel user;
    
    private UserManager userManager = new UserManager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void velgIS109Event(ActionEvent event) throws IOException, Exception {
         Parent log_page_parent = FXMLLoader.load(getClass().getResource("FXMLIS109.fxml"));
            Scene log_page_scene = new Scene(log_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(log_page_scene);
            app_stage.show();
            System.out.println(Framework.UserManager.getUsersLoggedInId());
    }
    
    
 
}
