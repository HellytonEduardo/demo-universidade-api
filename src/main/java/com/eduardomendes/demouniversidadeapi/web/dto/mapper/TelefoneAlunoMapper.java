package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.TelefoneAluno;
import com.eduardomendes.demouniversidadeapi.web.dto.TelefoneAlunoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.TelefoneAlunoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TelefoneAlunoMapper {
    public static TelefoneAluno toTelefone(TelefoneAlunoCreateDto telefoneAlunoCreateDto){
        return new ModelMapper().map(telefoneAlunoCreateDto, TelefoneAluno.class);
    }

    public static TelefoneAlunoResponseDto toDto(TelefoneAluno telefoneAluno){
        return new ModelMapper().map(telefoneAluno, TelefoneAlunoResponseDto.class);
    }

    public static List<TelefoneAlunoResponseDto> toListDto(List<TelefoneAluno> telefoneAlunos){
        return telefoneAlunos.stream().map(telefoneAluno -> toDto(telefoneAluno)).collect(Collectors.toList());
    }
}
