package EntityClasses;

import EntityClasses.Teacher;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T11:59:36")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T13:44:17")
>>>>>>> Stashed changes
@StaticMetamodel(Module.class)
public class Module_ { 

    public static volatile SingularAttribute<Module, String> moduleResources;
    public static volatile SingularAttribute<Module, Boolean> moduleObligatory;
    public static volatile SingularAttribute<Module, Teacher> teacheruserID;
    public static volatile SingularAttribute<Module, String> moduleTask;
    public static volatile SingularAttribute<Module, String> moduleAim;
    public static volatile SingularAttribute<Module, Date> moduleDeadline;
    public static volatile SingularAttribute<Module, String> moduleName;
    public static volatile SingularAttribute<Module, Integer> moduleID;

}