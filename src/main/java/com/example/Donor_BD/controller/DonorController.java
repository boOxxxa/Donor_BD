package com.example.Donor_BD.controller;

import com.example.Donor_BD.model.Donor;
import com.example.Donor_BD.service.DonorService;
import org.springframework.web.bind.annotation.*;

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
    public Donor create(@RequestBody Donor donor) {
        return service.save(donor);
    }

    @PutMapping("/{id}")
    public Donor update(@PathVariable Integer id, @RequestBody Donor updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
