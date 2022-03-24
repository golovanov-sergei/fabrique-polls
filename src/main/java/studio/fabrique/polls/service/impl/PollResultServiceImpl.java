package studio.fabrique.polls.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import studio.fabrique.polls.domain.Choice;
import studio.fabrique.polls.domain.Person;
import studio.fabrique.polls.domain.PollResult;
import studio.fabrique.polls.repositories.ChoiceRepository;
import studio.fabrique.polls.repositories.PersonRepository;
import studio.fabrique.polls.repositories.PollResultRepository;
import studio.fabrique.polls.service.PollResultService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PollResultServiceImpl implements PollResultService {
    private final PollResultRepository pollResultRepository;
    private final PersonRepository personRepository;
    private final ChoiceRepository choiceRepository;

    public PollResultServiceImpl(PollResultRepository pollResultRepository, PersonRepository personRepository, ChoiceRepository choiceRepository) {
        this.pollResultRepository = pollResultRepository;
        this.personRepository = personRepository;
        this.choiceRepository = choiceRepository;
    }

    @Override
    public List<PollResult> getAllPollResults() {
        return pollResultRepository.findAll();
    }

    @Override
    public List<PollResult> getAllPollResultsOfPerson(Long personId) {
        Person person = personRepository.findById(personId).get();
        return pollResultRepository.findByPerson(person);
    }

    @Override
    public PollResult createPollResult(Long personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        Person person;
        if (personOptional.isEmpty()) {
            person = personRepository.save(new Person());
        } else {
            person = personOptional.get();
        }
        PollResult pollResult = new PollResult();
        pollResult.setDateTime(LocalDateTime.now());
        pollResult.setPerson(person);
        return pollResultRepository.save(pollResult);
    }

    @Override
    public PollResult addChoiceToPoll(Long pollResultId, Long choiceId) {
        PollResult pollResult = pollResultRepository.findById(pollResultId).get();
        Choice choice = choiceRepository.findById(choiceId).get();
//        need validation for choice belongs to question of the poll
        pollResult.getChoices().add(choice);
        return pollResultRepository.save(pollResult);
    }

}
