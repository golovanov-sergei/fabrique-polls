package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.fabrique.polls.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}