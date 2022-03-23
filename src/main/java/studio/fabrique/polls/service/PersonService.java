package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person savePerson(Person person);
}
