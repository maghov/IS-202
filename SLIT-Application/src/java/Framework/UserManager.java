/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.UserDataModel;
import ejb.server.UserSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Mohammad
 */
public class UserManager {

    private UserSessionBeanRemote lookupUserSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (UserSessionBeanRemote) c.lookup("java:comp/env/UserSessionBean");
            return (UserSessionBeanRemote) c.lookup("java:global/SLIT-Server-ejb/UserSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
        
    public boolean login(String username, String password)
    {
        return this.lookupUserSessionBeanRemote().login(username, password);
    }
    
    public boolean register(String username, String password, String firstName, String lastName, String mail, String Phone) 
    {
        return this.lookupUserSessionBeanRemote().register(username, password, firstName, lastName, mail, Phone);
    }
    
    public UserDataModel loginUser(String username, String password) 
    {
        return this.lookupUserSessionBeanRemote().loginUser(username, password);
    }
    
    
}
