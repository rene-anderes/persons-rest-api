package org.anderes.persons.rest;

import org.anderes.persons.domain.Persons;

public interface PersonService {

    Persons getPersons();

    int save(Persons persons);

}
