package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaCreateDto {
    @NotBlank
    @Size(min = 5, max = 5)
    @Pattern(regexp = "[A-Z]{3}[0-9]{2}", message = "O código deve seguir um padrão: 'XXX00'")
    private String codigo;
    @NotBlank
    @Size(min=6, max = 50)
    private String nome;
    @NotNull
    private int cargaHoraria;
}
