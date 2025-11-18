package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.HeladoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helado")
public class HeladoController {
    @GetMapping("")
    public String heladoGet(Model model, @ModelAttribute HeladoDTO heladoDTO) {
        model.addAttribute("heladoDTO", heladoDTO);
        return "helado";
    }

    @PostMapping("")
    public String heladoPost(Model model, @ModelAttribute HeladoDTO heladoDTO) {

        int fresa = heladoDTO.getPorcentajeFresa();
        int choco = heladoDTO.getPorcentajeChoco();
        int vainilla = heladoDTO.getPorcentajeVainilla();

        model.addAttribute("fresa", fresa);
        model.addAttribute("choco", choco);
        model.addAttribute("vainilla", vainilla);

        return "helado";
    }
}
