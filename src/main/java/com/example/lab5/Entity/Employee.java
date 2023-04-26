package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "hire_date")
    private Timestamp hireDate;


    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Basic
    @Column(name = "salary")
    private BigDecimal salary;
    @Basic
    @Column(name = "commission_pct")
    private BigDecimal commissionPct;
    @Basic
    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Basic
    @Column(name = "enabled")
    private Integer enabled;


}
