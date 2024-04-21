package com.eduardomendes.demouniversidadeapi.web.dto;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.entity.Turma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoTurmaResponseDto {
    private Long id;
    private String codigoTurma;
    private String cpfAluno;
    private int nota;
    private String Status;
}
