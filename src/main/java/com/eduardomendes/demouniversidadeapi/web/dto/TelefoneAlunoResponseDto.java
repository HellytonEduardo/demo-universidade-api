package com.eduardomendes.demouniversidadeapi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneAlunoResponseDto {
    private Long id;
    private String telefone;
    private String cpfAluno;
}
