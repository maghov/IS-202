/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author Mohammad
 */
public class TeacherDataModel implements java.io.Serializable {
    
    private UserDataModel teacher_user;
    
    private String teacher_Office;
    
    private int FK_approvalQueue_ID;
    
    

    public UserDataModel getTeacher_user() {
        return teacher_user;
    }

    public void setTeacher_user(UserDataModel teacher_user_ID) {
        this.teacher_user = teacher_user_ID;
    }

    public String getTeacher_Office() {
        return teacher_Office;
    }

    public void setTeacher_Office(String teacher_Office) {
        this.teacher_Office = teacher_Office;
    }

    public int getFK_approvalQueue_ID() {
        return FK_approvalQueue_ID;
    }

    public void setFK_approvalQueue_ID(int FK_approvalQueue_ID) {
        this.FK_approvalQueue_ID = FK_approvalQueue_ID;
    }
    
    
    
}
