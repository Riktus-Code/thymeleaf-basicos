package com.iesvdm.thymeleafbasicos.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaludoDTO {
    //DTO = Data Transfer Object, subcategoria de Beans o POJOs
        //para recibir y enviar datos a la vista (capa view)

    private String nombre;
    private String idioma;

}
