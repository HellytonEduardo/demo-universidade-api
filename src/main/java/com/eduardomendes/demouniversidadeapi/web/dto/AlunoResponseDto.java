package com.eduardomendes.demouniversidadeapi.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoResponseDto {
    private Long id;
    private String cpf;
    private String matricula;
    private String nome;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dataNascimento;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dataMatricula;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
}
