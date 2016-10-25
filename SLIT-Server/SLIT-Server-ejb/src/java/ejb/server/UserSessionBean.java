/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import EntityClasses.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mohammad
 */

@Stateless
public class UserSessionBean implements UserSessionBeanRemote {

    @PersistenceContext(unitName = "SLIT-Server-ejbPU")
    private EntityManager em;
    
    @Override
    public String businessMethod() {
        return "Test";
    }
    
    
    @Override
    public boolean login(String username, String password) 
    {
        TypedQuery<Users> query = em.createNamedQuery("Users.login", Users.class); 
        query.setParameter("userUserName", username);
        query.setParameter("userPassword", password);
        
        try 
        {
            List<Users> user = query.getResultList();
           
            if(user.size() > 0)
                return true; 
            
            return false; 
 
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
            return false; 
        }

    }

    public boolean checkUserNameOrMail(String username, String mail)
    {
        TypedQuery<Users> query = em.createNamedQuery("Users.findByUserNameOrMail", Users.class); 
        query.setParameter("userUserName", username);
        query.setParameter("userEmail", mail); 
        
        try 
        {
             List<Users> user = query.getResultList();
           
            if(user.size() > 0)
                return true; 
            
            return false; 
        } 
        catch(Exception e) 
        {
            return false; 
        }
    }
    
    @Override
    public boolean register(String username, String password, String firstName, String lastName, String mail, String Phone)
    {
        System.out.println(this.checkUserNameOrMail(username, mail));
        if(this.checkUserNameOrMail(username, mail))
            return false;
        
        Users user = new Users(); 
        user.setUserFirstName(firstName);
        user.setUserLastName(lastName);
        user.setUserUserName(username);
        user.setUserPassword(password);
        user.setUserEmail(mail);
        user.setUserPhone(Phone);
        
        try 
        {
            em.persist(user);
            
            return true; 
        }
        catch(Exception e) 
        {
            return false;
        }
        
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}