package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jobs")

public class Job {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "job_id")
    private String jobId;
    @Basic
    @Column(name = "job_title")
    private String jobTitle;
    @Basic
    @Column(name = "min_salary")
    private Integer minSalary;
    @Basic
    @Column(name = "max_salary")
    private Integer maxSalary;
}
