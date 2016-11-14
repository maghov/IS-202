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
public class StudentDataModel implements java.io.Serializable {
    
    private UserDataModel student_user;
    
   private TeacherDataModel teacher_user;
   
    private int fk_UserStudent; 
    

    public UserDataModel getStudent_user() {
        return student_user;
    }

    public void setStudent_user(UserDataModel student_user) {
        this.student_user = student_user;
    }

    public int getFk_UserStudent() {
        return fk_UserStudent;
    }

    public void setFk_UserStudent(int fk_UserStudent) {
        this.fk_UserStudent = fk_UserStudent;
    }
    

    

    
    
    
}
