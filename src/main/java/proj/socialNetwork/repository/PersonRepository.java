package proj.socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.socialNetwork.entities.Person;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findByLogin(String login);
}