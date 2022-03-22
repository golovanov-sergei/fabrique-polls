package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}