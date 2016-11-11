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
public class UserDataModel implements java.io.Serializable {
    
    private int user_ID;
        
    private String user_UserName;

    private String user_Password;

    private String user_FirstName;

    private String user_LastName;

    private String user_Email;

    private String user_Phone;
    

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_UserName() {
        return user_UserName;
    }

    public void setUser_UserName(String user_UserName) {
        this.user_UserName = user_UserName;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public String getUser_FirstName() {
        return user_FirstName;
    }

    public void setUser_FirstName(String user_FirstName) {
        this.user_FirstName = user_FirstName;
    }

    public String getUser_LastName() {
        return user_LastName;
    }

    public void setUser_LastName(String user_LastName) {
        this.user_LastName = user_LastName;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }
        
        
        
}
