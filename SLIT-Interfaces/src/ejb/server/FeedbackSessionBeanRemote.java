/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;
import javax.ejb.Remote;
import DataModel.FeedbackDataModel;
import java.util.List;


/**
 *
 * @author Mohammad
 */
@Remote
public interface FeedbackSessionBeanRemote {
   
   Boolean getFeedbackApprovedByInt(int feedbackID);
   FeedbackDataModel getFeedbackById(int feedbackID);
   int getFeedbackID(int feedbackID);
   List<FeedbackDataModel> getFeedbackForUser(int deliveryID, int userID);
}
