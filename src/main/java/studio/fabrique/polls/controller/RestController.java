package studio.fabrique.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.service.PollService;

import java.util.List;

@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public final class RestController {
    @Autowired
    PollService pollService;

    @GetMapping("/polls")
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }
}
