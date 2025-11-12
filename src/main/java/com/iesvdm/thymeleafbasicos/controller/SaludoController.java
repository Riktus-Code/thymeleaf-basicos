package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.SaludoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Necesitamos estas anotaciones
@Slf4j

@Controller
public class SaludoController {

    //ENDPOINTS
    //Ejercicio 1
    @GetMapping("/saludos")
    public String saludos(Model model, @ModelAttribute SaludoDTO saludoDTO){

        //(@ModelAttribute SaludoDTO saludoDTO) reemplaza a lo de abajo
        //SaludoDTO saludoDTO1 =new SaludoDTO();

        model.addAttribute("saludoDTO", saludoDTO);

        return "saludos";
    }

    @PostMapping ("/saludos")
    public String saludosSubmit(Model model,@ModelAttribute SaludoDTO saludoDTO){

        log.info(saludoDTO.toString());
        if(saludoDTO.getIdioma().equalsIgnoreCase("es")) {
            model.addAttribute("saludo", "Hola " + saludoDTO.getNombre());
        }else if(saludoDTO.getIdioma().equalsIgnoreCase("en")){
            model.addAttribute("saludo", "Hello " + saludoDTO.getNombre());
        }else if(saludoDTO.getIdioma().equalsIgnoreCase("pr")){
            model.addAttribute("saludo", "Olá " + saludoDTO.getNombre());
        }

        return "saludos";
    }



}

