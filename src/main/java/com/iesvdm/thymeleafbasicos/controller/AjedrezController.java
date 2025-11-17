package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.AjedrezDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@RequestMapping("/ajedrez")
public class AjedrezController {

    @GetMapping("")
    public String ajedrez(Model model, @ModelAttribute AjedrezDTO ajedrezDTO){

        int[] rows = IntStream.rangeClosed(1,8).toArray();
        int[] cols = IntStream.rangeClosed(1,8).toArray();

        model.addAttribute("rows",rows);
        model.addAttribute("cols",cols);

        model.addAttribute("ajedrezDTO",ajedrezDTO);

        return "ajedrez";
    }

    @PostMapping("")

    public String ajedrezEnviar(Model model, @ModelAttribute AjedrezDTO ajedrezDTO){


        return "ajedrez";
    }
}
