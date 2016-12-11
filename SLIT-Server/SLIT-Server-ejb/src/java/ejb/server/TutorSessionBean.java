/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;
import EntityClasses.Tutor;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Johnjnsen
 */
@Stateless
public class TutorSessionBean implements TutorSessionBeanRemote {
    
    @PersistenceContext(unitName = "SLIT-Server-ejbPU")
        private EntityManager em;
    
    @Override 
    public int getTutorUserByTutorID(int tutorID) {
        return em.find(Tutor.class, tutorID).getTutoruserID();
    }

}

