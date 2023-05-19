package com.example.dev_j200_2.repo;

import com.example.dev_j200_2.entities.DomainEntity;
import com.example.dev_j200_2.entities.PersonEntity;
import com.example.dev_j200_2.entities.UsersEntity;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Metamodel;

import java.util.List;

@Singleton
public class AppRepository implements AppRepositoryI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PersonEntity> findAllPerson() {
        return em.createNativeQuery("select * from person", PersonEntity.class).getResultList();
    }

    @Override
    public List<DomainEntity> findAllDomain() {
        return em.createNamedQuery("Domain.All", DomainEntity.class).getResultList();
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Metamodel m = em.getMetamodel();
        Root<T> obj = cq.from(clazz);
        return em.createQuery(cq.select(obj)).getResultList();
    }

    @Override
    public PersonEntity findPersonById(long id) {
        return em.find(PersonEntity.class, id);
    }

    @Override
    public UsersEntity findUserById(long id) {
        return em.find(UsersEntity.class, id);
    }

    @Override
    public <T> T findById(Class<T> clazz, long id) {
        return em.find(clazz, id);
    }


}
