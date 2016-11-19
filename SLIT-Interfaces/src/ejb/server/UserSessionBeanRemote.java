/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import DataModel.FeedbackDataModel;
import DataModel.UserDataModel;
import SharedCommon.UserTypes;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Mohammad
 */
@Remote
public interface UserSessionBeanRemote {

    String businessMethod();
    
    boolean login(String username, String password);
    
    UserTypes getUserType(int userID);
    
    /**
     * 
     * @param username
     * @param password
     * @param name
     * @param mail
     * @return
     */
    boolean register(String username, String password, String firstName, String lastName, String mail, String Phone);
    
    
    
    UserDataModel loginUser(String username, String password);
   
}
