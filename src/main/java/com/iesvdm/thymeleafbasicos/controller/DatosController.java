package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.DatosDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/datos")
public class DatosController {
    @GetMapping("")
    public String datos(Model model, @ModelAttribute DatosDTO datosDTO) {
        model.addAttribute("datos", datosDTO);
        return "datos";
    }

    @PostMapping
    public String datosEnviar(Model model, @ModelAttribute DatosDTO datosDTO) {
        datosDTO.setNombre("Manuel");
        datosDTO.setApellido("Castillo Guillén");
        datosDTO.setTelefono("605602042");
        datosDTO.setEdad(28);
        datosDTO.setEmail("manolito6989@gmail.com");

        model.addAttribute("nombre",datosDTO.getNombre());
        model.addAttribute("apellido",datosDTO.getApellido());
        model.addAttribute("telefono",datosDTO.getTelefono());
        model.addAttribute("edad",datosDTO.getEdad());
        model.addAttribute("email",datosDTO.getEmail());
        return "datos";
    }
}
