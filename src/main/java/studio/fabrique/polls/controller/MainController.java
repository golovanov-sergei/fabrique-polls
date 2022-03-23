package studio.fabrique.polls.controller;

import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.Person;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.domain.Question;
import studio.fabrique.polls.service.PersonService;
import studio.fabrique.polls.service.PollService;
import studio.fabrique.polls.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public final class MainController {

    private final PollService pollService;
    private final PersonService personService;
    private final QuestionService questionService;

    public MainController(PollService pollService, PersonService personService, QuestionService questionService) {
        this.pollService = pollService;
        this.personService = personService;
        this.questionService = questionService;
    }

    @GetMapping("/question")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("/question")
    public Question createPoll(@RequestBody Question question, @PathVariable Long pollId){
        return questionService.saveQuestion(question, pollId);
    }

    @GetMapping("/poll")
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @PostMapping("/poll")
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.savePoll(poll);
    }

    @GetMapping("/person")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
}
