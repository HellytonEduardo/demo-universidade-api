package com.eduardomendes.demouniversidadeapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaCreateDto {
    @NotBlank
    @Pattern(regexp = "[A-Z]{1}-[0-9]{3}", message = "O código deve seguir um padrão: 'X-000'")
    @Size(min = 5, max = 5)
    private String codigo;
}
