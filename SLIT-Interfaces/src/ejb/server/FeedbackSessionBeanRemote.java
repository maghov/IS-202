/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;
import javax.ejb.Remote;
import DataModel.FeedbackDataModel;


/**
 *
 * @author Mohammad
 */
@Remote
public interface FeedbackSessionBeanRemote {
    
    FeedbackDataModel getFeedbackByID(int feedbackID);
}
