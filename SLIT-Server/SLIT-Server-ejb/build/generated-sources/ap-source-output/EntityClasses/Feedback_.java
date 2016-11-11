package EntityClasses;

import EntityClasses.Delivery;
import EntityClasses.Notification;
import EntityClasses.Student;
import EntityClasses.Teacher;
import EntityClasses.Tutor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-11T17:21:13")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Teacher> teacheruserID;
    public static volatile CollectionAttribute<Feedback, Notification> notificationCollection;
    public static volatile SingularAttribute<Feedback, Delivery> fKdeliveryID;
    public static volatile SingularAttribute<Feedback, Boolean> feedbackApproved;
    public static volatile SingularAttribute<Feedback, Tutor> tutoruserID;
    public static volatile SingularAttribute<Feedback, String> feedbackHiddenComment;
    public static volatile SingularAttribute<Feedback, Date> feedbackDate;
    public static volatile SingularAttribute<Feedback, Integer> feedbackID;
    public static volatile SingularAttribute<Feedback, String> feedbackComment;
    public static volatile SingularAttribute<Feedback, Student> studentuserID;

}