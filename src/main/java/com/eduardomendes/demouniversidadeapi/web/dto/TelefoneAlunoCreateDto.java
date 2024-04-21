package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneAlunoCreateDto {
    @NotBlank
    @Size(min = 11, max = 11)
    private String telefone;
    @NotBlank
    @Size(min = 11, max = 11)
    @CPF
    private String cpfAluno;
}
