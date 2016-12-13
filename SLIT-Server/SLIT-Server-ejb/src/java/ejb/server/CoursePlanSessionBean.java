/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import Common.DataModelConverter;
import DataModel.CoursePlanDataModel;
import EntityClasses.CoursePlan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Johnjnsen
 */
@Stateless
public class CoursePlanSessionBean implements CoursePlanSessionBeanRemote {

    @PersistenceContext(unitName = "SLIT-Server-ejbPU")
    private EntityManager em;
    
    
    @Override
    public int getCoursePlanByInt(int coursePlanID) {
        return em.find(CoursePlan.class, coursePlanID).getCoursePlanID();
    }
    
    @Override
    public CoursePlanDataModel getCoursePlanByID(int coursePlanID) {
        
        CoursePlanDataModel coursePlanDataModel = new CoursePlanDataModel();
        
        try 
        {
            CoursePlan coursePlan = em.find(CoursePlan.class, coursePlanID);
        
            
            if (coursePlan != null) {
                
                coursePlanDataModel = DataModelConverter.convertCoursePlanEntityToCoursePlanDataModel(coursePlan);
                
            }
                
        
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        
        return coursePlanDataModel;
    }
}

   