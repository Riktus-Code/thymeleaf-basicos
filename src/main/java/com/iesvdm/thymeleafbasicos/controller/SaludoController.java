package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.model.SaludoDTO;
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

    @GetMapping("/saludos")
    public String saludos(/*Model model,*/ @ModelAttribute SaludoDTO saludoDTO){

        //(@ModelAttribute SaludoDTO saludoDTO) reemplaza a lo de abajo
        //SaludoDTO saludoDTO1 =new SaludoDTO();

        //model.addAttribute("saludoDTO", saludoDTO);

        return "saludos";
    }

    @PostMapping ("/saludos")
    public String saludosSubmit(Model model,@ModelAttribute SaludoDTO saludoDTO){

        log.info(saludoDTO.toString());

        model.addAttribute("saludo", "Hola "+saludoDTO );

        return "saludos";
    }

}

