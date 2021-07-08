package one.digitalinovation.personapi.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository; 
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		Person p1 = new Person(1L, "Oliver", "Queen", "679094321", sdf.parse("05/02/1980"));
		Person p2 = new Person(2L, "Barry", "Allen", "548094321", sdf.parse("01/02/1975"));
		
		personRepository.saveAll(Arrays.asList(p1, p2));
	}
}
