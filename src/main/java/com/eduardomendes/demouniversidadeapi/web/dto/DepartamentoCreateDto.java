package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartamentoCreateDto {
    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;
    @NotBlank
    @Size(min = 2, max = 50)
    private String nome;
}
