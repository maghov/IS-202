/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

/**
 *
 * @author Johnjnsen
 */
public interface TutorSessionBeanRemote {
    int getTutorUserByTutorID(int tutorID);
    
}
