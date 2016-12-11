package EntityClasses;

import EntityClasses.Delivery;
import EntityClasses.Teacher;
import EntityClasses.Tutor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T12:19:26")
@StaticMetamodel(ApprovalQueue.class)
public class ApprovalQueue_ { 

    public static volatile CollectionAttribute<ApprovalQueue, Delivery> deliveryCollection;
    public static volatile SingularAttribute<ApprovalQueue, Integer> approvalQueueID;
    public static volatile CollectionAttribute<ApprovalQueue, Tutor> tutorCollection;
    public static volatile CollectionAttribute<ApprovalQueue, Teacher> teacherCollection;

}