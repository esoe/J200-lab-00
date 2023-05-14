/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack.repo;

import java.util.List;
import javax.ejb.Local;
import mainpack.entities.Domains;
import mainpack.entities.Person;

/**
 *
 * @author denis
 */
@Local
public interface AppRepositoryLocal {
    
    boolean checkUser(String username, String password);
    
    List<Person> getAllPerson();
    
    Person createPerson(Person person);
    
    Domains createDomains(Domains domain);
    
    void updateDomains(Domains domain);
}
