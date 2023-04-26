package com.example.lab5.Controller;


import com.example.lab5.Entity.Employee;
import com.example.lab5.Repository.EmployeeRepository;
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


    public ControllerEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }




    @GetMapping("/inicio")
    public String InicioEmployee(Model model) {


        List<Employee> listaEmpleados = employeeRepository.findAll();


        model.addAttribute("listaEmpleados",employeeRepository.findAll());


//
            return "listEmpleados";



    }

    @GetMapping("/new")
    public String nuevoEmpleadoFrm() {
        return "empleado/newFrm";
    }



    @PostMapping("/BuscarEmpleados")
    public String buscarTransportista(@RequestParam("searchField") String searchField,
                                      Model model) {

        List<Employee> listaEmpleados = employeeRepository.buscarEmployee(searchField);
        model.addAttribute("listaEmpleados", listaEmpleados);

        return "shipper/list";
    }


    @GetMapping("/edit")
    public String editarEmployee(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "editFrm";
        } else {
            return "redirect:/employee/inicio";
        }
    }

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        }
        return "redirect:/employee/inicio";

    }

    @PostMapping("/save")
    public String guardarNuevoEmpleado(Employee employee, RedirectAttributes attr) {
        employeeRepository.save(employee);
        return "redirect:/shipper/list";
    }



}
