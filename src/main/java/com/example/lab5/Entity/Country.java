package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private String countryId;
    @Basic
    @Column(name = "country_name")
    private String countryName;
    @Basic
    @Column(name = "region_id")
    private Integer regionId;

}
