package studio.fabrique.polls.service.impl;

import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.exception.NoSuchEntityException;
import studio.fabrique.polls.repositories.PollRepository;
import studio.fabrique.polls.service.PollService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {
    private static final String POLL_NOT_FOUND = "Poll with Id=%s not found.";

    private final PollRepository pollRepository;

    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    @Override
    public List<Poll> getAllActivePolls() {
        return pollRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public Poll savePoll(Poll poll) {
        return pollRepository.save(poll);
    }

    @Override
    public Poll editPoll(Long pollId, Poll poll) {
        Poll editedPoll = pollRepository.findById(pollId).orElseThrow(() -> new NoSuchEntityException(String.format(POLL_NOT_FOUND, pollId)));
        editedPoll.setName(poll.getName());
        editedPoll.setDescription(poll.getDescription());
        editedPoll.setEndDate(poll.getEndDate());
        return pollRepository.save(editedPoll);
    }

    @Override
    public void deletePoll(Long pollId) {
        pollRepository.deleteById(pollId);
    }
}
