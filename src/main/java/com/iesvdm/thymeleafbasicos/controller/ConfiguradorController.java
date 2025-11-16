package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.ConfiguradorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/configurador")
public class ConfiguradorController {

    @GetMapping("/interior")
    public String configurador(Model model, @ModelAttribute ConfiguradorDTO configuradorDTO){
        model.addAttribute("configuradorDTO",configuradorDTO);

        return "configurador";
    }

    @PostMapping("/interior/enviar")
    public String configuradorEnviar(Model model, @ModelAttribute ConfiguradorDTO configuradorDTO){

        log.info(configuradorDTO.toString());
        String color = configuradorDTO.getColor();
        String material = configuradorDTO.getMaterial();
        model.addAttribute("color",color);
        model.addAttribute("material",material);
        return "configurador";
    }
}
