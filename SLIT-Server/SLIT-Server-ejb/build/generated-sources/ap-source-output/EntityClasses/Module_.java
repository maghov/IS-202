package EntityClasses;

import EntityClasses.Teacher;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T16:49:01")
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