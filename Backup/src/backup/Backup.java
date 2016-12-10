/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import javafx.event.Event;

/**
 *
 * @author EirikOliversen
 */
public class Backup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
  
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
        
        
        
    }
    
}
