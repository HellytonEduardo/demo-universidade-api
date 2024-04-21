package com.eduardomendes.demouniversidadeapi.web.dto;

import com.eduardomendes.demouniversidadeapi.entity.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaResponseDto {
    private Long id;
    private String codigo;
    private String status;
}
