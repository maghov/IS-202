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
public class FeedbackDataModel {
    
    private UserDataModel teacher_user;
    
    private int feedback_ID;
    
    private String feedback_Comment;
    
    private String feedback_HiddenComment;
    
    private Date feedback_Date;
    
    private Boolean feedback_Approved;
    
    private UserDataModel student_user_ID;
    
    private int teacher_user_ID;
    
    private int tutor_user_ID;
    
    private int FK_delivery_ID;

    public UserDataModel getTeacher_user() {
        return teacher_user;
    }

    public void setTeacher_user(UserDataModel teacher_user) {
        this.teacher_user = teacher_user;
    }

    public int getFeedback_ID() {
        return feedback_ID;
    }

    public void setFeedback_ID(int feedback_ID) {
        this.feedback_ID = feedback_ID;
    }

    public String getFeedback_Comment() {
        return feedback_Comment;
    }

    public void setFeedback_Comment(String feedback_Comment) {
        this.feedback_Comment = feedback_Comment;
    }

    public String getFeedback_HiddenComment() {
        return feedback_HiddenComment;
    }

    public void setFeedback_HiddenComment(String feedback_HiddenComment) {
        this.feedback_HiddenComment = feedback_HiddenComment;
    }

    public Date getFeedback_Date() {
        return feedback_Date;
    }

    public void setFeedback_Date(Date feedback_Date) {
        this.feedback_Date = feedback_Date;
    }

    public Boolean getFeedback_Approved() {
        return feedback_Approved;
    }

    public void setFeedback_Approved(Boolean feedback_Approved) {
        this.feedback_Approved = feedback_Approved;
    }

    public UserDataModel getStudent_user_ID() {
        return student_user_ID;
    }

    public void setStudent_user_ID(UserDataModel student_user_ID) {
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

    public int getFK_delivery_ID() {
        return FK_delivery_ID;
    }

    public void setFK_delivery_ID(int FK_delivery_ID) {
        this.FK_delivery_ID = FK_delivery_ID;
    }
    

   
    
    

    

   
    
    
    
}
