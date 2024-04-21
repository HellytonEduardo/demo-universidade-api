package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import com.eduardomendes.demouniversidadeapi.entity.Disciplina;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DisciplinaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DisciplinaResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DisciplinaMapper {
    public static Disciplina toDisciplina(DisciplinaCreateDto disciplinaCreateDto){
        return new ModelMapper().map(disciplinaCreateDto, Disciplina.class);
    }

    public static DisciplinaResponseDto toDto(Disciplina disciplina){
        return new ModelMapper().map(disciplina, DisciplinaResponseDto.class);
    }

    public static List<DisciplinaResponseDto> toListDto(List<Disciplina> disciplinas){
        return disciplinas.stream().map(disciplina -> toDto(disciplina)).collect(Collectors.toList());
    }
}
