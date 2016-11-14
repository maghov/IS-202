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
public class ModuleDataModel implements java.io.Serializable {
    
    private int module_ID;
    
    private String module_Name;
    
    private String module_Task;
    
    private String module_Resources;
    
    private String module_Aim;
    
    private Date module_Deadline;
    
    private boolean module_Obligatory;
    
    private TeacherDataModel teacher_user;
    
    

    public int getModule_ID() {
        return module_ID;
    }

    public void setModule_ID(int module_ID) {
        this.module_ID = module_ID;
    }

    public String getModule_Name() {
        return module_Name;
    }

    public void setModule_Name(String module_Name) {
        this.module_Name = module_Name;
    }

    public String getModule_Task() {
        return module_Task;
    }

    public void setModule_Task(String module_Task) {
        this.module_Task = module_Task;
    }

    public String getModule_Resources() {
        return module_Resources;
    }

    public void setModule_Resources(String module_Resources) {
        this.module_Resources = module_Resources;
    }

    public String getModule_Aim() {
        return module_Aim;
    }

    public void setModule_Aim(String module_Aim) {
        this.module_Aim = module_Aim;
    }

    public Date getModule_Deadline() {
        return module_Deadline;
    }

    public void setModule_Deadline(Date module_Deadline) {
        this.module_Deadline = module_Deadline;
    }

    public boolean isModule_Obligatory() {
        return module_Obligatory;
    }

    public void setModule_Obligatory(boolean module_Obligatory) {
        this.module_Obligatory = module_Obligatory;
    }

    public TeacherDataModel getTeacher_user() {
        return teacher_user;
    }

    public void setTeacher_user(TeacherDataModel teacher_user) {
        this.teacher_user = teacher_user;
    }

    
    
    
    
}
