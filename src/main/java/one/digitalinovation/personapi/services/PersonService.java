package one.digitalinovation.personapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.repositories.PersonRepository;
import one.digitalinovation.personapi.services.exceptions.DatabaseException;
import one.digitalinovation.personapi.services.exceptions.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public void delete(Long id) {
		try {
			personRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Person update(Long id, Person obj) {
		try {
			Person person = personRepository.getOne(id);
			updateData(person, obj);
			return personRepository.save(person);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Person person, Person obj) {
		person.setFirstName(obj.getFirstName());
		person.setLastName(obj.getLastName());
	}
}
