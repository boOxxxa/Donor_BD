package com.example.Donor_BD.service;

import com.example.Donor_BD.model.Blood_Donation;
import com.example.Donor_BD.repository.BloodDonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodDonationService {

    private final BloodDonationRepository repository;

    public BloodDonationService(BloodDonationRepository repository) {
        this.repository = repository;
    }

    public List<Blood_Donation> getAll() {
        return repository.findAll();
    }

    public Blood_Donation getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Blood_Donation save(Blood_Donation donation) {
        return repository.save(donation);
    }

    public Blood_Donation update(Integer id, Blood_Donation updatedDonation) {
        Blood_Donation donation = repository.findById(id).orElseThrow();
        donation.setDonationDate(updatedDonation.getDonationDate());
        donation.setIdDonor(updatedDonation.getIdDonor());
        donation.setIdPoint(updatedDonation.getIdPoint());
        return repository.save(donation);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}