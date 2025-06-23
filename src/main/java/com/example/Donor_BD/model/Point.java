package com.example.Donor_BD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_point;
    private String city;
    private String address;
    @Column(length = 12)
    private String phone;
    private String fio_header;
    public Integer getIdPoint() { return id_point; }
    public void setIdPoint(Integer idPoint) { this.id_point = idPoint; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFioHeader() { return fio_header; }
    public void setFioHeader(String fioHeader) { this.fio_header = fioHeader; }
}
