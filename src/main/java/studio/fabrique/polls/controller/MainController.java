package studio.fabrique.polls.controller;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get all poll results for personId")
    @GetMapping("/pollresult/person/{personId}")
    public List<PollResult> getAllPollResultsOfPerson(@PathVariable Long personId) {
        return pollResultService.getAllPollResultsOfPerson(personId);
    }

    @ApiOperation(value = "Create poll result for personId")
    @PostMapping("/pollresult/add/{personId}")
    public PollResult createPollResult(@PathVariable Long personId) {
        return pollResultService.createPollResult(personId);
    }

    @ApiOperation(value = "Create anonymous poll result")
    @PostMapping("/pollresult/add")
    public PollResult createAnonymousPollResult() {
        return pollResultService.createPollResult(-1l);
    }

    @PostMapping("/pollresult/choice/{pollResultId}/{choiceId}")
    public PollResult addChoiceToPollResult(@PathVariable Long pollResultId, @PathVariable Long choiceId) {
        return pollResultService.addChoiceToPoll(pollResultId, choiceId);
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
    public List<Choice> updateChoiceList(@RequestBody List<Choice> choiceList, @PathVariable Long questionId) {
        return choiceService.createChoice(choiceList, questionId);
    }


    @GetMapping("/question")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/question/add/{pollId}")
    public Question createQuestion(@RequestBody Question question, @PathVariable Long pollId) {
        return questionService.createQuestion(question, pollId);
    }

    @ApiOperation(value = "Get all  Active Polls list")
    @GetMapping("/active-poll")
    public List<Poll> getAllActivePolls() {
        return pollService.getAllActivePolls();
    }

    @ApiOperation(value = "Get all Polls list")
    @GetMapping("/poll")
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @ApiOperation(value = "Create new poll")
    @PostMapping("/poll")
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.savePoll(poll);
    }

    @ApiOperation(value = "Edit poll")
    @PutMapping("/poll")
    public Poll editPoll(@RequestBody Poll poll) {
        return pollService.editPoll(poll);
    }

    @ApiOperation(value = "Delete poll by Id")
    @DeleteMapping("/poll/{pollId}")
    public void deletePoll(@PathVariable Long pollId) {
        pollService.deletePoll(pollId);
    }

    @ApiOperation(value = "Get all Persons list")
    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @ApiOperation(value = "Add new Person")
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
