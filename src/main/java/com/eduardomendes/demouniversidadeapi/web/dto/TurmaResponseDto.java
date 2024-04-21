package com.eduardomendes.demouniversidadeapi.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurmaResponseDto {
    private Long id;
    private String codigo;
    private String periodo;
    private int semestre;
    private String cpfAluno;
    private String codigoProfessor;
    private String codigoDisciplina;
    private String codigoSala;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dataInicio;
}
