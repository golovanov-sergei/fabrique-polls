package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studio.fabrique.polls.domain.Person;
import studio.fabrique.polls.domain.PollResult;

import java.util.List;

@Repository
public interface PollResultRepository extends JpaRepository<PollResult, Long> {
    public List<PollResult> findByPerson(Person person);
}