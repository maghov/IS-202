/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLIT;

import DataModel.FeedbackDataModel;
import DataModel.ModuleDataModel;
import Framework.ModuleManager;
import Framework.FeedbackManager;
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
import javafx.stage.Stage;
import java.text.DateFormat;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
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
    
    private final FeedbackManager feedbackManager = new FeedbackManager();
    
    private final UserManager userManager = new UserManager();
    
    @FXML
    private Label showModule1Resources;
    @FXML
    private Label showModuleFrist;
    @FXML
    private Circle test;
    @FXML
    private Label showFeedbackApproved;
    @FXML
    private Label showFeedbackApprovedbyTeacher;
    @FXML
    private Label Aim;
    @FXML
    private Label showModule1Aim;
    @FXML
    private Label showModule1Obligatory;
    @FXML
    private Label showModule2Aim;
    private Paint blue;
    private Paint red;
    @FXML
    private Tab Module3;
    @FXML
    private Circle circlemodule3;
    @FXML
    private Circle circleApproved;
    @FXML
    private Label showTrueOrFalseModule3;

    
    
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

    @FXML
    private void handleModule2Task(Event event) {
         ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(2);
        if(moduleDataModel.getModule_Obligatory() == true)
        {
            this.circleApproved.setFill(Color.GREEN);
        }
        if(moduleDataModel.getModule_ID() != 0)
        {
            this.showModule2Name.setText(moduleDataModel.getModule_Name());
            this.showModule2Task.setText(moduleDataModel.getModule_Task());
            this.showModule2Aim.setText(moduleDataModel.getModule_Aim());
           
            //this.setText(DateFormat.getDateInstance().format(moduleDataModel.getModule_Deadline())); 
        }
        else
            this.showModule2Name.setText("This does not work today"); 
    }

    @FXML
    private void handleModule1Task(Event event) {
        
        ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(1);
         if (moduleDataModel.getModule_Obligatory() == true);
         {
             this.test.setFill(Color.GREEN);
         }
          
        if(moduleDataModel.getModule_ID() != 0)
        {
            this.showModule1Name.setText(moduleDataModel.getModule_Name());
            this.showModule1Task.setText(moduleDataModel.getModule_Task());
            this.showModule1Resources.setText(moduleDataModel.getModule_Resources());
            this.showModule1Aim.setText(moduleDataModel.getModule_Aim());       
            this.showModuleFrist.setText(DateFormat.getDateInstance().format(moduleDataModel.getModule_Deadline()));
        }
        else
            System.out.println("lol");
        /*
        this.showModule1Name.setText(this.moduleManager.getModuleNameByInt(1));
        this.showModule1Task.setText(this.moduleManager.getModuleTaskByInt(1));
        this.showModule1Resources.setText(this.moduleManager.getModuleResourcesByInt(1));
        */
    }   

    @FXML
    private void handleModule3Task(Event event) {
        
       // ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(1);
       if (feedbackManager.getFeedbackByID(1) == true)
       this.showTrueOrFalseModule3.setText(feedbackManager.getFeedbackByID(1).toString());
       this.circlemodule3.setFill(Color.GREEN);
        
       /* if (moduleDataModel.getModule_ID() == 1 )
      {
          this.circlemodule3.setFill(Color.AQUA);
          System.out.println(moduleDataModel.getModule_ID());
      }
      
       else 
       {
           System.out.println("Dette går ikke kompis");
       } 
   
      /*FeedbackDataModel feedbackDataModel = this.feedbackManager.getFeedbackByID(1);
       if(feedbackDataModel.getFeedback_ID() != 0)
       {
            this.circlemodule3.setFill(Color.GREEN);
            
       }*/ 
       

    }

}