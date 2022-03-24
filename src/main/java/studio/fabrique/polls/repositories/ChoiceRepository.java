package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studio.fabrique.polls.domain.Choice;
import studio.fabrique.polls.domain.Question;

import java.util.List;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    public List<Choice> findByQuestion(Question question);
}