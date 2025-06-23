package com.example.Donor_BD.repository;

import com.example.Donor_BD.model.Blood_Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDonationRepository extends JpaRepository<Blood_Donation, Integer> {
}