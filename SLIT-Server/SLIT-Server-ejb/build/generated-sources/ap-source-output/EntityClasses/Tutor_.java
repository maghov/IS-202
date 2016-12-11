package EntityClasses;

import EntityClasses.ApprovalQueue;
import EntityClasses.Delivery;
import EntityClasses.Feedback;
import EntityClasses.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T12:19:26")
@StaticMetamodel(Tutor.class)
public class Tutor_ { 

    public static volatile CollectionAttribute<Tutor, Delivery> deliveryCollection;
    public static volatile SingularAttribute<Tutor, Integer> tutoruserID;
    public static volatile CollectionAttribute<Tutor, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Tutor, ApprovalQueue> fKapprovalQueueID;
    public static volatile SingularAttribute<Tutor, Users> users;

}