/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import Common.DataModelConverter;
import DataModel.FeedbackDataModel;
import EntityClasses.Feedback;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class FeedbackSessionBean implements FeedbackSessionBeanRemote {

    @PersistenceContext(unitName = "SLIT-Server-ejbPU")
    private EntityManager em;
    
    @Override
    public Boolean getFeedbackApprovedByInt(int feedbackID) {
        return em.find(Feedback.class, feedbackID).getFeedbackApproved();
    }
    
    @Override
    public int getFeedbackID(int feedbackID) {
        return em.find(Feedback.class, feedbackID).getFeedbackID();
    }
    
    @Override 
    public List<FeedbackDataModel> getFeedbackForUser(int deliveryID, int userID ) {
        List<FeedbackDataModel> feedbackReturnList = new ArrayList<FeedbackDataModel>();
        
        try {
            Query query = em.createQuery("SELECT f FROM Feedback f WHERE f.studentuserID = :userID AND f.fKdeliveryID = :deliveryID");
            
            query.setParameter("userID", userID);
            query.setParameter("deliveryID", deliveryID);
            
            List<Feedback> feedbackQueryResult = query.getResultList();
            
            for (Feedback feedback : feedbackQueryResult) {
                feedbackReturnList.add(DataModelConverter.convertFeedbackEntityToFeedbackDataModel(feedback));
            }
            
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return feedbackReturnList;
               
    }
            
    
    @Override
    public FeedbackDataModel getFeedbackById(int feedbackID) {
        
        FeedbackDataModel feedbackDataModel = new FeedbackDataModel();
        
        try 
        {
            Feedback feedback = em.find(Feedback.class, feedbackID);
        
            
            if (feedback != null) {
                
                feedbackDataModel = DataModelConverter.convertFeedbackEntityToFeedbackDataModel(feedback);
                
            }
                
        
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return feedbackDataModel;
    }

}