package com.eduardomendes.demouniversidadeapi.web.dto;

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
public class TurmaCreateDto {
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9]{3}", message = "O código da turma deve seguir um padrão: 'XXX000'")
    @Size(min = 6, max = 6)
    private String codigo;
    @NotBlank
    @Size(min = 5, max = 5)
    private String periodo;
    @NotNull
    private int semestre;
    @NotBlank
    @Size(min = 11, max = 11)
    private String codigoProfessor;
    @Pattern(regexp = "[A-Z]{3}[0-9]{2}", message = "O código deve seguir um padrão: 'XXX00'")
    @NotBlank
    @Size(min = 5, max = 5)
    private String codigoDisciplina;
}
