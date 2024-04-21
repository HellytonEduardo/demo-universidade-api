package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Turma;
import com.eduardomendes.demouniversidadeapi.web.dto.TurmaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.TurmaResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TurmaMapper {
    public static Turma toTurma(TurmaCreateDto turmaCreateDto){
        return new ModelMapper().map(turmaCreateDto, Turma.class);
    }
    public static TurmaResponseDto toDto(Turma turma){
        return new ModelMapper().map(turma, TurmaResponseDto.class);
    }
    public static List<TurmaResponseDto> toListDto(List<Turma> turmas){
        return turmas.stream().map(turmas1 -> toDto(turmas1)).collect(Collectors.toList());
    }
}
