package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
}