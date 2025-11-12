package com.iesvdm.thymeleafbasicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraDTO {
    private double nota1;
    private double nota2;
    private double nota3;

}
