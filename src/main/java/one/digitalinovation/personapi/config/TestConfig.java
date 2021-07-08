package one.digitalinovation.personapi.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.entities.Phone;
import one.digitalinovation.personapi.entities.enums.PhoneType;
import one.digitalinovation.personapi.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository; 
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		Person p1 = new Person(null, "Oliver", "Queen", "679094321", sdf.parse("05/02/1980"));
		Person p2 = new Person(null, "Barry", "Allen", "548094321", sdf.parse("01/02/1975"));
		Person p3 = new Person(null, "Kara", "Danvers", "548777321", sdf.parse("09/08/1978"));
		
		Phone f1 = new Phone(null, PhoneType.MOBILE, "11984408099");
		Phone f2 = new Phone(null, PhoneType.HOME, "1155554444");
		Phone f3 = new Phone(null, PhoneType.MOBILE, "11984408088");
		Phone f4 = new Phone(null, PhoneType.HOME, "1155554422");
		Phone f5 = new Phone(null, PhoneType.MOBILE, "11984408033");
		Phone f6 = new Phone(null, PhoneType.COMMERCIAL, "1133224444");
		
		p1.getPhones().addAll(Arrays.asList(f1, f2));
		p2.getPhones().addAll(Arrays.asList(f3, f4));
		p3.getPhones().addAll(Arrays.asList(f5, f6));
		
		personRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
