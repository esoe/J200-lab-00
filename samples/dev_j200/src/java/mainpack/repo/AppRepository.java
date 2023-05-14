/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack.repo;

import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mainpack.entities.Domains;
import mainpack.entities.Person;
import mainpack.entities.Users;

/**
 *
 * @author denis
 */
@Singleton
public class AppRepository implements AppRepositoryLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean checkUser(String username, String password) {
        String sql = "SELECT * FROM USERS WHERE \"NAME\"='" + username + "' AND PASSWORD='" + password + "'";
        Query query = em.createNativeQuery(sql);
        List<Users> users = query.getResultList();
        return users.size()>0;
    }

    @Override
    public List<Person> getAllPerson() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person createPerson(Person person) {
        String sql = "SELECT * FROM PERSON WHERE JOBTITLE='" + person.getJobtitle() 
                + "' AND FIRSTNAMELASTNAME='" + person.getFirstnamelastname()
                + "' AND PHONE='" + person.getPhone()
                + "' AND EMAIL='" + person.getEmail() + "'";
        List<Person> list = em.createNativeQuery(sql, Person.class).getResultList();
        if(list.size()>0) person = list.get(0);
        person = em.merge(person);
        return person;
    }

    @Override
    public Domains createDomains(Domains domain) {
        String sql = "SELECT * FROM DOMAINS WHERE WEBNAME='" + domain.getWebname() 
                + "' AND DOMAINNAME='" + domain.getDomainname() 
                + "' AND IP='" + domain.getIp() 
                + "' AND COUNTRYREG='" + domain.getCountryreg() + "'";
        List<Domains> list = em.createNativeQuery(sql, Domains.class).getResultList();
        if(list.size()>0) domain = list.get(0);
        domain = em.merge(domain);
        return domain;
    }

    @Override
    public void updateDomains(Domains domain) {
        em.merge(domain);
        em.flush();
    }

    
}
