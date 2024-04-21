package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.CursoTurma;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoTurmaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoTurmaResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CursoTurmaMapper {
    public static CursoTurma toCurso(CursoTurmaCreateDto cursoCreateDto){
        return new ModelMapper().map(cursoCreateDto, CursoTurma.class);
    }

    public static CursoTurmaResponseDto toDto(CursoTurma curso){
        return new ModelMapper().map(curso, CursoTurmaResponseDto.class);
    }

    public static List<CursoTurmaResponseDto> toListDto(List<CursoTurma> cursos){
        return cursos.stream().map(curso -> toDto(curso)).collect(Collectors.toList());
    }
}
