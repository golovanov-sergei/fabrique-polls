package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.PollResult;

public interface PollResultRepository extends JpaRepository<PollResult, Long> {
}