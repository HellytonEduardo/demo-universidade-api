package com.eduardomendes.demouniversidadeapi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoResponseDto {
    private Long id;
    private String codigo;
    private String nome;
}
