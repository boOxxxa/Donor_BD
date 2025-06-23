package com.example.Donor_BD.service;

import com.example.Donor_BD.model.Person;
import com.example.Donor_BD.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public Person update(Integer id, Person updatedPerson) {
        Person person = repository.findById(id).orElseThrow();
        person.setFio(updatedPerson.getFio());
        person.setGender(updatedPerson.getGender());
        return repository.save(person);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}