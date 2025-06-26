package com.example.Donor_BD.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_person;
    private String fio;
    @Column(length = 2)
    private String gender;
    public Integer getId_person() { return id_person; }
    public void setId_person(Integer idPerson) { this.id_person = idPerson; }

    public String getFio() { return fio; }
    public void setFio(String fio) { this.fio = fio; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}

