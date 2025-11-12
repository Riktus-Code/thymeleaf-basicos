package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.CalculadoraDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CalculadoraController {

    @GetMapping("/calculadora")
    public String calculadora(Model model, @ModelAttribute CalculadoraDTO calculadoraDTO){

        model.addAttribute("calculadoraDTO", calculadoraDTO);

        return "calculadora";
    }

    @PostMapping("/calculadora")
    public String calculadoraSubmit(Model model, @ModelAttribute CalculadoraDTO calculadoraDTO){
        log.info(calculadoraDTO.toString());
        double total=0;

        total = (calculadoraDTO.getNota1()+ calculadoraDTO.getNota2()+ calculadoraDTO.getNota3())/3;

        model.addAttribute("resultado","Media: "+total);

        return "calculadora";


    }


    }
