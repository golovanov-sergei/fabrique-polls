package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.PollResult;

import java.util.List;

public interface PollResultService {
    List<PollResult> getAllPollResults();
    PollResult createPollResult(Long personId);
    void addChoice(long pollResultId);
}
