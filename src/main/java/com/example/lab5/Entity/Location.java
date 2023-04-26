package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "location_id")
    private int locationId;
    @Basic
    @Column(name = "street_address")
    private String streetAddress;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state_province")
    private String stateProvince;
    @Basic
    @Column(name = "country_id")
    private String countryId;
}
