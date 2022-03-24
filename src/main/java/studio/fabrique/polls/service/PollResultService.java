package studio.fabrique.polls.service;

import studio.fabrique.polls.domain.PollResult;

import java.util.List;

public interface PollResultService {
    List<PollResult> getAllPollResults();
    List<PollResult> getAllPollResultsOfPerson(Long personId);
    PollResult createPollResult(Long personId);
    PollResult addChoiceToPoll(Long pollResultId, Long choiceId);
}
