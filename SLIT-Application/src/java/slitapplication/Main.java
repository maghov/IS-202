/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import ejb.server.UserSessionBeanRemote;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxprototype.JavaFXPrototype;
import javax.ejb.EJB;

/**
 *
 * @author Mohammad
 */
public class Main extends Application{

    @EJB
    private static UserSessionBeanRemote userSessionBean;

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
        launch(args);
    }
    
    /**
     * @param args the command line arguments
     
    public static void main(String[] args) {

    }
    */
}
