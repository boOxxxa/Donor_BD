package com.example.Donor_BD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_donor;

    @ManyToOne
    @JoinColumn(name = "id_person", nullable = false)
    private Person id_person;

    @Column(length = 3)
    private String blood_type;

    @Column(length = 2)
    private String rh_factor;
    public Integer getIdDonor() { return id_donor; }
    public void setIdDonor(Integer idDonor) { this.id_donor = id_donor; }

    public Person getIdPerson() { return id_person; }
    public void setIdPerson(Person id_person) { this.id_person = id_person; }

    public String getBlood_type() { return blood_type; }
    public void setBlood_type(String bloodType) { this.blood_type = bloodType; }

    public String getRh_factor() { return rh_factor; }
    public void setRh_factor(String rhFactor) { this.rh_factor = rhFactor; }
}
