package EntityClasses;

import EntityClasses.Delivery;
import EntityClasses.Teacher;
import EntityClasses.Tutor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T11:59:36")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T13:44:17")
>>>>>>> Stashed changes
@StaticMetamodel(ApprovalQueue.class)
public class ApprovalQueue_ { 

    public static volatile CollectionAttribute<ApprovalQueue, Delivery> deliveryCollection;
    public static volatile SingularAttribute<ApprovalQueue, Integer> approvalQueueID;
    public static volatile CollectionAttribute<ApprovalQueue, Tutor> tutorCollection;
    public static volatile CollectionAttribute<ApprovalQueue, Teacher> teacherCollection;

}