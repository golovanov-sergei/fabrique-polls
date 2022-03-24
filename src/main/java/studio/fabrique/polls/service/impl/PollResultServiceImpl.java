package studio.fabrique.polls.service.impl;

import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Person;
import studio.fabrique.polls.domain.PollResult;
import studio.fabrique.polls.repositories.PersonRepository;
import studio.fabrique.polls.repositories.PollResultRepository;
import studio.fabrique.polls.service.PollResultService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollResultServiceImpl implements PollResultService {
    private final PollResultRepository pollResultRepository;
    private final PersonRepository personRepository;

    public PollResultServiceImpl(PollResultRepository pollResultRepository, PersonRepository personRepository) {
        this.pollResultRepository = pollResultRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<PollResult> getAllPollResults() {
        return pollResultRepository.findAll();
    }

    @Override
    public PollResult createPollResult(Long personId) {
        Person person = personRepository.findById(personId).get();
        PollResult pollResult = new PollResult();
        pollResult.setDateTime(LocalDateTime.now());
        pollResult.setPerson(person);
        return pollResultRepository.save(pollResult);
    }

    @Override
    public void addChoice(long pollResultId) {

    }
}
