package org.pva.familytreebh.controller;

import lombok.RequiredArgsConstructor;
import org.pva.familytreebh.reopository.PersonRepository;
import org.pva.familytreebh.reopository.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/getAll")
    public Set<Person> getAll() {
        return personRepository.getAll();
    }

    @GetMapping("/getById/{id}")
    public Person getById(@PathVariable String id) {
        return personRepository.getById(id).orElse(null);
    }
}
