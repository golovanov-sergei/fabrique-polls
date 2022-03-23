package studio.fabrique.polls.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import studio.fabrique.polls.domain.PollResult;
import studio.fabrique.polls.repositories.PollResultRepository;
import studio.fabrique.polls.service.PollResultService;

import java.util.List;

public class PollResultServiceImpl implements PollResultService {
    @Autowired
    PollResultRepository pollResultRepository;

    @Override
    public List<PollResult> getAllPollResults() {
        return pollResultRepository.findAll();
    }

    @Override
    public PollResult savePollResult(PollResult pollResult) {
        return pollResultRepository.save(pollResult);
    }
}
