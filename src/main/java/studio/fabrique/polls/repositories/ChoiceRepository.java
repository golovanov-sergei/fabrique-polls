package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}