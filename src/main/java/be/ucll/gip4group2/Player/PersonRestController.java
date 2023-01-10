package be.ucll.gip4group2.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class PersonRestController {
    @Autowired
    public PersonService personService;

    //manager stories = speler gegevens wijzigen
    @PutMapping("/player/{id}")
    public void updatePerson(@PathVariable long id, @RequestBody Person person){
        personService.updatePerson(id, person);
    }

    //manager stories = speler toevoegen
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/player")
    public Person addPerson(@RequestBody Person person) {
        personService.add(person);
        return person;
    }

    @GetMapping("/player/{id}")
    public Optional<Person> getPersonById(@PathVariable long id){
        return personService.findById(id);
    }

    //manager stories = spelers oplijsten
    @RequestMapping("/player")
    public Iterable<Person> getPersons() { return personService.findAll(); }


    //manager stories = speler verwijderen
    @DeleteMapping("/player/{id}")
    public void removePerson(@RequestBody Person person) {
        personService.removePerson(person);
    }
}
