package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoCreateDto {
    @NotBlank
    @CPF
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank
    @Size(min = 10, max = 100)
    private String nome;
    private LocalDateTime dataNascimento;
    @NotBlank
    @Size(min = 10, max = 150)
    private String rua;
    @NotNull
    private int numero;
    @NotBlank
    @Size(min = 5, max = 50)
    private String bairro;
    @NotBlank
    @Size(min = 5, max = 30)
    private String cidade;
}
