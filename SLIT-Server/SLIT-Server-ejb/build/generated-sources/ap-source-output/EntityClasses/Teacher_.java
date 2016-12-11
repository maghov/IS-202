package EntityClasses;

import EntityClasses.ApprovalQueue;
import EntityClasses.Delivery;
import EntityClasses.Feedback;
import EntityClasses.Module;
import EntityClasses.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T12:19:26")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, Integer> teacheruserID;
    public static volatile CollectionAttribute<Teacher, Delivery> deliveryCollection;
    public static volatile SingularAttribute<Teacher, String> teacherOffice;
    public static volatile CollectionAttribute<Teacher, Feedback> feedbackCollection;
    public static volatile CollectionAttribute<Teacher, Module> moduleCollection;
    public static volatile SingularAttribute<Teacher, ApprovalQueue> fKapprovalQueueID;
    public static volatile SingularAttribute<Teacher, Users> users;

}