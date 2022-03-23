package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Poll;

import java.util.List;

public interface PollService {
    List<Poll> getAllPolls();
    Poll savePoll(Poll poll);
}
