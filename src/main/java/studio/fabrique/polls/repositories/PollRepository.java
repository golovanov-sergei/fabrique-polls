package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.Poll;

public interface PollRepository extends JpaRepository<Poll, Long> {
}