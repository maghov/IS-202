/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import ejb.server.ModuleSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Mohammad
 */
public class ModuleHandler {

    private ModuleSessionBeanRemote lookupModuleSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ModuleSessionBeanRemote) c.lookup("java:comp/env/ModuleSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    public void getModuleMethod () 
    {
        this.lookupModuleSessionBeanRemote().getModuleNameByInt(1);
        this.lookupModuleSessionBeanRemote().getModuleTaskByInt(1);
        this.lookupModuleSessionBeanRemote().getModuleResourcesByInt(1);
        
    }
    
    
}
