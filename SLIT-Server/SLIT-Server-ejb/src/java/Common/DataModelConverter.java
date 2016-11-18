/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import DataModel.FeedbackDataModel;
import DataModel.ModuleDataModel;
import DataModel.StudentDataModel;
import DataModel.TeacherDataModel;
import DataModel.UserDataModel;
import EntityClasses.Feedback;
import EntityClasses.Module;
import EntityClasses.Student;
import EntityClasses.Teacher;
import EntityClasses.Users;

/**
 *
 * @author Mohammad
 */
public class DataModelConverter {
    
    
    
    public static ModuleDataModel convertModuleEntityToModuleDataModel(Module module) {
        
        ModuleDataModel moduleDataModel = new ModuleDataModel();
        
        moduleDataModel.setModule_ID(module.getModuleID().intValue());
        moduleDataModel.setModule_Aim(module.getModuleAim());
        moduleDataModel.setModule_Deadline(module.getModuleDeadline());
        moduleDataModel.setModule_Name(module.getModuleName());
        moduleDataModel.setModule_Obligatory(module.getModuleObligatory());
        moduleDataModel.setModule_Resources(module.getModuleResources());
        moduleDataModel.setModule_Task(module.getModuleTask());
        
        
        if (module.getTeacheruserID() != null)
        {
            TeacherDataModel teacherDataModel = new TeacherDataModel();
            
            Teacher teacher = module.getTeacheruserID();
            
            teacherDataModel = convertTeacherEntityToTeacherDataModel(teacher);
            
            moduleDataModel.setTeacher_user(teacherDataModel);
            
            //moduleDataModel.setTeacher_user(convertTeacherEntityToTeacherDataModel(module.getTeacheruserID()));
            
        }
        
        return moduleDataModel;
    }
    
    public static UserDataModel convertUserEntityToUserDataModel(Users user) {
        
        UserDataModel userDataModel = new UserDataModel();
        
        userDataModel.setUser_FirstName(user.getUserFirstName());
        userDataModel.setUser_LastName(user.getUserLastName());
        userDataModel.setUser_Password(user.getUserPassword());
        userDataModel.setUser_Phone(user.getUserPhone());
        userDataModel.setUser_UserName(user.getUserUserName());
        userDataModel.setUser_Email(user.getUserEmail());
        userDataModel.setUser_ID(user.getUserID());
        
        return userDataModel;
        
    }
    
    public static Users convertUserDataModelToUserEntity(UserDataModel userDataModel) {
        
        Users user = new Users();
        
        user.setUserFirstName(userDataModel.getUser_FirstName());
        
        user.setUserLastName(userDataModel.getUser_LastName());
        
        user.setUserPassword(userDataModel.getUser_Password());
 
        user.setUserEmail(userDataModel.getUser_Email());
        
        user.setUserID(userDataModel.getUser_ID());
        
        user.setUserPhone(userDataModel.getUser_Phone());
        
   
        return user;
        
    }
    
    
    public static TeacherDataModel convertTeacherEntityToTeacherDataModel(Teacher teacher) {
        
        TeacherDataModel teacherDataModel = new TeacherDataModel();
        
        Users user = teacher.getUsers();
        
        UserDataModel userDataModel = new UserDataModel();
        
        userDataModel = convertUserEntityToUserDataModel(user);
        
        teacherDataModel.setTeacher_user(userDataModel);
        
        teacherDataModel.setTeacher_Office(teacher.getTeacherOffice());
        
        teacherDataModel.setFK_approvalQueue_ID(teacher.getFKapprovalQueueID().getApprovalQueueID());
        
        //teacherDataModel.setTeacher_user(DataModelConverter.convertUserEntityToUserDataModel(teacher.getUsers()));
        
        return teacherDataModel;
        
    }
    
    public static StudentDataModel convertStudentEntityToStudentDataModel(Student student) {
        
        StudentDataModel studentDataModel = new StudentDataModel();
        
        studentDataModel.setStudent_user(DataModelConverter.convertUserEntityToUserDataModel(student.getUsers()));
        
        return studentDataModel;
    
    }
    public static FeedbackDataModel convertFeedbackEntityToFeedbackDataModel(Feedback feedback) {
        
        
        FeedbackDataModel feedbackDataModel = new FeedbackDataModel();
        
        feedbackDataModel.setFeedback_Approved(feedback.getFeedbackApproved());
        
        feedbackDataModel.setFeedback_Comment(feedback.getFeedbackComment());
        
        feedbackDataModel.setFeedback_Date(feedback.getFeedbackDate());
        
        feedbackDataModel.setFeedback_HiddenComment(feedback.getFeedbackHiddenComment());
        
        feedbackDataModel.setFeedback_ID(feedback.getFeedbackID());
        
        //teacherDataModel.setTeacher_user(DataModelConverter.convertUserEntityToUserDataModel(teacher.getUsers()));
        
        return feedbackDataModel;
              
        
    }
}
    
    
    
   