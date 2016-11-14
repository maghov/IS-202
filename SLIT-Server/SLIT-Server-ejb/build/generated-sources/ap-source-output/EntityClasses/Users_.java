package EntityClasses;

import EntityClasses.Student;
import EntityClasses.Teacher;
import EntityClasses.Tutor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T14:33:35")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> userPassword;
    public static volatile SingularAttribute<Users, Teacher> teacher;
    public static volatile SingularAttribute<Users, String> userUserName;
    public static volatile SingularAttribute<Users, Student> student;
    public static volatile SingularAttribute<Users, String> userLastName;
    public static volatile SingularAttribute<Users, String> userPhone;
    public static volatile SingularAttribute<Users, Boolean> userTutor;
    public static volatile SingularAttribute<Users, String> userEmail;
    public static volatile SingularAttribute<Users, String> userFirstName;
    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, Tutor> tutor;

}