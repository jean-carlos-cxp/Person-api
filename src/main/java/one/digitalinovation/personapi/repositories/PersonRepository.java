package one.digitalinovation.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinovation.personapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
