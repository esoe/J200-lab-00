package mainpack.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mainpack.entities.Domains;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-11T19:29:32")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> jobtitle;
    public static volatile SingularAttribute<Person, String> firstnamelastname;
    public static volatile SingularAttribute<Person, String> phone;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile CollectionAttribute<Person, Domains> domainsCollection;
    public static volatile SingularAttribute<Person, String> email;

}