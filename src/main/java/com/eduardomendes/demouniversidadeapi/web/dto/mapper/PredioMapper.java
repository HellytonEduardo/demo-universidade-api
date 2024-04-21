package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Predio;
import com.eduardomendes.demouniversidadeapi.web.dto.PredioCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.PredioResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PredioMapper {
    public static Predio toPredio(PredioCreateDto predioCreateDto){
        return new ModelMapper().map(predioCreateDto, Predio.class);
    }

    public static PredioResponseDto toDto(Predio predio){
        return new ModelMapper().map(predio, PredioResponseDto.class);
    }

    public static List<PredioResponseDto> toListDto(List<Predio> predios){
        return predios.stream().map(predio -> toDto(predio)).collect(Collectors.toList());
    }
}
