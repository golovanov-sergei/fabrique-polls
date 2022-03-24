package studio.fabrique.polls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studio.fabrique.polls.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}