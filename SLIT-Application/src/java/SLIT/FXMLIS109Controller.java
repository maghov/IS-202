/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLIT;

import DataModel.DeliveryDataModel;
import DataModel.FeedbackDataModel;
import DataModel.ModuleDataModel;
import DataModel.UserDataModel;
import Framework.DeliveryManager;
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
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private final DeliveryManager deliveryManager = new DeliveryManager();

    private final FeedbackManager feedbackManager = new FeedbackManager();

    private final UserManager userManager = new UserManager();

    public static UserDataModel user;

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
    @FXML
    private Tab Module4;
    @FXML
    private Label showModule4feedbackData;
    @FXML
<<<<<<< Updated upstream

    private Label showFeedbackModul4;
    @FXML
    private TableView<FeedbackDataModel> feedbackList;
    @FXML
    private TableColumn<FeedbackDataModel, String> FeedBackFrom;
    @FXML
    private TableColumn<FeedbackDataModel, String> FeedBackComment;
    @FXML
    private TableColumn<FeedbackDataModel, String> FeedBackDate;
    @FXML
    private TableColumn<FeedbackDataModel, String> FeedBackStatus;
=======
    private Label showModule5Name;
    @FXML
    private Label showModule5Task;
    @FXML
    private Label showModule5Obligatory;
    @FXML
    private Tab Module5;
    @FXML
    private Label showModule5Resources;
    @FXML
    private Label showModule5Deadline;
    @FXML
    private Label showModule5Aim;
    @FXML
    private Label showModule5Feedback;
    @FXML
    private Circle showModule5Approved;
>>>>>>> Stashed changes

    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< Updated upstream
            
            FeedBackFrom.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, String>("FK_teacher_user_ID"));
            FeedBackComment.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, String> ("feedback_Comment"));
            FeedBackDate.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, String> ("feedback_Date"));
            FeedBackStatus.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, String> ("feedback_Status"));
            
=======

>>>>>>> Stashed changes
    }

    @FXML
    private void handleBackTask(ActionEvent event) throws IOException {
        Parent VelgFag_page_parent = FXMLLoader.load(getClass().getResource("FXMLVelgFag.fxml"));
        Scene VelgFag_page_scene = new Scene(VelgFag_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(VelgFag_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleModule2Task(Event event) {
        ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(2);
        if (moduleDataModel.getModule_Obligatory() == true) {
            this.circleApproved.setFill(Color.GREEN);
        }
        if (moduleDataModel.getModule_ID() != 0) {
            this.showModule2Name.setText(moduleDataModel.getModule_Name());
            this.showModule2Task.setText(moduleDataModel.getModule_Task());
            this.showModule2Aim.setText(moduleDataModel.getModule_Aim());

            //this.setText(DateFormat.getDateInstance().format(moduleDataModel.getModule_Deadline())); 
        } else {
            this.showModule2Name.setText("This does not work today");
        }

    }

    @FXML
    private void handleModule1Task(Event event) {

        ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(1);
        if (moduleDataModel.getModule_Obligatory() == true);
        {
            this.test.setFill(Color.GREEN);
        }

        if (moduleDataModel.getModule_ID() != 0) {
            this.showModule1Name.setText(moduleDataModel.getModule_Name());
            this.showModule1Task.setText(moduleDataModel.getModule_Task());
            this.showModule1Resources.setText(moduleDataModel.getModule_Resources());
            this.showModule1Aim.setText(moduleDataModel.getModule_Aim());
            this.showModuleFrist.setText(DateFormat.getDateInstance().format(moduleDataModel.getModule_Deadline()));
        } else {
            System.out.println("lol");
        }
        /*
        this.showModule1Name.setText(this.moduleManager.getModuleNameByInt(1));
        this.showModule1Task.setText(this.moduleManager.getModuleTaskByInt(1));
        this.showModule1Resources.setText(this.moduleManager.getModuleResourcesByInt(1));
         */
    }

    @FXML
    private void handleModule3Task(Event event) {
        FeedbackDataModel feedbackDataModel = this.feedbackManager.getFeedbackById(1);

        if (feedbackDataModel.getFeedback_Approved() == true) {
            this.showTrueOrFalseModule3.setText("Godkjent");
            this.circlemodule3.setFill(Color.GREEN);
        } else if (this.feedbackManager.getFeedbackApprovedByInt(1) == false) {
            this.showTrueOrFalseModule3.setText("Ikke godkjent");
            System.out.println("modol ikke godkjent");
        } else {
            this.showTrueOrFalseModule3.setText("hei");
        }

        // ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(1);
        if (feedbackManager.getFeedbackApprovedByInt(1) == true) {
            this.showTrueOrFalseModule3.setText(feedbackManager.getFeedbackApprovedByInt(1).toString());
            this.circlemodule3.setFill(Color.GREEN);
        } else {
            System.out.println("model ikke godkjent");
        }


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
        //ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(1);
        if (feedbackManager.getFeedbackApprovedByInt(1) == true) {
            this.showTrueOrFalseModule3.setText(feedbackManager.getFeedbackApprovedByInt(1).toString());
            this.circlemodule3.setFill(Color.GREEN);
        } else {
            System.out.println("Mo er kul");
        }

    }

    @FXML
    private void handleModule4Task(Event event) throws Exception {
<<<<<<< Updated upstream
        
       FeedbackManager feedbackmanager = new FeedbackManager();
       
       List<FeedbackDataModel> list = feedbackmanager.getFeedbackForUser(1);
       
       ObservableList<FeedbackDataModel> observableList = FXCollections.observableArrayList();
       
       
       
       for(FeedbackDataModel entity : list)
       {
           observableList.add(entity); 
           //System.out.println(entity);
           //System.out.println("Test");
       }
       
       this.feedbackList.setItems(observableList);
    }
}
        
   /*FeedbackDataModel feedbackDataModel =  feedbackDataModel.getFeedback_ID();
=======

        //DeliveryDataModel deliveryDataModel = this.deliveryManager.getDeliveryById(1);
        List<FeedbackDataModel> feedbackDataModel = this.feedbackManager.getFeedbackForUser(1);

        this.showModule4feedbackData.setText(feedbackDataModel.toString());

    }

    @FXML
    private void handleModule5Task(Event event) {
        ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(3);
        FeedbackDataModel feedbackDataModel = this.feedbackManager.getFeedbackById(1);

        if (moduleDataModel.getModule_ID() != 0) {
            this.showModule5Name.setText(moduleDataModel.getModule_Name());
            this.showModule5Task.setText(moduleDataModel.getModule_Task());
            this.showModule5Resources.setText(moduleDataModel.getModule_Resources());
            //this.showModule5Deadline.setText(moduleDataModel.getModule_Deadline().toString()); #Viser Date på en dårlig måte
            this.showModule5Deadline.setText(DateFormat.getDateInstance().format(moduleDataModel.getModule_Deadline()));
            this.showModule5Aim.setText(moduleDataModel.getModule_Aim());
            this.showModule5Feedback.setText(feedbackDataModel.getFeedback_Comment());
            if (feedbackDataModel.getFeedback_Approved() == true) {
                
                this.showModule5Approved.setFill(Color.GREEN);
            }else{
                this.showModule5Approved.setFill(Color.RED);
            }
            if (moduleDataModel.getModule_Obligatory() == true) {  //gjør om True og False til ja og nei.

                this.showModule5Obligatory.setText("Ja");
            } else {
                this.showModule5Obligatory.setText("Nei");

            }
        } else {
            System.out.println("Denne Modulen Finnes Ikke.");
        }
    }

}

/*FeedbackDataModel feedbackDataModel =  feedbackDataModel.getFeedback_ID();
>>>>>>> Stashed changes
        FeedbackDataModel feedbackDataModel = this.feedbackManager.getFeedbackById(1);
        if (feedbackDataModel.getFeedback_ID() != 0){
            if (feedbackDataModel.getFeedback_Approved() == true);
                {
                    this.showModule4feedbackData.setText(feedbackDataModel.getFeedback_Comment());
                }
        }
    }
 */
