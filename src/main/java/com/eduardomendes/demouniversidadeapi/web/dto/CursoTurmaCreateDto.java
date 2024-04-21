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
public class CursoTurmaCreateDto {
    @NotBlank
    @Size(min = 3, max = 3)
    @Pattern(regexp = "[A-Z]{3}", message = "O código do Curso deve seguir um padrão: 'XXX'")
    private String codigoCurso;
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9]{3}", message = "O código da turma deve seguir um padrão: 'XXX000'")
    @Size(min = 6, max = 6)
    private String codigoTurma2;
}
