package com.iesvdm.thymeleafbasicos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AjedrezDTO {

    private Integer caballo;
    private Integer alfil;

}
