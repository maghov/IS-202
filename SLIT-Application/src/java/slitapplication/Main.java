/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitapplication;

import ejb.server.UserSessionBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Mohammad
 */
public class Main {

    @EJB
    private static UserSessionBeanRemote userSessionBean;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserHandler handler = new UserHandler(); 
        
        System.out.println(handler.getBusinessMethod());
    }
    
}
