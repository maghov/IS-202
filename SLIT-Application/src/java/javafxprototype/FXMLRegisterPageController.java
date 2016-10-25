/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototype;

import Framework.UserManager;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLRegisterPageController implements Initializable {

    @FXML
    private TextField firstNameRegister;
    @FXML
    private TextField passwordRegister;
    
    private UserManager userManager = new UserManager();
    
    @FXML
    private TextField lastNameRegister;
    @FXML
    private TextField emailRegister;
    @FXML
    private TextField userNameRegister;
    @FXML
    private Label logRegistrerLabel;
    @FXML
    private TextField PhoneRegister;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    //String username, String password, String firstName, String lastName, String mail

    @FXML
    private void handleRegisterTask(ActionEvent event) throws IOException {
        
        if(this.userManager.register(this.userNameRegister.getText(), this.passwordRegister.getText(), this.firstNameRegister.getText(),
        this.lastNameRegister.getText(), this.emailRegister.getText(), this.PhoneRegister.getText()))
        {
            logRegistrerLabel.setText("Register successfull");
            
            System.out.println("Test!");
            Parent document_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene document_page_scene = new Scene(document_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(document_page_scene);
            app_stage.show();
        }
        else
        {
            this.logRegistrerLabel.setText("Username of password is irrcorrect");
        }
        
        

    }
    
}
