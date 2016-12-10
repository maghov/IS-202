/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import Common.DataModelConverter;
import DataModel.UserDataModel;
import EntityClasses.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import Common.DataModelConverter;
import EntityClasses.Student;
import EntityClasses.Teacher;
import SharedCommon.UserTypes;
import javax.persistence.Query;




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
    public UserTypes getUserType(int userID) {
        
        if (this.isUserStudent(userID)) {
            return UserTypes.Student;
           
        }
        else if(this.isUserTeacher(userID)){
            return UserTypes.Teacher;
        }
        else if(this.isUserTutor(userID))
        {
            return UserTypes.Tutor;
        }
        return null; 
    }
    
    public boolean isUserStudent(int userID) {
        
        TypedQuery<Student> query = em.createNamedQuery("Student.findByStudentuserID", Student.class);
        
        query.setParameter("studentuserID", userID);
        
        List<Student> result = query.getResultList();
        
        
        if (result.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
        
    
    public boolean isUserTeacher(int userID) {
        
        
        TypedQuery<Teacher> query = em.createNamedQuery("Teacher.findByTeacheruserID", Teacher.class);
        
        query.setParameter("teacheruserID", userID);
        
        List<Teacher> result = query.getResultList();
        
        
        if (result.size() > 0) {
            return true;
        }
        else {
            return false;
        }
        }
    
    
    public boolean isUserTutor(int userID) {
        
        return true;
        
    }
    
    
    @Override
    public UserDataModel loginUser(String username, String password) {
        
        UserDataModel user = new UserDataModel();
        
        TypedQuery<Users> query = em.createNamedQuery("Users.login", Users.class); 
        query.setParameter("userUserName", username);
        query.setParameter("userPassword", password);
        
        try 
        {
            List<Users> userlist = query.getResultList();
           
            if(userlist.size() > 0) {
                user = DataModelConverter.convertUserEntityToUserDataModel(userlist.get(0));
                
                
            }
                
 
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return user;
        
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
            
            Users registeredUser = this.getUserFromMail(user.getUserEmail()); 
            
            if(registeredUser != null)
            {
                System.out.println("Registered user:" + registeredUser.getUserID()); 
                
                Student student = new Student();
                student.setUsers(registeredUser);
                student.setStudentuserID(registeredUser.getUserID());
                
                Query query = em.createQuery("INSERT INTO Student VALUES(:userid)"); 
                
                query.setParameter("userid", registeredUser.getUserID()); 
               
                //em.persist(student);
            }
            
            //student.setStudentuserID(this.getUserFromMail(user.getUserEmail()).getUserID());  
            
            //em.persist(student);
            
            return true; 
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return false; 
    }
   
    public Users getUserFromMail(String mail)
    {
        Query query = em.createNamedQuery("Users.findByUserEmail", Users.class); 
        query.setParameter("userEmail", mail); 
        
        try 
        {
            Users user = (Users)query.getSingleResult(); 
            
            return user; 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null; 
    }
      
        
  
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}