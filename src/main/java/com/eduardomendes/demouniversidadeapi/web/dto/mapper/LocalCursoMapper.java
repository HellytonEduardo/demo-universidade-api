package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.LocalCurso;
import com.eduardomendes.demouniversidadeapi.web.dto.LocalCursoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.LocalCursoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalCursoMapper {
    public static LocalCurso toLocalCurso(LocalCursoCreateDto localCursoCreateDto){
        return new ModelMapper().map(localCursoCreateDto, LocalCurso.class);
    }

    public static LocalCursoResponseDto toDto(LocalCurso localCurso){
        return new ModelMapper().map(localCurso, LocalCursoResponseDto.class);
    }

    public static List<LocalCursoResponseDto> toListDto(List<LocalCurso> localCursos){
        return localCursos.stream().map(LocalCurso -> toDto(LocalCurso)).collect(Collectors.toList());
    }
}
