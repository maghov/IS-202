/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.Date;

/**
 *
 * @author Johnjnsen
 */
public class CoursePlanDataModel {
   
    public int coursePlan_ID;
    
    public String coursePlan_Name;
    
    public Date coursePlan_Forelesning;
    
    public String coursePlan_Plan;
    
    

    public int getCoursePlan_ID() {
        return coursePlan_ID;
    }

    public void setCoursePlan_ID(int coursePlan_ID) {
        this.coursePlan_ID = coursePlan_ID;
    }

    public String getCoursePlan_Name() {
        return coursePlan_Name;
    }

    public void setCoursePlan_Name(String coursePlan_Name) {
        this.coursePlan_Name = coursePlan_Name;
    }

    public Date getCoursePlan_Forelesning() {
        return coursePlan_Forelesning;
    }

    public void setCoursePlan_Forelesning(Date coursePlan_Forelesning) {
        this.coursePlan_Forelesning = coursePlan_Forelesning;
    }

    public String getCoursePlan_Plan() {
        return coursePlan_Plan;
    }

    public void setCoursePlan_Plan(String coursePlan_Plan) {
        this.coursePlan_Plan = coursePlan_Plan;
    }
    
    
 
    
}
