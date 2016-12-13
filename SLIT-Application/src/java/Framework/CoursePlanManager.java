/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.CoursePlanDataModel;
import ejb.server.CoursePlanSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Johnjnsen
 */
public class CoursePlanManager {
    
    private CoursePlanSessionBeanRemote lookupCoursePlanSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (CoursePlanSessionBeanRemote) c.lookup("java:global/SLIT-Server-ejb/CoursePlanSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
      public int getCoursePlanByInt(int coursePlanID)
    {
        return this.lookupCoursePlanSessionBeanRemote().getCoursePlanByInt(coursePlanID);
      
    }
      
      public CoursePlanDataModel getCoursePlanByID(int coursePlanID) {
          return this.lookupCoursePlanSessionBeanRemote().getCoursePlanByID(coursePlanID);
      }
      
      
    
}
