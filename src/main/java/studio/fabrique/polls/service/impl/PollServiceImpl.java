package studio.fabrique.polls.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.repositories.PollRepository;
import studio.fabrique.polls.service.PollService;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {
    private final PollRepository pollRepository;

    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    @Override
    public Poll savePoll(Poll poll) {
        return pollRepository.save(poll);
    }
}
