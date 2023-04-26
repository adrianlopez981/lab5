package com.example.lab5.Repository;

import com.example.lab5.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value= "with bd1 as(\n" +
            "select e.*,d.location_id as location,d.department_name from employees e left join departments d on e.department_id = d.department_id)\n" +
            "select * from bd1 left join locations l on bd1.location = l.location_id where bd1.first_name = %?1% or bd1.last_name = %?1% or bd1.department_name = %?1% or l.city = %?1%",
            nativeQuery = true)
    List<Employee> buscarEmployee(String campo);



}
