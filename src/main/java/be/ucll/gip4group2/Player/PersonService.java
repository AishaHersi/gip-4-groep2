package be.ucll.gip4group2.Player;


import be.ucll.gip4group2.Utils.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person updatePerson(long id, Person _person) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            person.get().setPreName(_person.getPreName());
            person.get().setName(_person.getName());
            person.get().setEmail(_person.getEmail());
            person.get().setPhone(_person.getPhone());
            person.get().setAddress(_person.getAddress());
            person.get().setBirthDate(_person.getBirthDate());
            person.get().setGender(_person.getGender());
            person.get().setIdentificationNumber(_person.getIdentificationNumber());
            personRepository.save(person.get());
            return person.get();
        }
        throw new UnprocessableEntityException("Player already exists.");
    }

    public void add(Person person) {
        List<Person> personList = personRepository.findAll();
        for (Person currentPerson : personList) {
            if (currentPerson.getIdentificationNumber().equals(person.getIdentificationNumber())) {
                throw new UnprocessableEntityException("Player already exists.");
            }
        }
        personRepository.save(person);
    }

    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    public void removePerson(Person person) {
        personRepository.delete(person);
    }
}
