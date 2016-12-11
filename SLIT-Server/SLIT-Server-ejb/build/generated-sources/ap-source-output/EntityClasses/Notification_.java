package EntityClasses;

import EntityClasses.Feedback;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-10T23:17:24")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, String> notificationTitle;
    public static volatile SingularAttribute<Notification, Feedback> fKfeedbackID;
    public static volatile SingularAttribute<Notification, String> notificationText;
    public static volatile SingularAttribute<Notification, Integer> notificationID;
    public static volatile SingularAttribute<Notification, Date> notificationDate;

}