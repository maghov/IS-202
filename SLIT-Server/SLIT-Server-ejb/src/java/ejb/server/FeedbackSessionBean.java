/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import EntityClasses.Feedback;
import EntityClasses.Module;
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
    public boolean getFeedbackApproved(boolean feedbackApproved) {
        return em.find(Feedback.class, feedbackApproved).getFeedbackApproved();
    }
    
    
    
}
