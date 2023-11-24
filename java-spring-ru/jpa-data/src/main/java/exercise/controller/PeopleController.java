package exercise.controller;

import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import exercise.model.Person;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person show(@PathVariable long id) {
        return personRepository.findById(id).get();
    }

    // BEGIN
    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    Person create(@Valid @RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable long id) {
        personRepository.deleteById(id);
    }

    @PostMapping("/{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) {
        var maybePerson = personRepository.findById(id).get();
        maybePerson.setFirstName(person.getFirstName());
        maybePerson.setLastName(person.getLastName());
        return person;
    }
    // END
}
