package studio.fabrique.polls.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.service.PollService;

import java.util.List;

@RestController
@RequestMapping("/api/poll")
public class PollController {
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @ApiOperation(value = "Get all  Active Polls list")
    @GetMapping("/active")
    public List<Poll> getAllActivePolls() {
        return pollService.getAllActivePolls();
    }

    @ApiOperation(value = "Get all Polls list")
    @GetMapping("/")
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @ApiOperation(value = "Create new poll")
    @PostMapping("/")
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.savePoll(poll);
    }

    @ApiOperation(value = "Edit poll by pollId")
    @PutMapping("/{pollId}")
    public Poll editPoll(@PathVariable Long pollId, @RequestBody Poll poll) {
        return pollService.editPoll(pollId, poll);
    }

    @ApiOperation(value = "Delete poll by Id")
    @DeleteMapping("/{pollId}")
    public void deletePoll(@PathVariable Long pollId) {
        pollService.deletePoll(pollId);
    }
}
