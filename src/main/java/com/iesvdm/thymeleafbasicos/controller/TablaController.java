package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.TablaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/tabla")
public class TablaController {

    @GetMapping("/multiplicar")
    public String tabla(Model model, @ModelAttribute TablaDTO tablaDTO) {

        model.addAttribute("tablaDTO", tablaDTO);
        return "tabla";

    }


    @PostMapping("/multiplicar/enviar")
    public String enviar(Model model, @ModelAttribute TablaDTO tablaDTO) {
        log.info(tablaDTO.toString());

        List<Integer> resul = new ArrayList<>();

        for (int i = 1; i <= 10  ; i++) {
            resul.add(tablaDTO.getNumero()*i) ;
        }

        model.addAttribute("resultado", resul);

        return "tabla";
    }
}
