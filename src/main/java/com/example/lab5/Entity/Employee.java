package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hire_date")
    private Date hireDate;


    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job_id;
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
