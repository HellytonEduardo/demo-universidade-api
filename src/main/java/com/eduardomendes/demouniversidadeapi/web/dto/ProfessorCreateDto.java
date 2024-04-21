package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorCreateDto {
    @NotBlank
    @Size(min = 11, max = 11)
    private String codigo;
    @NotBlank
    @Size(min = 5, max = 100)
    private String nome;
    @NotNull
    private BigDecimal salario;
    @Email(message = "formato do e-mail está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;
}
