package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Curso;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CursoMapper {
    public static Curso toCurso(CursoCreateDto cursoCreateDto){
        return new ModelMapper().map(cursoCreateDto, Curso.class);
    }

    public static CursoResponseDto toDto(Curso curso){
        return new ModelMapper().map(curso, CursoResponseDto.class);
    }

    public static List<CursoResponseDto> toListDto(List<Curso> cursos){
        return cursos.stream().map(curso -> toDto(curso)).collect(Collectors.toList());
    }
}
