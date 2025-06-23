package com.example.Donor_BD.controller;

import com.example.Donor_BD.model.Person;
import com.example.Donor_BD.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Integer id, @RequestBody Person updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}