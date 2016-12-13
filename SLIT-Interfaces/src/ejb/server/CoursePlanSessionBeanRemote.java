/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import DataModel.CoursePlanDataModel;
import DataModel.DeliveryDataModel;
import javax.ejb.Remote;

/**
 *
 * @author Johnjnsen
 */
@Remote
public interface CoursePlanSessionBeanRemote {
    
   int getCoursePlanByInt(int coursePlanID);
   public CoursePlanDataModel getCoursePlanByID(int coursePlanID);
    
}
