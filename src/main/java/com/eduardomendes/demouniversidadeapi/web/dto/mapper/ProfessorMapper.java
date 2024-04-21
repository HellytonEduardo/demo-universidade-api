package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Professor;
import com.eduardomendes.demouniversidadeapi.web.dto.ProfessorCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.ProfessorResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProfessorMapper {
    public static Professor toProfessor(ProfessorCreateDto professorCreateDto){
        return new ModelMapper().map(professorCreateDto, Professor.class);
    }
    public static ProfessorResponseDto toDto(Professor professor){
        return new ModelMapper().map(professor, ProfessorResponseDto.class);
    }
    public static List<ProfessorResponseDto> toListDto(List<Professor> professores){
        return professores.stream().map(professor -> toDto(professor)).collect(Collectors.toList());
    }
}
