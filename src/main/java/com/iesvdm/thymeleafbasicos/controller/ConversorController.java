package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.ConversorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ConversorController {

    @GetMapping("/conversor")
    public String conversor(Model model, @ModelAttribute ConversorDTO conversorDTO){
        model.addAttribute("conversorDTO",conversorDTO);
        return "conversor";
    }

    @PostMapping("/conversor")
    public String conversorSubmit(Model model, @ModelAttribute ConversorDTO conversorDTO){

        log.info(conversorDTO.toString());
        double resul = conversorDTO.getDolares()*0.81;

        model.addAttribute("resultado",resul);

        return "conversor";
    }

}
