package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlunoMapper {
    public static Aluno toAluno(AlunoCreateDto alunoCreateDto){
        return new ModelMapper().map(alunoCreateDto, Aluno.class);
    }

    public static AlunoResponseDto toDto(Aluno aluno){
        return new ModelMapper().map(aluno, AlunoResponseDto.class);
    }

    public static List<AlunoResponseDto> toListDto(List<Aluno> alunos){
        return alunos.stream().map(aluno -> toDto(aluno)).collect(Collectors.toList());
        }
}
