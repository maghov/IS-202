/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import ejb.server.FeedbackSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Mohammad
 */
public class FeedbackManager {

    private FeedbackSessionBeanRemote lookupFeedbackSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (FeedbackSessionBeanRemote) c.lookup("java:global/SLIT-Server-ejb/FeedbackSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public boolean getFeedBackApproved(boolean feedbackApproved) 
    {
        return this.lookupFeedbackSessionBeanRemote().getFeedbackApproved(feedbackApproved);
    }
    
}
