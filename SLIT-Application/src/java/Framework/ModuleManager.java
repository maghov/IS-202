/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.ModuleDataModel;
import ejb.server.ModuleSessionBeanRemote;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Mohammad
 */
public class ModuleManager {

    private ModuleSessionBeanRemote lookupModuleSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ModuleSessionBeanRemote) c.lookup("java:global/SLIT-Server-ejb/ModuleSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public String getModuleNameByInt(int moduleID) 
    {
        return this.lookupModuleSessionBeanRemote().getModuleNameByInt(moduleID);
    }
    

     public String getModuleTaskByInt(int moduleID) 
    {
        return this.lookupModuleSessionBeanRemote().getModuleTaskByInt(moduleID);
    }
     
     public String getModuleResourcesByInt(int moduleID) 
    {
        return this.lookupModuleSessionBeanRemote().getModuleResourcesByInt(moduleID);
    }
    
    public Date getModuleDeadlineByInt(int moduleID) 
    {
        return this.lookupModuleSessionBeanRemote().getModuleDeadlineByInt(moduleID);
    }
    
    public ModuleDataModel getModuleById(int moduleID)
    {
        return this.lookupModuleSessionBeanRemote().getModuleById(moduleID); 
        
    }

    public List<String> getAllModules()
    {
        return this.lookupModuleSessionBeanRemote().getAllModules(); 
    }
  
}
