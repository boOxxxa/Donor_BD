package com.example.Donor_BD.controller;

import com.example.Donor_BD.model.Person;
import com.example.Donor_BD.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "http://localhost:4200")

public class PersonController {
    @Autowired
    private PersonService personService;
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
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person saved = personService.save(person);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person updatedPerson) {
        Person updated = personService.update(id, updatedPerson);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        personService.delete(id);
        //return ResponseEntity.noContent().build();
    }
}