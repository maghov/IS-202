/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import javax.ejb.Stateless;

/**
 *
 * @author Mohammad
 */
@Stateless
public class UserSessionBean implements UserSessionBeanRemote {

    @Override
    public String businessMethod() {
        return "Test";
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
