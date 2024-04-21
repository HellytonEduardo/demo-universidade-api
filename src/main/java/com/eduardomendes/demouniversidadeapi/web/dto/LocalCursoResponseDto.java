package com.eduardomendes.demouniversidadeapi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalCursoResponseDto {
    private Long id;
    private String codigoCursoTurma;
    private String nomeDepartamentoPredio;
}
