/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import java.util.Date;

/**
 *
 * @author Mohammad
 */
public class DeliveryDataModel {
    
    public int delivery_ID;
    
    public String delivery_Name;
    
    public String delivery_Comment;
    
    public Boolean delivery_Status;
    
    public Date delivery_Date;
    
    public int student_user_ID;
    
    public int teacher_user_ID;
    
    public int tutor_user_ID;
    
    public int FK_approvalQueue_ID;

    public int getDelivery_ID() {
        return delivery_ID;
    }

    public void setDelivery_ID(int delivery_ID) {
        this.delivery_ID = delivery_ID;
    }

    public String getDelivery_Name() {
        return delivery_Name;
    }

    public void setDelivery_Name(String delivery_Name) {
        this.delivery_Name = delivery_Name;
    }

    public String getDelivery_Comment() {
        return delivery_Comment;
    }

    public void setDelivery_Comment(String delivery_Comment) {
        this.delivery_Comment = delivery_Comment;
    }

    public Boolean getDelivery_Status() {
        return delivery_Status;
    }

    public void setDelivery_Status(Boolean delivery_Status) {
        this.delivery_Status = delivery_Status;
    }

    public Date getDelivery_Date() {
        return delivery_Date;
    }

    public void setDelivery_Date(Date delivery_Date) {
        this.delivery_Date = delivery_Date;
    }

    public int getStudent_user_ID() {
        return student_user_ID;
    }

    public void setStudent_user_ID(int student_user_ID) {
        this.student_user_ID = student_user_ID;
    }

    public int getTeacher_user_ID() {
        return teacher_user_ID;
    }

    public void setTeacher_user_ID(int teacher_user_ID) {
        this.teacher_user_ID = teacher_user_ID;
    }

    public int getTutor_user_ID() {
        return tutor_user_ID;
    }

    public void setTutor_user_ID(int tutor_user_ID) {
        this.tutor_user_ID = tutor_user_ID;
    }

    public int getFK_approvalQueue_ID() {
        return FK_approvalQueue_ID;
    }

    public void setFK_approvalQueue_ID(int FK_approvalQueue_ID) {
        this.FK_approvalQueue_ID = FK_approvalQueue_ID;
    }
    
    
    
    
}