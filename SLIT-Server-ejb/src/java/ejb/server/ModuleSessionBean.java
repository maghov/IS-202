/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import EntityClasses.Module;
import java.util.ArrayList;
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
    public String getModuleNameByInt(int modulId) {
        return em.find(Module.class, modulId).getTittel(); 
        //System.out.println(em.find(Module.class, modulId).getTittel());
        
    }
    
    @Override 
    public List<String> getAllModules() 
    {
        TypedQuery<Module> query = em.createNamedQuery("Module.findAll", Module.class); 
        
        List<Module> entites = query.getResultList(); 
        
        List<String> result = new ArrayList<String>(); 
        
        for(Module module : entites)
        {
            result.add(module.getTittel()); 
        }
        
        return result; 
 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
    
}
