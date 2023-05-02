package com.example.lab5.Repository;

import com.example.lab5.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,String> {
}
