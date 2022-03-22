package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}