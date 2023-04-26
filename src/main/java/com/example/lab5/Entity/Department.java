package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @Basic
    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
