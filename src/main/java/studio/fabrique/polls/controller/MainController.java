package studio.fabrique.polls.controller;

import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.*;
import studio.fabrique.polls.service.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public final class MainController {

    private final PollService pollService;
    private final PersonService personService;
    private final QuestionService questionService;
    private final ChoiceService choiceService;
    private final PollResultService pollResultService;

    public MainController(PollService pollService, PersonService personService, QuestionService questionService, ChoiceService choiceService, PollResultService pollResultService) {
        this.pollService = pollService;
        this.personService = personService;
        this.questionService = questionService;
        this.choiceService = choiceService;
        this.pollResultService = pollResultService;
    }

    @GetMapping("/pollresult")
    public List<PollResult> getAllPollResults() {
        return pollResultService.getAllPollResults();
    }

    @PostMapping("/pollresult/{personId}")
    public PollResult createPollResult(@PathVariable Long personId) {
        return pollResultService.createPollResult(personId);
    }

    @GetMapping("/choice")
    public List<Choice> getAllChoices() {
        return choiceService.getAllChoices();
    }

    @GetMapping("/choice/{questionId}")
    public List<Choice> getChoices(@PathVariable Long questionId) {
        return choiceService.getAllChoices(questionId);
    }

    @PostMapping("/choice/add/{questionId}")
    public Choice createChoice(@RequestBody Choice choice, @PathVariable Long questionId) {
        return choiceService.createChoice(choice, questionId);
    }


    @GetMapping("/question")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/question/add/{pollId}")
    public Question createQuestion(@RequestBody Question question, @PathVariable Long pollId) {
        return questionService.createQuestion(question, pollId);
    }

    @GetMapping("/poll")
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @PostMapping("/poll")
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.savePoll(poll);
    }

    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
