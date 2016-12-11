package EntityClasses;

import EntityClasses.ApprovalQueue;
import EntityClasses.Feedback;
import EntityClasses.Student;
import EntityClasses.Teacher;
import EntityClasses.Tutor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-10T23:17:24")
@StaticMetamodel(Delivery.class)
public class Delivery_ { 

    public static volatile SingularAttribute<Delivery, Teacher> teacheruserID;
    public static volatile SingularAttribute<Delivery, Integer> deliveryID;
    public static volatile SingularAttribute<Delivery, Tutor> tutoruserID;
    public static volatile CollectionAttribute<Delivery, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Delivery, String> deliveryComment;
    public static volatile SingularAttribute<Delivery, Date> deliveryDate;
    public static volatile SingularAttribute<Delivery, String> deliveryName;
    public static volatile SingularAttribute<Delivery, Boolean> deliveryStatus;
    public static volatile SingularAttribute<Delivery, ApprovalQueue> fKapprovalQueueID;
    public static volatile SingularAttribute<Delivery, Student> studentuserID;

}