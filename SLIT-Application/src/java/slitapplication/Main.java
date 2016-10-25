/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import Framework.ModuleManager;
import Framework.UserManager;
import ejb.server.UserSessionBeanRemote;
import java.security.MessageDigest;
import java.util.List;
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
public class Main{


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModuleManager manager = new ModuleManager(); 
        
        List<String> list = manager.getAllModules(); 
        
        for(String entity : list)
        {
            System.out.println(entity); 
        }
        
        UserManager userManager = new UserManager(); 
        
        if(userManager.login("Nyranith", "Test123"))
        {
            System.out.println("Du er logget inn"); 
        }
        else 
        {
            System.out.println("Feil passord eller brukernavn");
        }
        
        if(userManager.register("Magnus", "Test123", "Magnus", "Høvik", "test@outlook.com", "12345678"))
        {
            System.out.println("GRATULERER ! DU HAR HERVED blitt med i klubben vår :D "); 
        }
        else 
        {
            System.out.println("Du fikk ikke lov til å være med idag"); 
        }
    }
    
}
