package studio.fabrique.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Poll;
import studio.fabrique.polls.repositories.PollRepository;

import java.util.List;

@Service
public class PollServiceImpl implements PollService{
    @Autowired
    PollRepository pollRepository;
    @Override
    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }
}
