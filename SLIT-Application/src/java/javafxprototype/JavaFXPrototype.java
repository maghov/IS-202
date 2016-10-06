/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototype;

import ejb.server.ModuleSessionBeanRemote;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.ejb.EJB;
import slitapplication.ModuleHandler;
import slitapplication.UserHandler;

/**
 *
 * @author Johnjnsen
 */
public class JavaFXPrototype extends Application {

    @EJB
    private static ModuleSessionBeanRemote moduleSessionBean;
   
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add
        (JavaFXPrototype.class.getResource("javafxprototype.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        
        ModuleHandler handler = new ModuleHandler();
        
        handler.getModuleMethod();
        
        //moduleSessionBean.getModuleNameByInt(1);
        
        //UserHandler handler = new UserHandler(); 
        
        //System.out.println(handler.getBusinessMethod());
    }
    
}
