package com.example.Donor_BD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blood_Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_donation;

    private LocalDate donation_date;

    @ManyToOne
    @JoinColumn(name = "id_point", nullable = false)
    private Point id_point;

    @ManyToOne
    @JoinColumn(name = "id_donor", nullable = false)
    private Donor id_donor;
    public Integer getIdDonation() { return id_donation; }
    public void setIdDonation(Integer idDonation) { this.id_donation = idDonation; }

    public LocalDate getDonationDate() { return donation_date; }
    public void setDonationDate(LocalDate donationDate) { this.donation_date = donationDate; }

    public Point getIdPoint() { return id_point; }
    public void setIdPoint(Point id_point) { this.id_point = id_point; }

    public Donor getIdDonor() { return id_donor; }
    public void setIdDonor(Donor id_donor) { this.id_donor = id_donor; }
}