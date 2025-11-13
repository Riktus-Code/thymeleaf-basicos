package com.iesvdm.thymeleafbasicos.controller;

import com.iesvdm.thymeleafbasicos.dto.CuadraticaDTO;
import jakarta.validation.Valid;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.MathContext;

@CommonsLog
@Controller
@RequestMapping("/cuadratica")
public class EcuacionController {
    //ruta /cuadratica/obtener
    @GetMapping("/formulario" )
    public String formulario(Model model, @ModelAttribute CuadraticaDTO cuadraticaDTO){

        model.addAttribute("cuadraticaDTO", cuadraticaDTO);
        return "cuadratica";
    }
    //ruta /cuadratica/formulario/enviar
    @PostMapping("/formulario/enviar")
    public String formularioEnviar(Model model,@Valid @ModelAttribute CuadraticaDTO cuadraticaDTO){

        log.info(cuadraticaDTO.toString());

        BigDecimal a = cuadraticaDTO.getA();
        BigDecimal b = cuadraticaDTO.getB();
        BigDecimal c = cuadraticaDTO.getC();

        BigDecimal discriminante= b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));

        if(discriminante.compareTo(BigDecimal.ZERO)>=0){

        BigDecimal raizDiscriminante = discriminante.sqrt(MathContext.DECIMAL128);

        BigDecimal resul1 = b.negate().add(raizDiscriminante).divide(BigDecimal.valueOf(2).multiply(a), MathContext.DECIMAL128);

        BigDecimal resul2 = b.negate().subtract(raizDiscriminante).divide(BigDecimal.valueOf(2).multiply(a), MathContext.DECIMAL128);

       // cuadraticaDTO.setRaiz1(resul1);
       // cuadraticaDTO.setRaiz2(resul2);

        model.addAttribute("msg","Soluciones");
        model.addAttribute("raiz1",resul1);
        model.addAttribute("raiz2",resul2);

        }else{
            model.addAttribute("msg", "Ec. sin soluciones");
        }

        return "cuadratica";
    }

}
