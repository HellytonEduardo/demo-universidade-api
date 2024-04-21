package com.eduardomendes.demouniversidadeapi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorResponseDto {
    private Long id;
    private String codigo;
    private String nome;
    private BigDecimal salario;
    private String email;
}
