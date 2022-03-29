package studio.fabrique.polls.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Person;
import studio.fabrique.polls.repositories.PersonRepository;
import studio.fabrique.polls.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
