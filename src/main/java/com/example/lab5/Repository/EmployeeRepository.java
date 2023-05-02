package com.example.lab5.Repository;

import com.example.lab5.Dto.EstadisticaxJob;
import com.example.lab5.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employees where enabled = 1",nativeQuery = true)
    List<Employee> ListarEmployeesHabilitados();

    @Query(value= " select e.* from employees e inner join departments d on e.department_id = d.department_id\n" +
            "inner join locations l on d.location_id = l.location_id\n" +
            "inner join jobs j on e.job_id = j.job_id\n" +
            "where e.enabled = 1 and e.first_name like %?1% or\n" +
            "e.last_name like %?1% or\n" +
            "j.job_title like %?1% or\n" +
            "l.city like %?1%",
            nativeQuery = true)
    List<Employee> buscarEmployee(String campo);


    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "update employees set enabled = 0 where employee_id = ?1")
    void deshabilitarEmployee(int id_employee);




    @Query(nativeQuery = true,
            value = "select job_title as jobtitle,min_salary as salariominimo,max_salary as salariomaximo,sum(salary) as sumasalarios,round(avg(salary),2) as salariopromedio from employees e inner join jobs j on e.job_id = j.job_id group by 1,2,3")

    List<EstadisticaxJob> listaReportes();




}
