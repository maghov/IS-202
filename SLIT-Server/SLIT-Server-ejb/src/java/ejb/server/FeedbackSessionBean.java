/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import Common.DataModelConverter;
import DataModel.FeedbackDataModel;
import EntityClasses.Feedback;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}