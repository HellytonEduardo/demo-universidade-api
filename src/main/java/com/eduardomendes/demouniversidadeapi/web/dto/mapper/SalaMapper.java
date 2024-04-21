package com.eduardomendes.demouniversidadeapi.web.dto.mapper;

import com.eduardomendes.demouniversidadeapi.entity.Sala;
import com.eduardomendes.demouniversidadeapi.web.dto.SalaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.SalaResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SalaMapper {
    public static Sala toSala(SalaCreateDto salaCreateDto){
        return new ModelMapper().map(salaCreateDto, Sala.class);
    }
    public static SalaResponseDto toDto(Sala sala){
        return new ModelMapper().map(sala, SalaResponseDto.class);
    }
    public static List<SalaResponseDto> toListDto(List<Sala> sala){
        return sala.stream().map(salas -> toDto(salas)).collect(Collectors.toList());
    }
}
