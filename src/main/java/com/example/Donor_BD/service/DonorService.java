package com.example.Donor_BD.service;

import com.example.Donor_BD.model.Donor;
import com.example.Donor_BD.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    private final DonorRepository repository;

    public DonorService(DonorRepository repository) {
        this.repository = repository;
    }

    public List<Donor> getAll() {
        return repository.findAll();
    }

    public Donor getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Donor save(Donor donor) {
        return repository.save(donor);
    }

    public Donor update(Integer id, Donor updatedDonor) {
        Donor donor = repository.findById(id).orElseThrow();
        donor.setIdPerson(updatedDonor.getIdPerson());
        donor.setBlood_type(updatedDonor.getBlood_type());
        donor.setRh_factor(updatedDonor.getRh_factor());
        return repository.save(donor);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}