package com.example.lab5.Controller;


import com.example.lab5.Entity.Department;
import com.example.lab5.Entity.Employee;
import com.example.lab5.Entity.Job;
import com.example.lab5.Repository.DepartmentRepository;
import com.example.lab5.Repository.EmployeeRepository;
import com.example.lab5.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class ControllerEmployee {


    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;

    final DepartmentRepository departmentRepository;


    public ControllerEmployee(EmployeeRepository employeeRepository, JobRepository jobRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
    }



    @GetMapping("/inicio")
    public String InicioEmployee(Model model) {


        List<Employee> listaEmpleados = employeeRepository.ListarEmployeesHabilitados();
        model.addAttribute("listaEmpleados",listaEmpleados);

        return "listEmpleados";
    }

    @GetMapping("/reportes")
    public String InicioReportes() {

        /*List<Employee> listaEmpleados = employeeRepository.ListarEmployeesHabilitados();
        model.addAttribute("listaEmpleados",listaEmpleados);*/

        return "inicioReportes";
    }

    @GetMapping("/tentativaAumento")
    public String tentativaAumentoSueldo() {

        return "Reporte – Tentativa de Aumento";
    }


    @GetMapping("/salario")
    public String ReporteSalario(Model model) {

        model.addAttribute("listaReportes",employeeRepository.listaReportes());


        /*List<Employee> listaEmpleados = employeeRepository.ListarEmployeesHabilitados();
        model.addAttribute("listaEmpleados",listaEmpleados);*/

        return "Reporte – Sueldos";
    }


    @GetMapping("/new")
    public String nuevoEmpleadoFrm(Model model) {

        List<Job> listaJobs = jobRepository.findAll();
        List<Department> listaDepartments = departmentRepository.findAll();
        List<Employee> listaManager = employeeRepository.findAll();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);


        model.addAttribute("listaJobs",listaJobs);
        model.addAttribute("listaDepartments",listaDepartments);
        model.addAttribute("listaManager",listaManager);


        return "newFrm";
    }



    @PostMapping("/BuscarEmpleados")
    public String buscarTransportista(@RequestParam("searchField") String searchField,
                                      Model model) {

        List<Employee> listaEmpleados = employeeRepository.buscarEmployee(searchField);
        model.addAttribute("listaEmpleados", listaEmpleados);

        return "listEmpleados";
    }


    @GetMapping("/edit")
    public String editarEmployee(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        List<Employee> listaManager = employeeRepository.findAll();
        List<Department> listaDepartments = departmentRepository.findAll();
        List<Job> listaJobs = jobRepository.findAll();

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            model.addAttribute("employee", employee);
            model.addAttribute("listaManager",listaManager);
            model.addAttribute("listaJobs",listaJobs);
            model.addAttribute("listaDepartments",listaDepartments);
            return "editFrm";
        } else {
            return "redirect:/employee/inicio";
        }
    }

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        employeeRepository.deshabilitarEmployee(id);
        attr.addFlashAttribute("msg", "Empleado borrado exitosamente");

        return "redirect:/employee/inicio";

    }

    @PostMapping("/save")
    public String guardarNuevoEmpleado(Employee employee, RedirectAttributes attr) {


        if (employee.getEmployeeId() == 0) {
            attr.addFlashAttribute("msg", "Empleado creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Empleado actualizado exitosamente");
        }


        employeeRepository.save(employee);

        return "redirect:/employee/inicio";
    }



}
