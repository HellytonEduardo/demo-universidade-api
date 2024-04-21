package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Departamento;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartamentoMapper {
    public static Departamento toDepartamento(DepartamentoCreateDto departamentoCreateDto){
        return new ModelMapper().map(departamentoCreateDto, Departamento.class);
    }

    public static DepartamentoResponseDto toDto(Departamento departamento){
        return new ModelMapper().map(departamento, DepartamentoResponseDto.class);
    }

    public static List<DepartamentoResponseDto> toListDto(List<Departamento> departamentos){
        return departamentos.stream().map(departamento -> toDto(departamento)).collect(Collectors.toList());
    }
}
