/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.DeliveryDataModel;
import ejb.server.DeliverySessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Mohammad
 */
public class DeliveryManager {
    
        private DeliverySessionBeanRemote lookupDeliverySessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (UserSessionBeanRemote) c.lookup("java:comp/env/UserSessionBean");
            return (DeliverySessionBeanRemote) c.lookup("java:global/SLIT-Server-ejb/DeliverySessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    public Boolean besvarelse(String deliveryName, String deliveryComment) {
        return this.lookupDeliverySessionBeanRemote().besvarelse(deliveryName, deliveryComment);
    }
    
        
        
}
