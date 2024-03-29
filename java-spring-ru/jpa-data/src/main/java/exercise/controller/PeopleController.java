package exercise.controller;

import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

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
    @GetMapping
    public List<Person> index(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer limit) {
        return personRepository.findAll().stream().skip((page - 1) * limit).limit(limit).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
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
