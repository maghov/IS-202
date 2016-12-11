package EntityClasses;

import EntityClasses.Delivery;
import EntityClasses.Feedback;
import EntityClasses.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T12:19:26")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile CollectionAttribute<Student, Delivery> deliveryCollection;
    public static volatile CollectionAttribute<Student, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Student, Integer> studentuserID;
    public static volatile SingularAttribute<Student, Users> users;

}