package mainpack.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mainpack.entities.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-11T19:29:32")
@StaticMetamodel(Domains.class)
public class Domains_ { 

    public static volatile SingularAttribute<Domains, Date> datereg;
    public static volatile SingularAttribute<Domains, String> countryreg;
    public static volatile SingularAttribute<Domains, String> ip;
    public static volatile SingularAttribute<Domains, String> webname;
    public static volatile SingularAttribute<Domains, String> domainname;
    public static volatile SingularAttribute<Domains, Person> personid;
    public static volatile SingularAttribute<Domains, Integer> id;

}