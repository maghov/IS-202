/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLIT;

import DataModel.DeliveryDataModel;
import DataModel.FeedbackDataModel;
import DataModel.ModuleDataModel;
import DataModel.TeacherDataModel;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javafx.scene.shape.Circle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLIS109Controller implements Initializable {

    @FXML
    private Tab Module1;
    private Label showModule1Name;
    private Label showModule1Task;
    @FXML
    private Tab Module2;
    private Label showModule2Name;
    private Label showModule2Task;

    private final ModuleManager moduleManager = new ModuleManager();

    private final DeliveryManager deliveryManager = new DeliveryManager();

    private final FeedbackManager feedbackManager = new FeedbackManager();

    private final UserManager userManager = new UserManager();

    public static UserDataModel user;

    private Label showModule1Resources;
    private Label showModuleFrist;
    private Circle test;
    private Label showModule1Aim;
    private Label showModule2Aim;
    private Paint blue;
    private Paint red;
    private Circle circlemodule3;
    private Circle circleApproved;
    private Label showTrueOrFalseModule3;
    @FXML
    private Tab Module4;
    private TableView<FeedbackDataModel> feedbackList;
    private TableColumn<FeedbackDataModel, String> FeedBackFrom;
    private TableColumn<FeedbackDataModel, String> FeedBackComment;
    private TableColumn<FeedbackDataModel, String> FeedBackDate;
    private TableColumn<FeedbackDataModel, Boolean> FeedBackStatus;

    @FXML
    private Label showModule5Name;
    private Label showModule5Task;
    private Label showModule5Obligatory;
    private Label showModule5Resources;
    private Label showModule5Deadline;
    private Label showModule5Aim;
    private Label showModule5Feedback;
    private Circle showModule5Approved;
    @FXML
    private Tab IS109;
    @FXML
    private TableColumn<?, ?> moduleName;
    @FXML
    private TableColumn<?, ?> moduleBeskrivelse;
    @FXML
    private TableColumn<?, ?> moduleObligatorisk;
    @FXML
    private TableColumn<?, ?> moduleFrist;
    @FXML
    private TableColumn<?, ?> moduleFulført;
    @FXML
    private Label showCoursePlanForelesning;
    @FXML
    private Label showCoursePlanPlan;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
            FeedBackFrom.setCellValueFactory(new Callback<CellDataFeatures<FeedbackDataModel, String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<FeedbackDataModel, String> param) {
                    return new SimpleStringProperty(param.getValue().getTeacher_user().getTeacher_user().getUser_FirstName());
                }
            });
            
            FeedBackDate.setCellValueFactory(new Callback<CellDataFeatures<FeedbackDataModel, String>,ObservableValue<String>>(){
                    
                @Override
                public ObservableValue<String> call(CellDataFeatures<FeedbackDataModel, String> param) {
                    return new SimpleStringProperty(DateFormat.getDateInstance().format(param.getValue().getFeedback_Date()));
                }
            });
            FeedBackComment.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, String> ("feedback_Comment"));
            //FeedBackDate.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, Date> ("feedback_Date"));
            FeedBackStatus.setCellValueFactory(new PropertyValueFactory<FeedbackDataModel, Boolean> ("feedback_Approved"));
                                                
       

            

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

       

    private void handleModule5Task(Event event) {
        ModuleDataModel moduleDataModel = this.moduleManager.getModuleById(3);
        FeedbackDataModel feedbackDataModel = this.feedbackManager.getFeedbackById(4);

        if (moduleDataModel.getModule_ID() != 0) {
            this.showModule5Name.setText(moduleDataModel.getModule_Name());
            this.showModule5Task.setText(moduleDataModel.getModule_Task());
            this.showModule5Resources.setText(moduleDataModel.getModule_Resources());
            this.showModule5Aim.setText(moduleDataModel.getModule_Aim());
            this.showModule5Deadline.setText(DateFormat.getDateInstance().format(moduleDataModel.getModule_Deadline()));
            
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

    @FXML
<<<<<<< HEAD
    private void handleIS109(Event event) {
=======
    private void handleLogOutTask(ActionEvent event) throws IOException, Exception {
        Parent LoginPage_page_parent = FXMLLoader.load(getClass().getResource("FXMLLoginPage.fxml"));
        Scene LoginPage_page_scene = new Scene(LoginPage_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(LoginPage_page_scene);
        app_stage.show();
>>>>>>> origin/develop
    }

}