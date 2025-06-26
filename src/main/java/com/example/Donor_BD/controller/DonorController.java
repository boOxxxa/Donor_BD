package com.example.Donor_BD.controller;

import com.example.Donor_BD.model.Donor;
import com.example.Donor_BD.model.Person;
import com.example.Donor_BD.service.DonorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/donors")
@CrossOrigin
public class DonorController {

    private final DonorService service;

    public DonorController(DonorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Donor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Donor getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Donor>  create(@RequestBody Donor donor) {
        Donor saved = service.save(donor);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> updated(@PathVariable Integer id, @RequestBody Donor updated) {
        Donor update = service.update(id, updated);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
