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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Framework.UserManager; 
import SharedCommon.UserTypes;




/**
 *
 * @author Phil
 */
public class FXMLLoginPageController implements Initializable {
    
    public Label label;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    
    private UserManager userManager = new UserManager();
    
    public static UserDataModel user;
    
    @FXML
    private Label logLabel;
   
    @FXML 
    public void goToRegisterButton(ActionEvent event) throws IOException {
        this.logLabel.setText("Sign in button pressed");
            System.out.println("Test!");
            Parent register_page_parent = FXMLLoader.load(getClass().getResource("FXMLRegisterPage.fxml"));
            Scene register_page_scene = new Scene(register_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(register_page_scene);
            app_stage.show();
    }
    
    @FXML
    public void handleButtonEvent(ActionEvent event) throws IOException {
        
        user = this.userManager.loginUser(this.userNameTextField.getText(), this.passwordTextField.getText());
        
        if (user.getUser_UserName() != null) {
            
            UserTypes userType = this.userManager.getUserType(user.getUser_ID());
            
            if(userType != null && userType == UserTypes.Student) {
                Parent VelgFag_page_parent = FXMLLoader.load(getClass().getResource("FXMLVelgFag.fxml"));
                Scene VelgFag_page_scene = new Scene(VelgFag_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(VelgFag_page_scene);
                app_stage.show();
                System.out.println("Student");
                System.out.println(user.getUser_ID());
                
            }
                
                if (userType != null && userType == UserTypes.Teacher) {

                }
               
        
        else 
        {
            this.logLabel.setText("Username or password is incorrect");
        }

        }}
        
        
        /*if(this.userManager.login(this.userNameTextField.getText(), this.passwordTextField.getText()))
        {
            logLabel.setText("Login successfull");
            
            System.out.println("Test!");
            Parent VelgFag_page_parent = FXMLLoader.load(getClass().getResource("FXMLVelgFag.fxml"));
            Scene VelgFag_page_scene = new Scene(VelgFag_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(VelgFag_page_scene);
            app_stage.show();
        }
        else 
        {
            this.logLabel.setText("Username or password is incorrect");
        }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
