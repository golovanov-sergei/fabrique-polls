package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.Poll;

import java.util.List;

public interface PollService {
    List<Poll> getAllPolls();
    List<Poll> getAllActivePolls();
    Poll savePoll(Poll poll);
    Poll editPoll(Poll poll);
    void deletePoll(Long pollId);
}
