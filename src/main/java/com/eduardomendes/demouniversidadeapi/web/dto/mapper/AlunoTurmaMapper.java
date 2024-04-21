package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoTurmaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoTurmaResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoTurmaMapper {
    public static AlunoTurma toAlunoTurma(AlunoTurmaCreateDto alunoTurmaCreateDto){
        return new ModelMapper().map(alunoTurmaCreateDto, AlunoTurma.class);
    }

    public static AlunoTurmaResponseDto toDto(AlunoTurma alunoTurma){
        return new ModelMapper().map(alunoTurma, AlunoTurmaResponseDto.class);
    }

    public static List<AlunoTurmaResponseDto> toListDto(List<AlunoTurma> alunoTurmas){
        return alunoTurmas.stream().map(alunoTurma -> toDto(alunoTurma)).collect(Collectors.toList());
    }
}
