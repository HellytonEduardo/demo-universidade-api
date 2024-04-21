package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.DepartamentoPredio;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoPredioCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoPredioResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartamentoPredioMapper {
    public static DepartamentoPredio toDepartamento(DepartamentoPredioCreateDto departamentoCreateDto){
        return new ModelMapper().map(departamentoCreateDto, DepartamentoPredio.class);
    }

    public static DepartamentoPredioResponseDto toDto(DepartamentoPredio departamento){
        return new ModelMapper().map(departamento, DepartamentoPredioResponseDto.class);
    }

    public static List<DepartamentoPredioResponseDto> toListDto(List<DepartamentoPredio> departamentos){
        return departamentos.stream().map(departamento -> toDto(departamento)).collect(Collectors.toList());
    }
}
