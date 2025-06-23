package com.example.Donor_BD.controller;

import com.example.Donor_BD.model.Blood_Donation;
import com.example.Donor_BD.service.BloodDonationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-donations")
@CrossOrigin
public class BloodDonationController {

    private final BloodDonationService service;

    public BloodDonationController(BloodDonationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Blood_Donation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Blood_Donation getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public Blood_Donation create(@RequestBody Blood_Donation donation) {
        return service.save(donation);
    }

    @PutMapping("/{id}")
    public Blood_Donation update(@PathVariable Integer id, @RequestBody Blood_Donation updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}