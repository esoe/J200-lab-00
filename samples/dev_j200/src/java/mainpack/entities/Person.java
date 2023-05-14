/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author denis
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id")
    , @NamedQuery(name = "Person.findByJobtitle", query = "SELECT p FROM Person p WHERE p.jobtitle = :jobtitle")
    , @NamedQuery(name = "Person.findByFirstnamelastname", query = "SELECT p FROM Person p WHERE p.firstnamelastname = :firstnamelastname")
    , @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone")
    , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "JOBTITLE", length = 100)
    private String jobtitle;
    @Column(name = "FIRSTNAMELASTNAME", length = 100)
    private String firstnamelastname;
    @Column(name = "PHONE", length = 50)
    private String phone;
    @Column(name = "EMAIL", length = 100)
    private String email;
    @OneToMany(mappedBy = "personid", fetch = FetchType.EAGER)
    private Collection<Domains> domainsCollection = new ArrayList<>();

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getFirstnamelastname() {
        return firstnamelastname;
    }

    public void setFirstnamelastname(String firstnamelastname) {
        this.firstnamelastname = firstnamelastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Domains> getDomainsCollection() {
        return domainsCollection;
    }

    public void setDomainsCollection(Collection<Domains> domainsCollection) {
        this.domainsCollection = domainsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", jobtitle=" + jobtitle + ", firstnamelastname=" + firstnamelastname + ", phone=" + phone + ", email=" + email + ", domainsCollection=" + domainsCollection + '}';
    }
}
