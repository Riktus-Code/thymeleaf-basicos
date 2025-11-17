package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.AjedrezDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;
@Controller
@RequestMapping("/ajedrez")
public class AjedrezController {

    @GetMapping("")
    public String ajedrezGet(Model model, @ModelAttribute AjedrezDTO ajedrezDTO){



        model.addAttribute("ajedrezDTO",ajedrezDTO);

        return "ajedrez";
    }

    @PostMapping("")

    public String ajedrezEnviar(Model model, @ModelAttribute AjedrezDTO ajedrezDTO){

        int nCaballo=ajedrezDTO.getCaballo();
        int nAlfil = ajedrezDTO.getAlfil();

        int filaCaballo = 0;
        int filaAlfil = 0;
        int colCaballo = 0;
        int colAlfil = 0;
        int[] rows = IntStream.rangeClosed(1,8).toArray();
        int[] cols = IntStream.rangeClosed(1,8).toArray();


        while(filaCaballo==filaAlfil && colCaballo==colAlfil){
            filaCaballo = (int) (Math.random()*8+1);
            filaAlfil = (int) (Math.random()*8+1);
            colCaballo = (int) (Math.random()*8+1);
            colAlfil = (int) (Math.random()*8+1);
        }


        model.addAttribute("rows", rows);
        model.addAttribute("cols",cols);
        model.addAttribute("colCaballo",colCaballo);
        model.addAttribute("colAlfil",colAlfil);
        model.addAttribute("filaCaballo",filaCaballo);
        model.addAttribute("filaAlfil",filaAlfil);
        model.addAttribute("nCaballo",nCaballo);
        model.addAttribute("nAlfil",nAlfil);

        return "ajedrez";
    }
}
