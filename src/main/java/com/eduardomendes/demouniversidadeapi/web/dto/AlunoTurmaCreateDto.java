package com.eduardomendes.demouniversidadeapi.web.dto;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.entity.Turma;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoTurmaCreateDto {
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9]{3}", message = "O código da turma deve seguir um padrão: 'XXX000'")
    @Size(min = 6, max = 6)
    private String codigoTurma;
    @CPF
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpfAluno;
}
