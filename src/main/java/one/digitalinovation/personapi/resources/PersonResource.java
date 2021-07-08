package one.digitalinovation.personapi.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.personapi.entities.Person;

@RestController
@RequestMapping(value = "/api/v1/people")
public class PersonResource {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@GetMapping
	public ResponseEntity<Person> findAll() throws ParseException {
		Person p1 = new Person(1L, "Oliver", "Queen", "679094321", sdf.parse("05/02/1980"));
		return ResponseEntity.ok().body(p1);
	}
}
