package EntityClasses;

import EntityClasses.Feedback;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T20:38:08")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:50:12")
>>>>>>> Stashed changes
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, String> notificationTitle;
    public static volatile SingularAttribute<Notification, Feedback> fKfeedbackID;
    public static volatile SingularAttribute<Notification, String> notificationText;
    public static volatile SingularAttribute<Notification, Integer> notificationID;
    public static volatile SingularAttribute<Notification, Date> notificationDate;

}