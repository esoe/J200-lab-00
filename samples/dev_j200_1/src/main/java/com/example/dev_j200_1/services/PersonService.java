package com.example.dev_j200_1.services;

import com.example.dev_j200_1.model.Person;
import jakarta.ejb.Local;

import java.util.Set;

@Local
public interface PersonService {

    Set<Person> getAllPerson();
}
