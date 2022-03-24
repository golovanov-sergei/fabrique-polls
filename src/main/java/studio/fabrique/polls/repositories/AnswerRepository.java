package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studio.fabrique.polls.domain.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}