package studio.fabrique.polls.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.Person;
import studio.fabrique.polls.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "Get all Persons list")
    @GetMapping("/")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @ApiOperation(value = "Add new Person")
    @PostMapping("/")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
