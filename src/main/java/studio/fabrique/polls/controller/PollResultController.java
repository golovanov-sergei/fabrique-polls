package studio.fabrique.polls.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.PollResult;
import studio.fabrique.polls.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/pollresult")
public class PollResultController {

    private final PollResultService pollResultService;

    public PollResultController(PollResultService pollResultService) {
        this.pollResultService = pollResultService;
    }

    @ApiOperation(value = "Get all poll results")
    @GetMapping("/")
    public List<PollResult> getAllPollResults() {
        return pollResultService.getAllPollResults();
    }

    @ApiOperation(value = "Get all poll results for personId")
    @GetMapping("/person/{personId}")
    public List<PollResult> getAllPollResultsOfPerson(@PathVariable Long personId) {
        return pollResultService.getAllPollResultsOfPerson(personId);
    }

    @ApiOperation(value = "Create poll result for personId")
    @PostMapping("/add/{personId}")
    public PollResult createPollResult(@PathVariable Long personId) {
        return pollResultService.createPollResult(personId);
    }

    @ApiOperation(value = "Create anonymous poll result")
    @PostMapping("/add")
    public PollResult createAnonymousPollResult() {
        return pollResultService.createPollResult(-1l);
    }

    @ApiOperation(value = "Adds choice to poll result")
    @PostMapping("/choice/{pollResultId}/{choiceId}")
    public PollResult addChoiceToPollResult(@PathVariable Long pollResultId, @PathVariable Long choiceId) {
        return pollResultService.addChoiceToPoll(pollResultId, choiceId);
    }
}
