/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import Common.DataModelConverter;
import DataModel.ModuleDataModel;
import EntityClasses.Module;
import EntityClasses.Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author Mohammad
 */

@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "SLIT-Server-ejbPU")
    private EntityManager em;

    
    @Override
    public String getModuleNameByInt(int moduleID) {
        return em.find(Module.class, moduleID).getModuleName();
    }
    
    @Override
    public String getModuleTaskByInt(int moduleID) {
        return em.find(Module.class, moduleID).getModuleTask();
    }
   
    @Override
    public String getModuleResourcesByInt(int moduleID) {
        return em.find(Module.class, moduleID).getModuleResources();
    }
    
    
    @Override
    public Date getModuleDeadlineByInt(int moduleID) {
        return em.find(Module.class, moduleID).getModuleDeadline();
    }
    
    @Override
    public ModuleDataModel getModuleById(int moduleID) {
        
        ModuleDataModel moduleDataModel = new ModuleDataModel();
        
        try 
        {
            Module module = em.find(Module.class, moduleID);
        
            
            if (module != null) {
                
                moduleDataModel = DataModelConverter.convertModuleEntityToModuleDataModel(module);
                
            }
                
        
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return moduleDataModel;
      
        
        
    }
    
    
    

    
    @Override 
    public List<String> getAllModules() 
    {
        TypedQuery<Module> query = em.createNamedQuery("Module.findAll", Module.class); 
        
        List<Module> entites = query.getResultList(); 
        
        List<String> result = new ArrayList<>(); 
        
        for(Module module : entites)
        {
            result.add(module.getModuleName()); 
        }
        
        return result; 
 
    }
    
        
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

   
    
}
