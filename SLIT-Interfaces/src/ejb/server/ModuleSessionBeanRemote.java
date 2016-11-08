/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Mohammad
 */
@Remote
public interface ModuleSessionBeanRemote {

    String getModuleNameByInt(int moduleID);
    

    String getModuleTaskByInt(int moduleID);
    
    String getModuleResourcesByInt(int moduleID);
            
     List<String> getAllModules();
}

