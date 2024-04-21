package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DepartamentoPredioCreateDto {
    @NotBlank
    @Size(min = 3, max = 3)
    private String codigoDepartamento;
    @NotNull
    private int codigoPredio;
}
