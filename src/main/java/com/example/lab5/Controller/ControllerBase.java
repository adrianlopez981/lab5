package com.example.lab5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("inicio")
public class ControllerBase {

    @GetMapping("")
    public String vistaInicio() {
        return "Recursos Humanos - TravelTrip";
    }
}
